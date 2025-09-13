CREATE TABLE IF NOT EXISTS `spring`.`users` (
    `id` INT NOT NULL AUTO_INCREMENT,
    `username` VARCHAR(45) NOT NULL UNIQUE,
    `password` VARCHAR(100) NOT NULL,
    `enabled` TINYINT(1) NOT NULL,
    PRIMARY KEY (`id`)
    );

CREATE TABLE IF NOT EXISTS `spring`.`authorities` (
      `id` INT NOT NULL AUTO_INCREMENT,
      `username` VARCHAR(45) NOT NULL,
    `authority` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`id`),
    CONSTRAINT fk_user FOREIGN KEY (username) REFERENCES users(username)
    );
