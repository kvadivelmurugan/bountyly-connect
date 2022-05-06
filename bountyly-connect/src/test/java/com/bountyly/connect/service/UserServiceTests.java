package com.bountyly.connect.service;

import com.bountyly.connect.exception.ResourceAlreadyExistsException;
import com.bountyly.connect.exception.ResourceDeleteException;
import com.bountyly.connect.exception.ResourceNotFoundException;
import com.bountyly.connect.exception.ResourceUpdateException;
import com.bountyly.connect.model.User;
import com.bountyly.connect.repository.UserRepository;
import com.bountyly.connect.util.CommonUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)
@Slf4j
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserServiceTests {

    @InjectMocks
    UserService userService;

    @SpyBean
    UserRepository userRepository;

    @Order(1)
    @Test
    public void should_Return_OnlyOneUser() {
        List<User> userList = userService.findAllUsers();
        log.info("Users count " + userList.size());
        assertEquals (1, userList.size());
    }

    @Order(2)
    @Test
    public void should_Return_Success_If_NewUserCreated () {
        User user = User.builder()
                        .userName("kvm126")
                        .userEmail("bountyly.connect123@mail.com")
                        .userMobile("+919840000126")
                        .userAddress1("add1")
                        .userAddress2("add2")
                        .userCode(null)
                        .userGroup(100001)
                        .userStatus(0)
                        .userLastLoggedIn(null)
                        .userCreatedOn(CommonUtil.getCurrentDateTime())
                        .userModifiedOn(null)
                        .userCreatedBy(10000001)
                        .userWalletBalance(0.0)
                        .userIntroducedBy(10000001).build();

        User userNew = userService.createUser(user);
        log.info ("userNew " + userNew.getUserId());
        assertNotEquals (null, userNew);
    }

    @Order(3)
    @Test
    public void should_Return_Success_If_ExistingUserUpdated () {
        User user = User.builder()
                .userId(10000002)
                .userName("kvm125")
                .userEmail("bountyly.connect123@mail.com")
                .userMobile("+919840000125")
                .userAddress1("add1")
                .userAddress2("add2")
                .userCode(null)
                .userGroup(100001)
                .userStatus(0)
                .userLastLoggedIn(null)
                .userCreatedOn(CommonUtil.getCurrentDateTime())
                .userModifiedOn(null)
                .userCreatedBy(10000001)
                .userModifiedBy(10000001)
                .userWalletBalance(0.0)
                .userIntroducedBy(10000001).build();

        int x = userService.updateUser(user);
        assertEquals (x, 1);
    }

    @Order(4)
    @Test
    public void should_Return_Success_If_ExistingUserDeleted () {
        User user = User.builder()
                .userId(10000002)
                .userName("kvm125")
                .userEmail("bountyly.connect123@mail.com")
                .userMobile("+919840000125")
                .userAddress1("add1")
                .userAddress2("add2")
                .userCode(null)
                .userGroup(100001)
                .userStatus(0)
                .userLastLoggedIn(null)
                .userCreatedOn(CommonUtil.getCurrentDateTime())
                .userModifiedOn(null)
                .userCreatedBy(10000001)
                .userWalletBalance(0.0)
                .userIntroducedBy(10000001).build();

        int x = userService.deleteUser(user);

        assertEquals (x, 1);
    }

    @Order(5)
    @Test
    public void should_Return_Valid_User() {
        User user = userService.findUserByUserId("10000001");
        assertNotEquals (null, user);
    }

    @Order(6)
    @Test
    public void should_Return_ResourceNotFoundException () {
        assertThrows(ResourceNotFoundException.class, () -> userService.findUserByUserId("99999999"));
    }

    @Order(7)
    @Test
    public void should_Return_ResourceAlreadyExistsException() {
        User user = User.builder()
                .userName("kvm125")
                .userEmail("bountyly.connect123@mail.com")
                .userMobile("+919999999999")
                .userAddress1("add1")
                .userAddress2("add2")
                .userCode(null)
                .userGroup(100001)
                .userStatus(0)
                .userLastLoggedIn(null)
                .userCreatedOn(CommonUtil.getCurrentDateTime())
                .userModifiedOn(null)
                .userCreatedBy(10000001)
                .userWalletBalance(0.0)
                .userIntroducedBy(10000001).build();

        assertThrows(ResourceAlreadyExistsException.class, () -> userService.createUser(user));
    }

    @Order(8)
    @Test
    public void should_Return_ResourceUpdateException () {
        User user = User.builder()
                .userId(9999999)
                .userName("kvm125")
                .userEmail("bountyly.connect123@mail.com")
                .userMobile("+919840000125")
                .userAddress1("add1")
                .userAddress2("add2")
                .userCode(null)
                .userGroup(100001)
                .userStatus(0)
                .userLastLoggedIn(null)
                .userCreatedOn(CommonUtil.getCurrentDateTime())
                .userModifiedOn(null)
                .userCreatedBy(10000001)
                .userWalletBalance(0.0)
                .userIntroducedBy(10000001).build();

        assertThrows(ResourceUpdateException.class, () -> userService.updateUser(user));
    }

    @Order(9)
    @Test
    public void should_Return_ResourceDeleteException () {
        User user = User.builder()
                .userId(9999999)
                .userName("kvm125")
                .userEmail("bountyly.connect123@mail.com")
                .userMobile("+919840000125")
                .userAddress1("add1")
                .userAddress2("add2")
                .userCode(null)
                .userGroup(100001)
                .userStatus(0)
                .userLastLoggedIn(null)
                .userCreatedOn(CommonUtil.getCurrentDateTime())
                .userModifiedOn(null)
                .userCreatedBy(10000001)
                .userWalletBalance(0.0)
                .userIntroducedBy(10000001).build();

        assertThrows(ResourceDeleteException.class, () -> userService.deleteUser(user));
    }
}
