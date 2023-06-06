package nguyen.vuong.controller;

import nguyen.vuong.model.Role;
import nguyen.vuong.model.RoleName;
import nguyen.vuong.model.User;
import nguyen.vuong.service.user.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import nguyen.vuong.service.role.IRoleService;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping(value = {"/"})
public class UserController {
    @Autowired
    private IRoleService roleService;
    @Autowired
    private IUserService userService;
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
    @GetMapping("/login")
    private String showFormLogin(Model model){
        model.addAttribute("user", new User());
        return "user/login-register";
    }
    @GetMapping("/login#cover")
    private String showFormRegister(Model model){
        model.addAttribute("user", new User());
        return "user/login-register";
    }
    @PostMapping("/create-user")
    private String actionCreateUser(@Validated @ModelAttribute("user") User user
            , BindingResult bindingResult, Model model){
        Set<Role> roleSet = new HashSet<>();
        roleSet.add(new Role(3, RoleName.USER));
        user.setRoleSet(roleSet);
        boolean existedEmail = userService.existedByEmail(user.getEmail());
        boolean hasError = bindingResult.hasFieldErrors();
        if (hasError || existedEmail){
            if (existedEmail)
                model.addAttribute("emailExisted", " ");
            return "user/login-register";
        }
        userService.save(user);
        return "redirect:/";
    }
}
