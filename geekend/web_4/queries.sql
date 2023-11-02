
-- create
CREATE TABLE students (
  id INTEGER PRIMARY KEY AUTO_INCREMENT,
  name TEXT NOT NULL,
  age TEXT NOT NULL,
  address TEXT NOT NULL
);

-- insert
INSERT INTO students (name, age,address) VALUES ('Clark', '25','Москва');
INSERT INTO students (name, age,address) VALUES ('Dave', '17','Тула');
INSERT INTO students (name, age,address) VALUES ('Ava', '30','Вологда');
INSERT INTO students (name, age,address) VALUES ('Иван', '54','Тула');
INSERT INTO students (name, age,address) VALUES ('Петр', '34','Рязань');


-- fetch 
SELECT id, name AS имя 
FROM students 
WHERE address = 'Тула';

