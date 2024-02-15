package am.hitech.connectTo.service;

import am.hitech.connectTo.model.ZipCode;
import am.hitech.connectTo.util.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ZipCodeService {

    List<ZipCode> findByStateId(int stateId, String zipCode);

    ZipCode findById(int id) throws NotFoundException;
}
