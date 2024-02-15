package am.hitech.connectTo.service.impl;

import am.hitech.connectTo.model.*;
import am.hitech.connectTo.repository.*;
import am.hitech.connectTo.service.*;
import am.hitech.connectTo.util.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Service
public class AreaDealsServiceImpl implements AreaDealsService {

    @Autowired
    private AreaDealsRepository areaDealsRepository;

    @Autowired
    private CountryService countryService;

    @Autowired
    private StateService stateService;

    @Autowired
    private ZipCodeService zipCodeService;

    @Autowired
    private ServiceCustomerService serviceCustomerService;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    @Transactional
    public void addNewDeal(int countryId, int stateId, int zipCodeId, int serviceId, String email) throws NotFoundException {

        AreaDeals areaDeals = new AreaDeals();

        Country country = countryService.findById(countryId);

        State state = stateService.findById(stateId);

        ZipCode zipCode = zipCodeService.findById(zipCodeId);

        ServiceCustomer serviceCustomer = serviceCustomerService.findById(serviceId);


        areaDeals.setCountry(country.getCountry());

        if (state.getCountryId() == countryId){
            areaDeals.setState(state.getState());
        }

        if (zipCode.getStateId() == stateId){
            areaDeals.setZipCode(zipCode.getZipCode());
        }

        areaDeals.setService(serviceCustomer.getDesc());

        if (email.matches("^\\w+([\\.-]?\\w+)*@\\w+([\\.-]?\\w+)*(\\.\\w{2,3})+$")){
            areaDeals.setEmail(email);
        }


        sendEmail(email,"Thank you", "Congratulations, we well contact you soon.");
        sendEmail("setaghyan.aren@gmail.com", "New area deals", areaDeals.toString());

        areaDealsRepository.save(areaDeals);

    }

    @Override
    @Transactional
    public void delete(int id) throws NotFoundException {
        AreaDeals areaDeals = areaDealsRepository.findById(id).orElseThrow(() ->new NotFoundException("There is no any deal with that id"));
        areaDealsRepository.delete(areaDeals);
    }


    public void sendEmail(String to, String subject, String body){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);
        message.setSubject(subject);
        message.setText(body);
        mailSender.send(message);
    }
}
