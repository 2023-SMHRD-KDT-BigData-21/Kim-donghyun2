package view;

import java.util.Scanner;

import controller.joinController;
import controller.loginController;
import model.UserVO;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("====자바 랜드====");
		while (true) {
			System.out.println("[1]회원가입 [2]로그인 [3]게임 종료");
			System.out.print("메뉴를 선택하세요 : ");
			int menu = sc.nextInt();
			if (menu == 1) {
				joinController join = new joinController();
				System.out.println("====회원가입====");
				
				System.out.print("ID : ");
				String id = sc.next();
				System.out.print("Pw : ");
				String pw = sc.next();
				System.out.print("Name : ");
				String name = sc.next();
				System.out.print("Age : ");
				int age = sc.nextInt();
				double balance = 10000;

				String result = join.joinCon(new UserVO(id, pw, name, age, balance));
				// 초기자금은 임의 값을 넣음
				System.out.println("회원가입에 " + result + "하셨습니다.");

			} else if (menu == 2) {
				loginController con = new loginController();
				System.out.println("====로그인====");
				System.out.print("ID : ");
				String id = sc.next();
				System.out.print("PW : ");
				String pw = sc.next();
				
				UserVO user = new UserVO(id, pw);

				String name = con.login(user);

				if (name != null) {
					System.out.println(name + "님 로그인 성공하셧습니다. ");
				} else {
					System.out.println("아이디 비밀번호를 확인해주세요~");
				}


				while (true) {
					System.out.println("[1]입장 [2]게임 룰 설명 [3]메인으로");
					System.out.print("메뉴를 선택하세요 : ");
					int me = sc.nextInt();
					if (me == 1) {
						System.out.println("====게임 선택====");

					} else if (me == 2) {
						System.out.println("====룰 설명====");
					} else if (me == 3) {
						System.out.println("메인 페이지로 이동합니다.");
						break;
					} else {
						System.out.println("올바른 번호를 입력해주세요.");
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