package p08.network_basic3;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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
				
				byte[] bytes = null;
				String message = null;
				
				InputStream is = socket.getInputStream();
				bytes = new byte[100];
				// read() : client에서 data를 보내기 기다리는 것, client에서 data write()하기를 기다림
				int readByteCount = is.read(bytes);
				message = new String(bytes, 0, readByteCount, "UTF-8");	// decoding
				System.out.println("[데이터 받기 성공] : " + message);
				
				OutputStream os = socket.getOutputStream();
				message = "Hello Client";
				bytes = message.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("[데이터 보내기 성공]");
				
				is.close();
				os.close();
				socket.close();
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