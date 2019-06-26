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
public class PlayerService {

	@Autowired
	PlayerRepository playerRepository;

	@Autowired
	TeamRepository teamRepository;

	public Player addTeamToPlayer(Integer playerId, Integer teamId) {
		System.out.println("player Id : " + playerId);
		System.out.println("team Id : " + teamId);
		Player player = playerRepository.findById(playerId).orElse(null);
		Team team = teamRepository.findById(teamId).orElse(null);

		player.setTeam(team);
		playerRepository.save(player);
		System.out.println("addPlayer");
		
		return player;

	}

	public List<Player> findAll() {
		List<Player> players = playerRepository.findAll();
		return players;
	}

	public Player findById(Integer id) {
		return playerRepository.findById(id).orElse(null);
	}

	public Player save(Player playerRequest) {

		Player player = new Player(playerRequest.getId(), playerRequest.getFirstName(), playerRequest.getLastName(),
				playerRequest.getBirthday(), playerRequest.getStartDay());

		return playerRepository.save(player);
	}

	public void deleteById(Integer id) {

		playerRepository.deleteById(id);
	}

}
