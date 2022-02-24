package click.techlabs.pingpong.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "ping-service")
public interface PingClient {

	@RequestMapping(path = "/ping", method = RequestMethod.GET)
	String ping();
}
