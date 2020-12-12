/**
 * 
 */
package com.busmgmt.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.busmgmt.domains.BusInfo;
import com.busmgmt.services.BusMgmtService;

/**
 * 
 * @author Neerajkumar
 *
 */

@RestController
public class BusMgmtController {

    private static final Logger LOGGER = LoggerFactory.getLogger(BusMgmtController.class);

    @Autowired
    private BusMgmtService busMgmtService;

    @GetMapping(value = "/v1/buses", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<BusInfo>> getAvailableBuses() {
        LOGGER.debug("retrieving available buses");

        List<BusInfo> busInfoList = busMgmtService.getAvailableBuses();

        return new ResponseEntity<List<BusInfo>>(busInfoList,
                HttpStatus.OK);

    }

    @GetMapping(value = "/v1/buses/{busNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<BusInfo> getBusDetails(@PathVariable("busNumber") String busNumber) {
        LOGGER.debug("retrieving bus details for busNumber:{}", busNumber);

        BusInfo busInfo = busMgmtService.getBusDetails(busNumber);

        return new ResponseEntity<BusInfo>(busInfo,
                HttpStatus.OK);

    }
}
