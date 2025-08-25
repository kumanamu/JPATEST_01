package com.my.jpaTest.service;

import org.springframework.test.context.TestPropertySource;

import com.my.jpaTest.entity.Member;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestPropertySource(locations = "classpath:application-test.properties")

class ContextServiceTest {
    @Autowired
    EntityManager em;

    @Autowired
    ContextService contextService;

    @Test
    @DisplayName("1차 캐시 테스트")
    void firstCash(){
        Member m = contextService.memberInsert();
        System.out.println("==========" + m);
    }

    @Test
    @DisplayName("데이터 영속성 보장 테스트")
    void 데이터_영속성_보장_테스트(){
        //인스턴스를 생성 > @데이타
        Member a_1= Member();
                .memberId("HOng")
                .name("홍길동")
                .build();
        Member b_1= Member.builder()
                .memberId("HOng")
                .name("홍길동")
                .build();
        // 엔티티 매니저의 영속성 컨텍스트영역에서 가져와서 똑같음
        Member a = em.find(Member.class, "jang");
        Member b =em.find(Member.class, "jang");
        System.out.println(a.equals(b));
    }

}