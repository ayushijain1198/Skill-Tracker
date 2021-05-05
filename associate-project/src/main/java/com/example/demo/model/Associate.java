package com.example.demo.model;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ASSOCIATE_DETAIL")
public class Associate {
    @Id
    @Column(name = "associate_id")
    private Integer associateId;
    @Column(name = "name")
    private String name;
    @Column(name = "email")
    private String email;
    @Column(name = "mobile_number")
    private String mobileNumber;

    @OneToMany
    @Column(name="skills")
    private List<Skill> skills;

    public Associate() {
        super();
    }

    public Associate(Integer associateId, String name, String email, String mobileNumber, List<Skill> skills) {
        this.associateId = associateId;
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.skills = skills;
    }

    public Integer getAssociateId() {
        return associateId;
    }

    public void setAssociateId(Integer associateId) {
        this.associateId = associateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public void add(Skill tempSkill) {
        if (skills == null)
            skills = new ArrayList<>();
        skills.add(tempSkill);
        tempSkill.setAssociate(this);
    }
}
