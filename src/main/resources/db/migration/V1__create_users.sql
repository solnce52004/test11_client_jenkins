# CREATE DATABASE IF NOT EXISTS test11_client_jenkins CHARACTER SET utf8 COLLATE utf8_general_ci;
create table users
(
    id BIGINT auto_increment,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) null,
    role VARCHAR(255) null,
    constraint users_pk
        primary key (id)
);

