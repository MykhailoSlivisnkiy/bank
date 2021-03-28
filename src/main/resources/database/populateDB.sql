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
(1, 'Misha', 'Slivinskiy', 'miwka0806@gmail.com', 'admin', '$2a$10$wjZXR6VOg1WtMR6nsLgeruX2xhCgGliq8SRsPfjpox55ns6hrKlrG', '380661480760', 2500, null),
(2, 'Pavlo', 'Balukh', 'pashka@gmail.com', 'employee', '$2a$10$kw/JFfdej.a5ALnDjX/XDudxXc4JU4aefEGxWbT0wZZrqednTpg9u', '380661480760', 500, null),
(3, 'Nazar', 'Shakin', 'nazar@gmail.com', 'user', '$2a$10$kw/JFfdej.a5ALnDjX/XDudxXc4JU4aefEGxWbT0wZZrqednTpg9u', '380661480760', null, '2001-09-02'),
(4, 'Roman', 'Test', 'roman@gmail.com', 'admin2', '$2a$10$wjZXR6VOg1WtMR6nsLgeruX2xhCgGliq8SRsPfjpox55ns6hrKlrG', '380661480760', 2500, null),
(5, 'Julia', 'Truth', 'julia@gmail.com', 'employee', '$2a$10$kw/JFfdej.a5ALnDjX/XDudxXc4JU4aefEGxWbT0wZZrqednTpg9u', '380661480760', 500, null),
(6, 'Andriy', 'Tretiak', 'andru@gmail.com', 'user', '$2a$10$kw/JFfdej.a5ALnDjX/XDudxXc4JU4aefEGxWbT0wZZrqednTpg9u', '380661480760', null, '2001-09-02'),
(7, 'Masha', 'Ridus', 'masha@gmail.com', 'admin3', '$2a$10$wjZXR6VOg1WtMR6nsLgeruX2xhCgGliq8SRsPfjpox55ns6hrKlrG', '380661480760', 2500, null),
(8, 'Sasha', 'Bilun', 'sassha@gmail.com', 'employee', '$2a$10$kw/JFfdej.a5ALnDjX/XDudxXc4JU4aefEGxWbT0wZZrqednTpg9u', '380661480760', 500, null),
(9, 'Vasil', 'Kinash', 'vasil@gmail.com', 'user', '$2a$10$kw/JFfdej.a5ALnDjX/XDudxXc4JU4aefEGxWbT0wZZrqednTpg9u', '380661480760', null, '2001-09-02'),
(10, 'Dasha', 'Sino', 'sino@gmail.com', 'admin4', '$2a$10$wjZXR6VOg1WtMR6nsLgeruX2xhCgGliq8SRsPfjpox55ns6hrKlrG', '380661480760', 2500, null);

INSERT INTO accounts VALUES
(1, '1111 1111 1111 1111', '123', 1, 1, 1, 15000, 'USD', '2001-10-05'),
(2, '1111 1111 1111 1112', '321', 1, 2, 2, 7000, 'USD', '2001-10-05'),
(3, '1111 1111 1111 1113', '846', 2, 1, 1, 2500, 'EUR', '2003-9-02'),
(4, '1111 1111 1111 1114', '333', 3, 2, 2, 17000, 'USD', '2011-02-05'),
(5, '1111 1111 1111 1115', '456', 3, 1, 1, 14500, 'EUR', '2011-01-01'),
(6, '1111 1111 1111 1116', '654', 3, 2, 2, 500, 'EUR', '2007-06-05'),
(7, '1111 1111 1111 1117', '954', 4, 1, 1, 3500, 'UAH', '2013-02-02'),
(8, '1111 1111 1111 1118', '257', 4, 2, 2, 7500, 'UAH', '2016-04-03'),
(9, '1111 1111 1111 1119', '572', 4, 1, 1, 9000, 'USD', '2002-02-04'),
(10, '1111 1111 1111 1121', '821', 5, 2, 2, 12000, 'EUR', '2012-06-06');

INSERT INTO role VALUES
(0, 'ROLE_CLIENT', 'description'),
(1, 'ROLE_EMPLOYEE', 'description'),
(2, 'ROLE_ADMIN', 'description');

INSERT INTO user_role VALUES
(1, 2),
(2, 1),
(3, 0);

INSERT INTO transactions VALUES
(1, 150, '2001-02-14', 'Enrollment of the transfer on the card', 'Transfer', 1),
(2, -250, '2001-02-14', 'Cash withdrawal at an ATM', 'Removal', 1),
(3, -50, '2001-02-14', 'Cash withdrawal at an ATM', 'Removal', 1),
(4, -2250, '2001-02-14', 'Cash withdrawal at an ATM', 'Removal', 2),
(5, -5000, '2001-02-14', 'Cash withdrawal at an ATM', 'Removal', 2),
(6, 1500, '2001-02-14', 'Enrollment of the transfer on the card', 'Transfer', 3),
(7, -2350, '2001-02-14', 'Cash withdrawal at an ATM', 'Removal', 3),
(8, -540, '2001-02-14', 'Cash withdrawal at an ATM', 'Removal', 3),
(9, -1250, '2001-02-14', 'Cash withdrawal at an ATM', 'Removal', 3),
(10, -1050, '2001-02-14', 'Cash withdrawal at an ATM', 'Removal', 4),
(11, 2150, '2001-02-14', 'Enrollment of the transfer on the card', 'Transfer', 4),
(12, 2250, '2001-02-14', 'Cash withdrawal at an ATM', 'Transfer', 5),
(13, 150, '2001-02-14', 'Cash withdrawal at an ATM', 'Transfer', 5),
(14, -3250, '2001-02-14', 'Cash withdrawal at an ATM', 'Removal', 5),
(15, -3000, '2001-02-14', 'Cash withdrawal at an ATM', 'Removal', 5),
(16, 1500, '2001-02-14', 'Enrollment of the transfer on the card', 'Transfer', 6),
(17, -1250, '2001-02-14', 'Cash withdrawal at an ATM', 'Removal', 7),
(18, -550, '2001-02-14', 'Cash withdrawal at an ATM', 'Removal', 7),
(19, -2420, '2001-02-14', 'Cash withdrawal at an ATM', 'Removal', 7),
(20, -2450, '2001-02-14', 'Cash withdrawal at an ATM', 'Removal', 8),
(21, -1500, '2001-02-14', 'Enrollment of the transfer on the card', 'Removal', 8),
(22, 250, '2001-02-14', 'Cash withdrawal at an ATM', 'Transfer', 9),
(23, 50, '2001-02-14', 'Cash withdrawal at an ATM', 'Transfer', 9),
(24, 2250, '2001-02-14', 'Cash withdrawal at an ATM', 'Transfer', 9),
(25, 5000, '2001-02-14', 'Cash withdrawal at an ATM', 'Transfer', 9),
(26, 1500, '2001-02-14', 'Enrollment of the transfer on the card', 'Transfer', 9),
(27, -2500, '2001-02-14', 'Cash withdrawal at an ATM', 'Removal', 10),
(28, -500, '2001-02-14', 'Cash withdrawal at an ATM', 'Removal', 10),
(29, -22500, '2001-02-14', 'Cash withdrawal at an ATM', 'Removal', 10),
(30, -50000, '2001-02-14', 'Cash withdrawal at an ATM', 'Removal', 10);
