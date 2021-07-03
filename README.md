# cs480---course-project-portfolio_manager
cs480---course-project-portfolio_manager created by GitHub Classroom

## Table of Contents
1. [Database](#database)
1. [Author(s)](#author)
1. [Database description](#description)
 
# Database
portfolio_manager

# Author(s)
1. Arvind Gupta
2. Stefan Vukovic
3. Vivek Mishra


# Database description

The topic for our project is a financial portfolio manager for users in which they will have different features. 
These features will include price averaging of stock bought/loss, different user profiles switching, input capability of history of trades, etc. 
All of these will be databases stored, thus the project will be database heavy with a front end to enable users to interact with the database.

**Database Design **

We will have the main user table with a user name, email, contact info, unique ID, etc. There will be another entity for a financial portfolio that will have a unique ID with a foreign key, connecting with the user table. Another entity will include financial stock names spread, prices, avg prices, and all the other necessary stock information from which the user will be able to select their picks. This entity will have its own categorization based on the financial sector, which will enable the user will have a drop a down menu for the category of stocks to pick from, based on different sector characteristics such as market capitalization. 
