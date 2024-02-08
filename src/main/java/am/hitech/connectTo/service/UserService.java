package am.hitech.connectTo.service;

import am.hitech.connectTo.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {

    User getByUserName(String email);
}
