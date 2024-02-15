package am.hitech.connectTo.service;

import am.hitech.connectTo.model.ServiceCustomer;
import am.hitech.connectTo.model.dto.ServiceCustomerRequestDto;
import am.hitech.connectTo.model.dto.ServiceCustomerResponseDto;
import am.hitech.connectTo.util.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;


public interface ServiceCustomerService {
    ServiceCustomer findById(int id) throws NotFoundException;

    ServiceCustomerResponseDto getByPosition(int position);

    void addNew(ServiceCustomerRequestDto requestDto);

    void delete(int id) throws NotFoundException;

    List<ServiceCustomerResponseDto> getAll();

    void update(ServiceCustomerRequestDto requestDto, int id) throws NotFoundException;
}
