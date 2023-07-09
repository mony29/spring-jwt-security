--- create table user ---
create table user_acc(
                         id uuid not null default gen_random_uuid() primary key ,
                         username varchar(50) ,
                         email varchar(100) not null ,
                         password varchar(50) not null ,
                         role varchar(20) ,
                         gender varchar(10) ,
                         phone varchar(50) ,
                         address text ,
                         profile text ,
                         is_enable boolean default false ,
                         created_at timestamp
);

------- database security configuration --------
create table users (
    id serial primary key ,
    name varchar(50) ,
    email varchar (100) ,
    password varchar (255) ,
    role varchar (20)
);

-------- jwt security ----------
create table roles(
                      id serial primary key ,
                      role_name varchar (100)
);

create table users(
                      id serial primary key ,
                      username varchar(50) ,
                      email varchar (100) ,
                      password varchar (255)
);

create table user_role(
                          user_id integer references users,
                          role_id integer references roles
);

