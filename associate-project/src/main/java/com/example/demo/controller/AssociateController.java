package com.example.demo.controller;

import com.example.demo.model.Associate;
import com.example.demo.model.Skill;
import com.example.demo.repo.AssociateRepo;
import com.example.demo.repo.SkillRepository;
import com.example.demo.service.AssociateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/associates")
public class AssociateController {
    private Environment environment;
    private AssociateRepo associateRepo;
    private SkillRepository skillRepository;
    private AssociateService associateService;

    @Autowired
    public AssociateController(Environment environment, AssociateRepo associateRepo, SkillRepository skillRepository, AssociateService associateService) {
        this.environment = environment;
        this.associateRepo = associateRepo;
        this.skillRepository = skillRepository;
        this.associateService = associateService;
    }


    @GetMapping("/status")
    public ResponseEntity<String> getStatus()
    {
        return ResponseEntity.ok("service is up and listining on port"+environment.getProperty("local.server.port"));
    }



    @GetMapping("/view")
    public String showFormForView(@RequestParam("associateId") int theId,
                                  Model theModel) {

        Associate theAssociate = associateService.findByAssociateId(theId);

        theModel.addAttribute("associates", theAssociate);

        return "view-associate";
    }


    @GetMapping("/list")
    public String getAssociates(Model model, String keyword)
    {
        List<Associate> list=associateService.getAllAssociates();
        if(keyword!=null){
            model.addAttribute("associates", associateService.findByKeyword(keyword));
        }
        else {
            model.addAttribute("associates", list);

        }
        return "list-associates";
    }

   /* @GetMapping("/list/skill")
    public String getSkills(Model model)
    {
        List<Skill> list=skillRepository.findAll();
            model.addAttribute("associates", list);
        return "list-skills";
    }*/

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {
        // create model attribute to bind form data
        Associate theAssociate = new Associate();
        //Skill theSkill=new Skill();
        theModel.addAttribute("associates", theAssociate);
        //theModel.addAttribute("skills",theSkill);
        return "associate-form";
    }

    @GetMapping("/showFormForAddSkill")
    public String showFormForAddSkill(Model theModel) {
        // Associate theAssociate = new Associate();
        Skill theSkill=new Skill();
        //theModel.addAttribute("associates", theAssociate);
        theModel.addAttribute("skills",theSkill);
        return "skill-form";
    }


    @PostMapping("/saveskill")
    public String saveSkill(@ModelAttribute("skills") Skill theSkill) {
        skillRepository.save(theSkill);
        return "redirect:/associates/list";
    }

    @PostMapping("/save")
    public String saveAssociate(@ModelAttribute("associates") Associate theAssociate) {

        associateService.createAssociate(theAssociate);
        //skillRepository.save(theSkill);
        return "redirect:/associates/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("associateId") int theId,
                                    Model theModel) {

        Associate theAssociate = associateService.findByAssociateId(theId);

        theModel.addAttribute("associates", theAssociate);

        return "associate-form";
    }

    @RequestMapping("/delete")
    public String deleteAssociateById(@RequestParam("associateId") int theId){
        associateService.deleteAssociateById(theId);
        return "redirect:/associates/list";
    }


}

