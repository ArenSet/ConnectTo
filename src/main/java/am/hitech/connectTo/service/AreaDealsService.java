package am.hitech.connectTo.service;

import am.hitech.connectTo.util.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface AreaDealsService {

    void addNewDeal(int countryId, int stateId, int zipCodeId, int serviceId, String email) throws NotFoundException;

    void delete(int id) throws NotFoundException;
}
