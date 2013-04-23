package com.tomczyk.football.view;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "league")
public class LeagueBean {
	
	private String name = "Nothing special now... - will be a league";

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


}
