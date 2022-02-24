package click.techlabs.pingpong.service;

import java.net.URI;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class EurekaClientExtService implements ExtService {

	private RestTemplate restTemplate;
	private EurekaClient eurekaClient;
	

	@Autowired
	public EurekaClientExtService(RestTemplate restTemplate, EurekaClient eurekaClient) {
		super();
		this.restTemplate = restTemplate;
		
		this.eurekaClient = eurekaClient;
	}

	@HystrixCommand(fallbackMethod = "pingDataFallback")
	@Override
	public String getPongData() {
		InstanceInfo instanceInfo = eurekaClient.getApplication("ping-service").getInstances().get(0);
		URI uri = null;
		try {
			System.out.println(instanceInfo.getHomePageUrl().concat("ping"));
			 uri = new URI(instanceInfo.getHomePageUrl().concat("ping"));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResponseEntity<String> resp = restTemplate.getForEntity(uri, String.class);
		if (resp.getStatusCode().equals(HttpStatus.OK)) {
			return resp.getBody();
		}

		throw new RuntimeException("Pong Service not working");
	}

	@HystrixCommand(fallbackMethod = "pingDataFallback")
	@Override
	public String getPingData() {
		InstanceInfo instanceInfo = eurekaClient.getApplication("pong-service").getInstances().get(0);
		URI uri = null;
		try {
			 uri = new URI(instanceInfo.getHomePageUrl().concat("pong"));
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ResponseEntity<String> resp = restTemplate.getForEntity(uri, String.class);
		if (resp.getStatusCode().equals(HttpStatus.OK)) {
			return resp.getBody();
		}

		throw new RuntimeException("Ping Service not working");
	}

	private String pingDataFallback() {
		return "Cached Ping";
	}

	private String pongDataFallback() {
		return "Cached Pong";
	}
}
