package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Team {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String teamName;
	private String city;
	@OneToMany(mappedBy="team")
	@JsonIgnore
	private List<Player>  players = new ArrayList<>();
	
	
	
	public Team() {
		}
	public Team(Integer id, String teamName, String city) {
		super();
		this.id = id;
		this.teamName = teamName;
		this.city = city;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public List<Player> getPlayer() {
		return players;
	}
	public void setPlayer(Player player) {
		this.players.add(player);
	}
	
	

}
