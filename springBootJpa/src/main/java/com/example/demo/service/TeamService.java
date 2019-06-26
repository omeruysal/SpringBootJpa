package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Player;
import com.example.demo.entity.Team;
import com.example.demo.repository.PlayerRepository;
import com.example.demo.repository.TeamRepository;

@Service
public class TeamService {
	
	@Autowired
	TeamRepository teamRepository;

	
	public Team save(Team teamRequest) {
		Team team = new Team(teamRequest.getId(), teamRequest.getTeamName(), teamRequest.getCity());
		return teamRepository.save(team);
	}
	public List<Team> findAll(){
		return teamRepository.findAll();
	}
	public Team findById(Integer id) {
		return teamRepository.findById(id).orElse(null);
	
	}
	public void deleteById(Integer id) {
		teamRepository.deleteById(id);
	}
	
	

}
