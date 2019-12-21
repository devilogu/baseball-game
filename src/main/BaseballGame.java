package main;

import java.util.ArrayList;

public class BaseballGame {

	private static final int INPUT_SIZE = 3;

	private Computer computer;
	private User user;
	
	private boolean start = true;

	private ArrayList<Integer> computerNum;
	private ArrayList<Integer> userNum;

	public BaseballGame() {
		computer = new Computer();
		user = new User();
	}

	/* 사용자에게 수를 입력받고, 컴퓨터는 난수 생성 */
	public void run() {
		computer.createRandomNum();
		
		while (start) {
			user.inputNumber();
			compare();
		}
	}

	/* 숫자 비교하여 스트라이크, 볼 체크 */
	public void compare() {
		int strike = 0;
		int ball = 0;

		computerNum = computer.getRandomNum();
		userNum = user.getNum();

		/* 스트라이크 개수 체크 */
		for (int i = 0; i < INPUT_SIZE; i++) {
			if (computerNum.get(i).equals(userNum.get(i))) {
				strike += 1;
			}
		}
		
		/* 볼 개수 체크 */
		for (int i = 0; i < INPUT_SIZE; i++) {
			if (computerNum.contains(userNum.get(i)) && computerNum.get(i) != userNum.get(i)) {
				ball += 1;
			}
		}

		/* 결과 출력  */
		result(strike, ball);
		
		/* 정답일 경우 유저에게 재시작 여부 묻기 */
		if(strike == 3) {
			restart();
		}
	}

	/* 결과 출력 */
	public void result(int strike, int ball) {
		if (strike <= 0 && ball <= 0) {
			System.out.println("Nothing");
		} else {
			System.out.println("strike: " + strike + " ball: " + ball);
		}
	}
	
	public void restart() {
		if(user.restart()) {
			start = true;
			computer.createRandomNum();
		}else {
			start = false;
		}
	}
}
