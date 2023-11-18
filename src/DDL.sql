CREATE TABLE `member` (
                          `id`		BIGINT		NOT NULL	AUTO_INCREMENT PRIMARY KEY,
                          `name`		VARCHAR(20)	NOT NULL,
                          `gender`	VARCHAR(10)	NOT NULL,
                          `age`		INT		NOT NULL,
                          `address`	VARCHAR(40)	NOT NULL,
                          `spec_address`	VARCHAR(40)	NOT NULL,
                          `status`	VARCHAR(15)	NOT NULL,
                          `inactive_date`	TIMESTAMP	NULL,
                          `created_at`	TIMESTAMP	NOT NULL,
                          `updated_at`	TIMESTAMP	NULL,
                          `email`		VARCHAR(50)	NOT NULL,
                          `point`		int		NOT NULL	DEFAULT 0
);

CREATE TABLE `terms` (
                         `id`		BIGINT		NOT NULL	AUTO_INCREMENT PRIMARY KEY,
                         `title`		VARCHAR(20)	NOT NULL,
                         `body`		TEXT		NULL,
                         `optional`	BOOLEAN		NULL,
                         `created_at`	TIMESTAMP	NOT NULL,
                         `updated_at`	TIMESTAMP	NULL
);

CREATE TABLE `region` (
                          `id`		BIGINT		NOT NULL	AUTO_INCREMENT PRIMARY KEY,
                          `name`		VARCHAR(20)	NOT NULL,
                          `created_at`	TIMESTAMP	NOT NULL,
                          `updated_at`	TIMESTAMP	NULL
);

CREATE TABLE `store` (
                         `id`		BIGINT		NOT NULL	AUTO_INCREMENT PRIMARY KEY,
                         `region_id` 	BIGINT 		NOT NULL,
                         FOREIGN KEY (`region_id`)	REFERENCES 	`region`(`id`),
                         `name`		VARCHAR(50)	NOT NULL,
                         `address`	VARCHAR(50)	NULL,
                         `score`		FLOAT		NULL,
                         `created_at`	TIMESTAMP	NOT NULL,
                         `updated_at`	TIMESTAMP	NULL
);

CREATE TABLE `member_agree` (
                                `id`		BIGINT		NOT NULL	AUTO_INCREMENT PRIMARY KEY,
                                `member_id` 	BIGINT 		NOT NULL,
                                FOREIGN KEY (`member_id`) 	REFERENCES 	`member`(`id`),
                                `terms_id` 	BIGINT 		NOT NULL,
                                FOREIGN KEY (`terms_id`)	REFERENCES 	`terms`(`id`),
                                `created_at`	TIMESTAMP	NOT NULL,
                                `updated_at`	TIMESTAMP	NULL
);

CREATE TABLE `food_category` (
                                 `id`		BIGINT		NOT NULL	AUTO_INCREMENT PRIMARY KEY,
                                 `name`		VARCHAR(15)	NOT NULL,
                                 `created_at`	TIMESTAMP	NOT NULL
);

CREATE TABLE `member_prefer` (
                                 `id`		BIGINT		NOT NULL	AUTO_INCREMENT PRIMARY KEY,
                                 `category_id` 	BIGINT 		NOT NULL,
                                 FOREIGN KEY (`category_id`) 	REFERENCES 	`food_category`(`id`),
                                 `member_id` 	BIGINT 		NOT NULL,
                                 FOREIGN KEY (`member_id`) 	REFERENCES 	`member`(`id`),
                                 `created_at`	TIMESTAMP	NOT NULL,
                                 `updated_at`	TIMESTAMP	NULL
);

CREATE TABLE `review` (
                          `id`		BIGINT		NOT NULL	AUTO_INCREMENT PRIMARY KEY,
                          `member_id` 	BIGINT		NOT NULL,
                          FOREIGN KEY (`member_id`) 	REFERENCES 	`member`(`id`),
                          `store_id` 	BIGINT 		NOT NULL,
                          FOREIGN KEY (`store_id`) 	REFERENCES 	`store`(`id`),
                          `body`		TEXT		NULL,
                          `score`		FLOAT		NULL
);

CREATE TABLE `review_image` (
                                `id`		BIGINT		NOT NULL	AUTO_INCREMENT PRIMARY KEY,
                                `review_id` 	BIGINT 		NOT NULL,
                                FOREIGN KEY (`review_id`) 	REFERENCES 	`review`(`id`),
                                `image_url`	TEXT		NULL,
                                `created_at`	TIMESTAMP	NOT NULL,
                                `updated_at`	TIMESTAMP	NULL
);

CREATE TABLE `mission` (
                           `id`		BIGINT		NOT NULL	AUTO_INCREMENT PRIMARY KEY,
                           `store_id` 	BIGINT 		NOT NULL,
                           FOREIGN KEY (`store_id`) 	REFERENCES 	`store`(`id`),
                           `reward`	INT		NULL,
                           `deadline`	TIMESTAMP	NULL,
                           `mission_spec`	TEXT		NULL,
                           `created_at`	TIMESTAMP	NOT NULL,
                           `updated_at`	TIMESTAMP	NULL
);

CREATE TABLE `member_mission` (
                                  `id`		BIGINT		NOT NULL	AUTO_INCREMENT PRIMARY KEY,
                                  `mission_id`	BIGINT 		NOT NULL,
                                  FOREIGN KEY (`mission_id`) 	REFERENCES 	`mission`(`id`),
                                  `member_id` 	BIGINT 		NOT NULL,
                                  FOREIGN KEY (`member_id`) 	REFERENCES 	`member`(`id`),
                                  `store_id` 	BIGINT 		NOT NULL,
                                  FOREIGN KEY (`store_id`) 	REFERENCES 	`mission`(`store_id`),
                                  `field`		TEXT		NULL
);
