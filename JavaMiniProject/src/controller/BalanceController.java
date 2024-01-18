package controller;

import model.UserDAO;
import model.UserVO;

public class BalanceController {
	public int getBalance(UserVO member) {
		
		UserDAO dao = new UserDAO();
		int bal = dao.Balance(member);
		return bal;
		
		
	}

}
