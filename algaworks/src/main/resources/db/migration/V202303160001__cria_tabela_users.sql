CREATE TABLE `algaworks`.`users` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `nome` VARCHAR(255) NOT NULL,
  `endereco` VARCHAR(255) NOT NULL,
  `cpf` VARCHAR(45) NOT NULL,
  `idade` INT NOT NULL,
  `email` VARCHAR(255) NOT NULL,
  `fone`  VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`));