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
				} //�ߺ�Ȯ��
					
			}
		}
		
		Scanner scan = new Scanner(System.in);
		
		
		while(check) {
			System.out.print("���ڸ� �Է����ּ���:");
			
			for(int i=0; i<Ply.length; i++) {
				num=scan.nextInt();

				Ply[i]=num;
				
				
				if(num<=0 || num>9) {
					System.out.println("1~9�� ���ڸ� �Է��ϼ���. ");
					
				} //����Ȯ��
				
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
				
			} //Computer�� Player ��
			
			if(strike==3) {
				check=false;
				break;
			}
			
			System.out.println(strike+"��Ʈ����ũ "+ball+"��");
			
			strike = 0;
			ball = 0; //�ʱ�ȭ
			
		}
		
		System.out.println("3���� ���ڸ� ��� �����̽��ϴ�! ���� ����");
		System.out.println("������ ���� �����Ϸ��� 1, �����Ϸ��� 2�� �Է��ϼ���.");
		replay=scan.nextInt();
		if(replay==1) { //�����
			check=true;
			run();
		}else if(replay==2) { //��������
			scan.close();
			
		}
	}

	
}
