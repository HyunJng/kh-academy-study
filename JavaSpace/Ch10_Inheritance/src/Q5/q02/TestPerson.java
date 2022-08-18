package Q5.q02;

public class TestPerson {
	public static void main(String[] args) {
		Person[] p = new Person[5];
		
		p[0] = new Person("우", "영우", "-1", "wo@naver.com");
		p[1] = new Student("김씨","서울" ,"0", "k@naver.com", 3);
		p[2] = new Employee("박씨","경기" ,"1", "p@naver.com", 505, 4000);
		p[3] = new Faculty("최씨", "강원", "2", "ch@naver.com", 402, 3000, "6~9", "대리");
		p[4] = new Staff("호씨", "인천", "3", "ho@naver.com", 101, 3200, "팀장");
		
		for(int i = 0 ;i<5; i++) 
			System.out.println(p[i]);
		
	}
}
