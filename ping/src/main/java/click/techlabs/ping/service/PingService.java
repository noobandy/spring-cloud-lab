package click.techlabs.ping.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Service;

@RefreshScope
@Service
public class PingService {

	@Value("${message:Ping}")
	private String message;
	public String ping() {
		return message;
	}
}
