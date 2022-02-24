package click.techlabs.pingpong.dto;

public class PingPongDTO {

	private String ping;
	private String pong;
	
	public PingPongDTO() {
		super();
		
	}
	
	public PingPongDTO(String ping, String pong) {
		super();
		this.ping = ping;
		this.pong = pong;
	}

	public String getPing() {
		return ping;
	}

	public void setPing(String ping) {
		this.ping = ping;
	}

	public String getPong() {
		return pong;
	}

	public void setPong(String pong) {
		this.pong = pong;
	}
	
}
