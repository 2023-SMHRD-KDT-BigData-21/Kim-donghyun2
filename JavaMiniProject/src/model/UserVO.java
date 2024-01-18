package model;

public class UserVO {

	private String id;
	private String pw;
	private String name;
	private int age;
	private int balance;

	public UserVO(String id, String pw, String name, int age, int balance) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.age = age;
		this.balance = balance;
	}

	public UserVO(String id, int balance) {
		this.id = id;
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

	public int getBalance() {
		return balance;
	}


}