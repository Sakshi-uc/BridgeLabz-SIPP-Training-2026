USE covid_database;

UPDATE covid_cases 
SET recoveries = recoveries + 50 
WHERE state = 'Maharashtra' AND date_recorded = '2023-01-04';

UPDATE covid_cases 
SET confirmed_cases = confirmed_cases + 10 
WHERE state = 'Delhi' AND date_recorded = '2023-01-03';

UPDATE covid_deaths 
SET deaths = 9 
WHERE state = 'Maharashtra' AND date_recorded = '2023-01-04';

UPDATE covid_vaccines 
SET doses_administered = doses_administered + 5000 
WHERE state = 'Tamil Nadu' AND date_administered = '2023-01-02';

UPDATE covid_vaccines 
SET fully_vaccinated = fully_vaccinated + 1500 
WHERE state = 'Karnataka' AND vaccine_type = 'Covaxin';

UPDATE covid_cases 
SET confirmed_cases = confirmed_indian_national + confirmed_foreign_national 
WHERE confirmed_cases IS NULL;

DELETE FROM covid_deaths 
WHERE deaths = 0 AND state = 'Uttar Pradesh';

DELETE FROM covid_cases 
WHERE confirmed_cases < 100 AND date_recorded < '2023-01-02';
