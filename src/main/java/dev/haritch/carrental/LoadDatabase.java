package dev.haritch.carrental;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    public static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner intiDatabase(WarehouseRepository repository){
        return args -> {
            log.info("Loading "+repository.save(new CarStorage("Sedan", "Toyota", "AB1000", "1st Floor", "Camry", "White", true, "Customer not showup", "15000KM", null, null, 50)));
            log.info("Loading "+repository.save(new CarStorage("Suv", "Toyota", "ขค2345", "2st floor", "Corolla Cross", "Grey", true, "not Rental", "5000km", null, null, 60)));
            log.info("Loading"+repository.save(new CarStorage("Suv", "Porsche", "PS1234", "3rd Floor", "Cayenne", "White", true, "not Rental", "1000km", null, null, 100)));
            log.info("Loading"+repository.save(new CarStorage("Sedan", "BMW", "KS9099", "3rd Floor", "M340i", "Black", true, "not Rental", "4700km", null, null, 80)));
            log.info("Loading"+repository.save(new CarStorage("Sedan", "BMW", "AATEST", "3rd Floor", "M340i", "Black", true, "not Rental", "4700km", null, null, 80)));
            log.info("Loading"+repository.save(new CarStorage("Sedan", "Mercedes Benz", "XZ1234", "3rd Floor", "C350e", "Black", true, "Rental", "6000km", null, null, 100)));
            log.info("Loading"+repository.save(new CarStorage("Suv", "Honda", "JX5000", "1st Floor", "HRV", "Grey", true, "Rental", "9000km", null, null, 40)));
            log.info("Loading"+repository.save(new CarStorage("Suv", "Toyota", "OL9191", "2st Floor", "Cross", "Black", true, "not Rental", "4700km", null, null, 80)));
            log.info("Loading"+repository.save(new CarStorage("Convertible", "BMW", "QA4102", "3rd Floor", "Z4", "White", true, "not Rental", "4330km", null, null, 100)));
            log.info("Loading"+repository.save(new CarStorage("Coupe", "Mercedes Benz", "IF8039", "3rd Floor", "C43 AMG", "Black", true, "not Rental", "8594km", null, null, 90)));
            log.info("Loading"+repository.save(new CarStorage("Wagon", "Audi", "RR0942", "2st Floor", "RS6", "Black", true, "not Rental", "1000km", null, null, 100)));
            log.info("Loading"+repository.save(new CarStorage("Sport", "Porsche", "PX2934", "1st Floor", "Carrera S", "Black", true, "not Rental", "349km", null, null, 110)));
        };
    }
}
