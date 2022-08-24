package p05.class_class;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionEx {

	public static void main(String[] args) throws ClassNotFoundException {
		Class cls = Class.forName("p05.class_class.Circle");

		System.out.println("[클래스 이름]");
		System.out.println(cls.getName());
		System.out.println();

		System.out.println("[생성자 정보]");
		Constructor[] constructors = cls.getDeclaredConstructors();
		for (Constructor c : constructors) {
			System.out.print(c.getName() + " (");
			Class[] parameters = c.getParameterTypes();
			printParameters(parameters);
			System.out.println(")");
		}
		System.out.println();

		System.out.println("[필드 정보]");
		Field[] fields = cls.getDeclaredFields();
		for (Field field : fields)
			System.out.println(field.getType().getSimpleName() + " " + field.getName());
		System.out.println();

		System.out.println("[메서드 정보]");
		Method[] methods = cls.getDeclaredMethods();
		for (Method method : methods) {
			System.out.print(method.getName() + "(");
			Class[] parameters = method.getParameterTypes();
			printParameters(parameters);
			System.out.println(")");
		}

	}

	private static void printParameters(Class[] parameters) {
//		for(Class c : parameters) {
//			System.out.print(c.getName() + ", ");
//		}
		for(int i = 0; i<parameters.length ; i++) {
			System.out.print(parameters[i].getName());
			if(i < parameters.length -1)
				System.out.print(", ");
		}
	}
}
