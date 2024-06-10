CREATE TABLE "user"
(
    id             UUID PRIMARY KEY,
    name           VARCHAR(255) NOT NULL UNIQUE,
    country_code   VARCHAR(255) NOT NULL,
    mobile_number  VARCHAR(255) NOT NULL,
    email          VARCHAR(255) NOT NULL UNIQUE,
    nationality_id UUID         NOT NULL,
    FOREIGN KEY (nationality_id) REFERENCES country (id),
    UNIQUE (country_code, mobile_number)
);