package am.hitech.connectTo.service;

import am.hitech.connectTo.util.exceptions.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface AreaDealsService {
    void addNewDeal(String country, String state, String zipCode, String service, String email);

    @Transactional
    void delete(int id) throws NotFoundException;
}
