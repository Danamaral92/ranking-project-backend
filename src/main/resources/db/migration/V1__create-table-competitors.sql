CREATE TABLE competitors(
    id       TEXT PRIMARY KEY UNIQUE NOT NULL,
    nome    TEXT                    NOT NULL UNIQUE,
    provas DECIMAL                    NOT NULL,
    lumosity     DECIMAL                    NOT NULL,
    keybr     DECIMAL                    NOT NULL
);

INSERT INTO competitors (id, nome, provas, lumosity, keybr) VALUES
('5a0d7a6a-7f5b-11ed-9d3c-0242ac120002', 'Daniele', 0.0, 0.0, 0.0);

INSERT INTO competitors (id, nome, provas, lumosity, keybr) VALUES
('5a0d7a6a-7f5b-11ed-9d3c-0242ac120003', 'Debora', 0.0, 0.0, 0.0);

INSERT INTO competitors (id, nome, provas, lumosity, keybr) VALUES
('5a0d7a6a-7f5b-11ed-9d3c-0242ac120004', 'Gabriel', 0.0, 0.0, 0.0)