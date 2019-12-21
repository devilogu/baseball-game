package main;

import java.util.ArrayList;

public class BaseballGame {
	private Computer computer;
	private User user;
	
	private ArrayList<Integer> computerNum;
	private ArrayList<Integer> userNum;
	
	public BaseballGame() {
		computer = new Computer();
		user = new User();
	}
	
	/* 사용자에게 수를 입력받고, 컴퓨터는 난수 생성 */
	public void run() {	
		user.inputNumber();
		computer.createRandomNum();
	}
	
	/* 결과 출력 */
	
	/* 스트라이크 개수 반환  */
	
	/* 볼 개수 반환 */
	
	
}
