package am.hitech.connectTo.service;

import am.hitech.connectTo.model.State;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StateService {

    List<State> findByCountryId(int countryId);

    State findByState(String state);
}
