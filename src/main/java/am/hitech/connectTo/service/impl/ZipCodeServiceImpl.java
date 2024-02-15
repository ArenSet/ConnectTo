package am.hitech.connectTo.service.impl;

import am.hitech.connectTo.model.ZipCode;
import am.hitech.connectTo.repository.ZipCodeRepository;
import am.hitech.connectTo.service.ZipCodeService;
import am.hitech.connectTo.util.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ZipCodeServiceImpl implements ZipCodeService {

    @Autowired
    private ZipCodeRepository zipCodeRepository;

    @Override
    public List<ZipCode> findByStateId(int stateId, String zipCode){
        return zipCodeRepository.findByStateId(stateId, zipCode);
    }

    @Override
    public ZipCode findById(int id) throws NotFoundException {

            ZipCode zipCode = zipCodeRepository.findById(id).orElseThrow(() -> new NotFoundException("jlsfn"));
            return zipCode;


    }
}
