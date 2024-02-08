package am.hitech.connectTo.service;

import am.hitech.connectTo.model.InetInfo;
import org.springframework.stereotype.Service;

@Service
public interface InetInfoService {
    InetInfo getInfo(String name);
}
