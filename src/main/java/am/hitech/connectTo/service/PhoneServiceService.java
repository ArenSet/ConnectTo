package am.hitech.connectTo.service;

import am.hitech.connectTo.model.PhoneService;
import am.hitech.connectTo.model.dto.PhoneServiceRequestDto;
import am.hitech.connectTo.util.exceptions.NotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public interface PhoneServiceService {
    PhoneService getByName(String name) throws NotFoundException;

    void addNew(PhoneServiceRequestDto requestDto);

    void delete(int id);

    @Transactional
    void updatePhoneService(PhoneServiceRequestDto requestDto, int id) throws NotFoundException;
}
