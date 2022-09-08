package p07.object_io_stream;

import java.io.Serializable;
//class로 선언된 인스턴스(new로 힙메모리에 생성)는 
//기본적으로 file에 read/write가 가능하고, 네트워크에 송수신이 가능하다.
// - 단 field만 가능(생성자, 메서드 제외)
// - field에서도 static은 제외
// - transient는 Serializable 인터페이스를 implement한 class에서 사용
//	=>  file에 write하거나 networ에서 송수신 대상에서 제외할 목적으로 사용(예, password를 관리하는 field인 경우)
public class ClassA implements Serializable{
	static final long serialVersionUID = 1;
	int field1;
	ClassB field2 = new ClassB();
	static int field3;	// static으로 선언된 field는 
	transient int field4;
	int field5;
}
