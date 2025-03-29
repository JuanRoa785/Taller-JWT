CREATE DATABASE taller_jwt

CREATE TABLE taller_jwt.tipoDocumento (
	id INTEGER auto_increment NOT NULL,
	nombre varchar(50) NOT NULL,
	descripcion varchar(100) NULL,
	CONSTRAINT tipo_documento_pk PRIMARY KEY (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO taller_jwt.tipoDocumento (nombre, descripcion)
VALUES
('C.C', 'Cedula de ciudadania'),
('C.E', 'Cedula de Extranjeria'),
('T.I', 'Tarjeta de Identidad'),
('R.C', 'Registro Civil');

CREATE TABLE taller_jwt.usuario (
	id INTEGER auto_increment NOT NULL,
	nombre varchar(200) NOT NULL,
	email varchar(200) NOT NULL,
	idTipoDocumento INTEGER NOT NULL,
	numeroDocumento varchar(50) NOT NULL,
	userName varchar(100) NOT NULL,
	password varchar(50) NOT NULL,
	rol varchar(1) NOT NULL DEFAULT '1',
	CONSTRAINT usuario_pk PRIMARY KEY (id),
	CONSTRAINT usuario_unique UNIQUE KEY (numeroDocumento),
	CONSTRAINT usuario_unique_usename UNIQUE KEY (userName),
	CONSTRAINT usuario_unique_email UNIQUE KEY (email),
	CONSTRAINT usuario_tipoDocumento_FK FOREIGN KEY (idTipoDocumento) REFERENCES tipoDocumento (id)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO taller_jwt.usuario (idTipoDocumento, numeroDocumento, email, nombre, password, userName)
VALUES
	(1, '63124561', 'pedro@lafloresta.com', 'Pedro Alonso Paquetiva', '$2a$12$JEcgS3VgUcBWBWlYlMbPp.sKOZMOtTGytMSRFspk6esJOVaBdu0Zq', 'admin'),
	(1, '9123455', 'pepe@gmail.com', 'Pepe', '$2a$12$sHGUj6dKiVOM4QHgUZ.VVOeLDq9nmrkxGT.QlEe/EJOD3BaqMGvYC', 'cliente'),
	(1, '890123445', 'palonso@floresta.edu.co', 'Pedro Alonso Paquetiva', '$2a$12$sVNQAPH4bZnKFy7Tia8pVupYeQNyFRQPkTJkUXjbLXbTTpYLqfazO', 'pepe'),
	(1, '91239999', 'JAnono@uis.edu.co', 'Jorge Arturo Cifuentes Velez', '$2a$12$k8zyEZ.5fAUCYlyMHDi6LujoOzxshN4OaY24LiIeMxcFoXQzixtAW', 'elnono'),
	(1, '91234190', 'llopez@gmail.com', 'Luis Pedro López', '$2a$12$I8pzB0An1AhWsbNyIWoZROIp3HT7D9opo8.W6S1So84Xv0NQ0fR62', 'llopez'),
	(1, '631245618', 'Sninio@uis.edu.co', 'Sandra Milena NIño', '$2a$12$A3uj/YOGKB5QlpgtKpCKWuNdoP83O/wiFazKKS/5ZaTZWHphl3kJi', 'sninio'),
	(1, '1098123451', 'Falarcon@gmail.com', 'Fernando José Alarcón Suarez', '$2a$12$dS4SybG.bB5MZhcd5KwvYOvaTBmu92DTLYtL1v0.fjWp.wCN7fEsa', 'FAlarcon'),
	(1, '65081136415', 'lcalderon@gmail.com', 'Luis Fernando Calderón', '$2a$12$lxyePdpp8NaXnogLUNYFiOhJGhiYs5jykREez7IptezuybG8e/zZa', 'lcalderon'),
	(1, '90213778', 'jsuarez@gmail.com', 'Jorge Ernesto Suarez', '$2a$12$I8pzB0An1AhWsbNyIWoZROIp3HT7D9opo8.W6S1So84Xv0NQ0fR62', 'jsuarez');

CREATE TABLE taller_jwt.proveedor (
	id INTEGER auto_increment NOT NULL,
	ciudad varchar(100) NOT NULL,
	direccion varchar(100) NOT NULL,
	nombre varchar(100) NOT NULL,
	telefono varchar(30) NOT NULL,
	nit varchar(10) NOT NULL,
	CONSTRAINT proveedor_pk PRIMARY KEY (id),
	CONSTRAINT proveedor_unique UNIQUE KEY (nit)
)
ENGINE=InnoDB
DEFAULT CHARSET=utf8mb4
COLLATE=utf8mb4_0900_ai_ci;

INSERT INTO taller_jwt.proveedor (ciudad, direccion, nombre, telefono, nit) 
VALUES
('Bogotá', 'Carrera 123 # 12 - 80', 'Colgate', '3124561234', '8901231227'),
('Bogotá', 'Avenida 7 # 12 - 80', 'Carvajal S.A', '2346781185', '8901235644');