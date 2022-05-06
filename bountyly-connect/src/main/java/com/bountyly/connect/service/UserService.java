package com.bountyly.connect.service;

import com.bountyly.connect.exception.ResourceAlreadyExistsException;
import com.bountyly.connect.exception.ResourceDeleteException;
import com.bountyly.connect.exception.ResourceNotFoundException;
import com.bountyly.connect.exception.ResourceUpdateException;
import com.bountyly.connect.model.User;
import com.bountyly.connect.repository.UserRepository;
import com.bountyly.connect.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAllUsers () { return userRepository.findAllUsers (); }

    public User findUserByUserId (String userId) {
        User user = userRepository.findUserByUserId(userId);

        if (Objects.isNull(user)) {
            throw new ResourceNotFoundException (
                    MessageFormat.format(
                            "User not found with the user id - {0} try with new one", userId));
        }
        return userRepository.findUserByUserId(userId);
    }

    public User createUser (User user) {
        if (isUserAlreadyExists(user)) {
            throw new ResourceAlreadyExistsException(
                    MessageFormat.format(
                            "User already exists with the mobile no - {0}, try with new one",
                            user.getUserMobile()));
        }
        return userRepository.createUser(user);
    }

    public int updateUser (User user) {
        int x = userRepository.updateUser(user);

        if (x == 0) {
            throw new ResourceUpdateException ("Resource update failed");
        }
        return x;
    }

    public int deleteUser (User user) {
        int x = userRepository.deleteUser(user);

        if (x == 0) {
            throw new ResourceDeleteException("Resource update failed");
        }
        return x;
    }

    public boolean isUserAlreadyExists(User user) {
        User existingUser = userRepository.findUserByMobileNo(user.getUserMobile());
        if (Objects.isNull(existingUser))
            return false;
        else
            return true;
    }
}
