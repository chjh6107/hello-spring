package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired //생성자를 스프링 컨테이너에 등록된 인스턴스와 연결시켜줌
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
