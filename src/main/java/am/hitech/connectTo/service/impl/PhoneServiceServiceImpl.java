package am.hitech.connectTo.service.impl;

import am.hitech.connectTo.model.PhoneService;
import am.hitech.connectTo.model.dto.PhoneServiceRequestDto;
import am.hitech.connectTo.repository.PhoneServiceRepository;
import am.hitech.connectTo.service.PhoneServiceService;
import am.hitech.connectTo.util.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PhoneServiceServiceImpl implements PhoneServiceService {

    @Autowired
    private PhoneServiceRepository phoneServiceRepository;

    @Override
    public PhoneService getByName(String name){
        PhoneService phoneService = phoneServiceRepository.findByServiceName(name);

        return phoneService;
    }

    @Override
    @Transactional
    public void addNew(PhoneServiceRequestDto requestDto){
        phoneServiceRepository.save(dtoToModel(requestDto));
    }

    @Override
    @Transactional
    public void delete(int id){
        phoneServiceRepository.deleteById(id);
    }

    @Transactional
    @Override
    public void updatePhoneService(PhoneServiceRequestDto requestDto, int id) throws NotFoundException {
        PhoneService phoneService = phoneServiceRepository.findById(id).orElseThrow(() -> new NotFoundException("There is no any inet info with that id"));
        if (requestDto.getName() != null){
            phoneService.setServiceName(requestDto.getName());
        }
        if (requestDto.getPrice() != null){
            phoneService.setPrice(requestDto.getPrice());
        }
    }

    private PhoneService dtoToModel(PhoneServiceRequestDto requestDto){
        PhoneService phoneService = new PhoneService();
        phoneService.setServiceName(requestDto.getName());
        phoneService.setPrice(requestDto.getPrice());

        return phoneService;
    }
}
