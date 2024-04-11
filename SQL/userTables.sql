create table if not exists smartdcu.users (
	uuid int primary key auto_increment,
    name varchar(255) not null,
    email varchar(45) unique not null,
    password varchar(255) not null
    );
    
create table if not exists smartdcu.roles (
	roleID int primary key,
    roleName varchar(255)
    );
    
create table if not exists smartdcu.user_roles (
	uuid int not null,
    roleID int not null,
    foreign key (uuid) references users (uuid),
    foreign key (roleID) references roles (roleID)
    );

insert into smartdcu.roles (roleID, roleName) values ('0', 'user');

insert into smartdcu.roles (roleID, roleName) values ('1', 'admin');