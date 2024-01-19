package controller;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SlotCon {

	public int slotResult(int bet) {
		Random ran = new Random();
		int[][] slot = new int[3][5];
		int count = 1;
		double rateV = 25.0;
		double rateW = 23.5;
		double rateM = 23.5;
		double rateA = 77.7;
		double rateI = 5.5;

		for (int i = 0; i < slot.length; i++) {
			for (int j = 0; j < slot[i].length; j++) {
				slot[i][j] = ran.nextInt(1, 8);
			}
		}

		for (int i = 0; i < slot.length; i++) {
			System.out.println("=====================");
			for (int j = 0; j < slot[i].length; j++) {

				System.out.print("| " + slot[i][j] + " ");
			}
			System.out.print("| ");
			System.out.println();
		}
		System.out.println("=====================");

		int v = 0;
		int w = 0;
		int m = 0;
		int a = 0;
		int l = 0;
		// 당첨경우의수1번째 배당 1.3배
		// l모양
		if ((slot[0][0] == slot[1][0]) && (slot[0][0] == slot[2][0])) {
			l++;
			bet *= rateI;
		}
		if ((slot[0][1] == slot[1][1]) && (slot[0][1] == slot[2][1])) {
			l++;
			bet *= rateI;
		}
		if ((slot[0][2] == slot[1][2]) && (slot[0][2] == slot[2][2])) {
			l++;
			bet *= rateI;
		}
		if ((slot[0][3] == slot[1][3]) && (slot[0][3] == slot[2][3])) {
			l++;
			bet *= rateI;
		}
		if ((slot[0][4] == slot[1][4]) && (slot[0][4] == slot[2][4])) {
			l++;
			bet *= rateI;
		}
		// ㅡ모양
		if ((slot[0][0] == slot[0][1]) && (slot[0][0] == slot[0][2]) && (slot[0][0] == slot[0][3])
				&& (slot[0][0] == slot[0][4])) {
			a++;
			bet *= rateA;
		}
		if ((slot[1][0] == slot[1][1]) && (slot[1][0] == slot[1][2]) && (slot[1][0] == slot[1][3])
				&& (slot[1][0] == slot[1][4])) {
			a++;
			bet *= rateA;
		}
		if ((slot[2][0] == slot[2][1]) && (slot[2][0] == slot[2][2]) && (slot[2][0] == slot[2][3])
				&& (slot[2][0] == slot[2][4])) {
			a++;
			bet *= rateA;
		}
		// v모양
		if ((slot[0][0] == slot[1][1]) && (slot[0][0] == slot[2][2]) && (slot[0][0] == slot[1][3])
				&& (slot[0][0] == slot[0][4])) {
			v++;
			bet *= rateV;
		}
		if ((slot[2][0] == slot[1][1]) && (slot[2][0] == slot[0][2]) && (slot[2][0] == slot[1][3])
				&& (slot[2][0] == slot[2][4])) {
			v++;
			bet *= rateV;
		}
		// m모양
		if ((slot[1][0] == slot[0][1]) && (slot[1][0] == slot[1][2]) && (slot[1][0] == slot[0][3])
				&& (slot[1][0] == slot[1][4])) {
			m++;
			bet *= rateM;
		}
		if ((slot[2][0] == slot[1][1]) && (slot[2][0] == slot[2][2]) && (slot[2][0] == slot[1][3])
				&& (slot[2][0] == slot[2][4])) {
			m++;
			bet *= rateM;
		}
		// w모양
		if ((slot[0][0] == slot[1][1]) && (slot[0][0] == slot[0][2]) && (slot[0][0] == slot[1][3])
				&& (slot[0][0] == slot[0][4])) {
			w++;
			bet *= rateW;
		}
		if ((slot[1][0] == slot[2][1]) && (slot[1][0] == slot[1][2]) && (slot[1][0] == slot[2][3])
				&& (slot[1][0] == slot[1][4])) {
			w++;
			bet *= rateW;
		}

		if (v > 0 || w > 0 || m > 0 || a > 0 || l > 0) {
			System.out.println("당첨입니다.");
			System.out.println("V당첨 횟수 : " + v);
			System.out.println("M당첨 횟수 : " + m);
			System.out.println("W당첨 횟수 : " + w);
			System.out.println("ㅡ당첨 횟수 : " + a);
			System.out.println("l당첨 횟수 : " + l);
		} else {
			System.out.println("실패!");
		}
		
		  try {

			  SoundCon sc = new SoundCon();
	            sc.playSound("bgm/[Track 01] Casino Sound Effect.wav", false);
	            // 2초 딜레이
	            TimeUnit.SECONDS.sleep(2);
	    		sc.playSound("src/audio/금전등록기.wav", false);

	            // delay 0.5 second
	            //TimeUnit.MICROSECONDS.sleep(500);

				// delay 1 minute
	            //TimeUnit.MINUTES.sleep(1);
				
	        } catch (InterruptedException e) {
	            System.err.format("IOException: %s%n", e);
	        }
		
		return bet;
	}

}
