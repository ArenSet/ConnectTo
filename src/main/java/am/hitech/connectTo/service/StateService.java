package am.hitech.connectTo.service;

import am.hitech.connectTo.model.State;
import am.hitech.connectTo.util.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StateService {

    State findById(int id) throws NotFoundException;

    List<State> findByCountryId(int countryId);

    State findByState(String state);
}
