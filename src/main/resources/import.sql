-- Premiership
insert into League (name) values ( 'Premiership')

-- Bundesliga
insert into League (name) values ( 'Bundesliga')

-- Teams in Premiership
insert into Team(name, league_id) values ('Arsenal', 1)
insert into Team(name, league_id) values ('Tottenham', 1)
insert into Team(name, league_id) values ('Chelsea', 1)

-- Teams in Bundesliga
insert into Team(name, league_id) values ('Borussia Dortmund', 2)
insert into Team(name, league_id) values ('HSV', 2)
insert into Team(name, league_id) values ('Bayern Munchen', 2)