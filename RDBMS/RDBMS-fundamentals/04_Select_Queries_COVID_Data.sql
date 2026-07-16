USE covid_database;

SELECT 'BASIC SELECT QUERIES' AS category;

SELECT * FROM covid_cases;

SELECT * FROM covid_deaths;

SELECT * FROM covid_vaccines;

SELECT 'FILTERED QUERIES' AS category;

SELECT date_recorded, state, confirmed_cases, recoveries 
FROM covid_cases 
WHERE state = 'Maharashtra';

SELECT date_recorded, state, deaths 
FROM covid_deaths 
WHERE deaths > 4;

SELECT date_administered, vaccine_type, doses_administered 
FROM covid_vaccines 
WHERE state = 'Delhi';

SELECT 'AGGREGATION QUERIES' AS category;

SELECT state, SUM(confirmed_cases) as total_cases, SUM(recoveries) as total_recoveries 
FROM covid_cases 
GROUP BY state;

SELECT state, SUM(deaths) as total_deaths 
FROM covid_deaths 
GROUP BY state;

SELECT state, vaccine_type, SUM(doses_administered) as total_doses 
FROM covid_vaccines 
GROUP BY state, vaccine_type;

SELECT 'STATISTICAL QUERIES' AS category;

SELECT state, AVG(confirmed_cases) as avg_cases 
FROM covid_cases 
GROUP BY state;

SELECT state, MAX(deaths) as max_deaths, MIN(deaths) as min_deaths 
FROM covid_deaths 
GROUP BY state;

SELECT vaccine_type, AVG(fully_vaccinated) as avg_fully_vaccinated 
FROM covid_vaccines 
GROUP BY vaccine_type;

SELECT 'ORDER AND LIMIT QUERIES' AS category;

SELECT state, SUM(confirmed_cases) as total_cases 
FROM covid_cases 
GROUP BY state 
ORDER BY total_cases DESC;

SELECT date_recorded, state, deaths 
FROM covid_deaths 
ORDER BY deaths DESC 
LIMIT 10;

SELECT state, SUM(doses_administered) as total_doses 
FROM covid_vaccines 
GROUP BY state 
ORDER BY total_doses DESC 
LIMIT 5;

SELECT 'JOIN QUERIES' AS category;

SELECT c.date_recorded, c.state, c.confirmed_cases, d.deaths 
FROM covid_cases c 
LEFT JOIN covid_deaths d ON c.case_id = d.case_id;

SELECT c.date_recorded, c.state, c.confirmed_cases, c.recoveries, 
       (c.confirmed_cases - c.recoveries) as active_cases 
FROM covid_cases c 
WHERE c.date_recorded = '2023-01-04';

SELECT 'CALCULATED FIELDS' AS category;

SELECT date_recorded, state, confirmed_cases, deaths, 
       ROUND((deaths / confirmed_cases) * 100, 2) as mortality_rate 
FROM covid_cases c 
JOIN covid_deaths d ON c.case_id = d.case_id;

SELECT date_recorded, state, confirmed_cases, recoveries, 
       (confirmed_cases - recoveries) as active_cases,
       ROUND((recoveries / confirmed_cases) * 100, 2) as recovery_rate 
FROM covid_cases 
WHERE confirmed_cases > 0;

SELECT 'HAVING CLAUSE QUERIES' AS category;

SELECT state, SUM(confirmed_cases) as total_cases 
FROM covid_cases 
GROUP BY state 
HAVING SUM(confirmed_cases) > 1000 
ORDER BY total_cases DESC;

SELECT vaccine_type, COUNT(*) as vaccination_days, SUM(doses_administered) as total_doses 
FROM covid_vaccines 
GROUP BY vaccine_type 
HAVING SUM(doses_administered) > 50000;

SELECT 'DISTINCT QUERIES' AS category;

SELECT DISTINCT state FROM covid_cases;

SELECT DISTINCT vaccine_type FROM covid_vaccines;

SELECT 'COUNT QUERIES' AS category;

SELECT COUNT(*) as total_records FROM covid_cases;

SELECT COUNT(DISTINCT state) as total_states FROM covid_cases;

SELECT state, COUNT(*) as record_count 
FROM covid_cases 
GROUP BY state;
