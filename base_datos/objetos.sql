-- Se cambia el AUTO_INCREMENT a SERIAL que es el equivalente en postgresql y se quita UNSIGNED
-- porque eso lo gestiona postgresql

DROP TABLE IF EXISTS nota CASCADE;
DROP TABLE IF EXISTS evaluacion CASCADE ;
DROP TABLE IF EXISTS grupo_estudiantes CASCADE ;
DROP TABLE IF EXISTS grupo_asignaturas CASCADE ;
DROP TABLE IF EXISTS grupo CASCADE ;
DROP TABLE IF EXISTS alumno_se_matricula_asignatura CASCADE ;
DROP TABLE IF EXISTS curso_escolar CASCADE ;
DROP TABLE IF EXISTS asignatura CASCADE ;
DROP TABLE IF EXISTS alumno CASCADE ;
DROP TABLE IF EXISTS profesor CASCADE ;
DROP TABLE IF EXISTS persona CASCADE ;
DROP TABLE IF EXISTS grado CASCADE ;
DROP TABLE IF EXISTS departamento CASCADE ;

CREATE TABLE curso_escolar (
    id SERIAL PRIMARY KEY,
    anyo_inicio INTEGER NOT NULL,
    anyo_fin INTEGER NOT NULL
);

CREATE TABLE grupo (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    id_curso_escolar INT NOT NULL,
    FOREIGN KEY (id_curso_escolar) REFERENCES curso_escolar(id)
);

CREATE TABLE grupo_asignaturas (
    id_curso_escolar INT,
	plan_enseñanza VARCHAR(50),
	recursos_compartidos VARCHAR(50),
    FOREIGN KEY (id_curso_escolar) REFERENCES curso_escolar(id)
) INHERITS (grupo);

CREATE TABLE grupo_estudiantes (
	id SERIAL PRIMARY KEY,
    id_curso_escolar INT,
	nombre_hermandad VARCHAR(50),
	sede VARCHAR(50),
    FOREIGN KEY (id_curso_escolar) REFERENCES curso_escolar(id)
) INHERITS (grupo);

CREATE TABLE departamento (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

CREATE TABLE grado (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL
);

CREATE TABLE persona (
    id SERIAL PRIMARY KEY,
    nif VARCHAR(9) UNIQUE,
    nombre VARCHAR(25) NOT NULL,
    apellido1 VARCHAR(50) NOT NULL,
    apellido2 VARCHAR(50),
    ciudad VARCHAR(25) NOT NULL,
    direccion VARCHAR(50) NOT NULL,
    telefono VARCHAR(9),
    fecha_nacimiento DATE NOT NULL,
    sexo CHAR(1) CHECK (sexo IN ('H', 'M')) NOT NULL
);

CREATE TABLE profesor (
    id_profesor SERIAL PRIMARY KEY,
    id_departamento INT NOT NULL,
    FOREIGN KEY (id_profesor) REFERENCES persona(id),
    FOREIGN KEY (id_departamento) REFERENCES departamento(id)
) INHERITS (persona);

CREATE TABLE alumno (
    id_alumno SERIAL PRIMARY KEY,
	nie INT NOT NULL,
    id_grado INT NOT NULL,
	grupo_alumno INT,
    FOREIGN KEY (id_alumno) REFERENCES persona(id),
    FOREIGN KEY (id_grado) REFERENCES grado(id),
	FOREIGN KEY (grupo_alumno) REFERENCES grupo_estudiantes(id)
) INHERITS (persona);

CREATE TABLE asignatura (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(100) NOT NULL,
    creditos FLOAT NOT NULL,
    tipo VARCHAR(20) CHECK (tipo IN ('básica', 'obligatoria', 'optativa')) NOT NULL,
    curso SMALLINT NOT NULL,
    cuatrimestre SMALLINT NOT NULL,
    id_profesor INT,
    id_grado INT NOT NULL,
	grupo_asignaturas INT,
    FOREIGN KEY (id_profesor) REFERENCES profesor(id_profesor),
    FOREIGN KEY (id_grado) REFERENCES grado(id),
	FOREIGN KEY (grupo_asignaturas) REFERENCES grupo_estudiantes(id)
);

CREATE TABLE alumno_se_matricula_asignatura (
    id_alumno INT NOT NULL,
    id_asignatura INT NOT NULL,
    id_curso_escolar INT NOT NULL,
    PRIMARY KEY (id_alumno, id_asignatura, id_curso_escolar),
    FOREIGN KEY (id_alumno) REFERENCES alumno(id_alumno),
    FOREIGN KEY (id_asignatura) REFERENCES asignatura(id),
    FOREIGN KEY (id_curso_escolar) REFERENCES curso_escolar(id)
);

CREATE TABLE evaluacion (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    fecha DATE NOT NULL,
    id_asignatura INT NOT NULL,
    id_grupo_estudiantes INT NOT NULL,
    FOREIGN KEY (id_asignatura) REFERENCES asignatura(id),
    FOREIGN KEY (id_grupo_estudiantes) REFERENCES grupo_estudiantes(id)
);

CREATE TABLE nota (
    id SERIAL PRIMARY KEY,
    valor FLOAT NOT NULL,
    id_alumno INT NOT NULL,
    id_evaluacion INT NOT NULL,
    FOREIGN KEY (id_alumno) REFERENCES alumno(id_alumno),
    FOREIGN KEY (id_evaluacion) REFERENCES evaluacion(id)
);

ALTER TABLE persona ADD COLUMN dtype VARCHAR(255);