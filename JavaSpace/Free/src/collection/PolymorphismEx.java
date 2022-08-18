package collection;
import java.util.ArrayList;


abstract class Unit {
    int x, y ;
    abstract void move(int x, int y) ; // 해당 이름의 메서드를 사용하는 자손클래스는 많지만 각 클래스에서의 move메서드 실행 코드는 다르다.
    void stop() {}
}
class Marine extends Unit {
    void move(int x, int y) {}
    void stimpack() {}
}
class Tank extends Unit {
    void move(int x, int y) {}
    void changeMode() {}
}
class Dropship extends Unit {
    void move(int x, int y) {}
    void load() {}
    void unload() {}
}

public class PolymorphismEx {
	public static void main(String[] args) {
		Unit[] group = new Unit[3] ;
		group[0] = new Marine() ;
		group[1] = new Tank() ;
		group[2] = new Dropship() ;

		for(int i = 0; i <group.length; i++)
		    group[i].move(100,200);
	}
}

