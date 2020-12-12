/**
 * 
 */
package com.busmgmt.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Neerajkumar
 *
 */
@Data
@NoArgsConstructor
public class Bus {

    @Id
    private String busId;

    private Location currentLocation;

    private float fuelLevel;

    private LocalDate nextMaintenanceDate;

    private Set<Integer> occupiedSeat = new HashSet<>();

    private Set<Integer> availableSeat = new HashSet<>();

}
