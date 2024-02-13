package am.hitech.connectTo.service;

import org.springframework.stereotype.Service;

@Service
public interface AreaDealsService {
    void addNewDeal(String country, String state, String zipCode, String service, String email);
}
