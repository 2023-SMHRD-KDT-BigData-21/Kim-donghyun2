package controller;


import model.UserDAO;
import model.UserVO;

public class joinController {
	public String joinCon(UserVO member) {


		UserDAO dao = new UserDAO();
		int row = dao.join(member);

		// 실행한 결과값 확인
		String result;
		if (row > 0) {
			result = "성공";
		} else {
			result = "실패";
		}
		return result;

	}
}
