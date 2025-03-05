package com.example.demo.Service;


import com.example.Details.CustomUserDetails;
import com.example.demo.DTO.UserDTO;
import com.example.demo.Entity.UserEntity;
import com.example.demo.Entity.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService implements org.springframework.security.core.userdetails.UserDetailsService {
    int foydalanuvchi;
    int redo;
    private UserEntity userEntity;

    @Autowired
    private UserRepository userRepository;

    public CustomUserDetailsService(UserEntity userEntity) {
        this.userEntity = userEntity;

    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        Optional<UserEntity> optional = userRepository.findById(username);
        if (optional.isEmpty()) {
            throw new UsernameNotFoundException(foydalanuvchi + " not found");
        }
        UserEntity user = optional.get();

        UserDetails userDetails = new CustomUserDetails(user);
        return userDetails;
    }

    public UserDTO register(UserDTO userDTO) {
        Optional<UserEntity> dto = userRepository.findById(userDTO.getNumber());
        if (dto.isPresent()) {
            return null;
        }
        UserEntity entity = new UserEntity();
        redo = Integer.parseInt(userDTO.getNumber());
        entity.setNumber(redo);
        entity.setName(userDTO.getName());
        entity.setSurname(userDTO.getSurname());
        entity.setRole(userDTO.getRole());
        entity.setPassword(userDTO.getPassword());
        entity.setBalance(userDTO.getBalance());
        userRepository.save(entity);

        userDTO.setId(entity.getId());

        return userDTO;


    }


}



