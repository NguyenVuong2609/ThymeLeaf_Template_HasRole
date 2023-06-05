package nguyen.vuong.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import nguyen.vuong.service.IRoleService;

@Controller
@RequestMapping(value = {"/"})
public class UserController {
    @Autowired
    private IRoleService roleService;
    @GetMapping
    private ModelAndView showHomePage(){
        roleService.setDefaultRoleName();
        ModelAndView modelAndView = new ModelAndView("index");
        return modelAndView;
    }
    @GetMapping("*")
    private String showError404(){
        return "error.404";
    }
}
