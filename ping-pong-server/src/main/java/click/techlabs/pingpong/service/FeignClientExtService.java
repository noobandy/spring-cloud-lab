package click.techlabs.pingpong.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service(value = "feignClientExtSerice")
public class FeignClientExtService implements ExtService {

	private PingClient pingClient;
	private PongClient pongClient;
	

	@Autowired
	public FeignClientExtService(PingClient pingClient, PongClient pongClient) {
		super();
		this.pingClient = pingClient;
		
		this.pongClient = pongClient;
	}

	@HystrixCommand(fallbackMethod = "pingDataFallback")
	@Override
	public String getPongData() {
		return pingClient.ping();
	}

	@HystrixCommand(fallbackMethod = "pingDataFallback")
	@Override
	public String getPingData() {
		return pongClient.pong();
	}

	private String pingDataFallback() {
		return "Cached Ping";
	}

	private String pongDataFallback() {
		return "Cached Pong";
	}
}
