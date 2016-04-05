/**
 * 
 */
package com.cat.spring.controller.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.cat.interceptor.MemberInterceptor;

/**
 * @author chenlf
 *
 * 2014-3-25
 */
@Controller
@RequestMapping(value="/member")
public class MemberController {

	@RequestMapping(value="/index",method=RequestMethod.GET)
	public ModelAndView index(HttpServletRequest request){
		ModelAndView view = new ModelAndView();
		HttpSession session = request.getSession();
		String username=(String) session.getAttribute(MemberInterceptor.SEESION_MEMBER);
		view.setViewName("/member/index");
		view.addObject("username", username);
		return view ;
	}
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public ModelAndView list(){
		return new ModelAndView("/member/list");
	}
}
