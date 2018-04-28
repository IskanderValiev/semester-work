INSERT INTO users(password, name, lastname, gender, city, telephone, email, id, bday, role, state, photo)
    SELECT '$2a$10$h/fLmIVZSk1yQHu4tSy7IuykVA0Zekh4EESsSPhlv1CEBMVd.vUmy', 'Admin', 'Admin', TRUE, 'Kazan', '123456789','iskand.valiev98@gmail.com',
      1, '1998-01-18', 'ADMIN', 'CONFIRMED', 1
WHERE not exists(
  SELECT id
  FROM users
  WHERE id = 1
);

CREATE TABLE IF NOT EXISTS persistent_logins (
  username VARCHAR(64) NOT NULL,
  series VARCHAR(64) NOT NULL,
  token VARCHAR(64) NOT NULL,
  last_used TIMESTAMP NOT NULL,
  PRIMARY KEY (series)
);