package com.apirest.webflux.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.apirest.webflux.document.Playlist;
import com.apirest.webflux.repository.PlaylistRepository;
import com.apirest.webflux.services.PlaylistService;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/playlist")
public class PlaylistController {
	
	@Autowired
	PlaylistService service;
	
	@GetMapping()
	public Flux<Playlist> getPlaylist(){
		return service.findAll();
	}

	@GetMapping(value="/{id}")
	public Mono<Playlist> getPlaylistId(@PathVariable String id){
		return service.findById(id);
	}
	

	@PostMapping(value="/playlist")
	public Mono<Playlist> save(@RequestBody Playlist playlist){
		return service.save(playlist);
	}
	
	@DeleteMapping(value="/{id}")
	public Mono<Void> deletePlaylistId(@PathVariable String id){
	  return service.deleteById(id);
	}
	
	@PutMapping(value="/{id}")
	public Mono<Playlist> updatePlaylistId(@PathVariable String id,  @RequestBody Playlist playlist){
	  playlist.setId(id);
	  return service.updateById(playlist);
	}
	
	

}
