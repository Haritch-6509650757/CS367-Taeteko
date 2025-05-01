package dev.haritch.carrental;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class CarStorage {
    private @Id
    @GeneratedValue Long id;
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

    CarStorage() {}

    public CarStorage(String carType, String carBrand, String licensePlate, String carLocation, String carModel, 
                    String carColor, boolean carInsurance, String carStatus, String milege, double price, String img){
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

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getImg(){
        return img;
    }

    public void setImg(String img){
        this.img = img;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        CarStorage other = (CarStorage) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        if (carType == null) {
            if (other.carType != null)
                return false;
        } else if (!carType.equals(other.carType))
            return false;
        if (carBrand == null) {
            if (other.carBrand != null)
                return false;
        } else if (!carBrand.equals(other.carBrand))
            return false;
        if (licensePlate == null) {
            if (other.licensePlate != null)
                return false;
        } else if (!licensePlate.equals(other.licensePlate))
            return false;
        if (carLocation == null) {
            if (other.carLocation != null)
                return false;
        } else if (!carLocation.equals(other.carLocation))
            return false;
        if (carModel == null) {
            if (other.carModel != null)
                return false;
        } else if (!carModel.equals(other.carModel))
            return false;
        if (carColor == null) {
            if (other.carColor != null)
                return false;
        } else if (!carColor.equals(other.carColor))
            return false;
        if (carInsurance != other.carInsurance)
            return false;
        if (carStatus == null) {
            if (other.carStatus != null)
                return false;
        } else if (!carStatus.equals(other.carStatus))
            return false;
        if (milege == null) {
            if (other.milege != null)
                return false;
        } else if (!milege.equals(other.milege))
            return false;
        if (Double.doubleToLongBits(price) != Double.doubleToLongBits(other.price))
            return false;
        if (img == null) {
            if (other.img != null)
                return false;
        } else if (!img.equals(other.img))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        result = prime * result + ((carType == null) ? 0 : carType.hashCode());
        result = prime * result + ((carBrand == null) ? 0 : carBrand.hashCode());
        result = prime * result + ((licensePlate == null) ? 0 : licensePlate.hashCode());
        result = prime * result + ((carLocation == null) ? 0 : carLocation.hashCode());
        result = prime * result + ((carModel == null) ? 0 : carModel.hashCode());
        result = prime * result + ((carColor == null) ? 0 : carColor.hashCode());
        result = prime * result + (carInsurance ? 1231 : 1237);
        result = prime * result + ((carStatus == null) ? 0 : carStatus.hashCode());
        result = prime * result + ((milege == null) ? 0 : milege.hashCode());
        long temp;
        temp = Double.doubleToLongBits(price);
        result = prime * result + (int) (temp ^ (temp >>> 32));
        result = prime * result + ((img == null) ? 0 : img.hashCode());
        return result;
    }

    @Override
    public String toString(){
        return "Storage [id=" + id + ", carType=" + carType + ", carBrand=" + carBrand + ", licensePlate=" + licensePlate +
                ", carLocation=" + carLocation + ", carModel=" + carModel + ", carColor=" + carColor + ", carInsurance=" + carInsurance +
                "carStatus=" + carStatus + "milege=" + milege + "img=" + img + "]";
    }

}

