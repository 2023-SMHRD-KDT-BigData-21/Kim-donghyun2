package controller;

import model.UserVO;

public class Controller {

	public String login(UserVO user) {
		System.out.println("입력한 ID : " + user.getId());
		System.out.println("입력한 PW : " + user.getPw());
		
		
		
		return null ;
	}
}
