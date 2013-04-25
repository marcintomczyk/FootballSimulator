package com.tomczyk.football.service.rest;

import javax.ejb.Stateless;
import javax.ws.rs.Path;

import com.tomczyk.football.model.League;

/**
 * <p>
 *     A JAX-RS endpoint for handling {@link League}s.
 *     Inherits the actual methods from {@link BaseEntityService}.
 * </p>
 */
@Path("/leagues")
@Stateless
public class LeagueServiceRs extends BaseEntityService<League> {

    public LeagueServiceRs() {
        super(League.class);
    }

}