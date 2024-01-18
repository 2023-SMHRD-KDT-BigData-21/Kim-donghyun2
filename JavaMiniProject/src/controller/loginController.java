package controller;

import model.UserDAO;
import model.UserVO;

public class loginController {

	public String login(UserVO member) {
		// View에서 입력한 사용자 데이터 확인		
		System.out.println("입력한 ID : " + member.getId());
		System.out.println("입력한 PW : " + member.getPw());
		
		UserDAO dao = new UserDAO();
		String name = dao.login(member);
		return name;
	}
}
