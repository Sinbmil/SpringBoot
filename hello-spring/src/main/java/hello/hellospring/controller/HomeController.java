package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    // 스프링 컨테이너 안에서 관련 컨트롤러 찾기, resource에서 html파일 찾기
    @GetMapping("/")
    public String home(){
        return "home";
    }
}
