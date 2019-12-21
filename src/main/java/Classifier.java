import java.util.Scanner;

public class Classifier {

	private int number, userNumber;
	private Scanner sc;
	Classifier(){
		setNumber();	/* 랜덤숫자 지정 */
		sc = new Scanner(System.in);	
	}
	
	void setNumber() {
		this.number = ((int)(Math.random()*9)+1)*100
				+((int)(Math.random()*9)+1)*10
				+((int)(Math.random()*9)+1);
	}
	
	void setUserNumber(int userNumber) {
		this.userNumber = userNumber;		
	}
	
	boolean judge() { 
		int i=0,j=0,n,un; //i는 스트라이크, j는 볼
		String stringNumber = number+"";
		
		//첫번째 자리
		n = number/100;
		un = userNumber/100;
		if(stringNumber.contains(un+""))
			j++;
		if(n==un) {
			j--;
			i++;
		}
		//두번째자리
		n = (number%100)/10;
		un = (userNumber%100)/10;
		if(stringNumber.contains(un+""))
			j++;
		if(n==un) {
			j--;
			i++;
		}
		//셋째자리
		n = number%10;
		un = userNumber%10;
		if(stringNumber.contains(un+""))
			j++;
		if(n==un) {
			j--;
			i++;
		}
		
		if(i>0)
			System.out.print(i+"스트라이크 ");
		if(j>0)
			System.out.print(j+"볼");
		if(number==userNumber) {
			System.out.println("\n3개의 숫자를 모두 맞히셨습니다! 게임종료");
			return true;
		}
		return false;
	}
	void newGame() {
		System.out.println("게임을 새로 시작하려면 1, "
				+ "종료하려면 2를 입력하세요");
	}
	void game() {
		while(true) {
			System.out.print("\n숫자를 입력해 주세요 :");
			setUserNumber(sc.nextInt());	/* 사용자 입력받기  */
			if(judge()) {
				break;
			}
		}
	}
	
	void board() {
		while(true) {
			game();
			System.out.println("게임을 새로 시작하려면 1,"
					+ " 종료하려면 2를 입력하세요 .");
			if(sc.nextInt()==2) {
				break;
			}
		}
	}
	
}
