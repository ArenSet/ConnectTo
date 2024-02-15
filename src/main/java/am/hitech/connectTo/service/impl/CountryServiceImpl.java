package am.hitech.connectTo.service.impl;

import am.hitech.connectTo.model.Country;
import am.hitech.connectTo.repository.CountryRepository;
import am.hitech.connectTo.service.CountryService;
import am.hitech.connectTo.util.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CountryServiceImpl implements CountryService {

    @Autowired
    private CountryRepository countryRepository;

    @Override
    public Country getByCountry(String country){
        return countryRepository.findByCountry(country);
    }

    @Override
    public List<Country> findAll(){
        return countryRepository.findAll();
    }

    @Override
    public Country findById(int id) throws NotFoundException {
        Country country = countryRepository.findById(id).orElseThrow(() ->
                new NotFoundException("There is no any country with that id"));
        return country;
    }
}
