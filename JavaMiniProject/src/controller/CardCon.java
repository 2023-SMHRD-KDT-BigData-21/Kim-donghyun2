package controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class CardCon {

	public int cardResult(int bet) {

		SoundCon sc = new SoundCon();
		sc.playSound("src/audio/cardstart.wav", false);
		

		List<String> deck = new ArrayList<>();
		String[] suits = { "♠️", "♦️", "♥️", "♣️" };
		String[] ranks = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };

		for (String suit : suits) {
			for (String rank : ranks) {
				deck.add(suit + rank);
			}
		}

		Random ran = new Random();
		Scanner scanner = new Scanner(System.in);

		List<String> playerHand = new ArrayList<>();
		List<String> computerHand = new ArrayList<>();

		for (int i = 0; i < 2; i++) {
			playerHand.add(deck.remove(ran.nextInt(deck.size())));
			computerHand.add(deck.remove(ran.nextInt(deck.size())));
		}

		if (total(playerHand) > 21) { // 플레이어 패가 AA로 22넘는경우 확인
			System.out.println("플레이어의 카드의 총합이 21을 초과하여 패배하셨습니다.");
			System.out.println("Player: " + playerHand + " Total: " + total(playerHand));
			System.out.println("Computer: " + computerHand + " Total: " + total(computerHand));
			System.out.println("Winner : Computer");
			return bet;
		}
		if (total(computerHand) > 21) { // 컴퓨터 패가 AA로 22넘는경우 확인
			System.out.println("컴퓨터의 카드의 총합이 21을 초과하여 승리하셨습니다.");
			System.out.println("Player: " + playerHand + " Total: " + total(playerHand));
			System.out.println("Computer: " + computerHand + " Total: " + total(computerHand));
			System.out.println("Winner : Player");
			return bet * 2;
		}

		while (true) {// 게임 진행
			System.out.println("Player: " + playerHand + " Total: " + total(playerHand));

			String hiddenHand = "";
			for (int i = 0; i < computerHand.size(); i++) {
				hiddenHand += "?";
			}
			System.out.println("Computer: " + hiddenHand);

			System.out.println("카드를 한 장 더 받으시겠습니까? (y/n)"); // total 확인 후 카드 받을지 결정
			
			String input = scanner.nextLine().toLowerCase();

			if (input.equals("y")) { // 플레이어 카드 더 받음
				playerHand.add(deck.remove(ran.nextInt(deck.size())));
				sc.playSound("src/audio/cardPlace.wav", false);
			} else if (input.equals("n")) { // 플레이어 카드 받지 않음
				while (total(computerHand) <= 16) { // 컴퓨터 total이 16이하면 무한 추가 드로우
					computerHand.add(deck.remove(ran.nextInt(deck.size())));
					System.out.println("컴퓨터가 카드를 한 장 드로우 하였습니다.");
				}
				System.out.println("Final hands:");
				System.out.println("Player: " + playerHand + " Total: " + total(playerHand));
				System.out.println("Computer: " + computerHand + " Total: " + total(computerHand));
				break;
			} else {
				System.out.println("y 혹은 n 을 입력해주세요");
			}

			if (total(playerHand) > 21) { // 플레이어가 카드를 추가로 뽑다가 21초과하면 패배
				System.out.println("카드의 총합이 21을 초과하여 패배하셨습니다.");
				System.out.println("Player: " + playerHand + " Total: " + total(playerHand));
				System.out.println("Computer: " + computerHand + " Total: " + total(computerHand));
				System.out.println("Winner : Computer");
				return bet;
			}
			if (total(computerHand) > 21) { // 컴퓨터가 카드를 추가로 뽑다가 21초과하면 패배
				System.out.println("컴퓨터의 총합이 21을 초과하여 승리하셨습니다.");
				System.out.println("Player: " + playerHand + " Total: " + total(playerHand));
				System.out.println("Computer: " + computerHand + " Total: " + total(computerHand));
				System.out.println("Winner : Player");
				return bet * 2;
			}
		}
		String winner = determineWinner(playerHand, computerHand); // 승자 출력
		System.out.println("Winner: " + winner);
		if (winner.equals("Player")) {
			return bet * 2;
		} else if (winner.equals("Nobody")) { // 동점일 경우 무승부 출력
			System.out.println("플레이어와 컴퓨터의 점수가 같습니다.");

			return bet - 1;
		} else {
			return bet;
		}

	}

	// 패에 들어가는 카드 숫자 계산 메소드
	private static int total(List<String> hand) {
		int total = 0;

		for (String card : hand) {
			String rank = card.substring(card.length() - 1);
			if (rank.equals("A")) {
				total += 11;
			} else if (rank.equals("K") || rank.equals("Q") || rank.equals("J")) {
				total += 10;
			} else if (rank.equals("0")) {
				total += 10;
			} else {
				total += Integer.parseInt(rank);
			}
		}
		return total;
	}

	// 승패 계산 메소드
	private static String determineWinner(List<String> playerHand, List<String> computerHand) {
		int playerTotal = total(playerHand);
		int computerTotal = total(computerHand);

		if (playerTotal > 21 && computerTotal <= 21) {
			return "Computer";
		} else if (computerTotal > 21 && playerTotal <= 21) {
			return "Player";
		} else if (playerTotal == computerTotal) {
			return "Nobody";
		} else {
			return (playerTotal > computerTotal) ? "Player" : "Computer";
		}
	}
}