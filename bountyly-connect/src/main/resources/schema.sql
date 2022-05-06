
CREATE SCHEMA IF NOT EXISTS BOUNTYLY_CONNECT;

CREATE TABLE IF NOT EXISTS BOUNTYLY_CONNECT.LOV (LOV_ID BIGINT PRIMARY KEY, LOV_NAME VARCHAR(50));
CREATE TABLE IF NOT EXISTS BOUNTYLY_CONNECT.LOV_DTL (LOV_DTL_ID BIGINT PRIMARY KEY, LOV_ID BIGINT,LOV_CODE VARCHAR(24),LOV_VALUE VARCHAR(24));
CREATE TABLE IF NOT EXISTS BOUNTYLY_CONNECT.PRODUCTS (PRODUCT_ID BIGINT PRIMARY KEY, PRODUCT_NAME VARCHAR(100),PRODUCT_STATUS INT);
CREATE TABLE IF NOT EXISTS BOUNTYLY_CONNECT.PERMISSIONS (PERMISSION_ID BIGINT PRIMARY KEY, PERMISSION_NAME VARCHAR(100),PERMISSION_STATUS INT);
CREATE TABLE IF NOT EXISTS BOUNTYLY_CONNECT.GROUPS (GROUP_ID BIGINT PRIMARY KEY, GROUP_NAME VARCHAR(100),GROUP_STATUS INT);
CREATE TABLE IF NOT EXISTS BOUNTYLY_CONNECT.GROUPS_PERMISSIONS (GROUP_ID BIGINT,PERMISSION_ID BIGINT, PRIMARY KEY(GROUP_ID,PERMISSION_ID), CONSTRAINT FK_GP_GROUP_ID FOREIGN KEY (GROUP_ID) REFERENCES BOUNTYLY_CONNECT.GROUPS(GROUP_ID), CONSTRAINT FK_GP_PERMISSION_ID FOREIGN KEY (PERMISSION_ID) REFERENCES BOUNTYLY_CONNECT.PERMISSIONS(PERMISSION_ID));
CREATE TABLE IF NOT EXISTS BOUNTYLY_CONNECT.USERS (USER_ID BIGINT PRIMARY KEY, USER_NAME VARCHAR(50),USER_EMAIL VARCHAR(50),USER_MOBILE VARCHAR(15) NOT NULL,USER_ADDRESS_1 VARCHAR(100),USER_ADDRESS_2 VARCHAR(100),USER_CODE VARCHAR(5),USER_GROUP BIGINT,USER_STATUS INT,USER_LAST_LOGGED_IN TIMESTAMP,USER_CREATED_ON TIMESTAMP,USER_MODIFIED_ON TIMESTAMP,USER_CREATED_BY BIGINT,USER_MODIFIED_BY BIGINT,USER_WALLET_BALANCE NUMERIC(10,2),USER_INTRODUCED_BY BIGINT, CONSTRAINT FK_USERS_GROUP_ID FOREIGN KEY (USER_GROUP) REFERENCES BOUNTYLY_CONNECT.GROUPS(GROUP_ID), CONSTRAINT FK_USERS_CREATED_BY FOREIGN KEY (USER_CREATED_BY) REFERENCES BOUNTYLY_CONNECT.USERS(USER_ID), CONSTRAINT FK_USERS_MODIFIED_BY FOREIGN KEY (USER_MODIFIED_BY) REFERENCES BOUNTYLY_CONNECT.USERS(USER_ID), CONSTRAINT FK_USERS_INTRODUCED_BY FOREIGN KEY (USER_INTRODUCED_BY) REFERENCES BOUNTYLY_CONNECT.USERS(USER_ID), CONSTRAINT UK_USERS_MOBILE_NO UNIQUE (USER_MOBILE));
CREATE TABLE IF NOT EXISTS BOUNTYLY_CONNECT.USERS_PRODUCTS (USER_ID BIGINT,PRODUCT_ID BIGINT, PRIMARY KEY(USER_ID,PRODUCT_ID), CONSTRAINT FK_UP_USER_ID FOREIGN KEY (USER_ID) REFERENCES BOUNTYLY_CONNECT.USERS(USER_ID), CONSTRAINT FK_UP_PRODUCT_ID FOREIGN KEY (PRODUCT_ID) REFERENCES BOUNTYLY_CONNECT.PRODUCTS(PRODUCT_ID));

CREATE SEQUENCE IF NOT EXISTS BOUNTYLY_CONNECT.users_id_seq START WITH 10000002;
CREATE UNIQUE INDEX IF NOT EXISTS IDX_USERS_MOBILE_NO ON BOUNTYLY_CONNECT.USERS(USER_MOBILE);