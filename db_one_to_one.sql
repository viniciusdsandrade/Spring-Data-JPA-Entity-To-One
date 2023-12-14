DROP DATABASE IF EXISTS db_one_to_one;
CREATE DATABASE IF NOT EXISTS db_one_to_one;
USE db_one_to_one;

CREATE TABLE IF NOT EXISTS tb_department
(
	id   BIGINT UNSIGNED AUTO_INCREMENT,
	name VARCHAR(50) NOT NULL,
	PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS tb_person
(

	id            BIGINT UNSIGNED AUTO_INCREMENT,
	name          VARCHAR(50) NOT NULL,
	salary        DOUBLE      NOT NULL,
	department_id INT         NOT NULL,

	PRIMARY KEY (id),
	FOREIGN KEY (department_id) REFERENCES tb_department (id)
);

INSERT INTO tb_department (name) VALUES ('Administrativo');
INSERT INTO tb_department (name) VALUES ('Produção');

INSERT INTO tb_person (name, salary, department_id) VALUES ('Ana', 5000.0, 1);
INSERT INTO tb_person (name, salary, department_id) VALUES ('Joao', 4000.0, 1);
INSERT INTO tb_person (name, salary, department_id) VALUES ('Maria', 6000.0, 2);
INSERT INTO tb_person (name, salary, department_id) VALUES ('Carlos', 3000.0, 2);