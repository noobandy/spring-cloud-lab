package click.techlabs.pingpong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import click.techlabs.pingpong.dto.PingPongDTO;
import click.techlabs.pingpong.service.PingPongService;

@RestController
public class PingPongController {

	@Autowired
	private PingPongService service;
	
	@GetMapping("/pingpong")
	public ResponseEntity<PingPongDTO> ping() {
		return ResponseEntity.ok(service.pingpong());
	}
}
