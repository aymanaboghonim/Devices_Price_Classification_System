package com.example.DevicesPriceClassificationSystem.controller;

import com.example.DevicesPriceClassificationSystem.model.Device;
import com.example.DevicesPriceClassificationSystem.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/devices")
public class DeviceController {

    @Autowired
    private DeviceService deviceService;

    @GetMapping
    public List<Device> getAllDevices() {
        return deviceService.getAllDevices();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Device> getDeviceById(@PathVariable Long id) {
        Optional<Device> device = deviceService.getDeviceById(id);
        if (device.isPresent()) {
            return ResponseEntity.ok(device.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Device addDevice(@RequestBody Device device) {
        return deviceService.addDevice(device);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Device> updateDevice(@PathVariable Long id, @RequestBody Device device) {
        Device updatedDevice = deviceService.updateDevice(id, device);
        if (updatedDevice != null) {
            return ResponseEntity.ok(updatedDevice);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDevice(@PathVariable Long id) {
        deviceService.deleteDevice(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/predict/{id}")
    public ResponseEntity<Device> predictPrice(@PathVariable Long id) {
        Optional<Device> optionalDevice = deviceService.getDeviceById(id);
        if (optionalDevice.isPresent()) {
            Device device = optionalDevice.get();
            Integer priceRange = deviceService.predictPrice(device);
            device.setPriceRange(priceRange);
            deviceService.updateDevice(id, device);
            return ResponseEntity.ok(device);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
