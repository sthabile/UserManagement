package sn.pp.usermanagement.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sn.pp.usermanagement.model.User;
import sn.pp.usermanagement.repository.UserRepository;

@Service
@RequiredArgsConstructor
public class UserService {

    @Autowired
    private final UserRepository userRepo;

    public User saveUser(User newUser){
        return userRepo.save(newUser);
    }

    public User updateUser(User updatedUserDetails){

        return userRepo.save(updatedUserDetails);
    }

}
