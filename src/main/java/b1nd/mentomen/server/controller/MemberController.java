package b1nd.mentomen.server.controller;

import b1nd.mentomen.server.domain.Member;
import b1nd.mentomen.server.dto.MemberForm;
import b1nd.mentomen.server.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/new")
    public ModelAndView creatForm(){
        return new ModelAndView("members/createMemberForm");
    }
    @PostMapping("/new")
    public ModelAndView create(MemberForm form){

        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);
        return new ModelAndView("index");
    }
    @GetMapping("/list")
    public ModelAndView list(){
        List<Member> members = memberService.findMember();
        ModelAndView modelAndView = new ModelAndView("members/memberList");
        modelAndView.addObject("members" , members);
        return modelAndView;
    }

}
