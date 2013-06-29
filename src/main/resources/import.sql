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

-- Arsenal's players
insert into Player(first_name, last_name, age, team_id) values ('Wojciech', 'Szczęsny', 23, 1)
insert into Player(first_name, last_name, age, team_id) values ('Łukasz', 'Fabiański', 28, 1)

-- Borussia Dortmund's players
insert into Player(first_name, last_name, age, team_id) values ('Robert', 'Lewandowski', 24, 4)
insert into Player(first_name, last_name, age, team_id) values ('Jakub', 'Błaszczykowski', 27, 4)
insert into Player(first_name, last_name, age, team_id) values ('Łukasz', 'Piszczek', 28, 4)

-- Bayern Munchen's players
insert into Player(first_name, last_name, age, team_id) values ('Franck', 'Ribery', 30, 6)