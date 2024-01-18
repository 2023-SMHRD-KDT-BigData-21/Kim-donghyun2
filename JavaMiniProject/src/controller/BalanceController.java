package controller;

import model.UserDAO;
import model.UserVO;

public class BalanceController {
	public double getBalance(UserVO member) {
		
		UserDAO dao = new UserDAO();
		double bal = dao.Balance(member);
		return bal;
		
		
	}

}
