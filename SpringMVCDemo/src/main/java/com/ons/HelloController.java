package com.ons;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloController {

	
	@RequestMapping("/hello")
	public String mymethod(Model model){
		model.addAttribute("msg", "Hello First Spring" );
		return "hellopage";
	}

	
	/*******Following are some different variations of same method call*****/
	
/*	@RequestMapping("/hello")
	public String mymethod(ModelMap model){
		model.addAttribute("msg", "Hello First Spring" );
		return "hellopage";
	}
	
	@RequestMapping("/hello")
	public ModelAndView mymethod(){
		return new ModelAndView("hellopage","msg","Hello First Spring");
	}*/
}
