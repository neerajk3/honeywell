/**
 * 
 */
package com.busmgmt.domains;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.busmgmt.entities.Location;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Neerajkumar
 *
 */
@Data
@NoArgsConstructor
@JsonInclude(Include.NON_NULL)
public class BusInfo {

    private String busNumber;

    private Location currentLocation;

    private float fuelLevel;

    private LocalDate nextMaintenanceDate;

    private Set<Integer> occupiedSeat = new HashSet<>();

    private Set<Integer> availableSeat = new HashSet<>();

}
