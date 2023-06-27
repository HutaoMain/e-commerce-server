package com.rimsti.rimsti.service;

import com.rimsti.rimsti.model.User;
import com.rimsti.rimsti.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public User registerUser(User user) {
        User userByEmail = userRepository.findByEmail(user.getEmail());

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        return userRepository.save(user);
    }

    public User loginUser(String email, String password) throws Exception {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new Exception("User not found");
        }
        if (!encoder.matches(password, user.getPassword())) {
            throw new Exception("Invalid password");
        }
        return user;
    }

    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public List<User> getListUser() {
        return userRepository.findAll();
    }

    public void updatePassword(String email, User user) {
        User setUser = userRepository.findByEmail(email);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
        String encodedPassword = encoder.encode(user.getPassword());
        setUser.setPassword(encodedPassword);
        userRepository.save(setUser);
    }

    public void updateAddress(String email, User user) {
        User setUser = userRepository.findByEmail(email);
        setUser.setFirstLogin(true);
        setUser.setBarangay(user.getBarangay());
        setUser.setStreet(user.getStreet());
        setUser.setCity(user.getCity());
        setUser.setMunicipality(user.getMunicipality());
        setUser.setPostalCode(user.getPostalCode());
        userRepository.save(setUser);
    }

    public void updateUserImageUrl(String email, User user) {
        User setUser = userRepository.findByEmail(email);
        setUser.setImageUrl(user.getImageUrl());
        userRepository.save(setUser);
    }
}
