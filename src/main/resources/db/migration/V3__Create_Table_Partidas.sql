CREATE TABLE partidas
(
    id_partida        INT not null AUTO_INCREMENT PRIMARY KEY,
    id_timeA          INT not null,
    id_timeB          INT not null,
    resultado         VARCHAR(20),
    data_hora_partida DATETIME,
    FOREIGN KEY (id_timeA) REFERENCES `times` (id),
    FOREIGN KEY (id_timeB) REFERENCES `times` (id)
);