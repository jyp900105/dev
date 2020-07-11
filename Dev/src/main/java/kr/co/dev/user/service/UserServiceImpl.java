package kr.co.dev.user.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import kr.co.dev.user.dao.UserDao;
import kr.co.dev.user.dto.User;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	UserDao dao;

	@Override
	public ModelAndView regUser(String id, String password, String name, int age, String email, String address,
			String phone, String country) throws Exception {
		
		int result = dao.regUser(id, password, name, age, email, address, phone, country);
		
		String msg = "";
		
		if(result != 0) {
			msg = "회원가입에 성공했습니다.";
		} else {
			msg = "회원가입에 실패했습니다.";
		}
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("msg", msg);
		mv.setViewName("home");
		
		return mv;
	}

	@Override
	public ModelAndView login(String id, String password) throws ClassNotFoundException, SQLException {
		
		ModelAndView mv = new ModelAndView();
		
		User loginUserInfo = dao.login(id, password);
		
		if(loginUserInfo == null) {
			
			String msg = "로그인에 실패했습니다.";
			
			mv.addObject("msg", msg);
			mv.setViewName("home");
			
			return mv;
		} 
			
		String msg = "로그인에 성공했습니다.";
		mv.addObject("msg", msg);
		mv.addObject("loginUserInfo", loginUserInfo);
		mv.setViewName("redirect:/listPage");
		
		return mv;
	}

}
