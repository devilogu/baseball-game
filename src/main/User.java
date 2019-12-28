package main;

import java.util.ArrayList;
import java.util.Scanner;

public class User {

	private static final int INPUT_SIZE = 3;

	private ArrayList<Integer> inputNum;
	
	Scanner sc;

	/* 유저로부터 숫자 입력받기 */
	public void inputNumber() {
		String input;
		
		inputNum = new ArrayList<>();
		sc = new Scanner(System.in);
		
		while (true) {
			System.out.print("숫자를 입력해 주세요 : ");
			input = sc.next();

			if (isInteger(input) && checkInputLen(input) && isDifferent(input)) {
				changeInput(input);
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
		return input.length() == INPUT_SIZE;
	}

	/* 유저가 입력한 값이 다 다른지 체크 */
	public boolean isDifferent(String input) {

		if (input.charAt(0) == input.charAt(1) || input.charAt(0) == input.charAt(2)
				|| input.charAt(1) == input.charAt(2)) {
			return false;
		}
		return true;
	}

	/* 유저가 입력한 값(String)을 int로 변환해서 리스트에 삽입 */
	public void changeInput(String input) {
		for (int i = 0; i < INPUT_SIZE; i++) {
			char c = input.charAt(i);
			int value = (int)c - 48;
			inputNum.add(value);
		}
	}

	/* getter */
	public ArrayList<Integer> getNum() {
		return inputNum;
	}
	
	/* 재시작할건지 선택 */
	public boolean restart() {
		while(true) {
			System.out.print("재시작하려면 1, 종료하려면 2 입력 : ");
			int choice = sc.nextInt();
			if(choice == 1) {
				return true;
			}
			else {
				sc.close();
				return false;
			}
		}
	}
}
