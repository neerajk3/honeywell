/**
 * 
 */
package com.busmgmt.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.busmgmt.domains.BusInfo;
import com.busmgmt.entities.Bus;

/**
 * @author Neerajkumar
 *
 */
@Service
public class BusMgmtUtil {

    private static final Logger LOGGER = LoggerFactory.getLogger(BusMgmtUtil.class);

    public BusInfo getBusInfoDetails(Bus bus) {
        LOGGER.trace("converting bus details to busInfo");
        BusInfo busInfo = new BusInfo();
        busInfo.setBusNumber(bus.getBusId());
        busInfo.setCurrentLocation(bus.getCurrentLocation());
        busInfo.setAvailableSeat(bus.getAvailableSeat());
        busInfo.setOccupiedSeat(bus.getOccupiedSeat());
        busInfo.setFuelLevel(bus.getFuelLevel());
        busInfo.setNextMaintenanceDate(bus.getNextMaintenanceDate());
        return busInfo;
    }

    public BusInfo getBusInfoForList(Bus bus) {
        LOGGER.trace("converting buses details to busInfo list");
        BusInfo busInfo = new BusInfo();
        busInfo.setBusNumber(bus.getBusId());
        busInfo.setCurrentLocation(bus.getCurrentLocation());
        busInfo.setFuelLevel(bus.getFuelLevel());
        busInfo.setNextMaintenanceDate(bus.getNextMaintenanceDate());
        return busInfo;
    }

}
