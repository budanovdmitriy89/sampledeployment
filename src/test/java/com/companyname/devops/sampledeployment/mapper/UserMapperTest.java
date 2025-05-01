package com.companyname.devops.sampledeployment.mapper;

import com.companyname.devops.sampledeployment.dto.UserDTO;
import com.companyname.devops.sampledeployment.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = { UserMapperImpl.class })
class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    void testToDto() {
        User user = new User();
        user.setId(1L);
        user.setName("Alice");
        user.setNumber("123");

        UserDTO dto = userMapper.toDto(user);

        assertEquals(user.getName(), dto.getName());
        assertEquals(user.getNumber(), dto.getNumber());
    }

    @Test
    void testToEntity() {
        UserDTO dto = new UserDTO();
        dto.setName("Bob");
        dto.setNumber("456");

        User user = userMapper.toEntity(dto);

        assertNull(user.getId());
        assertEquals(dto.getName(), user.getName());
        assertEquals(dto.getNumber(), user.getNumber());
    }
}
