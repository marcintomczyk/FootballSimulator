package com.tomczyk.football.model;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.tomczyk.football.model.dictionary.SkillType;

/**
 * 
 * Player's skill
 * 
 * Player can have many skills
 *
 */
@Entity
public class Skill {

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	/*
	 * value from 0 to 10
	 */
	private Integer level;
	
	@ManyToOne
	@JoinColumn(name = "player_id")
	private Player player;
	
	@ManyToOne
	@JoinColumn(name = "skill_type_id")
	private SkillType skillType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getLevel() {
		return level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public SkillType getSkillType() {
		return skillType;
	}

	public void setSkillType(SkillType skillType) {
		this.skillType = skillType;
	}
	
}
