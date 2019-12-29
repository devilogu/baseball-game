import java.util.Scanner;

public class Classifier {

	private int number, userNumber;
	private Scanner sc;
	Classifier(){
		setNumber();	/* 랜덤숫자 지정 */
		sc = new Scanner(System.in);	
	}
	
	void setNumber() {
		int first,middle=0,last=0;
		first = ((int)(Math.random()*9)+1);
		middle = ((int)(Math.random()*9)+1);
		last = ((int)(Math.random()*9)+1);
		while(middle==first) {
			middle = ((int)(Math.random()*9)+1);
		}
		while(last==first || last==middle) {
			last = ((int)(Math.random()*9)+1);
		}
		this.number = (first*100)+(middle*10)+last;		
		System.out.println(":"+this.number);
	}
	
	void setUserNumber(int userNumber) {
		this.userNumber = userNumber;		
	}
	
	boolean judge() { 
		int strike=0,ball=0,computerNumber,userNumber; //i는 스트라이크, j는 볼
		String stringNumber = this.number+"";
		
		//첫번째 자리
		computerNumber = this.number/100;
		userNumber = this.userNumber/100;
		if(stringNumber.contains(userNumber+"")) {
			ball++;	
		}
		if(computerNumber==userNumber) {
			ball--;
			strike++;
		}
		//두번째자리
		computerNumber = (this.number%100)/10;
		userNumber = (this.userNumber%100)/10;
		if(stringNumber.contains(userNumber+"")) {
			ball++;
		}
		if(computerNumber==userNumber) {
			ball--;
			strike++;
		}
		//셋째자리
		computerNumber = number%10;
		userNumber = this.userNumber%10;
		if(stringNumber.contains(userNumber+"")) {
			ball++;
		}
		if(computerNumber==userNumber) {
			ball--;
			strike++;
		}
		
		if(strike>0) {
			System.out.print(strike+"스트라이크 ");
		}
		if(ball>0) {
			System.out.print(ball+"볼");
		}
		if(number==this.userNumber) {
			System.out.println("\n3개의 숫자를 모두 맞히셨습니다! 게임종료");
			return true;
		}
		return false;
	}
	
	void game() {
		do {
			System.out.print("\n숫자를 입력해 주세요 :");
			setUserNumber(sc.nextInt());	/* 사용자 입력받기  */
		}while(!judge());
	}
	
	void board() {
		do	{
			game();
			System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요 .");		
		}while(sc.nextInt()==1);
	}	
}
