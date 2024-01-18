package view;

import java.util.ArrayList;
import java.util.Scanner;

import controller.BalanceController;
import controller.RankingCon;
import controller.joinController;
import controller.loginController;
import model.UserVO;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("====메인 메뉴====");
		while (true) {
			System.out.println("[1]회원가입 [2]로그인 [3]게임 종료");
			System.out.print("메뉴를 선택하세요 : ");
			int menu1 = sc.nextInt();
			if (menu1 == 1) {
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
				int balance = 10000;

				String result = join.joinCon(new UserVO(id, pw, name, age, balance));
				// 초기자금은 임의 값을 넣음
				System.out.println("회원가입에 " + result + "하셨습니다.");

			} else if (menu1 == 2) {
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
					
					while (true) {
						System.out.println("===== 자 바 랜 드 =====");
						System.out.println("[1]입장 [2]게임 룰 설명 [3]메인으로");
						System.out.print("메뉴를 선택하세요 : ");
						int menu2 = sc.nextInt();
						if (menu2 == 1) { // 게임선택으로 이동
							while (true) {
								System.out.println("====게임 선택====");
								System.out.println("[1]슬롯게임 [2]카드게임 [3]잔액확인 [4]랭킹확인 [5]뒤로가기");
								System.out.print("메뉴를 선택하세요 : ");
								int menu3 = sc.nextInt();
								if (menu3 == 1) {
									System.out.println("====슬롯게임====");
									
								} else if (menu3 == 2) {
									System.out.println("====카드게임====");
									
								} else if (menu3 == 3) {
									System.out.println("====잔액확인====");
									BalanceController bc = new BalanceController();
									UserVO uv = new UserVO(id);
									int bal = bc.getBalance(uv);
									
									System.out.println("잔액은 : " + bal + "원입니다.");
									
								}else if(menu3 == 4) {
									RankingCon rc = new RankingCon();
									System.out.println("====랭킹확인====");
									ArrayList<UserVO> list = rc.musicList();
									int ranking =1;
									System.out.println("== Play List ==");
									for (UserVO ranker:list) {
											
										System.out.print(ranking+"위. 닉네임: "+ranker.getName());
										System.out.println(" 자산 : "+ranker.getBalance()+"원");
										ranking++;
									}
								}
								else if (menu3 == 5) {
									break;
								} else {
									System.out.println("올바른 번호를 입력해주세요.");
								}
							}
							
						} else if (menu2 == 2) {
							System.out.println("====룰 설명====");
						} else if (menu2 == 3) {
							System.out.println("메인 페이지로 이동합니다.");
							break;
						} else {
							System.out.println("올바른 번호를 입력해주세요.");
						}
					}
					
				} else { // 로그인 실패시 else문
					System.out.println("아이디 비밀번호를 확인해주세요.");
				}

			} else if (menu1 == 3) {
				System.out.println("프로그램을 종료합니다.");
				break;
			} else {
				System.out.println("올바른 번호를 입력해주세요.");
			}

		}

	}
}