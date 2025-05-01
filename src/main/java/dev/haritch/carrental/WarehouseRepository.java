package dev.haritch.carrental;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface WarehouseRepository extends JpaRepository<CarStorage, Long>  {
    List<CarStorage> findByCarType(String carType);
    List<CarStorage> findByCarBrand(String CarBrand);
    Optional<CarStorage> findByLicensePlate(String licensePlate);
    List<CarStorage> findByCarStatus(String carStatus);
    List<CarStorage> findByCarTypeAndCarStatus(String carType, String carStaSttus);
}
