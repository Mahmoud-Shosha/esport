CREATE TABLE request
(
    id             UUID PRIMARY KEY,
    owner_name     VARCHAR(255) NOT NULL,
    country_code   VARCHAR(255) NOT NULL,
    mobile_number  VARCHAR(255) NOT NULL,
    national_id    VARCHAR(255) NOT NULL,
    email          VARCHAR(255) NOT NULL,
    club_name      VARCHAR(255) NOT NULL,
    club_name_Ar   VARCHAR(255) NOT NULL,
    club_iban      VARCHAR(255) NOT NULL,
    nationality_id UUID         NOT NULL,
    status_id      UUID         NOT NULL,
    FOREIGN KEY (nationality_id) REFERENCES country (id),
    FOREIGN KEY (status_id) REFERENCES request_status (id)

);