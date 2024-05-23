package com.example.DevicesPriceClassificationSystem.service;

import com.example.DevicesPriceClassificationSystem.model.Device;
import com.example.DevicesPriceClassificationSystem.repository.DeviceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class DeviceServiceImpl implements DeviceService {

    @Autowired
    private DeviceRepository deviceRepository;

    @Override
    public List<Device> getAllDevices() {
        return deviceRepository.findAll();
    }

    @Override
    public Optional<Device> getDeviceById(Long id) {
        return deviceRepository.findById(id);
    }

    @Override
    public Device addDevice(Device device) {
        return deviceRepository.save(device);
    }

    @Override
    public Device updateDevice(Long id, Device device) {
        if (deviceRepository.existsById(id)) {
            device.setId(id);
            return deviceRepository.save(device);
        }
        return null;
    }

    @Override
    public void deleteDevice(Long id) {
        deviceRepository.deleteById(id);
    }

    @Override
    public Integer predictPrice(Device device) {
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:5000/predict";
        Map<String, Object> request = new HashMap<>();
        request.put("battery_power", device.getBatteryPower());
        request.put("blue", device.getBlue());
        request.put("clock_speed", device.getClockSpeed());
        request.put("dual_sim", device.getDualSim());
        request.put("fc", device.getFc());
        request.put("four_g", device.getFourG());
        request.put("int_memory", device.getIntMemory());
        request.put("m_dep", device.getMDep());
        request.put("mobile_wt", device.getMobileWt());
        request.put("n_cores", device.getNCores());
        request.put("pc", device.getPc());
        request.put("px_height", device.getPxHeight());
        request.put("px_width", device.getPxWidth());
        request.put("ram", device.getRam());
        request.put("sc_h", device.getScH());
        request.put("sc_w", device.getScW());
        request.put("talk_time", device.getTalkTime());
        request.put("three_g", device.getThreeG());
        request.put("touch_screen", device.getTouchScreen());
        request.put("wifi", device.getWifi());

        try {
            ResponseEntity<Map> response = restTemplate.postForEntity(url, request, Map.class);
            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                return (Integer) response.getBody().get("predicted_price_range");
            }
        } catch (HttpClientErrorException e) {
            e.printStackTrace();
        }
        return null;
    }
}
