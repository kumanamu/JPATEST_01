package com.my.jpaTest.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Team {
@Id
    private String teamId;
  private String teamName;
    //팀의 소속된 멤버의 리스트를 저장
//연관관곗러정 member클래스의 team 정보를 가리킴
    @OneToMany(mappedBy = "team", fetch = FetchType.EAGER)
    private   List<Member> memberList = new ArrayList<>();

}
