package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Player;
import com.example.demo.entity.Team;
import com.example.demo.service.TeamService;

@RestController
@RequestMapping("/team")
public class TeamController {
	
	@Autowired
	TeamService teamService;
	
	@RequestMapping(method = RequestMethod.GET,value="/all")
	public ResponseEntity<List<Team>> findAll(){
		
		List<Team> teams = teamService.findAll();
		return ResponseEntity.ok(teams);
	}
	@RequestMapping(method = RequestMethod.GET,value="/get/{id}")
	public ResponseEntity<Team> findById(@PathVariable Integer id){
		
		try {
			Team team = teamService.findById(id);
		return ResponseEntity.ok(team);		
		
			
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
	}
	@RequestMapping(method=RequestMethod.POST, value="/save")
	public ResponseEntity<Team> save(@Valid @RequestBody Team teamRequest) {
		
		return ResponseEntity.ok(teamService.save(teamRequest));
		
		}
	
	@RequestMapping(method = RequestMethod.DELETE,value="/delete/{id}")//Postmanden delete islemi oluyor fakat
																	// tarayıcıdan olmuyor
 	public ResponseEntity<Team> delete(@PathVariable Integer id)
	
	{
		Team team = teamService.findById(id);

        if (team != null) {
           teamService.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return new ResponseEntity("No Team found to delete for ID " + id, HttpStatus.NOT_FOUND);

	}
	
	@RequestMapping("/denemeteam")
	public String opening() {

		return "Hello";

	}

}
