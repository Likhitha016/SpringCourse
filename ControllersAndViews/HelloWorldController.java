package SpringMVCBasics;

import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class HelloWorldController {
	@RequestMapping("/showform")
 public String showform()
 {
	 return "hello-world-form";
 }
	@RequestMapping("/processform")
  public String processform()
	{
		return "hello-world";
	}
	
	 }
