package view;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("====자바 랜드====");
		while (true) {
			System.out.println("[1]회원가입 [2]로그인 [3]게임 종료");
			System.out.print("메뉴를 선택하세요 : ");
			int menu = sc.nextInt();
			if (menu == 1) {
				System.out.println("====회원가입====");

			} else if (menu == 2) {
				System.out.println("====로그인====");
				
				while (true) {
					System.out.println("[1]입장 [2]게임 룰 설명 [3]게임 종료");
					System.out.print("메뉴를 선택하세요 : ");
					int me = sc.nextInt();
					if (me == 1) {
						System.out.println("====게임 선택====");

					} else if (me == 2) {
						System.out.println("====룰 설명====");
					}
				}

			} else if (menu == 3) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("다시 입력해주세요");
			}

		}

	}

}
