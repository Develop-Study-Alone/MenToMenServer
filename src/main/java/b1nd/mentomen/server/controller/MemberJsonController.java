package b1nd.mentomen.server.controller;

import b1nd.mentomen.server.domain.Member;
import b1nd.mentomen.server.dto.MemberForm;
import b1nd.mentomen.server.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/member-json")
@RequiredArgsConstructor
public class MemberJsonController {

    private final MemberService memberService;

    @PostMapping("/new")
    public Member create(@RequestBody MemberForm form){

        Member member = new Member();
        member.setName(form.getName());
        memberService.join(member);
        return member;
    }
    @GetMapping("/list")
    public List<Member> list(){
        List<Member> members = memberService.findMember();
        return members;
    }

}
