/*Хранилище машин

Нужно написать SQL скрипты:

    Создать структуру данных в базе.
    Таблицы: Кузов, Двигатель, Коробка передач.
    Создать структуру Машина. Машина не может существовать без данных из п.1.
    Заполнить таблицы через insert.*/

/*Создание таблиц:*/

/*Кузов*/
create table bodywork(
    id serial primary key,
    name varchar(200),
    color varchar(200)
);

/*Двигатель*/
create table engine(
    id serial primary key,
    type varchar(200),
    power varchar(200)
);

/*Коробка передач*/
create table transmission(
    id serial primary key,
    type varchar(200),
    gears int
);

/*Машина*/
create table car(
    id serial primary key,
    name varchar(200),
    bodywork int references bodywork(id),
    engine int references engine(id),
    transmission int references transmission(id)
);

/*Добавление элементов в таблицу "Кузов"*/
insert into bodywork(name, color) values ('sedan', 'white');
insert into bodywork(name, color) values ('jeep', 'black');
insert into bodywork(name, color) values ('estate', 'green');
insert into bodywork(name, color) values ('hatchback', 'brown');

/*Добавление элементов в таблицу "Двигатель"*/
insert into engine(type, power) values ('petrol', 200);
insert into engine(type, power) values ('diesel', 100);
insert into engine(type, power) values ('petrol', 300);
insert into engine(type, power) values ('diesel', 250);

/*Добавление элементов в таблицу "Коробка передач"*/
insert into transmission(type, gears) values ('mechanical', 4);
insert into transmission(type, gears) values ('automatic', 5);
insert into transmission(type, gears) values ('mechanical', 6);
insert into transmission(type, gears) values ('automatic', 3);

/*Добавление элементов в таблицу "Машина"*/
insert into car(name, bodywork, engine, transmission) values ('Audi', 1, 2, 3);
insert into car(name, bodywork, engine, transmission) values ('BMW', 2, 1, 2);

/*Задание:*/

/*1. Вывести список всех машин и все привязанные к ним детали.*/

select c.name, b.name, e.type, t.type from car as c
left outer join bodywork as b on c.bodywork = b.id
left outer join transmission as t on c.transmission = t.id
left outer join engine as e on c.engine = e.id;

/*2. Вывести отдельно детали, которые не используются в машине, кузова, двигатели, коробки передач.*/

select b.name, e.type, t.type from car as c
full outer join bodywork as b on c.bodywork = b.id
full outer join transmission as t on c.transmission = t.id
full outer join engine as e on c.engine = e.id where e.id is null OR b.id is null OR t.id is null;
