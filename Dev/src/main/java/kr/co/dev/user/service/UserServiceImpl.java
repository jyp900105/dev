package kr.co.dev.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import kr.co.dev.user.dao.UserDao;

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
			msg = "로그인에 성공했습니다.";
		} else {
			msg = "로그인에 실패했습니다.";
		}
		
		ModelAndView mv = new ModelAndView();
		
		mv.addObject("msg", msg);
		mv.setViewName("home");
		
		return mv;
	}

}
