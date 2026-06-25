USE covid_database;

SELECT '================ ADVANCED SQL QUERIES ================' AS section;

SELECT '1. SUBQUERIES' AS subsection;

SELECT state, confirmed_cases 
FROM covid_cases 
WHERE confirmed_cases > (
    SELECT AVG(confirmed_cases) FROM covid_cases
)
ORDER BY confirmed_cases DESC;

SELECT state, deaths 
FROM covid_deaths 
WHERE deaths > (
    SELECT MAX(deaths) * 0.8 FROM covid_deaths
);

SELECT DISTINCT state 
FROM covid_cases 
WHERE state IN (
    SELECT state FROM covid_deaths WHERE deaths > 5
);

SELECT '2. CASE STATEMENT' AS subsection;

SELECT 
    date_recorded, 
    state, 
    confirmed_cases,
    CASE 
        WHEN confirmed_cases > 500 THEN 'High'
        WHEN confirmed_cases > 300 THEN 'Medium'
        ELSE 'Low'
    END as case_severity
FROM covid_cases
ORDER BY case_severity DESC;

SELECT 
    date_administered,
    state,
    doses_administered,
    CASE vaccine_type
        WHEN 'Covaxin' THEN 'Indian Made'
        WHEN 'Covishield' THEN 'UK Made'
        ELSE 'Other'
    END as vaccine_origin
FROM covid_vaccines;

SELECT '3. WINDOW FUNCTIONS' AS subsection;

SELECT 
    date_recorded,
    state,
    confirmed_cases,
    SUM(confirmed_cases) OVER (PARTITION BY state ORDER BY date_recorded) as running_total
FROM covid_cases
ORDER BY state, date_recorded;

SELECT 
    date_recorded,
    state,
    confirmed_cases,
    ROW_NUMBER() OVER (PARTITION BY state ORDER BY confirmed_cases DESC) as case_rank
FROM covid_cases
WHERE date_recorded = '2023-01-04'
ORDER BY state, case_rank;

SELECT '4. STRING FUNCTIONS' AS subsection;

SELECT 
    UPPER(state) as state_upper,
    LOWER(state) as state_lower,
    LENGTH(state) as state_name_length,
    SUBSTRING(state, 1, 3) as state_abbreviation,
    confirmed_cases
FROM covid_cases;

SELECT 
    CONCAT(state, ' - ', date_recorded) as location_date,
    CONCAT(confirmed_cases, ' cases confirmed') as case_info
FROM covid_cases
LIMIT 5;

SELECT '5. DATE FUNCTIONS' AS subsection;

SELECT 
    date_recorded,
    YEAR(date_recorded) as year,
    MONTH(date_recorded) as month,
    DAY(date_recorded) as day,
    DAYNAME(date_recorded) as day_name,
    confirmed_cases
FROM covid_cases
ORDER BY date_recorded;

SELECT 
    state,
    DATEDIFF('2023-01-04', MIN(date_recorded)) as days_since_first_case,
    MIN(date_recorded) as first_case_date
FROM covid_cases
GROUP BY state;

SELECT '6. MATHEMATICAL FUNCTIONS' AS subsection;

SELECT 
    state,
    SUM(confirmed_cases) as total_cases,
    ROUND(AVG(confirmed_cases), 2) as avg_cases,
    CEIL(AVG(confirmed_cases)) as ceiling_avg,
    FLOOR(AVG(confirmed_cases)) as floor_avg,
    ABS(MAX(confirmed_cases) - MIN(confirmed_cases)) as case_variation
FROM covid_cases
GROUP BY state;

SELECT '7. UNION QUERIES' AS subsection;

SELECT 
    state,
    'Cases' as metric,
    SUM(confirmed_cases) as count
FROM covid_cases
GROUP BY state
UNION ALL
SELECT 
    state,
    'Deaths' as metric,
    SUM(deaths) as count
FROM covid_deaths
GROUP BY state
ORDER BY state, metric;

SELECT '8. COMPLEX JOINS' AS subsection;

SELECT 
    c.date_recorded,
    c.state,
    c.confirmed_cases,
    COALESCE(d.deaths, 0) as deaths,
    COALESCE(v.doses_administered, 0) as doses_vaccinated
FROM covid_cases c
LEFT JOIN covid_deaths d ON c.case_id = d.case_id
LEFT JOIN covid_vaccines v ON c.state = v.state AND c.date_recorded = v.date_administered
WHERE c.date_recorded = '2023-01-04'
ORDER BY c.state;

SELECT '9. PERFORMANCE ANALYSIS' AS subsection;

SELECT 
    state,
    COUNT(*) as days_recorded,
    SUM(confirmed_cases) as total_cases,
    AVG(confirmed_cases) as avg_daily_cases,
    MAX(confirmed_cases) as peak_daily_cases,
    MIN(confirmed_cases) as lowest_daily_cases,
    ROUND((SUM(recoveries) / SUM(confirmed_cases)) * 100, 2) as recovery_percentage
FROM covid_cases
GROUP BY state
ORDER BY total_cases DESC;

SELECT '10. VACCINATION ANALYSIS' AS subsection;

SELECT 
    state,
    vaccine_type,
    COUNT(*) as vaccination_days,
    SUM(doses_administered) as total_doses,
    SUM(people_vaccinated) as people_vaccinated,
    SUM(fully_vaccinated) as fully_vaccinated,
    ROUND((SUM(fully_vaccinated) / SUM(people_vaccinated)) * 100, 2) as full_vaccination_rate
FROM covid_vaccines
GROUP BY state, vaccine_type
ORDER BY state, total_doses DESC;

SELECT '11. CORRELATIVE ANALYSIS' AS subsection;

SELECT 
    c.state,
    ROUND(AVG(c.confirmed_cases), 2) as avg_cases,
    ROUND(AVG(d.deaths), 2) as avg_deaths,
    ROUND((AVG(d.deaths) / AVG(c.confirmed_cases)) * 100, 3) as death_rate,
    ROUND(AVG(v.doses_administered), 2) as avg_daily_vaccinations
FROM covid_cases c
LEFT JOIN covid_deaths d ON c.case_id = d.case_id
LEFT JOIN covid_vaccines v ON c.state = v.state AND c.date_recorded = v.date_administered
GROUP BY c.state
ORDER BY death_rate DESC;

SELECT '12. DATA QUALITY CHECKS' AS subsection;

SELECT 
    'Missing Deaths' as issue_type,
    COUNT(*) as count
FROM covid_deaths
WHERE deaths IS NULL
UNION ALL
SELECT 
    'Missing Cases',
    COUNT(*)
FROM covid_cases
WHERE confirmed_cases IS NULL
UNION ALL
SELECT 
    'Negative Values in Cases',
    COUNT(*)
FROM covid_cases
WHERE confirmed_cases < 0
UNION ALL
SELECT 
    'Negative Values in Deaths',
    COUNT(*)
FROM covid_deaths
WHERE deaths < 0;

SELECT '================ END OF QUERIES ================' AS section;
