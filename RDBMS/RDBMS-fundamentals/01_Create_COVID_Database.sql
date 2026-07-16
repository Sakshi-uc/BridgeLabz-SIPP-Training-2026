CREATE DATABASE covid_database;

USE covid_database;

CREATE TABLE covid_cases (
    case_id INT PRIMARY KEY AUTO_INCREMENT,
    date_recorded DATE NOT NULL,
    state VARCHAR(50) NOT NULL,
    confirmed_indian_national INT DEFAULT 0,
    confirmed_foreign_national INT DEFAULT 0,
    confirmed_cases INT,
    recoveries INT DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE covid_deaths (
    death_id INT PRIMARY KEY AUTO_INCREMENT,
    date_recorded DATE NOT NULL,
    state VARCHAR(50) NOT NULL,
    deaths INT DEFAULT 0,
    case_id INT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (case_id) REFERENCES covid_cases(case_id)
);

CREATE TABLE covid_vaccines (
    vaccine_id INT PRIMARY KEY AUTO_INCREMENT,
    date_administered DATE NOT NULL,
    state VARCHAR(50) NOT NULL,
    vaccine_type VARCHAR(50),
    doses_administered INT DEFAULT 0,
    people_vaccinated INT DEFAULT 0,
    fully_vaccinated INT DEFAULT 0,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE INDEX idx_date_cases ON covid_cases(date_recorded);
CREATE INDEX idx_state_cases ON covid_cases(state);
CREATE INDEX idx_date_deaths ON covid_deaths(date_recorded);
CREATE INDEX idx_state_deaths ON covid_deaths(state);
CREATE INDEX idx_date_vaccines ON covid_vaccines(date_administered);
CREATE INDEX idx_state_vaccines ON covid_vaccines(state);
