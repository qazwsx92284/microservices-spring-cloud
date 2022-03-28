package com.infybuzz.app.service;

import com.infybuzz.app.entity.Address;
import com.infybuzz.app.repository.*;
import com.infybuzz.app.response.AddressResponse;
import com.infybuzz.app.request.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AddressService {

    Logger logger = LoggerFactory.getLogger(AddressService.class);

    @Autowired
    AddressRepository addressRepository;

    public AddressResponse createAddress(CreateAddressRequest createAddressRequest) {
        Address address = new Address();
        address.setStreet(createAddressRequest.getStreet());
        address.setCity(createAddressRequest.getCity());
        address.setCylinders(createAddressRequest.getCylinders());
        address.setColor(createAddressRequest.getColor());
        address.setState(createAddressRequest.getState());

        addressRepository.save(address);

        return new AddressResponse(address);
    }

    public AddressResponse getById(long id) {
        logger.info("Inside getById " + id);

        Address address  = addressRepository.findById(id).get();

        return new AddressResponse(address);
    }
}
