package model;

public class UserVO {

	private String id;
	private String pw;
	private String name;
	private int age;

	private double bet;
	private double balance;

	public UserVO(String id, String pw, String name, int age, double balance) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
		this.balance = balance;
	}

	public UserVO(double bet, double balance) {
		this.bet = bet;
		this.balance = balance;
	}

	public UserVO(String id, String pw) {
		this.id = id;
		this.pw = pw;
	}

	public UserVO(String id) {
		this.id = id;
	}

	public String getId() {
		return id;
	}

	public String getPw() {
		return pw;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public double getBalance() {
		return balance;
	}

	public double getBet() {
		return bet;
	}

}