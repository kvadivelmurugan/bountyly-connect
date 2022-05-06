package com.bountyly.connect.repository;

import com.bountyly.connect.mapper.UserMapper;
import com.bountyly.connect.model.User;
import com.bountyly.connect.util.CommonUtil;
import com.bountyly.connect.util.SQLQueries;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.util.List;

@Repository
@Slf4j
public class UserRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<User> findAllUsers () {
        return jdbcTemplate.query (SQLQueries.FIND_ALL_USERS, new UserMapper<User>());
    }

    public User findUserByUserId(String userId) {
        try {
            return jdbcTemplate.queryForObject(SQLQueries.FIND_USER_BY_USER_ID,
                    new UserMapper<User>(), new Object[]{userId});
        } catch (EmptyResultDataAccessException e) {
            log.warn (MessageFormat.format("No record found with the user id - {0}", userId));
            return null;
        }
    }

    public User findUserByMobileNo(String mobileNo) {
        try {
        return jdbcTemplate.queryForObject(SQLQueries.FIND_USER_BY_MOBILE_NO,
                new UserMapper<User>(), new Object[]{mobileNo});
        } catch (EmptyResultDataAccessException e) {
            log.warn (MessageFormat.format("No record found with the mobile no - {0}", mobileNo));
            return null;
        }
    }

    //USER_NAME, USER_EMAIL, USER_MOBILE, USER_ADDRESS_1, USER_ADDRESS_2, USER_CODE,
    // USER_GROUP, USER_STATUS, USER_CREATED_ON, USER_CREATED_BY, USER_WALLET_BALANCE, USER_INTRODUCED_BY
    public User createUser (User user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(connection -> {
            PreparedStatement ps = connection.prepareStatement(SQLQueries.CREATE_USER, new String[]{"user_id"});
            //ps.setObject(1, user.getUserId());
            ps.setString (1, user.getUserName());
            ps.setString (2, user.getUserEmail());
            ps.setString (3, user.getUserMobile());
            ps.setString (4, user.getUserAddress1());
            ps.setString (5, user.getUserAddress2());
            ps.setString (6, user.getUserCode());
            ps.setLong (7, user.getUserGroup());
            ps.setLong (8, user.getUserStatus());
            ps.setTimestamp (9, CommonUtil.getCurrentDateTime());
            ps.setLong (10, user.getUserCreatedBy());
            ps.setDouble (11, user.getUserWalletBalance());
            ps.setLong (12, user.getUserIntroducedBy());
            return ps;
        }, keyHolder);
        user.setUserId(keyHolder.getKey().longValue());
        return user;
    }

    public int updateUser (User user) {
        int x = jdbcTemplate.update(SQLQueries.UPDATE_USER, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, user.getUserName());
                ps.setString(2, user.getUserEmail());
                ps.setString(3, user.getUserMobile());
                ps.setString(4, user.getUserAddress1());
                ps.setString(5, user.getUserAddress2());
                ps.setString(6, user.getUserCode());
                ps.setLong (7, user.getUserGroup());
                ps.setLong(8, user.getUserStatus());
                ps.setLong (9, user.getUserModifiedBy());
                ps.setLong (10, user.getUserIntroducedBy());
                ps.setObject(11, user.getUserId());
            }
        });
        return x;
    }

    public int deleteUser (User user) {
        return jdbcTemplate.update(SQLQueries.DELETE_USER, new Object[]{user.getUserId()});
    }

}
