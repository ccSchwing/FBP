--
-- Use this to add or update a record.
-- Useful to prevent duplicate displayNames and when updating passwords.
-- This would have to fully fleshed out with all fields in a real application.
-- ccs

insert into User(displayName, hashedPassword) values ('a', '')
on duplicate key update hashedPassword='newHashedPassword'