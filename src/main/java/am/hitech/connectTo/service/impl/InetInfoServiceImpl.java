package am.hitech.connectTo.service.impl;

import am.hitech.connectTo.model.InetInfo;
import am.hitech.connectTo.model.dto.InetInfoRequestDto;
import am.hitech.connectTo.repository.InetInfoRepository;
import am.hitech.connectTo.service.InetInfoService;
import am.hitech.connectTo.util.exceptions.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class InetInfoServiceImpl implements InetInfoService {

    @Autowired
    InetInfoRepository inetInfoRepository;


    @Override
    public InetInfo getInfo(String name){
        return inetInfoRepository.findByName(name);
    }

    @Transactional
    @Override
    public void delete(String name){
        inetInfoRepository.deleteByName(name);
    }

    @Transactional
    @Override
    public void add(InetInfoRequestDto requestDto){
        inetInfoRepository.save(dtoToModel(requestDto));
    }

    @Transactional
    @Override
    public void updateInetInfo(InetInfoRequestDto requestDto, int id) throws NotFoundException {
        InetInfo inetInfo = inetInfoRepository.findById(id).orElseThrow(() -> new NotFoundException("There is no any inet info with that id"));
        if (requestDto.getName() != null){
            inetInfo.setName(requestDto.getName());
        }
        if (requestDto.getSpeed() != null){
            inetInfo.setSpeed(requestDto.getSpeed());
        }
        if (requestDto.getPrice() != null){
            inetInfo.setPrice(requestDto.getPrice());
        }
    }




    private InetInfo dtoToModel(InetInfoRequestDto requestDto){
        InetInfo inetInfo = new InetInfo();
        inetInfo.setName(requestDto.getName());
        inetInfo.setPrice(requestDto.getPrice());
        inetInfo.setSpeed(requestDto.getSpeed());

        return inetInfo;
    }
}
