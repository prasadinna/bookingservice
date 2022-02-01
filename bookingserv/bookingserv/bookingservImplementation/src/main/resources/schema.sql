

CREATE TABLE ADDRESS (
  id INT   PRIMARY KEY,
  line1 VARCHAR(250) NOT NULL,
  line2 VARCHAR(250)  ,
  city VARCHAR(50) NOT null,
  state VARCHAR(50) NOT null,
  zipcode VARCHAR(50) NOT null
);


CREATE TABLE PERSON (
  id INT   PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250)  ,
  address_id INT NOT null,
  contact INT,
  birthdate Date,
  foreign key (address_id) references ADDRESS(ID)
);


CREATE TABLE BOOKING (
  id INT   PRIMARY KEY,
  checkin_datetime BIGINT ,
  checkout_datetime BIGINT,
  person_id int,
  total_amount numeric(10,2),
  total_currency varchar(10),
  deposit_amount numeric(10,2),
  deposit_currency varchar(10),
  foreign key (person_id) references PERSON(ID)
);