package am.hitech.connectTo.service.impl;

import am.hitech.connectTo.model.State;
import am.hitech.connectTo.repository.StateRepository;
import am.hitech.connectTo.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateServiceImpl implements StateService {

    @Autowired
    private StateRepository stateRepository;

    @Override
    public List<State> findByCountryId(int countryId){
        return stateRepository.findByCountryId(countryId);
    }

    @Override
    public State findByState(String state){
        return stateRepository.findByState(state);
    }
}
