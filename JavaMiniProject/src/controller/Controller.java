package controller;

import model.UserDAO;
import model.UserVO;

public class Controller {

	public String login(UserVO user) {
		// View에서 입력한 사용자 데이터 확인		
		System.out.println("입력한 ID : " + user.getId());
		System.out.println("입력한 PW : " + user.getPw());
		
		UserDAO dao = new UserDAO();
		String name = dao.login(user);
		return name;
	}
}
