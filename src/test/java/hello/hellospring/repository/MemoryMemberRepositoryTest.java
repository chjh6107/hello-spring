package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository=new MemoryMemberRepository();

    @AfterEach //메서드 동작이 끝날 때마다 어떤 동작을 하는 콜백 메서드
    public void afterEach(){
        repository.clearStore();
    }
    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");
        repository.save(member);
        Member result=repository.findById(member.getId()).get();
//        System.out.println("result = "+(result==member));
//        Assertions.assertEquals(member,result);

        //얘는 더 편한거 core씀
        Assertions.assertThat(member).isEqualTo(result);
    }
    @Test
    public void findByName(){
        Member member1= new Member();
        member1.setName("spring1");
        repository.save(member1);
        Member member2= new Member();
        member2.setName("spring1");
        repository.save(member2);

        Member result=repository.findByName("spring1").get();
        Assertions.assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll(){
        Member member1= new Member();
        member1.setName("spring1");
        repository.save(member1);
        Member member2= new Member();
        member2.setName("spring1");
        repository.save(member2);
        List<Member> result=repository.findAll();
        Assertions.assertThat(result.size()).isEqualTo(2);
    }
}