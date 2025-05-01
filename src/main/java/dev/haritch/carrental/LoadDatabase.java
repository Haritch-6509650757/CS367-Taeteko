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
    CommandLineRunner intiDatabase(WarehouseRepository repository) {
        return args -> {
            log.info("Loading " + repository.save(new CarStorage("Sedan", "Toyota", "AB1000", "1st Floor", "Camry", "White", true, "Customer not showup", "15000KM", 50, null, null)));
            log.info("Loading " + repository.save(new CarStorage("Suv", "Toyota", "XX8888", "2st floor", "Corolla Cross", "Grey", true, "not Rental", "5000km", 60, "https://www.headlightmag.com/hlmwp/wp-content/uploads/2023/02/oyota-Grand-Highlander_01.jpg", "Broken")));
            log.info("Loading" + repository.save(new CarStorage("Suv", "Porsche", "PS1234", "3rd Floor", "Cayenne", "White", true, "InProgress", "1000km", 100, null, null)));
            log.info("Loading" + repository.save(new CarStorage("Sedan", "BMW", "KS9099", "3rd Floor", "M340i", "Black", true, "InProgress", "4700km", 80, null, null)));
            log.info("Loading" + repository.save(new CarStorage("Sedan", "BMW", "AATEST", "3rd Floor", "M340i", "Black", true, "InProgress", "4700km", 80, null, null)));
            log.info("Loading" + repository.save(new CarStorage("Sedan", "Mercedes Benz", "XZ1234", "3rd Floor", "C350e", "Black", true, "Rental", "6000km", 100, null, null)));
            log.info("Loading" + repository.save(new CarStorage("Suv", "Honda", "JX5000", "1st Floor", "HRV", "Grey", true, "Rental", "9000km", 40, null, null)));
            log.info("Loading" + repository.save(new CarStorage("Suv", "Toyota", "OL9191", "2st Floor", "Cross", "Black", true, "not Rental", "4700km", 80, "https://www.rentconnected.com/blog/img/Toyota_cross_Hybrid_premium.jpg", null)));
            log.info("Loading" + repository.save(new CarStorage("Convertible", "BMW", "QA4102", "3rd Floor", "Z4", "White", true, "not Rental", "4330km", 100, "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcSjBV7NhtULAlA2FuZJlRHWyj-aYTLnYxS4Pw&s", null)));
            log.info("Loading" + repository.save(new CarStorage("Coupe", "Mercedes Benz", "IF8039", "3rd Floor", "C43 AMG", "Black", true, "not Rental", "8594km", 90, "https://www.รถมือสอง.com/img/post/thumb/img_8d8c3c26ab1d4b2756733aa605fd89ee.jpg", null)));
            log.info("Loading" + repository.save(new CarStorage("Wagon", "Audi", "RR0942", "2st Floor", "RS6", "Black", true, "not Rental", "1000km", 100, "https://www.thesupercarblog.com/wp-content/uploads/2024/05/MTM-Audi-RS6-GT-EVO-1.jpg", null)));
            log.info("Loading" + repository.save(new CarStorage("Sport", "Porsche", "PX2934", "1st Floor", "Carrera S", "Black", true, "not Rental", "349km", 110, "https://rpmtechnik.co.uk/wp-content/uploads/992-Turbo-S-16-1500x1000.jpg", null)));
            log.info("Loading " + repository.save(new CarStorage("Sport", "Nissan", "NS4532", "1st Floor", "GT-R", "Red", true, "Rental", "12000km", 95, null, null)));
            log.info("Loading " + repository.save(new CarStorage("Sedan", "Mazda", "MD1133", "2nd Floor", "Mazda 3", "White", true, "Rental", "6000km", 55, null, null)));
            log.info("Loading " + repository.save(new CarStorage("Hatchback", "Honda", "HN7623", "1st Floor", "Jazz", "Blue", true, "not Rental", "3000km", 40, "https://www.goodcarrodzing.com/wp-content/uploads/2023/03/jazz-gk-%E0%B8%A1%E0%B8%B7%E0%B8%AD%E0%B8%AA%E0%B8%AD%E0%B8%87%E0%B9%81%E0%B8%95%E0%B9%88%E0%B8%87.jpg", null)));
            log.info("Loading " + repository.save(new CarStorage("SUV", "Ford", "FD9943", "3rd Floor", "Everest", "Black", true, "not Rental", "8500km", 65, "https://cf.autodeft2.pw/uploads/images/2017/New%20York%20Auto%20Show%202017/Ford%20Explorer/2018-Ford-Explorer-1.jpg", "Broken")));
            log.info("Loading " + repository.save(new CarStorage("Sedan", "Toyota", "TY1093", "2nd Floor", "Altis", "Grey", true, "Customer not showup", "7200km", 50, null, null)));
            log.info("Loading " + repository.save(new CarStorage("Pickup", "Isuzu", "IZ3392", "1st Floor", "D-Max", "Silver", true, "Rental", "9500km", 60, null, null)));
            log.info("Loading " + repository.save(new CarStorage("Van", "Hyundai", "HY7651", "2nd Floor", "Staria", "White", true, "not Rental", "4000km", 70, "https://cars.car2day.com/wp-content/uploads/2024/05/1-28.jpg", null)));
            log.info("Loading " + repository.save(new CarStorage("Convertible", "Mazda", "MZ2901", "3rd Floor", "MX-5", "Red", true, "Rental", "5500km", 85, null, null)));
            log.info("Loading " + repository.save(new CarStorage("Coupe", "Toyota", "TY9876", "1st Floor", "86", "Orange", true, "Rental", "4900km", 75, null, null)));
            log.info("Loading " + repository.save(new CarStorage("Wagon", "Subaru", "SB1400", "2nd Floor", "Levorg", "Blue", true, "not Rental", "3500km", 70, "https://ig-model.online/cdn/shop/products/1656-1.jpg?v=1592828312", null)));
            log.info("Loading " + repository.save(new CarStorage("SUV", "Chevrolet", "CH4920", "1st Floor", "Captiva", "Grey", true, "Rental", "9100km", 60, null, null)));
            log.info("Loading " + repository.save(new CarStorage("Sedan", "Nissan", "NS2211", "2nd Floor", "Teana", "White", true, "not Rental", "6200km", 50, "https://i.i-sgcm.com/cars_used/201809/771320_3b.jpg", null)));
            log.info("Loading " + repository.save(new CarStorage("Hatchback", "Volkswagen", "VW7639", "3rd Floor", "Golf", "Black", true, "Rental", "4700km", 65, null, null)));
            log.info("Loading " + repository.save(new CarStorage("Sport", "BMW", "BM8400", "3rd Floor", "M4", "Yellow", true, "Rental", "3000km", 110, null, null)));
            log.info("Loading " + repository.save(new CarStorage("Convertible", "Mini", "MN3933", "2nd Floor", "Cooper S", "Green", true, "not Rental", "2100km", 80, "https://bringatrailer.com/wp-content/uploads/2017/10/59f12c207155b_xIMG_0339-7.jpg?fit=940%2C579", null)));
            log.info("Loading " + repository.save(new CarStorage("Sedan", "Lexus", "LX1235", "1st Floor", "ES300h", "White", true, "Rental", "5800km", 75, null, null)));
            log.info("Loading " + repository.save(new CarStorage("SUV", "Volvo", "VO3219", "3rd Floor", "XC60", "Black", true, "Rental", "4900km", 85, null, null)));
            log.info("Loading " + repository.save(new CarStorage("Pickup", "Toyota", "TY5432", "2nd Floor", "Revo", "Grey", true, "not Rental", "8200km", 55, "https://s.isanook.com/au/0/ud/16/84616/revo_60th_01.jpg", null)));
            log.info("Loading " + repository.save(new CarStorage("Sport", "Ferrari", "FR9999", "3rd Floor", "488", "Red", true, "not Rental", "1500km", 150, "https://www.prodrive-shop.com/wp-content/uploads/2021/10/Ferrari-488-GTB-x-BC-Forged-x-Vorsteine-x-Capristo-x-Novitec-x-IPE-Innotech_12.jpg", null)));

        };
    }
}
