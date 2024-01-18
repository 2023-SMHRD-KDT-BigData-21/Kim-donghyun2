package controller;

import java.util.ArrayList;


import model.UserDAO;
import model.UserVO;

public class RankingCon {
	ArrayList<UserVO> list= new UserDAO().getRankingList();
	public ArrayList<UserVO> musicList(){
		return list;
	}
}
