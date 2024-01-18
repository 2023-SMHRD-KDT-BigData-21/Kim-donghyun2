package controller;

public class RuleCon {
	public void cardrule() {
	      System.out.println("1. 게임시작 시 플레이어에게는  2장의 카드가 랜덤으로 주어집니다");
	      System.out.println("2. 랜덤으로 지급되는 카드는 2~11까지의 숫자입니다");
	      System.out.println("3. K·Q·J은 10점으로 계산하며 그밖에카드는 9 이하의 카드는 그 숫자대로 점수를 센다.");
	      System.out.println("4. A은 11점으로 계산합니다.");
	      System.out.println("5. 카드숫자를 확인한 후 추가로 더 받을지 Stop할지 플레이어의 몫입니다 ");
	      System.out.println("6. 인공지능은 합이 (16)이하 이면 카드한장을 받고 (17)이상이면 카드를 받지않습니다.  ");
	      System.out.println("7. 플레이어와 인공지능에 순서가 다 끝난 후 게임이 종료됩니다");
	      System.out.println("8. 카드숫자의 합이 (21)의 더 가까운 플레이어가 이기게 됩니다 ");
	      System.out.println("9. 플레이어와 인공지능의 총 합이 같을 시 무승부처리가 됩니다");
	      System.out.println("10. 단 총 합이 (21)을 넘을 시 (0)점으로 간주되어 자동으로 패배하게 됩니다");

	   }
	public void slotrule() {
		System.out.println("1. money 투입: 슬롯머신에 투입하여 게임을 시작합니다.");
		System.out.println("2. 베팅: 플레이어는 베팅 금액을 선택해야 합니다.");
		System.out.println("3. 스핀 버튼: 베팅을 완료한 후 스핀 버튼을 눌러 슬롯머신을 작동시킵니다.");
		System.out.println("4. 페이라인: 슬롯머신에는 V, M, W, l 의 페이라인이 있습니다.");
		System.out.println("5. 슬롯머신은 5 페이라인 으로 만들어졌습니다.");
	}
}
