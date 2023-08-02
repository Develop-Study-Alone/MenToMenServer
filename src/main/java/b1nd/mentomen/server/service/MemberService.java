package b1nd.mentomen.server.service;

import b1nd.mentomen.server.domain.Member;
import b1nd.mentomen.server.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;
    //회원가입
    public Long join(Member member){
        validDuplicateMember(member); //중복값 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }
    public List<Member> findMember(){
        return memberRepository.findAll();
    }

}
