package com.umc.mission7.entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "mission", schema = "umc")
public class MissionEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @ManyToOne
    @JoinColumn(name = "store_id")
    private StoreEntity store;
    @Basic
    @Column(name = "reward")
    private Integer reward;
    @Basic
    @Column(name = "deadline")
    private Timestamp deadline;
    @Basic
    @Column(name = "mission_spec")
    private String missionSpec;
    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    public void setReward(Integer reward) {
        this.reward = reward;
    }


    public void setDeadline(Timestamp deadline) {
        this.deadline = deadline;
    }


    public void setMissionSpec(String missionSpec) {
        this.missionSpec = missionSpec;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
