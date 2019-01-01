package cn.wen.springbootDemo.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//@RestController 是spring4里的新注解，是@ResponseBody和@Controller的缩写
@RestController
public class HelloController {
	@RequestMapping("/hello")
	public String hello(){
		return "hello springboot";
	}
}
//