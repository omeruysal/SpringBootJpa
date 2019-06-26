package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Player;
import com.example.demo.service.PlayerService;

@RestController
@RequestMapping("/player")
public class PlayerController {

	@Autowired
	PlayerService playerService;

	
	@RequestMapping(method=RequestMethod.POST, value="/addTeam/{playerId}/{teamId}")
	public ResponseEntity<Player> addTeamToPlayer(@PathVariable Integer playerId,@PathVariable Integer teamId){
	
		
		return ResponseEntity.ok(playerService.addTeamToPlayer(playerId, teamId));
	}
	
	@RequestMapping(method=RequestMethod.POST, value="/save")
	public ResponseEntity<Player> save(@Valid @RequestBody Player playerRequest) {//Valid kriterlere uygun olup olmadıgını kontroleder
		
		return ResponseEntity.ok(playerService.save(playerRequest));
		
		}
	
	@RequestMapping(method = RequestMethod.GET, value = "/all")
	public ResponseEntity<List<Player>> findAll() {
		List<Player> players = playerService.findAll();
		return ResponseEntity.ok(players);
	}
	

	@RequestMapping(method = RequestMethod.GET, value = "/get/{id}")
	public ResponseEntity<Player> findById(@PathVariable Integer id) {

		try {
			Player player = playerService.findById(id);
			return ResponseEntity.ok(player);
		} catch (Exception e) {

			return ResponseEntity.notFound().build();
		}

	}

	@RequestMapping("/deneme")
	public String opening() {

		return "Hello";

	}

}
