INSERT INTO BOUNTYLY_CONNECT.PRODUCTS(PRODUCT_ID,PRODUCT_NAME,PRODUCT_STATUS) VALUES(100001,'Life Insurance',0);
INSERT INTO BOUNTYLY_CONNECT.PRODUCTS(PRODUCT_ID,PRODUCT_NAME,PRODUCT_STATUS) VALUES(100002,'Health Insurance',0);
INSERT INTO BOUNTYLY_CONNECT.PRODUCTS(PRODUCT_ID,PRODUCT_NAME,PRODUCT_STATUS) VALUES(100003,'Motor Insurance',0);

INSERT INTO BOUNTYLY_CONNECT.PERMISSIONS(PERMISSION_ID,PERMISSION_NAME,PERMISSION_STATUS) VALUES(100001,'CreateNewAgent',0);
INSERT INTO BOUNTYLY_CONNECT.PERMISSIONS(PERMISSION_ID,PERMISSION_NAME,PERMISSION_STATUS) VALUES(100002,'GetAgentList',0);
INSERT INTO BOUNTYLY_CONNECT.PERMISSIONS(PERMISSION_ID,PERMISSION_NAME,PERMISSION_STATUS) VALUES(100003,'UpdateAgent',0);
INSERT INTO BOUNTYLY_CONNECT.PERMISSIONS(PERMISSION_ID,PERMISSION_NAME,PERMISSION_STATUS) VALUES(100004,'DeleteAgent',0);
INSERT INTO BOUNTYLY_CONNECT.PERMISSIONS(PERMISSION_ID,PERMISSION_NAME,PERMISSION_STATUS) VALUES(100005,'UpdateWallet',0);
INSERT INTO BOUNTYLY_CONNECT.PERMISSIONS(PERMISSION_ID,PERMISSION_NAME,PERMISSION_STATUS) VALUES(100006,'CreateNewStaff',0);
INSERT INTO BOUNTYLY_CONNECT.PERMISSIONS(PERMISSION_ID,PERMISSION_NAME,PERMISSION_STATUS) VALUES(100007,'GetStaffList',0);
INSERT INTO BOUNTYLY_CONNECT.PERMISSIONS(PERMISSION_ID,PERMISSION_NAME,PERMISSION_STATUS) VALUES(100008,'UpdateStaff',0);
INSERT INTO BOUNTYLY_CONNECT.PERMISSIONS(PERMISSION_ID,PERMISSION_NAME,PERMISSION_STATUS) VALUES(100009,'DeleteStaff',0);
INSERT INTO BOUNTYLY_CONNECT.PERMISSIONS(PERMISSION_ID,PERMISSION_NAME,PERMISSION_STATUS) VALUES(100010,'CreateNewLead',0);
INSERT INTO BOUNTYLY_CONNECT.PERMISSIONS(PERMISSION_ID,PERMISSION_NAME,PERMISSION_STATUS) VALUES(100011,'UpdateLead',0);
INSERT INTO BOUNTYLY_CONNECT.PERMISSIONS(PERMISSION_ID,PERMISSION_NAME,PERMISSION_STATUS) VALUES(100012,'GetLeadList',0);
INSERT INTO BOUNTYLY_CONNECT.PERMISSIONS(PERMISSION_ID,PERMISSION_NAME,PERMISSION_STATUS) VALUES(100013,'DeleteLead',0);
INSERT INTO BOUNTYLY_CONNECT.PERMISSIONS(PERMISSION_ID,PERMISSION_NAME,PERMISSION_STATUS) VALUES(100014,'GetWalletBalance',0);


INSERT INTO BOUNTYLY_CONNECT.GROUPS(GROUP_ID,GROUP_NAME,GROUP_STATUS) VALUES(100001,'Super Admin',0);
INSERT INTO BOUNTYLY_CONNECT.GROUPS(GROUP_ID,GROUP_NAME,GROUP_STATUS) VALUES(100002,'Office Staff',0);
INSERT INTO BOUNTYLY_CONNECT.GROUPS(GROUP_ID,GROUP_NAME,GROUP_STATUS) VALUES(100003,'Agent',0);

