package com.springbook.view.user;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.springbook.biz.user.UserVO;
import com.springbook.biz.user.impl.UserDAO;

@Controller
public class LoginController {

	@RequestMapping(value="/login.do", method = RequestMethod.GET)
	public String loginView(UserVO vo) {
		System.out.println("page moving...login screen");
		vo.setId("test");
		vo.setPassword("test123");
		return "login";
	}

	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public String login(UserVO vo, UserDAO userDAO, HttpSession session) {
		if(vo.getId() == null || vo.getId().equals("")) {
			throw new IllegalArgumentException("아이디는 반드시 입력해야 합니다.");
		}
		UserVO user = userDAO.getUser(vo);
		System.out.println("login confirm process...");
		if(userDAO.getUser(vo) != null){
			session.setAttribute("userName", user.getName());
			return "redirect:boardList.do";
		} else return "login";
	}
}