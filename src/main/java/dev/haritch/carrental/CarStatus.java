package dev.haritch.carrental;

public class CarStatus {
    private String licensePlate;
    private String status;

    public CarStatus() {}

    public CarStatus(String licensePlate, String status) {
        this.licensePlate = licensePlate;
        this.status = status;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

}
