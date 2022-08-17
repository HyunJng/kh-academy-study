package p01.practice;

//  학생 성적 매기기 (문제수 : 10)
public class GradeExam {
	public static void main(String[] args) {
		char[][] studentAnswers = { 
				{ 'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D' }, // 첫번째 학생이 제출한 정답
				{ 'D', 'B', 'A', 'B', 'C', 'D', 'E', 'E', 'A', 'D' },
				{ 'E', 'D', 'D', 'A', 'C', 'D', 'E', 'E', 'A', 'D' },
				{ 'C', 'B', 'A', 'E', 'C', 'D', 'E', 'E', 'A', 'D' },
				{ 'A', 'B', 'A', 'C', 'C', 'D', 'E', 'E', 'A', 'D' },
				{ 'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D' }};

		char[] answer = { 'D', 'B', 'D', 'C', 'C', 'D', 'A', 'E', 'A', 'D' }; // 정답

		// 5명의 학생 성적 구하기
		for (int i = 0; i < studentAnswers.length; i++) {
			int correctcCnt = 0;
			for (int j = 0; j < studentAnswers[i].length; j++) {
				if (answer[j] == studentAnswers[i][j])
					correctcCnt++;
			}
			System.out.println("학생번호 " + i + "의 정답 총 개수: " + correctcCnt);
		}
	}
}
