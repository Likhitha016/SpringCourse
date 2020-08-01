package SpringMVCBasics;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class ControllerDemo {
	@RequestMapping("/")
	public String get()
	{
		return "main-menu";
	}

}