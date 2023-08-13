package com.example.casemd6.service.impl;

import com.example.casemd6.model.User;
import com.example.casemd6.model.UserPrinciple;
import com.example.casemd6.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private IUserRepository iUserRepository;

    public User findByUsername(String username) {
        return iUserRepository.findAllByUsername(username);
    }

    public boolean add(User user) {
        iUserRepository.save(user);
        return true;
    }

    public UserDetails loadUserByUsername(String username) {
        List<User> users = iUserRepository.findAll();
        for (User user : users) {
            if (Objects.equals(user.getUsername(), username)) {
                return UserPrinciple.build(user);
            }
        }
        return null;
    }

    public User findAllByEmailIdIgnoreCase(String email) {
        return iUserRepository.findAllByEmailIgnoreCase(email);
    }

    public List<User> findAll() {
        return iUserRepository.findAll();
    }
    public User findOne(Long id){
        return iUserRepository.findById(id).get();
    }
}
