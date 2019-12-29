import java.util.Scanner;

public class Classifier {

	private int number, userNumber;
	private Scanner sc;
	Classifier(){
		setNumber();	/* �������� ���� */
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
		int strike=0,ball=0,computerNumber,userNumber; //i�� ��Ʈ����ũ, j�� ��
		String stringNumber = this.number+"";
		
		//ù��° �ڸ�
		computerNumber = this.number/100;
		userNumber = this.userNumber/100;
		if(stringNumber.contains(userNumber+"")) {
			ball++;	
		}
		if(computerNumber==userNumber) {
			ball--;
			strike++;
		}
		//�ι�°�ڸ�
		computerNumber = (this.number%100)/10;
		userNumber = (this.userNumber%100)/10;
		if(stringNumber.contains(userNumber+"")) {
			ball++;
		}
		if(computerNumber==userNumber) {
			ball--;
			strike++;
		}
		//��°�ڸ�
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
			System.out.print(strike+"��Ʈ����ũ ");
		}
		if(ball>0) {
			System.out.print(ball+"��");
		}
		if(number==this.userNumber) {
			System.out.println("\n3���� ���ڸ� ��� �����̽��ϴ�! ��������");
			return true;
		}
		return false;
	}
	
	void game() {
		do {
			System.out.print("\n���ڸ� �Է��� �ּ��� :");
			setUserNumber(sc.nextInt());	/* ����� �Է¹ޱ�  */
		}while(!judge());
	}
	
	void board() {
		do	{
			game();
			System.out.println("������ ���� �����Ϸ��� 1, �����Ϸ��� 2�� �Է��ϼ��� .");		
		}while(sc.nextInt()==1);
	}	
}
