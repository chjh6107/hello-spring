package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional //데이터 변경하거나 저장할때는 항상 해당 어노테이션 사용
//@Service //일반 자바 코드로 이루어진 클리스를 스프링 컨테이너에 등록해줌
//회원 서비스 만들기
public class MemberService {
    private final MemberRepository memberRepository;

//    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    //회원가입
    public Long join(Member member){
        //중복회원은 안됨
        validateDuplicate(member); //중복회원검증
        memberRepository.save(member);
        return member.getId();
    }

    private void validateDuplicate(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m->{
                        throw new IllegalStateException("이미 존재하는 회원");
                });
    }
//    전체회원 조회
    public List<Member> findMembers(){
        return memberRepository.findAll();
    }
//    특정회원 조회
    public Optional<Member> findOne(Long memberId){
        return memberRepository.findById(memberId);
    }

}















