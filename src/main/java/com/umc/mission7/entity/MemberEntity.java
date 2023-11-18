package com.umc.mission7.entity;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "member", schema = "umc")
public class MemberEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private long id;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "gender")
    private String gender;
    @Basic
    @Column(name = "age")
    private int age;
    @Basic
    @Column(name = "address")
    private String address;
    @Basic
    @Column(name = "spec_address")
    private String specAddress;
    @Basic
    @Column(name = "status")
    private String status;
    @Basic
    @Column(name = "inactive_date")
    private Timestamp inactiveDate;
    @Basic
    @Column(name = "created_at")
    private Timestamp createdAt;
    @Basic
    @Column(name = "updated_at")
    private Timestamp updatedAt;
    @Basic
    @Column(name = "email")
    private String email;
    @Basic
    @Column(name = "point")
    private int point;

    public void setId(long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setSpecAddress(String specAddress) {
        this.specAddress = specAddress;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setInactiveDate(Timestamp inactiveDate) {
        this.inactiveDate = inactiveDate;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPoint(int point) {
        this.point = point;
    }
}
