create table users
(
    id       uuid         not null primary key,
    username varchar(255) not null unique,
    email    varchar(255) not null unique,
    password varchar(255) not null,
    role     varchar(255) not null
);