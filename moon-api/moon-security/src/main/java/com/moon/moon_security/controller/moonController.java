package com.moon.moon_security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.view.RedirectView;

/**
 * @ClassName moonController
 * @Description: TODO
 * @Author zyl
 * @Date 2020/11/26
 * @Version V1.0
 **/
@RestController
@Slf4j
public class moonController {

    @GetMapping("/moon")
    public  void  moon () {
        log.info("moon");
    }

    @GetMapping("/moonz")
    public  void  moonz () {
        log.info("moonz");
    }

    @GetMapping("/moony")
    public  void  moony () {
        log.info("moony");
    }

    @GetMapping("/login")
    public RedirectView login () {
       return new RedirectView("/login.html");
    }
}
