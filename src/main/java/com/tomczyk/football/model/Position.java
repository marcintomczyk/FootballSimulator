package com.tomczyk.football.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.tomczyk.football.model.dictionary.PositionType;
import com.tomczyk.football.model.dictionary.SkillType;

/**
 * 
 * Player's position
 * 
 * Player can play on different positions
 *
 */
@Entity
public class Position {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	private boolean preferred;
	
	@ManyToOne
	@JoinColumn(name = "player_id")
	private Player player;
	
	@ManyToOne
	@JoinColumn(name = "position_type_id")
	private PositionType positionType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public boolean isPreferred() {
		return preferred;
	}

	public void setPreferred(boolean preferred) {
		this.preferred = preferred;
	}

	public PositionType getPositionType() {
		return positionType;
	}

	public void setPositionType(PositionType positionType) {
		this.positionType = positionType;
	}
	
}
