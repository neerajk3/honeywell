/**
 * 
 */
package com.busmgmt.services;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.busmgmt.domains.BusInfo;
import com.busmgmt.entities.Bus;
import com.busmgmt.repositories.BusRepository;
import com.busmgmt.utils.BusMgmtUtil;

/**
 * @author Neerajkumar
 *
 */
@Service
public class BusMgmtService {

    private static final Logger LOGGER = LoggerFactory.getLogger(BusMgmtService.class);

    @Autowired
    private BusRepository busRepository;

    @Autowired
    private BusMgmtUtil busMgmtUtil;

    public List<BusInfo> getAvailableBuses() {
        List<Bus> buses = busRepository.findAll();
        List<BusInfo> busInfoList = buses.stream()
                .map(bus -> busMgmtUtil.getBusInfoForList(bus))
                .collect(Collectors.toList());
        return busInfoList;
    }

    public BusInfo getBusDetails(String busNumber) {
        Bus bus = busRepository.findByBusId(busNumber);
        if (null == bus) {
            LOGGER.error("bus details not available for busNumber:{}", busNumber);
            // throw exception
        }
        BusInfo busInfo = busMgmtUtil.getBusInfoDetails(bus);
        return busInfo;
    }

}
