package p08.network_basic2;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerEx {
	public static void main(String[] args) {
		ServerSocket serverSocket = null;
		
		try {
			// server용 socket생성 ( socket : network 상에서 data를 주고받을 때 생성하는 instance)
			serverSocket = new ServerSocket();
			// IP address : "localhost(자신의 컴퓨터, 127.0.0.1)", port : 5001 
			// 위의 정보를 묶는 것
			serverSocket.bind(new InetSocketAddress("localhost", 5001));
			
			while(true) {
				System.out.println("[연결 기다림]");
				// accept: client에서 connect요청한 것에 대해 accept함
				Socket socket = serverSocket.accept();
				InetSocketAddress isa = (InetSocketAddress) socket.getRemoteSocketAddress();
				System.out.println("[연결수락함]" + isa.getHostName());
			}
		} catch (IOException e) {
			System.out.println("server socket 생성 실패");
		}
		
		if(!serverSocket.isClosed()) {
			try {
				serverSocket.close();
			} catch (IOException e) {
				System.out.println("socket close error");
			}
		}
	}
}
