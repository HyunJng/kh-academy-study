package q07.ch13_no07;

public class Board {
	private String title;
	private String content;

	public Board(String title, String content) {
		this.title = title;
		this.content = content;
	}

	protected String getTitle() {
		return title;
	}

	protected String getContent() {
		return content;
	}
}
