-- this 'runscript' statement is mainly because an initial import.sql with the 'insert' statements 
-- resulted in the ComparisonException while comparing strings containings 'ę' chars etc using arquillian testing
-- It looks like a problem with storing data in a correct format (a charset 'UTF-8' not set ?)
-- workspace's, project's, file's properties etc. have utf-8 encoding
-- What's interesting: 
-- import.sql with the 'insert' statements works 'ok' if the application is run on server (we can see the correct data using h2console)

-- SOLUTION:
-- As below: just using RUNSCRIPT statement and put initial 'insert' statements into a separate file (initial_data.sql)
-- in this way it is not the 'hbm2ddl' tool which makes 'inserts' but the h2 engine itself.
-- According the h2 docs, h2 uses internally utf8 encoding
-- you can notice I did not set encoding in the initial_data.sql file

-- Another possible solution is to use import from csv file

-- TO BE DONE: move RUNSCRIPT to connection url - in this case we do not need import.sql at all

-- absolute path works
-- classpath:initial_data.sql does not work
RUNSCRIPT FROM '~\workspaces\jsf\FootballSimulator\src\main\resources\initial_data.sql'