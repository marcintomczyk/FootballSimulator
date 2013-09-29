package com.tomczyk.football.arquillian.base;

import org.jboss.shrinkwrap.api.spec.WebArchive;

import com.tomczyk.football.model.League;
import com.tomczyk.football.model.Team;
import com.tomczyk.football.model.dictionary.PositionType;
import com.tomczyk.football.service.LeagueService;
import com.tomczyk.football.service.impl.LeagueServiceImpl;
import com.tomczyk.football.service.rest.BaseEntityService;
import com.tomczyk.football.service.rest.LeagueServiceRs;
import com.tomczyk.football.util.MultivaluedHashMap;

public class RestDeployment {

	public static WebArchive deployment() {

		return FootballSimulatorDeployment.deployment()
				.addPackage(League.class.getPackage())
				.addPackage(Team.class.getPackage())
				.addPackage(PositionType.class.getPackage())
				.addPackage(MultivaluedHashMap.class.getPackage())
				.addPackage(BaseEntityService.class.getPackage())
				.addClass(LeagueService.class)
				.addClass(LeagueServiceImpl.class)
				.addClass(LeagueServiceRs.class);
	}

}
