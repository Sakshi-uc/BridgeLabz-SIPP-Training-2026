USE covid_database;

ALTER TABLE covid_cases 
ADD COLUMN state_code VARCHAR(5) AFTER state;

ALTER TABLE covid_cases 
ADD COLUMN region VARCHAR(50) DEFAULT 'India';

ALTER TABLE covid_deaths 
ADD COLUMN case_fatality_rate DECIMAL(5, 2);

ALTER TABLE covid_vaccines 
ADD COLUMN vaccination_rate DECIMAL(5, 2) DEFAULT 0;

ALTER TABLE covid_vaccines 
ADD COLUMN booster_doses INT DEFAULT 0;

ALTER TABLE covid_cases 
MODIFY COLUMN state VARCHAR(100) NOT NULL;

ALTER TABLE covid_cases 
CHANGE COLUMN created_at record_created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP;

ALTER TABLE covid_deaths 
DROP COLUMN case_fatality_rate;

ALTER TABLE covid_vaccines 
ADD CONSTRAINT fk_vaccine_date UNIQUE (date_administered, state, vaccine_type);

ALTER TABLE covid_cases 
ADD CONSTRAINT chk_positive_cases CHECK (confirmed_cases >= 0);

ALTER TABLE covid_deaths 
ADD CONSTRAINT chk_positive_deaths CHECK (deaths >= 0);

ALTER TABLE covid_vaccines 
ADD CONSTRAINT chk_positive_vaccines CHECK (doses_administered >= 0);

CREATE INDEX idx_state_date_cases ON covid_cases(state, date_recorded);

CREATE INDEX idx_state_vaccine_type ON covid_vaccines(state, vaccine_type);

DROP INDEX idx_date_cases ON covid_cases;

RENAME TABLE covid_vaccines TO covid_vaccination_data;

RENAME TABLE covid_vaccination_data TO covid_vaccines;

ALTER TABLE covid_cases ADD COLUMN status ENUM('Active', 'Resolved', 'Recovered') DEFAULT 'Active';

ALTER TABLE covid_vaccines ADD COLUMN manufacturer VARCHAR(100) DEFAULT 'Unknown';
