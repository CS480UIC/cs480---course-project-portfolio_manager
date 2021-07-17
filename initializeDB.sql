create database portfolio_manager;

use portfolio_manager;

create table users(
	      user_id INT AUTO_INCREMENT, 
        user_name varchar(20), 
        password varchar(20), 
        email_id varchar(20), 
	      contact varchar(15),
        is_admin boolean,
        PRIMARY KEY (user_id)
);

desc users;
      
create table stock_category(
	      category_id INT AUTO_INCREMENT,
        industry varchar(30),
        market_cap varchar(30),
	      PRIMARY KEY (category_id)
);

desc stock_category;

create table exchanges(
	      exchange_id INT AUTO_INCREMENT,
        exchange_name varchar(20),
        number_of_stock INT,
        PRIMARY KEY (exchange_id)
);

desc exchanges;

create table stock_info (
	      stock_id INT AUTO_INCREMENT,
        stock_name varchar(30),
        category_id INT,
        exchange_id INT,
        PRIMARY KEY (stock_id),
        FOREIGN KEY (category_id) REFERENCES stock_category (category_id),
        FOREIGN KEY (exchange_id) REFERENCES exchanges (exchange_id)
);

desc stock_info;

create table portfolio (
	      user_id INT,
        stock_id INT,
	      avg_price float,
	      quantity INT,
	      latest_transaction_date DATE,
	      FOREIGN KEY (user_id) REFERENCES users (user_id),
	      FOREIGN KEY (stock_id) REFERENCES stock_info (stock_id)
);

desc portfolio;

insert into users(user_name, password, email_id , contact , is_admin ) values
	('Vivek', 'vivek123', 'vivek@xyz.com', '777-775-4555', true),
    ('Arvind', 'arvind123', 'arvind@xyz.com', '777-775-4556', true),
    ('Stefan', 'stefan123', 'stefan@xyz.com', '777-775-4557', true);
