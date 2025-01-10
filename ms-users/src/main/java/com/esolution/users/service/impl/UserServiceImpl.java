package com.esolution.users.service.impl;

import com.esolution.users.dto.UserDto;
import com.esolution.users.entity.UserEntity;
import com.esolution.users.exceptions.NotFoundException;
import com.esolution.users.mapper.UserMapper;
import com.esolution.users.service.IUserService;
import com.esolution.users.exceptions.OperationFailedException;
import com.esolution.users.repository.IUserRepository;
import com.esolution.users.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {
    private final IUserRepository userRepository;
    private final UserMapper userMapper;
    private final UserValidator userValidator;

    @Autowired
    public UserServiceImpl(IUserRepository userRepository, UserMapper userMapper, UserValidator userValidator) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userValidator = userValidator;
    }

    @Override
    public List<UserDto> searchAll() throws OperationFailedException {
        List<UserEntity> searchResultList = userRepository.findAll();
        return userMapper.toDtos(searchResultList);
    }

    @Override
    public UserDto search(String userId) throws RuntimeException {
        UserEntity searchResult = userRepository.findById(userId).orElseThrow(
                () -> new NotFoundException("user")
        );

        return userMapper.toDto(searchResult);
    }

    @Override
    public UserDto add(UserDto dto) throws RuntimeException {
        // TODO - check email and username as unique
        // TODO - encrypt password
        // TODO - revisit spring security as this method won't remain the same

        /*Optional<UserEntity> userExists;

        try {
            userExists = userRepository.findByEmail(dto.getEmail());
        }
        catch(OperationFailedException exception) {
            throw new OperationFailedException();
        }

        if(userExists.isPresent()) {
            throw new AlreadyFoundException("This e-mail already exists in the system. Please log in instead");
        }*/

        UserEntity entity = userMapper.toEntity(new UserEntity(), dto);

        try {
            userRepository.save(entity);
        }
        catch(DataAccessException exception) {
            throw new OperationFailedException("Could not create a new user due to an error in the database.");
        }

        return userMapper.toDto(entity);
    }

    @Override
    public UserDto update(UserDto dto) {
        UserEntity existingUser = userRepository.findById(dto.getId()).orElseThrow(
                () -> new NotFoundException("user")
        );

        UserEntity entity = userMapper.toEntity(existingUser, dto);
        try {
            userRepository.save(entity);
        }
        catch (DataAccessException exception) {
            throw new OperationFailedException("Could not update user information due to an error in the database.");
        }

        return userMapper.toDto(entity);
    }

    @Override
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(String userId) {

        boolean userExists = userRepository.existsById(userId);
        userValidator.deletionValidator(userExists);

        userRepository.deleteById(userId);
    }
}
