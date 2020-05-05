INSERT INTO address(address_id,address_name) VALUES(1,'地址1');
INSERT INTO user(user_id,username,password,address_id) VALUES(1,'admin','admin',1);

INSERT INTO hobby(hobby_id,hobby_name) VALUES(1,'跳舞');
INSERT INTO hobby(hobby_id,hobby_name) VALUES(2,'唱歌');

INSERT INTO user_hobby(user_id, hobby_id) VALUES(1,1);