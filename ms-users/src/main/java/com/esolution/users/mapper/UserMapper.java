package com.esolution.users.mapper;

import com.esolution.users.dto.UserDto;
import com.esolution.users.entity.UserEntity;
import com.esolution.users.helper.AbstractMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper extends AbstractMapper<UserEntity, UserDto> {
    @Override
    public UserEntity toEntity(UserEntity entity, UserDto dto) {
        entity.setEmail(dto.getEmail());
        entity.setUsername(dto.getUsername());
        entity.setFirstName(dto.getFirstName());
        entity.setLastName(dto.getLastName());
        entity.setPassword(dto.getPassword());

        return entity;
    }

    @Override
    public UserDto toDto(UserEntity entity) {
        UserDto dto = new UserDto();

        dto.setId(entity.getId().toHexString());
        dto.setEmail(entity.getEmail());
        dto.setUsername(entity.getUsername());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setPassword(entity.getPassword());

        return dto;
    }
}
