package main;

import java.util.Scanner;

public class User {

	private static final int BALL_SIZE = 3;

	private int[] num;

	public User() {
		num = new int[BALL_SIZE];
	}

	/* 유저로부터 숫자 입력받기 */
	public void inputNumber() {
		Scanner sc = new Scanner(System.in);
		String input;

		while (true) {
			System.out.print("숫자를 입력해 주세요 : ");
			input = sc.next();

			if (isInteger(input) && checkInputLen(input) && isDifferent(input)) {
				setNum(input);
				
				sc.close();
				break;
			}
		}
	}

	/* 유저가 입력한 값이 숫자(1-9)인지 체크 */
	public boolean isInteger(String input) {
		char tmp;

		for (int i = 0; i < input.length(); i++) {
			tmp = input.charAt(i);

			if (!('1' <= tmp && tmp <= '9')) {
				return false;
			}
		}
		return true;
	}

	/* 유저가 입력한 값이 3글자인지 체크 */
	public boolean checkInputLen(String input) {
		return input.length() == BALL_SIZE;
	}

	/* 유저가 입력한 값이 다 다른지 체크 */
	public boolean isDifferent(String input) {

		if (input.charAt(0) == input.charAt(1) || input.charAt(0) == input.charAt(2)
				|| input.charAt(1) == input.charAt(2)) {
			return false;
		}
		return true;
	}

	/* num배열에 유저가 입력한 값 넣기 */
	public void setNum(String input) {
		for (int i = 0; i < BALL_SIZE; i++) {
			char c = input.charAt(i);
			num[i] = (int) c - 48;
		}
	}

	/* getter */
	public int[] getNum() {
		return num;
	}
}
