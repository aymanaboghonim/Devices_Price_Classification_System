package com.example.DevicesPriceClassificationSystem.model;

import javax.persistence.*;

@Entity
public class Device {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int batteryPower;
    private int blue;
    private float clockSpeed;
    private int dualSim;
    private int fc;
    private int fourG;
    private int intMemory;
    private float mDep;
    private int mobileWt;
    private int nCores;
    private int pc;
    private int pxHeight;
    private int pxWidth;
    private int ram;
    private float scH;
    private float scW;
    private int talkTime;
    private int threeG;
    private int touchScreen;
    private int wifi;
    private Integer priceRange;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getBatteryPower() {
        return batteryPower;
    }

    public void setBatteryPower(int batteryPower) {
        this.batteryPower = batteryPower;
    }

    public int getBlue() {
        return blue;
    }

    public void setBlue(int blue) {
        this.blue = blue;
    }

    public float getClockSpeed() {
        return clockSpeed;
    }

    public void setClockSpeed(float clockSpeed) {
        this.clockSpeed = clockSpeed;
    }

    public int getDualSim() {
        return dualSim;
    }

    public void setDualSim(int dualSim) {
        this.dualSim = dualSim;
    }

    public int getFc() {
        return fc;
    }

    public void setFc(int fc) {
        this.fc = fc;
    }

    public int getFourG() {
        return fourG;
    }

    public void setFourG(int fourG) {
        this.fourG = fourG;
    }

    public int getIntMemory() {
        return intMemory;
    }

    public void setIntMemory(int intMemory) {
        this.intMemory = intMemory;
    }

    public float getMDep() {
        return mDep;
    }

    public void setMDep(float mDep) {
        this.mDep = mDep;
    }

    public int getMobileWt() {
        return mobileWt;
    }

    public void setMobileWt(int mobileWt) {
        this.mobileWt = mobileWt;
    }

    public int getNCores() {
        return nCores;
    }

    public void setNCores(int nCores) {
        this.nCores = nCores;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public int getPxHeight() {
        return pxHeight;
    }

    public void setPxHeight(int pxHeight) {
        this.pxHeight = pxHeight;
    }

    public int getPxWidth() {
        return pxWidth;
    }

    public void setPxWidth(int pxWidth) {
        this.pxWidth = pxWidth;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public float getScH() {
        return scH;
    }

    public void setScH(float scH) {
        this.scH = scH;
    }

    public float getScW() {
        return scW;
    }

    public void setScW(float scW) {
        this.scW = scW;
    }

    public int getTalkTime() {
        return talkTime;
    }

    public void setTalkTime(int talkTime) {
        this.talkTime = talkTime;
    }

    public int getThreeG() {
        return threeG;
    }

    public void setThreeG(int threeG) {
        this.threeG = threeG;
    }

    public int getTouchScreen() {
        return touchScreen;
    }

    public void setTouchScreen(int touchScreen) {
        this.touchScreen = touchScreen;
    }

    public int getWifi() {
        return wifi;
    }

    public void setWifi(int wifi) {
        this.wifi = wifi;
    }

    public Integer getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(Integer priceRange) {
        this.priceRange = priceRange;
    }
}
