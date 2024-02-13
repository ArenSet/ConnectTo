package am.hitech.connectTo.service;

import am.hitech.connectTo.model.ZipCode;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ZipCodeService {
    List<ZipCode> findByStateId(int stateId);
}
