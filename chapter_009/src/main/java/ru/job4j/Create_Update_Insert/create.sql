/*3. Создать SQL скрипт инициализирующий создание новой базы данных.*/

CREATE DATABASE job4j;

/*4. Создать SQL скрипт создающий таблицы для хранения структуры системы заявок.*/

CREATE TABLE Rules
(
	Id SERIAL PRIMARY KEY,
	Opportunities VARCHAR(30) NOT NULL
);

CREATE TABLE Role
(
    Id SERIAL PRIMARY KEY,
    Title VARCHAR(30) NOT NULL,
    Rules_Id INT REFERENCES Rules(Id)
);

CREATE TABLE Users
(
    Id SERIAL PRIMARY KEY,
    Name VARCHAR(30) NOT NULL,
    Birth_day DATE NOT NULL,
    Role INT REFERENCES Role(Id)
);

CREATE TABLE Comments
(
    Id SERIAL PRIMARY KEY,
    Comment TEXT
);

CREATE TABLE Attaches(
    Id SERIAL PRIMARY KEY,
    Attach OID NULL
);

CREATE TABLE Category
(
    Id SERIAL PRIMARY KEY,
    Type VARCHAR(100) NOT NULL
);

CREATE TABLE State
(
    Id SERIAL PRIMARY KEY,
    Status VARCHAR(30) NOT NULL
);

CREATE TABLE Item
(
    Id SERIAL PRIMARY KEY,
    Number INT NOT NULL,
    User_ID INT REFERENCES Users(Id),
    Comments_Id INT REFERENCES Comments(Id),
    Attaches_Id INT REFERENCES Attaches(Id),
    Category_Id INT REFERENCES Category(Id),
    State_Id INT REFERENCES State(Id)
);


/*5. Создать SQL скрипт заполняющий начальные данные для системы заявок.*/

INSERT INTO Rules VALUES (1, 'add_products');
INSERT INTO Role VALUES (1, 'Manager', 1);
INSERT INTO Users VALUES (1, 'Ivanov Ivan', '1/08/1990', 1);
INSERT INTO Comments VALUES (1, 'Hello World');
INSERT INTO Attaches VALUES (1, null);
INSERT INTO Category VALUES (1, 'Electronics');
INSERT INTO State VALUES (1, 'Paid');
INSERT INTO Item VALUES (1, 864, 1, 1, 1, 1, 1);