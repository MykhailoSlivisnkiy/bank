DROP TABLE IF EXISTS accounts CASCADE;
-- DROP SEQUENCE IF EXISTS accounts_id_seq;

DROP TABLE IF EXISTS account_status;
-- DROP SEQUENCE IF EXISTS account_status_id_seq;

DROP TABLE IF EXISTS account_type;
-- DROP SEQUENCE IF EXISTS account_type_id_seq;

DROP TABLE IF EXISTS employees CASCADE;
-- DROP SEQUENCE IF EXISTS employees_id_seq;

DROP TABLE IF EXISTS clients CASCADE;
-- DROP SEQUENCE IF EXISTS clients_id_seq;

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
    account_name  VARCHAR(25) NOT NULL ,
    account_type BIGSERIAL NOT NULL ,
    account_status BIGSERIAL NOT NULL ,
    balance INTEGER NOT NULL ,
    currency VARCHAR(3) NOT NULL ,
    opened_date DATE NOT NULL ,
    CONSTRAINT fk_account_status
        FOREIGN KEY(account_status)
	    REFERENCES account_status(id) ,
	CONSTRAINT fK_account_type
	    FOREIGN KEY(account_type)
	    REFERENCES account_type(id)

);

CREATE TABLE IF NOT EXISTS employees
(
    id BIGSERIAL PRIMARY KEY ,
    firstname  VARCHAR(200) NOT NULL ,
    lastname  VARCHAR(200) NOT NULL ,
    email VARCHAR(254) NOT NULL ,
    login VARCHAR(200) NOT NULL ,
    password VARCHAR(200) NOT NULL ,
    phone VARCHAR(20)  NOT NULL
);

CREATE TABLE IF NOT EXISTS clients
(
    id BIGSERIAL PRIMARY KEY ,
    firstname VARCHAR(200) NOT NULL ,
    lastname VARCHAR(200) NOT NULL ,
    account_id BIGSERIAL NOT NULL ,
    employee_id BIGSERIAL NOT  NULL ,
    email VARCHAR(254) NOT NULL ,
    login VARCHAR(200) NOT NULL ,
    password VARCHAR(200) NOT NULL ,
    date_became_customer DATE NOT NULL ,
    phone VARCHAR(20)  NOT NULL ,
    CONSTRAINT fk_account
        FOREIGN KEY(account_id)
	    REFERENCES accounts(id) ,
    CONSTRAINT fk_employee
        FOREIGN KEY(employee_id)
	    REFERENCES employees(id)
);
