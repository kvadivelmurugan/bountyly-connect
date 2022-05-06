package com.bountyly.connect.mapper;

import com.bountyly.connect.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;


public class UserMapper<U> implements RowMapper<User> {
    @Override
    public User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setUserId(rs.getLong("USER_ID"));
        user.setUserName(rs.getString("USER_NAME"));
        user.setUserEmail(rs.getString("USER_EMAIL"));
        user.setUserMobile(rs.getString("USER_MOBILE"));
        user.setUserAddress1(rs.getString("USER_ADDRESS_1"));
        user.setUserAddress2(rs.getString("USER_ADDRESS_2"));
        user.setUserCode(rs.getString("USER_CODE"));
        user.setUserGroup(rs.getInt("USER_GROUP"));
        user.setUserStatus(rs.getInt("USER_STATUS"));
        user.setUserLastLoggedIn(rs.getTimestamp("USER_LAST_LOGGED_IN"));
        user.setUserCreatedOn(rs.getTimestamp("USER_CREATED_ON"));
        user.setUserModifiedOn(rs.getTimestamp("USER_MODIFIED_ON"));
        user.setUserCreatedBy(rs.getInt("USER_CREATED_BY"));
        user.setUserModifiedBy(rs.getInt("USER_MODIFIED_BY"));
        user.setUserWalletBalance(rs.getDouble("USER_WALLET_BALANCE"));
        user.setUserIntroducedBy(rs.getInt("USER_INTRODUCED_BY"));
        return user;
    }
}
