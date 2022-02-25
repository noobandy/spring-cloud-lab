package click.techlabs.pong.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PongService {

	@Value("${message:Pong}")
	private String message;
	
	public String pong() {
		return message;
	}
}
