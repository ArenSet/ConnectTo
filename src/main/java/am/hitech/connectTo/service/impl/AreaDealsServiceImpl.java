package am.hitech.connectTo.service.impl;

import am.hitech.connectTo.model.AreaDeals;
import am.hitech.connectTo.repository.AreaDealsRepository;
import am.hitech.connectTo.service.AreaDealsService;
import am.hitech.connectTo.util.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AreaDealsServiceImpl implements AreaDealsService {

    @Autowired
    private AreaDealsRepository areaDealsRepository;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    @Transactional
    public void addNewDeal(String country, String state, String zipCode, String service, String email){

        AreaDeals areaDeals = new AreaDeals();
        areaDeals.setCountry(country);
        areaDeals.setState(state);
        areaDeals.setZipCode(zipCode);
        areaDeals.setService(service);
        areaDeals.setEmail(email);

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
