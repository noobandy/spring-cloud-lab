package click.techlabs.pong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import click.techlabs.pong.service.PongService;

@RestController
public class PongController {

	@Autowired
	private PongService service;
	
	@GetMapping("/pong")
	public ResponseEntity<String> pong() {
		return ResponseEntity.ok(service.pong());
	}
}
