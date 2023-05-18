package com.softusing.BaiYunXiao.controller;

import com.softusing.BaiYunXiao.entity.User;
import com.softusing.BaiYunXiao.form.UserForm;
import com.softusing.BaiYunXiao.mapperIterfac.UserServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
public class LoginController {
    @Autowired
    private UserServiceInterface userServiceInterface;


    @GetMapping("/register")
    public String registerPage(Model model) {
        model.addAttribute("userForm",new UserForm());
        return "register";
    }

    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }

    @PostMapping("/register")
    public String register(@Valid UserForm userForm, BindingResult result) {
        if (!userForm.confirmPassword()){
            result.rejectValue("confirmPassword", "confirmError","两次密码不一致");
        }
        if (result.hasErrors()){
            return "register";
        }
//        boolean boo = true;
//        if (!userForm.confirmPassword()) {
//            result.rejectValue("confirmPassword", "两次密码不一致", "confirmError");
//            boo = false;
//        }
//        if (result.hasErrors()) {
//            List<FieldError> fieldErrors = result.getFieldErrors();
//            for (FieldError error : fieldErrors) {
//                System.out.println(error.getField() + " : " + error.getDefaultMessage() + " : " + error.getCode());
//            }
//            boo = false;
//        }
//        if (!boo) {
//            return "register";
//        }
        User user = userForm.convertToUser();
        userServiceInterface.save(user);
        return "redirect:/login";
    }
    @GetMapping("/exception")
    public String exception(){
        throw new RuntimeException();
    }
}
