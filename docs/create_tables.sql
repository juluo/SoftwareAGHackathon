-- RideShare Database
create database rideshare;

-- User Table
create table rideshare.user_info(id int(11) primary key, name varchar(100), age int(2), gender varchar(10));

-- Ride Table
create table rideshare.ride_info(id int(11) auto_increment primary key, user_id int(15), Start varchar(100), end varchar(100), departure datetime, arrival datetime, 
duration_mins int, price float, share_status boolean, active boolean); 

-- Match Table 
create table rideshare.ride_match(id int(11) auto_increment primary key, ride_id int(11), user_id int(15), matched_rideId int(11), matched_user_id int(15),
match_status boolean);

-- Request Table
create table rideshare.ride_request(id int(11) auto_increment primary key, Ride_id int(11), user_id int(15), request_status boolean);

