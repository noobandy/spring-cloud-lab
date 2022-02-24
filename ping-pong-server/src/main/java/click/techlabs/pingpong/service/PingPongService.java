package click.techlabs.pingpong.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import click.techlabs.pingpong.dto.PingPongDTO;

@Service
public class PingPongService {

	@Autowired
	private ExtService extService;


	
	public PingPongDTO pingpong() {
		
		String pingData = extService.getPingData();
		String pongData = extService.getPongData();
		
		return new PingPongDTO(pingData, pongData);
	}


}
