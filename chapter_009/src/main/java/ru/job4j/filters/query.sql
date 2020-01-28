/*Создание таблиц*/

/*1. Таблица "Тип продукта"*/
CREATE TABLE Type
(
    Id SERIAL,
    Name VARCHAR(30) NOT NULL PRIMARY KEY
);

/*2. Таблица "Продукт"*/
CREATE TABLE Product
(
    Id SERIAL PRIMARY KEY,
    Name VARCHAR(30) NOT NULL,
    Type_name VARCHAR(50) REFERENCES Type(Name),
    Expired_date DATE NOT NULL,
    Price REAL NOT NULL
);

/*Добавление продуктов в таблицы*/

/*1. Добавление типов продуктов в таблицу Type*/
INSERT INTO Type VALUES (1, 'milk_products');
INSERT INTO Type VALUES (2, 'meat_products');
INSERT INTO Type VALUES (3, 'bakery');
INSERT INTO Type VALUES (4, 'sweets');
INSERT INTO Type VALUES (5, 'vegetables');
INSERT INTO Type VALUES (6, 'fruits');

/*2. Добавление продуктов в таблицу Product*/
INSERT INTO Product VALUES (1, 'cheese', 'milk_products', '2020-01-28', 15.5);
INSERT INTO Product VALUES (2, 'beef', 'meat_products', '2020-02-14', 260.8);
INSERT INTO Product VALUES (3, 'bread', 'bakery', '2020-05-14', 30.7);
INSERT INTO Product VALUES (4, 'candies', 'sweets', '2020-02-18', 168.2);
INSERT INTO Product VALUES (5, 'potato', 'vegetables', '2020-03-29', 45.3);
INSERT INTO Product VALUES (6, 'apple', 'fruits', '2020-04-21', 78.9);
INSERT INTO Product VALUES (7, 'strawberry ice cream', 'milk_products', '2020-02-13', 46.7);

/*Задание.*/

/*1. Написать запрос получение всех продуктов с типом "Молочные продукты"*/

select*from Product AS p
WHERE p.type_name = 'milk_products';

/*2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное"*/

select*from Product AS p
WHERE p.name LIKE '%ice cream%';

/*3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.*/

select*from Product AS p
WHERE p.expired_date BETWEEN '2020-01-31' AND '2020-03-01';

/*4. Написать запрос, который выводит самый дорогой продукт.*/

select * from Product
where price = (select max(price) from Product);

/*5. Написать запрос, который выводит количество всех продуктов определенного типа.*/

select COUNT (p.Type_name) from Product AS p
WHERE p.Type_name = 'bakery';

/*6. Написать запрос получение всех продуктов с типом "молочные продукты" и "сладости"*/

select * from Product AS p
WHERE p.type_name = 'milk_products' or p.type_name = 'sweets';

/*7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.*/

Select type_name,
count(type_name)
from product
group by type_name
having count(type_name) < 10;

/*8. Вывести все продукты и их тип.*/

select p.name,  p.type_name from Product AS p;