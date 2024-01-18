package view;

import java.util.Scanner;

import controller.BalanceController;
import controller.SlotCon;
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
								System.out.println("[1]슬롯게임 [2]카드게임 [3]잔액확인 [4]뒤로가기");
								System.out.print("메뉴를 선택하세요 : ");
								int menu3 = sc.nextInt();
								if (menu3 == 1) {
									//배팅금액 입력받은걸 매개변수로 slotcon에서 사용
									//slotcon의 slotresult는 배팅성공금액을 리턴해서 
									//데베의 balance를 업데이트 (차감/증가)
									//bal 불러와서 bet값만큼 차감 후 업데이트;
									//실패시 bal-bet 업데이트
									//만약 성공하면 bet * 배당만큼해서 한번 더 업데이트
									System.out.println("====슬롯게임====");
									BalanceController bc = new BalanceController();
									UserVO uv = new UserVO(id);
									int bal = bc.getBalance(uv);
									System.out.println(name + "님의 최대배팅 가능 금액은" + bal +" 원입니다.");
									System.out.println("배팅할 금액을 입력해주세요: ");
									int bet = sc.nextInt();
									if(bal < bet) {
										System.out.println("잔액이 부족합니다.");
									}else {
										SlotCon slc = new SlotCon();
										int betresult = slc.slotResult(bet);
										System.out.println(betresult + "원");
										if(betresult == bet) {
											int resultFail = bal - bet;
											UserVO betFail = new UserVO(id,resultFail);
											bc.updateBalance(betFail);
											
										}else {
											int resultSuccess = bal - bet + betresult;
											UserVO betSuc = new UserVO(id, resultSuccess);
											bc.updateBalance(betSuc);
										}
										
										
									}
									
									
									
									
								} else if (menu3 == 2) {
									System.out.println("====카드게임====");
									
								} else if (menu3 == 3) {
									System.out.println("====잔액확인====");
									BalanceController bc = new BalanceController();
									UserVO uv = new UserVO(id);
									int bal = bc.getBalance(uv);
									
									System.out.println(name + "님의 잔액은 : " + bal + "원입니다.");
									
								} else if (menu3 == 4) {
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