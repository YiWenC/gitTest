package cn.wen.springbootDemo.web;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import cn.wen.springbootDemo.exception.MyException;
/**
 * 启动应用后，被 @ExceptionHandler、@InitBinder、@ModelAttribute 注解的方法，都会作用在 被 @RequestMapping 注解的方法上。
 * @ModelAttribute：在Model上设置的值，对于所有被 @RequestMapping 注解的方法中，都可以通过 ModelMap获取或者 通过@ModelAttribute获取
 * @ExceptionHandler 拦截了异常，我们可以通过该注解实现自定义异常处理。
 * 其中，@ExceptionHandler 配置的 value 指定需要拦截的异常类型
 */
@ControllerAdvice
public class MyControllerAdvice {
	/**
     * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
     * @param binder
     */
    @InitBinder
    public void initBinder(WebDataBinder binder) {}

    /**
     * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
     * @param model
     */
    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("author", "WEN");
    }

    /**
     * 全局异常捕捉处理,拦截了 Exception.class 这种异常,返回JSON数据
     * @param ex
     * @return
     */
    @ResponseBody
    @ExceptionHandler(value = Exception.class)
    public Map errorHandler(Exception ex) {
        Map map = new HashMap();
        map.put("code", 100);
        map.put("msg", ex.getMessage());
        return map;
    }
    /**
     * 拦截捕捉自定义异常 MyException.class，返回页面
     * @param ex
     * @return
     */
    
    @ExceptionHandler(value = MyException.class)
    public ModelAndView myErrorHandler(MyException ex,HttpServletRequest req) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("errorPage");
        modelAndView.addObject("code", ex.getCode());
        modelAndView.addObject("msg", ex.getMsg());
        modelAndView.addObject("exception", ex);
        modelAndView.addObject("url", req.getRequestURL());
        return modelAndView;
    }
}
