package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
    //GetMapping은 GetPost와 같음
    @GetMapping("hello") //웹앱에서 /hello로 들어오면 아래 메서드 호출
    public String hello(Model model){
        model.addAttribute("data","테스트"); //key,value
        return "hello";
    }
}
