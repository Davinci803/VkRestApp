CREATE TABLE IF NOT EXISTS clients
    (
    id    SERIAL PRIMARY KEY,
    role    VARCHAR(20) NOT NULL,
    login  VARCHAR(200) NOT NULL,
    password VARCHAR(254) NOT NULL,
    token VARCHAR(20)  NOT NULL
);