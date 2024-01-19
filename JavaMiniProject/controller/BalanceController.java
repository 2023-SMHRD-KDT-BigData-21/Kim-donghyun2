package controller;

import model.UserDAO;
import model.UserVO;

public class BalanceController {
	public int getBalance(UserVO member) {
		
		UserDAO dao = new UserDAO();
		int bal = dao.Balance(member);
		return bal;
		
		
	}
	
	public String updateBalance(UserVO member) {
		UserDAO dao = new UserDAO();
		int row = dao.balanceUpdate(member);
		
		if(row>0)
			return "성공";
		else
			return "실패";
	}

}
