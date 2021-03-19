package com.iu.s1.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MemberController {
	
	@Autowired
	private MemberService memberService;
	
	
	// memberJoin  //   /member/memberJoin GET
	@RequestMapping(value = "/member/memberJoin")
	public String memberJoin() {
		return "member/memberJoin";
	}
	
	// memberJoin2 //	/member/memberJoin POST
	@RequestMapping(value = "/member/memberJoin", method = RequestMethod.POST)
	public void memberJoin2(String id, String pw, String name, String email, String phone)throws Exception{
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(id);
		memberDTO.setPw(pw);
		memberDTO.setName(name);
		memberDTO.setPhone(phone);
		memberDTO.setEmail(email);
		int result = memberService.memberJoin(memberDTO);
		
		System.out.println(result);
	}
	
	//똑같은 이름으로 메서드를 만들수 없어서 1,2로 나눔 // 상속받은 매서드를 재정의 : 오버라이딩, 같은 이름을 메서드 여러개 : 오버로딩,
	//오버로딩 적용!!
	
	//memberLogin print   //  /member/memberLogin
	@RequestMapping(value = "/member/memberLogin")
	public String memberLogin() { 
		//String name = request.getParameter("name");
		//int age = Integer.parseInt(request.getParameter("age"));
		//System.out.println(name);
		//System.out.println(age);
		System.out.println("login-------");
		// /WEB-INF/views/member/memberLogin.jsp
		return "member/memberLogin";
	}
	
	//memberLogin2 print
		@RequestMapping(value = "/member/memberLogin", method = RequestMethod.POST)
		public ModelAndView memberLogin2(MemberDTO memberDTO, ModelAndView modelAndView) throws Exception {
			ModelAndView modelAndView2 = new ModelAndView();
		
		memberDTO = memberService.memberLogin(memberDTO);
		
		modelAndView.addObject("dto", memberDTO);
		modelAndView.setViewName("member/memberPage");
		
		return modelAndView;
	}

}