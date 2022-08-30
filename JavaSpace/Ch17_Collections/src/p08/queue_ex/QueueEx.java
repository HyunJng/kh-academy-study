package p08.queue_ex;

import java.util.LinkedList;
import java.util.Queue;

public class QueueEx {
	public static void main(String[] args) {
		Queue<Message> messagesQueue = new LinkedList<>();
		
		messagesQueue.offer(new Message("sendMail", "홍길동"));
		messagesQueue.offer(new Message("sendSMS", "신용권"));
		messagesQueue.offer(new Message("sendkakaotalk", "홍두께"));
		
		while(!messagesQueue.isEmpty()) {
			Message message = messagesQueue.poll();
			switch (message.getSend()) {
			case "sendMail":
				System.out.println(message.getTo() + "님에게 메일을 보냅니다.");
				break;
			case "sendSMS":
				System.out.println(message.getTo() + "님에게 SMS을 보냅니다.");
				break;
			case "sendkakaotalk":
				System.out.println(message.getTo() + "님에게 카카오톡을 보냅니다.");
				break;
			}
		}
	}
}
