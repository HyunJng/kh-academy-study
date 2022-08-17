package p01.basic;

public class TwoDimArrayBasic {

	public static void main(String[] args) {
		String[][] gPerson = { 
				{ "1", "박철호", "서울", "회사원" }, 
				{ "2", "김의실", "경기", "공무원" }, 
				{ "3", "오수철", "수원", "연예인" }, 
		};

		String[] onePerson = new String[4];
		onePerson = gPerson[2];
		onePerson[2] = "부산";
		
		for (int i = 0; i < onePerson.length; i++) {
			System.out.println("onePerson[" + i + "] : " + onePerson[i]);
		}

		System.out.println();
		for (int i = 0; i < gPerson.length; i++) {
			System.out.println("gPerson[" + i + "]: " + gPerson[i]);
			for (int j = 0; j < gPerson[i].length; j++) {
				System.out.println("gPerson[" + i + "][" + j + "] : " + gPerson[i][j]);
			}
		}

	}

}
