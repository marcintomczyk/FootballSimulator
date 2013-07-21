-- Provided data are only for presentation, testing etc. purposes
-- Premiership
insert into League (name) values ( 'Premiership');

-- Bundesliga
insert into League (name) values ( 'Bundesliga');

-- Teams in Premiership
insert into Team(name, league_id) values ('Arsenal', 1);
insert into Team(name, league_id) values ('Tottenham', 1);
insert into Team(name, league_id) values ('Chelsea', 1);

-- Teams in Bundesliga
insert into Team(name, league_id) values ('Borussia Dortmund', 2);
insert into Team(name, league_id) values ('HSV', 2);
insert into Team(name, league_id) values ('Bayern Munchen', 2);

-- Arsenal's players
insert into Player(first_name, last_name, age, team_id) values ('Wojciech', 'Szczęsny', 23, 1);
insert into Player(first_name, last_name, age, team_id) values ('Łukasz', 'Fabiański', 28, 1);

-- Borussia Dortmund's players
insert into Player(first_name, last_name, age, team_id) values ('Robert', 'Lewandowski', 24, 4);
insert into Player(first_name, last_name, age, team_id) values ('Jakub', 'Błaszczykowski', 27, 4);
insert into Player(first_name, last_name, age, team_id) values ('Łukasz', 'Piszczek', 28, 4);

-- Bayern Munchen's players
insert into Player(first_name, last_name, age, team_id) values ('Franck', 'Ribery', 30, 6);

-- all available skills
insert into SkillType(name) values ('Passing');
insert into SkillType(name) values ('Shooting');
insert into SkillType(name) values ('Technique');
insert into SkillType(name) values ('Kicking');
insert into SkillType(name) values ('Dribbling');
insert into SkillType(name) values ('Aggression');
insert into SkillType(name) values ('Concentration');
insert into SkillType(name) values ('Teamwork');
insert into SkillType(name) values ('Acceleration');
insert into SkillType(name) values ('Stamina');
insert into SkillType(name) values ('Agility');
insert into SkillType(name) values ('Jumping');
insert into SkillType(name) values ('Heading');

-- player's skills

-- player '1'
insert into Skill(level, player_id, skill_type_id) values (5,1,1);
insert into Skill(level, player_id, skill_type_id) values (3,1,2);
insert into Skill(level, player_id, skill_type_id) values (4,1,3);
insert into Skill(level, player_id, skill_type_id) values (4,1,4);
insert into Skill(level, player_id, skill_type_id) values (4,1,5);
insert into Skill(level, player_id, skill_type_id) values (4,1,6);
insert into Skill(level, player_id, skill_type_id) values (4,1,7);
insert into Skill(level, player_id, skill_type_id) values (4,1,8);
insert into Skill(level, player_id, skill_type_id) values (4,1,9);
insert into Skill(level, player_id, skill_type_id) values (4,1,10);
insert into Skill(level, player_id, skill_type_id) values (4,1,11);
insert into Skill(level, player_id, skill_type_id) values (4,1,12);
insert into Skill(level, player_id, skill_type_id) values (4,1,13);

	
-- player '2'
insert into Skill(level, player_id, skill_type_id) values (4,2,1);
insert into Skill(level, player_id, skill_type_id) values (4,2,2);
insert into Skill(level, player_id, skill_type_id) values (4,2,3);


-- all available positions
insert into PositionType(name) values ('Goalkeeper');
insert into PositionType(name) values ('Defender');
insert into PositionType(name) values ('Midfielder');
insert into PositionType(name) values ('Forward');

-- player's positions

-- player '1'
insert into Position(preferred, player_id, position_type_id) values (true,1,1);

-- player '2'
insert into Position(preferred, player_id, position_type_id) values (true,2,1);

-- player '3'
insert into Position(preferred, player_id, position_type_id) values (true,3,4);
insert into Position(preferred, player_id, position_type_id) values (false,3,3);

-- player '4'
insert into Position(preferred, player_id, position_type_id) values (true,4,3);
insert into Position(preferred, player_id, position_type_id) values (false,4,4);