package com.example.api.controller;

import com.example.api.error.errorCode.MemberErrorCode;
import com.example.api.error.exception.MemberException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.Base64;

@Controller
@RequestMapping("/main")
public class LoginController {
/*
    private Facebook facebook;
    private ConnectionRepository connectionRepository;

    @Inject
    public LoginController(Facebook facebook, ConnectionRepository connectionRepository) {
        this.facebook = facebook;
        this.connectionRepository = connectionRepository;
    }*/


    @GetMapping
    public String getMainPage(Principal principal) {
        return "main";
    }

    @GetMapping("/admin")
    public String getAdminPage() {
        return "admin";
    }

    @GetMapping("/writer")
    public String getWriterPage() {
        return "writer";
    }

    @GetMapping("/social_login")
    public String login() {
        return "social_login";
    }

    @GetMapping("/error")
    public String memberError() {

        if (1 == 1)
            throw new MemberException(MemberErrorCode.NOT_FOUND_MEMBER);
        return "writer";
    }

/*
    @GetMapping("/facebook/login")
    public String login1() {
        return "connect/facebookConnect";
    }


    @GetMapping("/facebook")
    public ModelAndView facebookController() {
        ModelAndView model = new ModelAndView();
        if (connectionRepository.findPrimaryConnection(Facebook.class) != null) {
            model.addObject("pic",Base64.getEncoder().encodeToString(facebook.userOperations().getUserProfileImage()));
            model.addObject("facebookProfile", facebook.userOperations().getUserProfile());
        }
        model.setViewName("connect/facebookProfile");
        return model;
    }
*/

}
