package click.techlabs.ping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import click.techlabs.ping.service.PingService;

@RestController
public class PingController {

	@Autowired
	private PingService service;
	
	@GetMapping("/ping")
	public ResponseEntity<String> ping() {
		return ResponseEntity.ok(service.ping());
	}
}
