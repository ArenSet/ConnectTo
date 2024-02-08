package am.hitech.connectTo.service;

import am.hitech.connectTo.model.InetInfo;
import am.hitech.connectTo.model.dto.InetInfoRequestDto;
import am.hitech.connectTo.util.exceptions.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public interface InetInfoService {
    InetInfo getInfo(String name);

    void delete(String name);

    void add(InetInfoRequestDto requestDto);

    void updateInetInfo(InetInfoRequestDto requestDto, int id) throws NotFoundException;
}
