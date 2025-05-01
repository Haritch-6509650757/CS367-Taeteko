package dev.haritch.carrental;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class CarStorage {

    private @Id
    @GeneratedValue
    Long id;
    private String carType;
    private String carBrand;
    private String licensePlate;
    private String carLocation;
    private String carModel;
    private String carColor;
    private boolean carInsurance;
    private String carStatus;
    private String milege;
    private double price;
    private String img;
    private String remark;

    CarStorage() {
    }

    public CarStorage(String carType, String carBrand, String licensePlate, String carLocation, String carModel,
            String carColor, boolean carInsurance, String carStatus, String milege, double price, String img, String remark) {
        this.carType = carType;
        this.carBrand = carBrand;
        this.licensePlate = licensePlate;
        this.carLocation = carLocation;
        this.carModel = carModel;
        this.carColor = carColor;
        this.carInsurance = carInsurance;
        this.carStatus = carStatus;
        this.milege = milege;
        this.price = price;
        this.img = img;
        this.remark = remark;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getCarBrand() {
        return carBrand;
    }

    public void setCarBrand(String carBrand) {
        this.carBrand = carBrand;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getCarLocation() {
        return carLocation;
    }

    public void setCarLocation(String carLocation) {
        this.carLocation = carLocation;
    }

    public String getCarModel() {
        return carModel;
    }

    public void setCarModel(String carModel) {
        this.carModel = carModel;
    }

    public String getCarColor() {
        return carColor;
    }

    public void setCarColor(String carColor) {
        this.carColor = carColor;
    }

    public boolean isCarInsurance() {
        return carInsurance;
    }

    public void setCarInsurance(boolean carInsurance) {
        this.carInsurance = carInsurance;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }

    public String getMilege() {
        return milege;
    }

    public void setMilege(String milege) {
        this.milege = milege;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("CarStorage{");
        sb.append("id=").append(id);
        sb.append(", carType=").append(carType);
        sb.append(", carBrand=").append(carBrand);
        sb.append(", licensePlate=").append(licensePlate);
        sb.append(", carLocation=").append(carLocation);
        sb.append(", carModel=").append(carModel);
        sb.append(", carColor=").append(carColor);
        sb.append(", carInsurance=").append(carInsurance);
        sb.append(", carStatus=").append(carStatus);
        sb.append(", milege=").append(milege);
        sb.append(", price=").append(price);
        sb.append(", img=").append(img);
        sb.append(", remark=").append(remark);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 17 * hash + Objects.hashCode(this.id);
        hash = 17 * hash + Objects.hashCode(this.carType);
        hash = 17 * hash + Objects.hashCode(this.carBrand);
        hash = 17 * hash + Objects.hashCode(this.licensePlate);
        hash = 17 * hash + Objects.hashCode(this.carLocation);
        hash = 17 * hash + Objects.hashCode(this.carModel);
        hash = 17 * hash + Objects.hashCode(this.carColor);
        hash = 17 * hash + (this.carInsurance ? 1 : 0);
        hash = 17 * hash + Objects.hashCode(this.carStatus);
        hash = 17 * hash + Objects.hashCode(this.milege);
        hash = 17 * hash + (int) (Double.doubleToLongBits(this.price) ^ (Double.doubleToLongBits(this.price) >>> 32));
        hash = 17 * hash + Objects.hashCode(this.img);
        hash = 17 * hash + Objects.hashCode(this.remark);
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
        if (this.carInsurance != other.carInsurance) {
            return false;
        }
        if (Double.doubleToLongBits(this.price) != Double.doubleToLongBits(other.price)) {
            return false;
        }
        if (!Objects.equals(this.carType, other.carType)) {
            return false;
        }
        if (!Objects.equals(this.carBrand, other.carBrand)) {
            return false;
        }
        if (!Objects.equals(this.licensePlate, other.licensePlate)) {
            return false;
        }
        if (!Objects.equals(this.carLocation, other.carLocation)) {
            return false;
        }
        if (!Objects.equals(this.carModel, other.carModel)) {
            return false;
        }
        if (!Objects.equals(this.carColor, other.carColor)) {
            return false;
        }
        if (!Objects.equals(this.carStatus, other.carStatus)) {
            return false;
        }
        if (!Objects.equals(this.milege, other.milege)) {
            return false;
        }
        if (!Objects.equals(this.img, other.img)) {
            return false;
        }
        if (!Objects.equals(this.remark, other.remark)) {
            return false;
        }
        return Objects.equals(this.id, other.id);
    }

}
