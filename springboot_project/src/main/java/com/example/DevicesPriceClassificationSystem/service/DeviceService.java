package com.example.DevicesPriceClassificationSystem.service;

import com.example.DevicesPriceClassificationSystem.model.Device;
import java.util.List;
import java.util.Optional;

public interface DeviceService {
    List<Device> getAllDevices();
    Optional<Device> getDeviceById(Long id);
    Device addDevice(Device device);
    Device updateDevice(Long id, Device device);
    void deleteDevice(Long id);
    Integer predictPrice(Device device);
}
