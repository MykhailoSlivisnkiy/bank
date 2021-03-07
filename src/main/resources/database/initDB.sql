DROP TABLE IF EXISTS accounts CASCADE;

DROP TABLE IF EXISTS account_status;

DROP TABLE IF EXISTS account_type;

DROP TABLE IF EXISTS users CASCADE;

DROP TABLE IF EXISTS role CASCADE;

DROP TABLE IF EXISTS user_role CASCADE;

DROP TABLE IF EXISTS client_attributes CASCADE;

DROP TABLE IF EXISTS employee_attributes CASCADE;

DROP SEQUENCE IF EXISTS user_id_seq;
DROP SEQUENCE IF EXISTS transaction_id_seq;
DROP SEQUENCE IF EXISTS accounts_id_seq;

CREATE SEQUENCE user_id_seq INCREMENT 1 START 4;
CREATE SEQUENCE transaction_id_seq INCREMENT 1 START 4;
CREATE SEQUENCE accounts_id_seq INCREMENT 1 START 4;

CREATE TABLE IF NOT EXISTS users
(
    id BIGSERIAL PRIMARY KEY ,
    firstname VARCHAR(200) NOT NULL ,
    lastname VARCHAR(200) NOT NULL ,
    email VARCHAR(254) NOT NULL ,
    username VARCHAR(200) NOT NULL ,
    password VARCHAR(200) NOT NULL ,
    phone VARCHAR(20)  NOT NULL ,
    salary INTEGER ,
    date_became_client DATE
);

CREATE TABLE IF NOT EXISTS role
(
    id BIGSERIAL PRIMARY KEY ,
    role_name VARCHAR(100) NOT NULL,
    desciption VARCHAR(200)
);

CREATE TABLE IF NOT EXISTS user_role
(
    user_id BIGSERIAL NOT NULL ,
    role_id BIGSERIAL NOT NULL ,
    CONSTRAINT fk_user
        FOREIGN KEY(user_id)
        REFERENCES users(id) ,
    CONSTRAINT fr_role
        FOREIGN KEY(role_id)
        REFERENCES role(id)
);

CREATE TABLE IF NOT EXISTS account_status
(
    id BIGSERIAL PRIMARY KEY ,
    status_desciption  VARCHAR(500) NOT NULL
);

CREATE TABLE IF NOT EXISTS account_type
(
    id BIGSERIAL PRIMARY KEY ,
    account_type  VARCHAR(25) NOT NULL
);

CREATE TABLE IF NOT EXISTS accounts
(
    id BIGSERIAL PRIMARY KEY ,
    account_number  VARCHAR(25) NOT NULL ,
    card_varification_value VARCHAR NOT NULL ,
    client_id BIGSERIAL NOT NULL ,
    account_type BIGSERIAL NOT NULL ,
    account_status BIGSERIAL NOT NULL ,
    balance INTEGER NOT NULL ,
    currency VARCHAR(3) NOT NULL ,
    opened_date DATE NOT NULL ,
    CONSTRAINT fk_clientId
        FOREIGN KEY(client_id)
        REFERENCES users(id) ,
    CONSTRAINT fk_account_status
        FOREIGN KEY(account_status)
	    REFERENCES account_status(id) ,
	CONSTRAINT fK_account_type
	    FOREIGN KEY(account_type)
	    REFERENCES account_type(id)
);
