CREATE TABLE IF NOT EXISTS users (
    id integer primary key,
    username varchar(60) unique,
    password varchar(60)
);