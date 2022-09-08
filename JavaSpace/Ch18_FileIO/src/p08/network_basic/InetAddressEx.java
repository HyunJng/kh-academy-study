package p08.network_basic;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressEx {
	public static void main(String[] args) {
		try {
			InetAddress local = InetAddress.getLocalHost();
			System.out.println("내 컴퓨터 IP 주소 : "+ local.getHostAddress());
			
			InetAddress[] ia = InetAddress.getAllByName("www.naver.com");
			
			for(InetAddress remote : ia) {
				System.out.println("www.naver.com IP 주소 : " + remote.getHostAddress());
			}
		} catch (UnknownHostException e) {
			System.out.println("local host를 알 수 없습니다.");
		}
		
		
	}
}
