INSERT INTO account_status VALUES
(1, 'Active'),
(2, 'Pending'),
(3, 'Inactive');

INSERT INTO account_type VALUES
(1, 'Cash Account'),
(2, 'Bank Account'),
(3, 'Expense Account'),
(4, 'Credit Card');

INSERT INTO accounts VALUES
(1, '1111 1111 1111 1111', 1, 1, 15000, 'USD', '2001-10-05'),
(2, '1111 1111 1111 1112', 2, 2, 7000, 'USD', '2001-10-05');

INSERT INTO employees VALUES
(1, 'Misha', 'Slivinskiy', 'vpetrov@jr.com', 'login', 'password','+7 (191) 322-22-33'),
(2, 'Andriy', 'Tretiak', 'pvasechkin@jr.com', 'login', 'password', '+7 (191) 223-33-22');

INSERT INTO clients VALUES
(1, 'Vassily', 'Petrov', 1, 2, 'vpetrov@jr.com', 'login', 'password', '2001-09-04', '+7 (191) 322-22-33'),
(2, 'Pjotr', 'Vasechkin', 2, 2, 'pvasechkin@jr.com', 'login', 'password', '2001-08-03', '+7 (191) 223-33-22');