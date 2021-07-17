create database portfolio_manager;

use portfolio_manager;

create table user(
	user_id INT AUTO_INCREMENT, 
        user_name varchar(20), 
        password varchar(20),
	email_id varchar(20), 
        contact varchar(15),
        PRIMARY KEY (user_id)
      );
