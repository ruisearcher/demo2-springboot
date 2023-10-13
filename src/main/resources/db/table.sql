create table if not exists 't_user'(
                                   USER_ID int not null primary key auto_increment,
                                   USER_NAME varchar(50),
                                   PASSWORD varchar(50)
    );