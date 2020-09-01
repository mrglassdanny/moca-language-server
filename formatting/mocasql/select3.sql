SELECT p.PersonId,
       p.FirstName,
       p.LastName,
       p.Name
  FROM Person AS p 
 WHERE p.Name = 'New York'
    OR p.Name = 'Chicago'