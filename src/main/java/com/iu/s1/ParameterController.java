package com.iu.s1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ParameterController {
	
	@RequestMapping(value = "/param/param1")
	public String paramTest() {
		return "param/param1";
	}
	@RequestMapping(value = "/param/param1", method = RequestMethod.POST)
	public void paramTest2(@RequestParam(defaultValue = "100") int p, String p2, String p3, String p4,String p5, String [] p6) {
		
		System.out.println(p);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println(p4);
		
		System.out.println(p5);
		//같은 파라미터 이름으로 value가 여러개 일때는 배열로 선언
		for(int i=0;i<p6.length;i++) {
			System.out.println(p6[i]);
		}
		
		
	}

}