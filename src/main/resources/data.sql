CREATE TABLE users (
                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                       name VARCHAR(255) NOT NULL,
                       birthdate DATE NOT NULL,
                       country VARCHAR(255) NOT NULL,
                       phoneNumber VARCHAR(255),
                       gender VARCHAR(255)
);
