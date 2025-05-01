package com.example.carrentalstore;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class  CarStorage{
    private @Id
    @GeneratedValue Long id;

    private String plateNumber;
    private String brand;
    private Boolean readyToReturn;

    public CarStorage() {}

    public CarStorage(String brand, String plateNumber, Boolean readyToReturn) {
        this.brand = brand;
        this.plateNumber = plateNumber;
        this.readyToReturn = readyToReturn;
    }

    public Long getId() {
        return id;
    }

    public String getPlateNumber() {
        return plateNumber;
    }

    public String getBrand() {
        return brand;
    }

    public Boolean getReadyToReturn() {
        return readyToReturn;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPlateNumber(String plateNumber) {
        this.plateNumber = plateNumber;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setReadyToReturn(Boolean readyToReturn) {
        this.readyToReturn = readyToReturn;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 67 * hash + Objects.hashCode(this.id);
        hash = 67 * hash + Objects.hashCode(this.plateNumber);
        hash = 67 * hash + Objects.hashCode(this.brand);
        hash = 67 * hash + Objects.hashCode(this.readyToReturn);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final CarStorage other = (CarStorage) obj;
        if (!Objects.equals(this.plateNumber, other.plateNumber)) {
            return false;
        }
        if (!Objects.equals(this.brand, other.brand)) {
            return false;
        }
        if (!Objects.equals(this.id, other.id)) {
            return false;
        }
        return Objects.equals(this.readyToReturn, other.readyToReturn);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CarStorage{");
        sb.append("id=").append(id);
        sb.append(", plateNumber=").append(plateNumber);
        sb.append(", brand=").append(brand);
        sb.append(", readyToReturn=").append(readyToReturn);
        sb.append('}');
        return sb.toString();
    }

    
}