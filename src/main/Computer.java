package main;

import java.util.ArrayList;

public class Computer {
	
	private static final int BALL_SIZE = 3;
	
	private ArrayList<Integer> randomNum; //랜덤숫자를 담을 리스트

	/* 난수 생성 */
	public ArrayList<Integer> createRandomNum() {
		randomNum = new ArrayList<>();
		
		while(randomNum.size() < BALL_SIZE) {
			int num = (int)(Math.random() * 9 + 1);

			if(!isDifferent(num)) {
				randomNum.add(num);
			}
		}
		return randomNum;
	}
	
	/* 중복 확인 */
	public boolean isDifferent(int num) {
		return randomNum.contains(num);
	}
	
	/* getter */
	public ArrayList<Integer> getRandomNum() {
		return randomNum;
	}
}
