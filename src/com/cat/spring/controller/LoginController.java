/**
 * 
 */
package com.cat.spring.controller;

import java.net.URLDecoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cat.interceptor.MemberInterceptor;

/**
 * @author chenlf
 * 
 *         2014-3-24
 */
@Controller
public class LoginController {

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(String redirectURL, HttpServletRequest request) {
		ModelAndView view = new ModelAndView();
		//把拦截前路径存下来，以便登入成功可以直接请求到登录前的页面
		view.addObject("redirectURL", redirectURL);
		view.setViewName("/login");
		return view;
	}

	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String submit(String username, String password, String redirectURL,
			HttpServletRequest request) {
		//模拟登陆成功 用户admin 密码admin的用户
		if (StringUtils.isNotBlank(username) && StringUtils.isNotBlank(password)
				&& username.equals("admin") && password.equals("admin")) {
			//当登陆成功是，将用户信息存放到session中去
			HttpSession session = request.getSession();
			session.setAttribute(MemberInterceptor.SEESION_MEMBER, "admin");
			if (StringUtils.isNotBlank(redirectURL)) {
				return "redirect:" + URLDecoder.decode(redirectURL);
			}
			return "redirect:/member/index.htm";
		} else {
			if (StringUtils.isNotBlank(redirectURL)) {
				return "redirect:/login.htm?" + URLDecoder.decode(redirectURL);
			}
			return "redirect:/login.htm";
		}
	}
}
