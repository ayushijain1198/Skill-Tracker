package com.example.demo;

import com.example.demo.model.Associate;
import com.example.demo.model.Skill;
import com.example.demo.repo.AssociateRepo;
import com.example.demo.repo.SkillRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import java.util.Arrays;


@SpringBootApplication
@EnableEurekaClient
public class AssociateProjectApplication implements CommandLineRunner {
    private AssociateRepo associateRepo;
    private SkillRepository skillRepository;

    @Autowired
    public AssociateProjectApplication(AssociateRepo associateRepo, SkillRepository skillRepository) {
        this.associateRepo = associateRepo;
        this.skillRepository = skillRepository;
    }


    public static void main(String[] args) {
        SpringApplication.run(AssociateProjectApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Skill javascript = new Skill(1, "Javascript");
        Skill java = new Skill(2, "Java");
        Skill cpp = new Skill(3, "C++");
        Skill  python = new Skill(4, "Python");
        Skill angular = new Skill(5, "Angular");
        Skill react = new Skill(6, "React");
        Skill c = new Skill(7, "C");
        Skill  ML = new Skill(8, "Machine Learning");


        skillRepository.save(javascript);
        skillRepository.save(java);
        skillRepository.save(cpp);
        skillRepository.save(python);
        skillRepository.save(angular);
        skillRepository.save(react);
        skillRepository.save(c);
        skillRepository.save(ML);
        associateRepo.save(new Associate(1,"Ayushi","ayu@email.com","999999991", Arrays.asList(new Skill[]{java})));
        associateRepo.save(new Associate(2,"Marry","marry@email.com","999999992",Arrays.asList(new Skill[]{javascript})));
        associateRepo.save(new Associate(3,"Rohan","rohan@email.com","99999993",Arrays.asList(new Skill[]{cpp})));
        associateRepo.save(new Associate(4,"Sachin","Sachin@email.com","999999994",Arrays.asList(new Skill[]{python})));
    }
}
