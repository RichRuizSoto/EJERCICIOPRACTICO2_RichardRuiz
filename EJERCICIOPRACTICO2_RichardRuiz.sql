USE EJERCICIOPRACTICO2_RichardRuiz;

-- Crear tabla peliculas (si no existe)
CREATE TABLE IF NOT EXISTS peliculas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    director VARCHAR(255) NOT NULL,
    duracion INT,
    genero VARCHAR(100),
    descripcion TEXT
);

-- Insertar 3 registros en peliculas
INSERT INTO peliculas (titulo, director, duracion, genero, descripcion) VALUES
('Dragon Ball', 'Akira Toriyama', 120, 'Anime', 'Serie de artes marciales y aventuras.'),
('Inception', 'Christopher Nolan', 148, 'Ciencia ficción', 'Un ladrón que roba secretos a través de los sueños.'),
('Parasite', 'Bong Joon-ho', 132, 'Thriller', 'Historia sobre clases sociales y supervivencia.');

-- Crear tabla reservas (si no existe)
CREATE TABLE IF NOT EXISTS reservas (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nombre_cliente VARCHAR(255) NOT NULL,
    cantidad_entradas INT NOT NULL,
    pelicula VARCHAR(255) NOT NULL
);

-- Insertar 3 registros en reservas
INSERT INTO reservas (nombre_cliente, cantidad_entradas, pelicula) VALUES
('Juan Pérez', 2, 'Dragon Ball'),
('María López', 4, 'Inception'),
('Carlos Gómez', 1, 'Parasite');

-- Tabla usuarios ya existe según el mensaje, pero agregamos 3 registros más
INSERT INTO usuarios (nombre, correo, contrasena, direccion) VALUES
('Ana Martínez', 'ana@example.com', 'pass123', 'Calle Falsa 456'),
('Luis Fernández', 'luis@example.com', 'secret', 'Av. Libertad 789'),
('Sofía Rodríguez', 'sofia@example.com', '123456', 'Plaza Central 101');




SELECT * FROM peliculas;
SELECT * FROM reservas;
SELECT * FROM usuarios;


