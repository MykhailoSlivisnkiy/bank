INSERT INTO account_status VALUES
(0, 'Active'),
(1, 'Pending'),
(2, 'Inactive'),
(3, 'Frozen');

INSERT INTO account_type VALUES
(0, 'Cash Account'),
(1, 'Bank Account'),
(2, 'Expense Account'),
(3, 'Credit Card');

INSERT INTO users VALUES
(1, 'Misha', 'Slivinskiy', 'miwka0806@gmail.com', 'admin', '123', '380661480760', 2500, null),
(2, 'Pavlo', 'Balukh', 'pashka@gmail.com', 'employee', '123', '380661480760', 500, null),
(3, 'Andriy', 'Tretiak', 'andruDick@gmail.com', 'user', '123', '380661480760', null, '2001-09-02');

INSERT INTO accounts VALUES
(1, '1111 1111 1111 1111', '123', 1, 1, 1, 15000, 'USD', '2001-10-05'),
(2, '1111 1111 1111 1112', '321', 1, 2, 2, 7000, 'USD', '2001-10-05');

INSERT INTO role VALUES
(0, 'ROLE_CLIENT', 'description'),
(1, 'ROLE_EMPLOYEE', 'description'),
(2, 'ROLE_ADMIN', 'description');

INSERT INTO user_role VALUES
(1, 2),
(2, 1),
(3, 0);
