drop table if exists users;
create table if not exists users(
    id   serial primary key,
    name varchar(25) not null,
    age integer not null);