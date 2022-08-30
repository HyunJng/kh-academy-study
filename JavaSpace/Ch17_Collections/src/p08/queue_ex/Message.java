package p08.queue_ex;

public class Message {
	private String send;
	private String to;

	public Message(String send, String to) {
		this.send = send;
		this.to = to;
	}

	protected String getSend() {
		return send;
	}

	protected String getTo() {
		return to;
	}
	
	
}
