package am.hitech.connectTo.service.impl;

import am.hitech.connectTo.model.User;
import am.hitech.connectTo.repository.UserRepository;
import am.hitech.connectTo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getByUserName(String email){
        return userRepository.findByEmail(email);
    }
}
