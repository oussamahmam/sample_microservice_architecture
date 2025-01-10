package com.esolution.users.service;

import com.esolution.users.dto.UserDto;
import com.esolution.users.exceptions.OperationFailedException;

import java.util.List;

public interface IUserService {
    List<UserDto> searchAll() throws OperationFailedException;
    UserDto search(String userId) throws RuntimeException;
    UserDto add(UserDto dto) throws RuntimeException;
    UserDto update(UserDto dto) throws RuntimeException;
    void  delete(String userId);
}
