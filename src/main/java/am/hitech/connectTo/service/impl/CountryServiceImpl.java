package am.hitech.connectTo.service.impl;

import am.hitech.connectTo.model.Country;
import am.hitech.connectTo.repository.CountryRepository;
import am.hitech.connectTo.service.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Country getByCountry(String country){
        return countryRepository.findByCountry(country);
    }
}
