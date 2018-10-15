package kr.or.ddit.sum;

public class CalculationLogic {
	public static void main(String[] args) {
		CalculationLogic logic =  new CalculationLogic();
		
		int start = 1;
		int end = 10;
		int sum = logic.sumBetweenTwoNumbers(start, end);
		
		if(sum == 55){
			System.out.println("정답");
		}else{
			System.out.println("오답");
		}
		
		sum = logic.sumBetweenTwoNumbers(start+2, end+2);
		
		if(sum == 75){
			System.out.println("정답");
		}else{
			System.out.println("오답");
		}
	}

	public int sumBetweenTwoNumbers(int start, int end) {
		int min = Math.min(start, end);
		int max = Math.max(start, end);
		
		int result = 0;
		for (int i = start ; i <= end; i++) {
			result += i;
		}
		return result;
	}

}
