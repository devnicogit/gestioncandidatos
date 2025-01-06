CREATE TABLE tabla_mortalidad (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    edad INT NOT NULL,
    sexo VARCHAR(1) NOT NULL,
    probabilidad_muerte DECIMAL(5, 4) NOT NULL
);
