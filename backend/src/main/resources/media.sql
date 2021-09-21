DROP TABLE IF EXISTS billionaires;

CREATE TABLE media (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  description VARCHAR(250) DEFAULT NULL,
  author VARCHAR(250) DEFAULT NULL
);

INSERT INTO media  (name, description, author) VALUES
  ('Aliko', 'Dangote', 'Billionaire Industrialist'),
  ('Bill', 'Gates', 'Billionaire Tech Entrepreneur'),
  ('Folrunsho', 'Alakija', 'Billionaire Oil Magnate');



