package com.umc.mission7.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table(name = "member_mission", schema = "umc")
public class MemberMissionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "mission_id")
    private MissionEntity mission;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private MemberEntity member;

    @Basic
    @Column(name = "field")
    private String field;

    public void setField(String field) {
        this.field = field;
    }
}
