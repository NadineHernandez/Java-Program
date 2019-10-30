-- NORTHWIND
-- What are the categories of products in the database?
-- camera, laptop, tablet, phone
SELECT northwind.products.category FROM northwind.products;

-- What products are made by Dell?
-- Dell Inspiration Laptop
SELECT * FROM northwind.products WHERE northwind.products.product_name like 'Dell%';

-- List all the orders shipped to Pennsylvania.
SELECT * FROM northwind.orders WHERE ship_state = 'Pennsylvania';

-- List the first name and last name of all employees with last names that start with w
SELECT northwind.employees.first_name, northwind.employees.last_name FROM northwind.employees
WHERE northwind.employees.last_name like 'W%';

-- List all customers from zipcodes that start with 55
SELECT * FROM northwind.customers WHERE northwind.customers.postal_code like '55%';

-- List all customers from zipcodes that end with 0
SELECT * FROM northwind.customers WHERE northwind.customers.postal_code like '%0';

-- List the first name, last name, and email for all customers with a .org email address
SELECT northwind.customers.first_name, northwind.customers.last_name, northwind.customers.email 
FROM northwind.customers WHERE northwind.customers.email like '%.org';

-- List the first name, last name, and phone number for all customers from the 202 area code
SELECT northwind.customers.first_name, northwind.customers.last_name, northwind.customers.phone 
FROM northwind.customers WHERE northwind.customers.phone like '___202%';

-- List the order id for each order placed by George Wilson
SELECT northwind.orders.id FROM northwind.orders
INNER JOIN northwind.customers ON northwind.customers.id = northwind.orders.customer_id
WHERE northwind.customers.first_name = 'George' and northwind.customers.last_name = 'Wilson';

-- List all the products and quantities associated with order 4003
SELECT northwind.products.product_name, northwind.order_details.quantity FROM northwind.order_details
INNER JOIN northwind.products ON northwind.products.id = northwind.order_details.product_id
INNER JOIN northwind.orders ON northwind.orders.id = northwind.order_details.order_id
WHERE northwind.orders.id = 4003;

-- CAR LOT
-- Add the following cars to inventory:

-- 2012 Red Honda Accord
INSERT INTO car_lot.car (id, model_year, color, make, model)
VALUES (1, 2012, 'Red', 'Honda', 'Accord');

-- 2017 Black Chevy Impala
INSERT INTO car_lot.car (id, model_year, color, make, model)
VALUES (2, 2017, 'Black', 'Chevy', 'Impala');

-- 2019 Siver Ford F-150
INSERT INTO car_lot.car (id, model_year, color, make, model)
VALUES (3, 2019, 'Silver', 'Ford', 'F-150');

-- 2020 White Subaru Outback
INSERT INTO car_lot.car (id, model_year, color, make, model)
VALUES (4, 2020, 'White', 'Subaru', 'Outback');

-- 2015 Silver Ford Mustang
INSERT INTO car_lot.car (id, model_year, color, make, model)
VALUES (5, 2015, 'Silver', 'Ford', 'Mustang');

-- 2018 Blue Honda Ridgeline
INSERT INTO car_lot.car (id, model_year, color, make, model)
VALUES (6, 2018, 'Blue', 'Honda', 'Ridgeline');

-- 2017 Gray Chevy Silverado
INSERT INTO car_lot.car (id, model_year, color, make, model)
VALUES (7, 2017, 'Gray', 'Chevy', 'Silverado');

-- Make the following updates to the database:

-- Change all Hondas to Black
UPDATE car_lot.car SET color = 'Black' WHERE car_lot.car.make = 'Honda';

-- Change 'Chevy' to 'Chevrolet'
UPDATE car_lot.car SET make = 'Chevrolet' WHERE car_lot.car.make = 'Chevy';

-- Change all 2020 model years to 2019
UPDATE car_lot.car SET model_year = 2019 WHERE car_lot.car.model_year = 2020;

-- Delete the following:

-- Delete all blue inventory
DELETE FROM car_lot.car WHERE car_lot.car.color = 'blue';

-- Delete all Fords
DELETE FROM car_lot.car WHERE car_lot.car.make = 'Ford';

-- Delete all cars from 2012 and 2017
DELETE FROM car_lot.car WHERE car_lot.car.model_year IN (2012, 2017);