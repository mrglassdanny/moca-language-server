SELECT p.PersonId,
       p.FirstName,
       p.LastName,
       c.Name
  FROM Person AS p 
  JOIN City AS c 
    ON p.CityId = c.CityId