INSERT INTO BOUNTYLY_CONNECT.GROUPS_PERMISSIONS(GROUP_ID,PERMISSION_ID) VALUES(100001,100001);
INSERT INTO BOUNTYLY_CONNECT.GROUPS_PERMISSIONS(GROUP_ID,PERMISSION_ID) VALUES(100001,100002);
INSERT INTO BOUNTYLY_CONNECT.GROUPS_PERMISSIONS(GROUP_ID,PERMISSION_ID) VALUES(100001,100003);
INSERT INTO BOUNTYLY_CONNECT.GROUPS_PERMISSIONS(GROUP_ID,PERMISSION_ID) VALUES(100001,100004);
INSERT INTO BOUNTYLY_CONNECT.GROUPS_PERMISSIONS(GROUP_ID,PERMISSION_ID) VALUES(100001,100005);
INSERT INTO BOUNTYLY_CONNECT.GROUPS_PERMISSIONS(GROUP_ID,PERMISSION_ID) VALUES(100001,100006);
INSERT INTO BOUNTYLY_CONNECT.GROUPS_PERMISSIONS(GROUP_ID,PERMISSION_ID) VALUES(100001,100007);
INSERT INTO BOUNTYLY_CONNECT.GROUPS_PERMISSIONS(GROUP_ID,PERMISSION_ID) VALUES(100001,100008);
INSERT INTO BOUNTYLY_CONNECT.GROUPS_PERMISSIONS(GROUP_ID,PERMISSION_ID) VALUES(100001,100009);
INSERT INTO BOUNTYLY_CONNECT.GROUPS_PERMISSIONS(GROUP_ID,PERMISSION_ID) VALUES(100001,100010);
INSERT INTO BOUNTYLY_CONNECT.GROUPS_PERMISSIONS(GROUP_ID,PERMISSION_ID) VALUES(100001,100011);
INSERT INTO BOUNTYLY_CONNECT.GROUPS_PERMISSIONS(GROUP_ID,PERMISSION_ID) VALUES(100001,100012);
INSERT INTO BOUNTYLY_CONNECT.GROUPS_PERMISSIONS(GROUP_ID,PERMISSION_ID) VALUES(100001,100013);
INSERT INTO BOUNTYLY_CONNECT.GROUPS_PERMISSIONS(GROUP_ID,PERMISSION_ID) VALUES(100001,100014);
INSERT INTO BOUNTYLY_CONNECT.GROUPS_PERMISSIONS(GROUP_ID,PERMISSION_ID) VALUES(100002,100001);
INSERT INTO BOUNTYLY_CONNECT.GROUPS_PERMISSIONS(GROUP_ID,PERMISSION_ID) VALUES(100002,100002);
INSERT INTO BOUNTYLY_CONNECT.GROUPS_PERMISSIONS(GROUP_ID,PERMISSION_ID) VALUES(100002,100003);
INSERT INTO BOUNTYLY_CONNECT.GROUPS_PERMISSIONS(GROUP_ID,PERMISSION_ID) VALUES(100002,100004);
INSERT INTO BOUNTYLY_CONNECT.GROUPS_PERMISSIONS(GROUP_ID,PERMISSION_ID) VALUES(100002,100005);
INSERT INTO BOUNTYLY_CONNECT.GROUPS_PERMISSIONS(GROUP_ID,PERMISSION_ID) VALUES(100002,100013);
INSERT INTO BOUNTYLY_CONNECT.GROUPS_PERMISSIONS(GROUP_ID,PERMISSION_ID) VALUES(100002,100014);
INSERT INTO BOUNTYLY_CONNECT.GROUPS_PERMISSIONS(GROUP_ID,PERMISSION_ID) VALUES(100003,100010);
INSERT INTO BOUNTYLY_CONNECT.GROUPS_PERMISSIONS(GROUP_ID,PERMISSION_ID) VALUES(100003,100011);
INSERT INTO BOUNTYLY_CONNECT.GROUPS_PERMISSIONS(GROUP_ID,PERMISSION_ID) VALUES(100003,100012);
INSERT INTO BOUNTYLY_CONNECT.GROUPS_PERMISSIONS(GROUP_ID,PERMISSION_ID) VALUES(100003,100013);
INSERT INTO BOUNTYLY_CONNECT.GROUPS_PERMISSIONS(GROUP_ID,PERMISSION_ID) VALUES(100003,100014);

INSERT INTO BOUNTYLY_CONNECT.USERS (USER_ID, USER_NAME, USER_EMAIL, USER_MOBILE, USER_GROUP, USER_STATUS, USER_CREATED_ON, USER_CREATED_BY) VALUES(10000001,'sadmin','bountyly.connect@mail.com','+919999999999',100001,0,LOCALTIMESTAMP,10000001);

INSERT INTO BOUNTYLY_CONNECT.USERS_PRODUCTS(USER_ID,PRODUCT_ID) VALUES(10000001,100001);
INSERT INTO BOUNTYLY_CONNECT.USERS_PRODUCTS(USER_ID,PRODUCT_ID) VALUES(10000001,100002);
INSERT INTO BOUNTYLY_CONNECT.USERS_PRODUCTS(USER_ID,PRODUCT_ID) VALUES(10000001,100003);