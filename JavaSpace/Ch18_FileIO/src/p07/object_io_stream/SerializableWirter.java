package p07.object_io_stream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializableWirter {
	public static void main(String[] args) throws IOException {
		FileOutputStream fos = new FileOutputStream("c:/tmp/object1.dat");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		
		ClassA a = new ClassA();
		a.field1 = 1;
		a.field2.field1 = 2;
		a.field3 = 3;
		a.field4 = 4;
		oos.writeObject(a);
		oos.flush();
		oos.close();
		fos.close();
		
	}
}
