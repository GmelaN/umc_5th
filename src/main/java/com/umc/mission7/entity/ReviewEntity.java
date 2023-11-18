package com.umc.mission7.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Table(name = "review", schema = "umc")
public class ReviewEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private MemberEntity member;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private StoreEntity store;
    @Basic
    @Column(name = "body")
    private String body;
    @Basic
    @Column(name = "score")
    private Double score;
//    @OneToMany(mappedBy = "review")
//    private List<ReviewImageEntity> reviewImageEntities;

    public void setBody(String body) {
        this.body = body;
    }

    public void setScore(Double score) {
        this.score = score;
    }
}
