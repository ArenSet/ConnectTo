package am.hitech.connectTo.service.impl;

import am.hitech.connectTo.model.InetInfo;
import am.hitech.connectTo.repository.InetInfoRepository;
import am.hitech.connectTo.service.InetInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InetInfoServiceImpl implements InetInfoService {

    @Autowired
    InetInfoRepository inetInfoRepository;


    @Override
    public InetInfo getInfo(String name){
        return inetInfoRepository.findByName(name);
    }
}
