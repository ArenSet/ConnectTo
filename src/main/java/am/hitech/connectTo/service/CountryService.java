package am.hitech.connectTo.service;

import am.hitech.connectTo.model.Country;
import org.springframework.stereotype.Service;

@Service
public interface CountryService {
    Country getByCountry(String country);
}
