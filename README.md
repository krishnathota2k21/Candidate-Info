# Candidate-Info

To run the application install the below software:
1. java 11
2. maria db

create the database with name `candidateinfo` and execute the below queries:

CREATE TABLE `roles` (
`id` int NOT NULL AUTO_INCREMENT,
`name` varchar(255) DEFAULT NULL,
PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 ;

CREATE TABLE `users` (
`id` int NOT NULL AUTO_INCREMENT,
`email` varchar(255) NOT NULL,
`is_enabled` tinyint NOT NULL,
`name` varchar(255) DEFAULT NULL,
`password` varchar(255) DEFAULT NULL,
PRIMARY KEY (`id`),
UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=1 ;

CREATE TABLE `user_role` (
`user_id` int NOT NULL,
`role_id` int NOT NULL,
PRIMARY KEY (`user_id`,`role_id`),
KEY `FKt7e7djp752sqn6w22i6ocqy6q` (`role_id`),
CONSTRAINT `FKj345gk1bovqvfame88rcx7yyx` FOREIGN KEY (`user_id`) REFERENCES `users` (`id`),
CONSTRAINT `FKt7e7djp752sqn6w22i6ocqy6q` FOREIGN KEY (`role_id`) REFERENCES `roles` (`id`)
);

INSERT INTO roles (id, name) VALUES
(1, 'ROLE_ADMIN'),
(2, 'ROLE_USER');


INSERT INTO users (id, email, password, name, is_enabled) VALUES
(1, 'admin@gmail.com', '$2y$12$05djVoQWe9K8u6uFm0Gyqe6U0d29P5VBvkdTr1P2uwmb2ZN.di.ya', 'Admin', true),
(2, 'user@gmail.com', '$2y$12$05djVoQWe9K8u6uFm0Gyqe6U0d29P5VBvkdTr1P2uwmb2ZN.di.ya', 'User', true);

insert into user_role(user_id, role_id) values
(1,1),
(1,2),
(2,2);

