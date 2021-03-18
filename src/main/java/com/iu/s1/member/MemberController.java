package com.iu.s1.member;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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
	public void memberLogin2(HttpServletRequest request) throws Exception {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(id);
		memberDTO.setPw(pw);
		memberDTO = memberService.memberLogin(memberDTO);
		
		System.out.println(memberDTO);
		
	}

}