SELECT p.PersonId,
       p.FirstName,
       p.LastName,
       p.Name
  FROM Person AS p 
 WHERE p.Name = @abc
    OR p.Name = nvl(@abc, @@def)
   and @+def