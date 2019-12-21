
public class RandomNumber {
	private int number;
	
	RandomNumber(){
		this.number = ((int)(Math.random()*9)+1)*100
				+((int)(Math.random()*9)+1)*10
				+((int)(Math.random()*9)+1);
//		System.out.println("»ÌÀº ¼ıÀÚ ="+number);
	}
	
	int getNumber() {
		return this.number;
	}
	
}
