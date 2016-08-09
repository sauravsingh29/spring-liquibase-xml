--liquibase formatted sql
--preconditions onFail:HALT onError:HALT 
--changeset rxp-apm:release-01:create_apm_payment_method runAlways:false runOnChange:true comments:"APM Country table creation with country_id as primary key"
CREATE TABLE apm_countries (
    country_id int  NOT NULL,
    country_name varchar(100)  NULL,
    country_code varchar(6)  NULL,
    create_time timestamp  NULL DEFAULT current_timestamp,
    update_time timestamp  NOT NULL,
    user_id varchar(30)  NULL,
    CONSTRAINT apm_countries_pk PRIMARY KEY  (country_id)
);
--rollback drop table apm_countries;