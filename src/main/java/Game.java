package main.java;

import java.util.Random;
import java.util.Scanner;

public class Game {
	
	public void run() {
		
		int Com[] = new int[3];
		int Ply[] = new int[3];
		
		int strike = 0;
		int ball = 0;
		boolean check = true;
		
		int replay = 0;
		int num=0;
		
		for(int i=0; i<Com.length; i++) {
			Com[i] = (int)(Math.random()*9)+1;
			
			for(int j=0; j<i; j++) {
				if(Com[j]==Com[i]) {
					i--;
					break;
				} //중복확인
					
			}
		}
		
		Scanner scan = new Scanner(System.in);
		
		
		while(check) {
			System.out.print("숫자를 입력해주세요:");
			
			for(int i=0; i<Ply.length; i++) {
				num=scan.nextInt();

				Ply[i]=num;
				
				
				if(num<=0 || num>9) {
					System.out.println("1~9의 숫자를 입력하세요. ");
					
				} //범위확인
				
			}
			
			for(int i=0; i<Com.length; i++) {
				for(int j=0; j<Ply.length; j++) {
					if(Com[i]==Ply[j] && i==j) {
						strike++;
					}
					else if(Com[i]==Ply[j] && i!=j) {
						ball++;
					}
				}
				
			} //Computer와 Player 비교
			
			if(strike==3) {
				check=false;
				break;
			}
			
			System.out.println(strike+"스트라이크 "+ball+"볼");
			
			strike = 0;
			ball = 0; //초기화
			
		}
		
		System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
		System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
		replay=scan.nextInt();
		if(replay==1) { //재시작
			check=true;
			run();
		}else if(replay==2) { //게임종료
			scan.close();
			
		}
	}

	
}
