package neusoft.controller;

import neusoft.pojo.Blogger;
import neusoft.service.BloggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/blogger")
public class BloggerController {
    @Autowired
    private BloggerService bloggerService;

    //@PostMapping("/login")http://localhost:8080/ssm-02/blogger/login
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(String name, String password, Model model, HttpSession session) {
        System.out.println("login:::name:::" + name + ", password:::" + password);
        Blogger bean = bloggerService.login(name, password);
        if (bean != null && bean.getId() == 1) {
            //登录成功
            //session保存
            session.setAttribute("loginBlogger", bean);
            //记住密码，使用Cookie
            return "forward:../admin/main.jsp";
        }
        else if (bean != null){
            session.setAttribute("loginBlogger", bean);
            return "forward:../mainTemp.jsp";
        }
        else {
            //登录失败
            model.addAttribute("msg", "用户名或密码错误");
            //return "forward:login.jsp";//http://localhost:8080/ssm-02/blogger/login.jsp
            return "forward:../login.jsp";
        }
    }

    @PostMapping("/reg")
    public String reg(@Valid Blogger bean, BindingResult br, String cfmpassword, Model model) {
        System.out.println("reg:::" + bean);
        System.out.println("reg:::" + cfmpassword);
        //判断两次密码是否一致
        if(!bean.getPassword().equals(cfmpassword)) {
            model.addAttribute("msg", "两次输入密码不一致");
            return "forward:../register.jsp";
        }
        //数据较验
        if(br.hasErrors()) {
            Map<String, String> errors = new HashMap<String, String>();
            System.out.println("==============================表单数据出错=================================");
            List<FieldError> fieldErrors = br.getFieldErrors();
            for (FieldError item : fieldErrors) {
                System.out.println(item.getField());
                System.out.println(item.getDefaultMessage());
                errors.put(item.getField(), item.getDefaultMessage());
            }
            model.addAttribute("errors", errors);
            return "forward:../register.jsp";
        }

        //判断用户名重复
        if (bloggerService.getByName(bean.getName()) != null) {
            model.addAttribute("msg", "该用户名已经被使用");
            return "forward:../register.jsp";
        }

        boolean result = bloggerService.insert(bean);
        if (result) {
            System.out.println("注册成功");
            return "forward:../login.jsp";
        }
        System.out.println("注册失败");
        model.addAttribute("msg", "注册失败");
        return "forward:../register.jsp";
    }


    /**
     * 查找博主信息
     * @return
     * @throws Exception
     */
    @RequestMapping("/aboutMe")
    public ModelAndView aboutMe(int id)throws Exception{
        ModelAndView mav=new ModelAndView();
        mav.addObject("blogger",bloggerService.getById(id));
        mav.addObject("mainPage", "../foreground/blogger/info.jsp");
        mav.addObject("pageTitle","关于博主");
        mav.setViewName("mainTemp");
        return mav;
    }
}
