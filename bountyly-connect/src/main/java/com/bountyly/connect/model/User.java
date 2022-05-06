package com.bountyly.connect.model;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.sql.Timestamp;
import java.util.Date;
import java.util.UUID;

@NoArgsConstructor (access = AccessLevel.PUBLIC)
@AllArgsConstructor (access = AccessLevel.PUBLIC)
@Builder
@Data
public class User {
    private long userId;
    private String userName;
    private String userEmail;
    private String userMobile;
    private String userAddress1;
    private String userAddress2;
    private String userCode;
    private long userGroup;
    private long userStatus;
    private Timestamp userLastLoggedIn;
    private Timestamp userCreatedOn;
    private Timestamp userModifiedOn;
    private long userCreatedBy;
    private long userModifiedBy;
    private double userWalletBalance;
    private long userIntroducedBy;
}
