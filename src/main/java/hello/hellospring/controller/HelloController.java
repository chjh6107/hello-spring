package hello.hellospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {
    //GetMapping은 GetPost와 같음
    @GetMapping("hello") //웹앱에서 /hello로 들어오면 아래 메서드 호출
    public String hello(Model model){
        model.addAttribute("data","헬로헬로"); //key,value
        return "hello";
    }
    @GetMapping("hello-mvc")
    //RequestParam으로 외부 파라미터 받아옴
    //이친구를 쓰려면 주소 /hello-mvc/{name={내용}} 을 집어넣어야함
    public String helloMvc(@RequestParam("name") String name, Model model){
        model.addAttribute("name",name);
        return "hello-template";
    }
}
