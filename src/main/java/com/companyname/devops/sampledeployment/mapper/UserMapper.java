package com.companyname.devops.sampledeployment.mapper;

import com.companyname.devops.sampledeployment.dto.UserDTO;
import com.companyname.devops.sampledeployment.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User toEntity(UserDTO userDTO);
    UserDTO toDto(User user);
}
