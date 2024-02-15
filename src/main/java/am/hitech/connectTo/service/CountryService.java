package am.hitech.connectTo.service;

import am.hitech.connectTo.model.Country;
import am.hitech.connectTo.util.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface CountryService {
    Country getByCountry(String country);

    List<Country> findAll();

    Country findById(int id) throws NotFoundException;
}
