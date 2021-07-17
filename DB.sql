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
      
create table stock_category(
	category_id INT AUTO_INCREMENT,
        industry varchar(30),
        market_cap varchar(30),
	PRIMARY KEY (category_id)
	);
