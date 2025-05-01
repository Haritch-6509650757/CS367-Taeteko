package com.example.carrentalstore;
import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class OrderStorage{
    private @Id
    @GeneratedValue Long id;

    private String carPlateNumber;
    private String status;
    private String customerName;
    private String storeId;
    private String remarks;
    private String orderDate;
    private String deliveryDate;

    private String lastUpdated;

    public OrderStorage() {}

    public OrderStorage(String status) {
    this.status = status;
    }   

    public OrderStorage(String carPlateNumber, String status, String customerName, String storeId, String remarks, String orderDate, String deliveryDate, String lastUpdated) {
    this.carPlateNumber = carPlateNumber;
    this.status = status;
    this.customerName = customerName;
    this.storeId = storeId;
    this.remarks = remarks;
    this.orderDate = orderDate;
    this.deliveryDate = deliveryDate;
    this.lastUpdated = lastUpdated;
    }   


    public Long getId() {
        return id;
    }

    public String getCarPlateNumber() {
        return carPlateNumber;
    }

    public String getStatus() {
        return status;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getStoreId() {
        return storeId;
    }

    public String getRemarks() {
        return remarks;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public String getDeliveryDate() {
        return deliveryDate;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setCarPlateNumber(String carPlateNumber) {
        this.carPlateNumber = carPlateNumber;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setStoreId(String storeId) {
        this.storeId = storeId;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public void setDeliveryDate(String deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + Objects.hashCode(this.id);
        hash = 53 * hash + Objects.hashCode(this.carPlateNumber);
        hash = 53 * hash + Objects.hashCode(this.status);
        hash = 53 * hash + Objects.hashCode(this.customerName);
        hash = 53 * hash + Objects.hashCode(this.storeId);
        hash = 53 * hash + Objects.hashCode(this.remarks);
        hash = 53 * hash + Objects.hashCode(this.orderDate);
        hash = 53 * hash + Objects.hashCode(this.deliveryDate);
        hash = 53 * hash + Objects.hashCode(this.lastUpdated);
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
        final OrderStorage other = (OrderStorage) obj;
        if (!Objects.equals(this.carPlateNumber, other.carPlateNumber)) {
            return false;
        }
        if (!Objects.equals(this.status, other.status)) {
            return false;
        }
        if (!Objects.equals(this.customerName, other.customerName)) {
            return false;
        }
        if (!Objects.equals(this.storeId, other.storeId)) {
            return false;
        }
        if (!Objects.equals(this.remarks, other.remarks)) {
            return false;
        }
        if (!Objects.equals(this.orderDate, other.orderDate)) {
            return false;
        }
        if (!Objects.equals(this.deliveryDate, other.deliveryDate)) {
            return false;
        }
        if (!Objects.equals(this.lastUpdated, other.lastUpdated)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("OrderStorage{");
        sb.append("id=").append(id);
        sb.append(", carPlateNumber=").append(carPlateNumber);
        sb.append(", status=").append(status);
        sb.append(", customerName=").append(customerName);
        sb.append(", storeId=").append(storeId);
        sb.append(", remarks=").append(remarks);
        sb.append(", orderDate=").append(orderDate);
        sb.append(", deliveryDate=").append(deliveryDate);
        sb.append(", lastUpdated=").append(lastUpdated);
        sb.append('}');
        return sb.toString();
    }

}