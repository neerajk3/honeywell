package com.busmgmt.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.busmgmt.entities.Bus;

/**
 * @author Neerajkumar
 *
 */
public interface BusRepository extends MongoRepository<Bus, String> {

    public Bus findByBusId(String busId);

}
