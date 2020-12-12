package com.busmgmt;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.busmgmt.entities.Bus;
import com.busmgmt.entities.Location;
import com.busmgmt.repositories.BusRepository;

@SpringBootApplication
@EnableMongoRepositories
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    CommandLineRunner initDatabase(BusRepository busRepository) {
        return args -> {
            Bus bus01 = new Bus();
            Set<Integer> occupiedSeat = new HashSet<>();
            occupiedSeat.add(1);
            occupiedSeat.add(2);
            Set<Integer> availableSeat = new HashSet<>();
            availableSeat.add(3);
            availableSeat.add(4);
            bus01.setAvailableSeat(availableSeat);
            bus01.setOccupiedSeat(occupiedSeat);
            Location currentLocation01 = new Location();
            currentLocation01.setLatitude(151.1f);
            currentLocation01.setLongitude(155.1f);
            bus01.setCurrentLocation(currentLocation01);
            bus01.setFuelLevel(5.5f);

            LocalDate date01 = LocalDate.now().plusMonths(1);

            bus01.setNextMaintenanceDate(date01);

            Bus bus02 = new Bus();
            Set<Integer> occupiedSeat01 = new HashSet<>();
            occupiedSeat01.add(1);
            occupiedSeat01.add(2);
            Set<Integer> availableSeat02 = new HashSet<>();
            availableSeat02.add(3);
            availableSeat02.add(4);
            bus02.setAvailableSeat(availableSeat02);
            bus02.setOccupiedSeat(occupiedSeat01);
            Location currentLocation02 = new Location();
            currentLocation02.setLatitude(156.1f);
            currentLocation02.setLongitude(157.1f);
            bus02.setCurrentLocation(currentLocation02);
            bus02.setFuelLevel(5.5f);

            LocalDate date02 = LocalDate.now().plusMonths(1);

            bus02.setNextMaintenanceDate(date02);

            busRepository.save(bus01);
            busRepository.save(bus02);
        };
    }

}
