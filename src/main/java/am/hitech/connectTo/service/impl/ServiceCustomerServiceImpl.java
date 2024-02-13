package am.hitech.connectTo.service.impl;

import am.hitech.connectTo.model.ServiceCustomer;
import am.hitech.connectTo.model.dto.ServiceCustomerRequestDto;
import am.hitech.connectTo.model.dto.ServiceCustomerResponseDto;
import am.hitech.connectTo.repository.ServiceCustomerRepository;
import am.hitech.connectTo.service.ServiceCustomerService;
import am.hitech.connectTo.util.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class ServiceCustomerServiceImpl implements ServiceCustomerService {

    @Autowired
    private ServiceCustomerRepository repository;

    @Autowired
    private JavaMailSender mailSender;

    @Override
    public ServiceCustomerResponseDto getByPosition(int position){
        return modelToDto(repository.findByPosition(position));
    }

    @Override
    public void addNew(ServiceCustomerRequestDto requestDto){
        repository.save(dtoToModel(requestDto));
    }

    @Override
    public void delete(int id) throws NotFoundException {
        ServiceCustomer serviceCustomer = repository.findById(id).orElseThrow(() -> new NotFoundException("There is no any service with that id"));
        repository.deleteById(id);
    }

    @Override
    public List<ServiceCustomerResponseDto> getAll(){
        List<ServiceCustomer> customers = repository.findAll();
        List<ServiceCustomerResponseDto> responseDto = new ArrayList<>();
        for (int i = 0; i < customers.size(); i++){
            responseDto.add(modelToDto(customers.get(i)));
        }
        return responseDto;
    }

    @Transactional
    @Override
    public void update(ServiceCustomerRequestDto requestDto, int id) throws NotFoundException {
        ServiceCustomer serviceCustomer = repository.findById(id).orElseThrow(() -> new NotFoundException("There is no any service with that id"));
        if (requestDto.getTitle() != null){
            serviceCustomer.setTitle(requestDto.getTitle());
        }
        if (requestDto.getDesc() != null){
            serviceCustomer.setDesc(requestDto.getDesc());
        }
        if (requestDto.getPosition() != null){
            serviceCustomer.setPosition(requestDto.getPosition());
        }
        if (requestDto.getIcon() != null){
            serviceCustomer.setIcon(requestDto.getIcon());
        }
    }


    private ServiceCustomer dtoToModel(ServiceCustomerRequestDto requestDto){
        ServiceCustomer serviceCustomer = new ServiceCustomer();

        serviceCustomer.setTitle(requestDto.getTitle());
        serviceCustomer.setDesc(requestDto.getDesc());
        serviceCustomer.setPosition(requestDto.getPosition());
        serviceCustomer.setIcon(requestDto.getIcon());

        return serviceCustomer;
    }
    private ServiceCustomerResponseDto modelToDto(ServiceCustomer serviceCustomer){
        ServiceCustomerResponseDto responseDto = new ServiceCustomerResponseDto();

        responseDto.setTitle(serviceCustomer.getTitle());
        responseDto.setDesc(serviceCustomer.getDesc());
        responseDto.setPosition(serviceCustomer.getPosition());
        responseDto.setIcon(serviceCustomer.getIcon());

        return responseDto;
    }
}
