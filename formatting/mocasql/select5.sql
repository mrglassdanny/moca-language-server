SELECT p.PersonId,
       p.FirstName,
       p.LastName,
       CASE
         WHEN p.Age < 18 THEN 'below 18'
         WHEN p.Age >= 18 THEN '18 or more'
       END AS Age
  FROM Person AS p