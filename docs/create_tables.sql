-- RideShare Database
create database rideshare;

-- User Table
-- create table rideshare.user_info(id int(11) primary key, name varchar(100), age int(2), gender varchar(10));

-- Ride Table
-- create table rideshare.ride_info(id int(11) auto_increment primary key, user_id int(15), Start varchar(100), end varchar(100), departure datetime, arrival datetime, 
-- duration_mins int, price float, share_status boolean, active boolean); 

-- Match Table 
-- create table rideshare.ride_match(id int(11) auto_increment primary key, ride_id int(11), user_id int(15), matched_rideId int(11), matched_user_id int(15),
-- match_status boolean);

-- Request Table
-- create table rideshare.ride_request(id int(11) auto_increment primary key, Ride_id int(11), user_id int(15), request_status boolean);

create table rideshare.user_info(id int(11) primary key, name varchar(100), phone varchar(100), gender varchar(10));

create table rideshare.share_details(id int(11) auto_increment primary key, userId varchar(100), startLat float, startLong float,
stopLat float, stopLong float, duration varchar(100), price float, inActive boolean);


create table rideshare.suggested_route_details(id int(11), primaryUser varchar(100), secondaryUser varchar(100), combinedStartLat float,
combinedStartLong float, combinedEndLat float, combinedEndLong float, price float, time varchar(100), point1 varchar(100),
point2 varchar(100), point3 varchar(100), point4 varchar(100), primaryStartIn varchar(100), secondaryStartIn varchar(100),
primaryPrice varchar(100), secondaryPrice varchar(100), primaryTime varchar(100), secondaryTime varchar(100), 
matchCount int(2), inActive boolean);


