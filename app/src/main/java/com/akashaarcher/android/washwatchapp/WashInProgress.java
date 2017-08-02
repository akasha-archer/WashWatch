package com.akashaarcher.android.washwatchapp;

/**
 * Created by Akasha on 5/11/17.
 */

public class WashInProgress {

    private String machineNumber;
    private String washCycle;
    private String tenantPhone;

    public WashInProgress(String machineNumber, String washCycle, String tenantPhone) {
        this.machineNumber = machineNumber;
        this.washCycle = washCycle;
        this.tenantPhone = tenantPhone;
    }


    public String getMachineNumber() {
        return machineNumber;
    }

    public void setMachineNumber(String machineNumber) {
        this.machineNumber = machineNumber;
    }

    public String getWashCycle() {
        return washCycle;
    }

    public void setWashCycle(String washCycle) {
        this.washCycle = washCycle;
    }

    public String getTenantPhone() {
        return tenantPhone;
    }

    public void setTenantPhone(String tenantPhone) {
        this.tenantPhone = tenantPhone;
    }

}
