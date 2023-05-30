# 04-Actividad-Nuevos-Ingresos
 <br/>
 Video de explicación

https://drive.google.com/file/d/1lRh4s17hwTQ_tlaC_VUxr0ma1G4NTshg/view?usp=sharing
<br/>Esquema de bd

```sql
CREATE DATABASE actividad;
\c actividad;

CREATE SCHEMA IF NOT EXISTS Actividad;

SET search_path TO Actividad;

CREATE TABLE Actividad.TO_USUARIOS (
  CRR_USUARIO         NUMERIC(11) NOT NULL,
  COD_USUARIO_CREA    NUMERIC(11) NOT NULL,
  COD_USUARIO_MOD     NUMERIC(11) NOT NULL,
  GLS_FUNCIONARIO_CREA VARCHAR(50) NOT NULL,
  GLS_FUNCIONARIO_MOD VARCHAR(50) NOT NULL,
  FEC_CREA            DATE NOT NULL,
  FEC_MOD             DATE NOT NULL,
  GLS_USERNAME        VARCHAR(30),
  GLS_CONCEPTO        VARCHAR(50),
  FEC_CONCEPTO        DATE,
  COD_CONCEPTO        NUMERIC,
  RUT                 NUMERIC(10),
  RUT_DV              CHAR(1),
  -- Agregar aquí más columnas adicionales según sea necesario

  CONSTRAINT PK_TO_USUARIOS PRIMARY KEY (CRR_USUARIO),
  CONSTRAINT UK_TO_USUARIOS UNIQUE (CRR_USUARIO)
);

SELECT table_name
FROM information_schema.tables
WHERE table_schema = 'public'
AND table_type = 'BASE TABLE';

ALTER TABLE Actividad.TO_USUARIOS
ALTER COLUMN CRR_USUARIO SET DATA TYPE INTEGER;

ALTER TABLE TO_USUARIOS ALTER COLUMN CRR_USUARIO ADD GENERATED ALWAYS AS IDENTITY;
```
