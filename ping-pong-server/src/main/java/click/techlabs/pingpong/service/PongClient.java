package click.techlabs.pingpong.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "pong-service")
public interface PongClient {

	@RequestMapping(path = "/pong", method = RequestMethod.GET)
	String pong();
}
