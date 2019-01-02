package cn.wen.springbootDemo.web;

import java.text.DateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.wen.springbootDemo.exception.MyException;

//根据application.properties 中的视图重定向，到/WEB-INF/jsp目录下去寻找hello.jsp文件
@Controller
public class HelloJspController {
  
    @RequestMapping("/helloJsp")
    public String hello(Model m) {
        m.addAttribute("now", DateFormat.getDateTimeInstance().format(new Date()));
        return "hello";
    }
    @RequestMapping("/exceptionTest")
    public String exceptionTest(Model m) throws Exception {
    	throw new Exception("some exception");
    }
    @RequestMapping("/myExceptionTest")
    public String myExceptionTest(Model m) throws Exception {
    	throw new MyException("101", "错误");
    }
}
//