-- Created by Saurav Singh
-- Last modification date: 2016-07-19 18:31:54.221

-- tables
-- Table: apm_countries
CREATE TABLE apm_countries (
    country_id int  NOT NULL IDENTITY,
    country_name varchar(100)  NULL,
    country_code varchar(6)  NULL,
    create_time datetime  NULL DEFAULT NOW(),
    update_time datetime  NOT NULL,
    "user" varchar(30)  NULL,
    CONSTRAINT apm_countries_pk PRIMARY KEY  (country_id)
);

-- Table: apm_currencies
CREATE TABLE apm_currencies (
    currency_id int  NOT NULL IDENTITY,
    currency_name varchar(50)  NULL,
    currency_decription varchar(255)  NULL,
    currency_code varchar(10)  NULL,
    create_time datetime  NULL DEFAULT NOW(),
    update_time datetime  NOT NULL,
    "user" varchar(30)  NULL,
    CONSTRAINT apm_currencies_pk PRIMARY KEY  (currency_id)
);

-- Table: apm_payment_config
CREATE TABLE apm_payment_config (
    payment_config_id int  NOT NULL IDENTITY,
    enabled bit  NULL,
    create_time datetime  NULL DEFAULT NOW(),
    update_time datetime  NOT NULL,
    "user" varchar(30)  NOT NULL,
    apm_payment_details_payment_id int  NOT NULL,
    apm_countries_country_id int  NOT NULL,
    apm_currencies_currency_id int  NOT NULL,
    CONSTRAINT apm_payment_config_pk PRIMARY KEY  (payment_config_id)
);

-- Table: apm_payment_details
CREATE TABLE apm_payment_details (
    payment_id int  NOT NULL IDENTITY,
    payment_name varchar(55)  NULL,
    payment_enabled bit  NULL,
    create_time datetime  NULL DEFAULT NOW(),
    update_time datetime  NOT NULL,
    "user" varchar(30)  NULL,
    CONSTRAINT apm_payment_details_pk PRIMARY KEY  (payment_id)
);

-- foreign keys
-- Reference: apm_payment_config_apm_countries (table: apm_payment_config)
ALTER TABLE apm_payment_config ADD CONSTRAINT apm_payment_config_apm_countries
    FOREIGN KEY (apm_countries_country_id)
    REFERENCES apm_countries (country_id);

-- Reference: apm_payment_config_apm_currencies (table: apm_payment_config)
ALTER TABLE apm_payment_config ADD CONSTRAINT apm_payment_config_apm_currencies
    FOREIGN KEY (apm_currencies_currency_id)
    REFERENCES apm_currencies (currency_id);

-- Reference: apm_payment_config_apm_payment_details (table: apm_payment_config)
ALTER TABLE apm_payment_config ADD CONSTRAINT apm_payment_config_apm_payment_details
    FOREIGN KEY (apm_payment_details_payment_id)
    REFERENCES apm_payment_details (payment_id);

-- End of file.

