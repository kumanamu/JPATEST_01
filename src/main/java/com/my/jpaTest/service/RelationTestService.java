package com.my.jpaTest.service;

import com.my.jpaTest.entity.Member;
import com.my.jpaTest.entity.Team;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;

@Service
@Transactional

public class RelationTestService {
//팀과 멤버를 저장하는 코드
@Autowired
EntityManager em;

    public void insertMemberAndTeam(){
//        Member member = Member.builder().memberId("eso").memberId("이서")
//                .teamId("ive").build();
//        em.persist(member);
//        Team team = Team.builder().teamId("ive").teamName("아이브").build();

        Team team = Team.builder().teamId("ive").teamName("아이브").build();
        em.persist(team);

        Member member = Member.builder().memberId("jang").name("장원영").team(team).build();
        em.persist(member);


    }

    public void InsertBothRelation(){
        //시름
        Team ssirum = Team.builder().teamId("ssrium").teamName("씨름팀").build();
        em.persist(ssirum);

        //이만기

        Member lee = Member.builder().memberId("lee").name("이만기").team(ssirum).build();
        em.persist((lee));

        //강호동

        Member gang = Member.builder().memberId("gang").name("강호동").team(ssirum).build();
        em.persist((gang));
    //씨름팀에 이만기와 강호동을 리스트에 추가
        //객체 지향 개념을 확실하게 하기 위해

        ssirum.getMemberList().add(lee);
        ssirum.getMemberList().add(gang);
    }



}
