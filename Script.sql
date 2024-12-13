CREATE DATABASE Ninjas; 

USE Ninjas;




CREATE TABLE Aldea(
    aldeaId INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    poblacion INT NOT NULL
 
);

CREATE TABLE Habilidad(
    habilidadId INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT NOT NULL
    
);


CREATE TABLE Rango(
    rangoId INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
    
);


CREATE TABLE Mision(
    misionId INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    descripcion TEXT NOT NULL,
    recompensa DECIMAL(10,2) NOT NULL,
    estado BOOLEAN   
);

CREATE TABLE Ninja (
    ninjaId VARCHAR(100) PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    telefono VARCHAR(100) NOT NULL UNIQUE,
    correo VARCHAR(100) NOT NULL UNIQUE,
    direccion VARCHAR(100),
    rangoId INT NOT NULL,
    aldeaId INT NOT NULL,
    FOREIGN KEY (rangoId) REFERENCES Rango(rangoId),
    FOREIGN KEY (aldeaId) REFERENCES Aldea(aldeaId)
    
);

CREATE TABLE MisionNinja (

    ninjaId VARCHAR(100) NOT NULL,
    misionId INT NOT NULL,
    fechaInicio DATE NOT NULL,
    fechaFin DATE NOT NULL,
    FOREIGN KEY (misionId) REFERENCES Mision(misionId),
    FOREIGN KEY (ninjaId) REFERENCES Ninja(ninjaId),
    PRIMARY KEY(ninjaId, misionId)
    
);

CREATE TABLE HabilidadNinja (

    ninjaId VARCHAR(100) NOT NULL,
    habilidadId INT NOT NULL,
    FOREIGN KEY (habilidadId) REFERENCES Habilidad(habilidadId),
    FOREIGN KEY (ninjaId) REFERENCES Ninja(ninjaId),
    PRIMARY KEY(ninjaId, habilidadId)
    
);













