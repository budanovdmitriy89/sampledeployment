package com.companyname.devops.sampledeployment.service;

import com.companyname.devops.sampledeployment.dto.UserDTO;
import com.companyname.devops.sampledeployment.entity.User;
import com.companyname.devops.sampledeployment.mapper.UserMapper;
import com.companyname.devops.sampledeployment.reposiroty.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo repo;
    private final UserMapper mapper;

    public Optional<User> findById(Long id) {
        return repo.findById(id);
    }

    public User save(UserDTO userDTO) {
        return repo.save(mapper.toEntity(userDTO));
    }

    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    public List<UserDTO> findAll() {
        return repo.findAll().stream().map(mapper::toDto).toList();
    }
}
