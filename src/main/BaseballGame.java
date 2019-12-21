package main;

import java.util.ArrayList;

public class BaseballGame {
	
	private static final int INPUT_SIZE = 3;
	
	private Computer computer;
	private User user;
	
	private ArrayList<Integer> computerNum;
	private ArrayList<Integer> userNum;
	
	private int strike = 0;
	private int ball = 0;
	
	public BaseballGame() {
		computer = new Computer();
		user = new User();
		
	}
	
	/* 사용자에게 수를 입력받고, 컴퓨터는 난수 생성 */
	public void run() {	
		user.inputNumber();
		computer.createRandomNum();
		
		compare();
	}

	
	/* 숫자 비교  */
	public void compare() {
		userNum = user.getNum();
		computerNum = computer.getRandomNum();
		System.out.println(computerNum);
		checkStrike();
		checkball();
		
		if(strike <= 0 && ball <= 0) {
			System.out.println("Nothing");
		}else {
			System.out.println("strike: " + strike + " ball: " + ball);
		}
	}
	
	/* 스트라이크 개수 반환  */
	public void checkStrike() {
		for(int i=0; i<INPUT_SIZE; i++) {
			if(computerNum.get(i).equals(userNum.get(i))) {
				strike += 1;
			}
		}
	}
	
	/* 볼 개수 반환 */
	public void checkball() {
		for(int i=0; i<INPUT_SIZE; i++) {
			if(computerNum.contains(userNum.get(i)) && computerNum.get(i) != userNum.get(i)){
				ball += 1;
			}
		}
	}
	
	/* 재시작 여부 */
}
