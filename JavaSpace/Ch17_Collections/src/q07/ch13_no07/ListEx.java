package q07.ch13_no07;

import java.util.List;

public class ListEx {
	public static void main(String[] args) {
		BoardDao dao = new BoardDao();
		List<Board> list = dao.getBoardList();
		
		for(Board b : list)
			System.out.println(b.getTitle() + "-" + b.getContent());
	}
}
