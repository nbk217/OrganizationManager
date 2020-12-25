package com.demo.controller;

import com.demo.model.Entity;
import com.demo.model.Requirement;
import com.demo.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes("name")
public class EntityController {

    @Autowired
    private EntityService entityService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat,false));
    }
    @RequestMapping(value = "/entities", method = RequestMethod.GET)
    public String entities(ModelMap model){
        List<Entity> entityList = entityService.retrieveAllEntities();
//        Collections.sort(entityList);
        model.addAttribute("entities", entityList);
        return "entities";
    }

    @RequestMapping(value = "/myaccount", method = RequestMethod.GET)
    public String showMyAccountPage(ModelMap modelMap){
        Entity entity= new Entity();
        entity.setLegalName("ABC Corporation");
        modelMap.addAttribute("entity",entity);
        return "myaccount";
    }


    @RequestMapping(value = "/add-requirement", method = RequestMethod.GET)
    public String addRequirement(ModelMap modelMap){
        Requirement requirement=new Requirement();
        modelMap.addAttribute("requirement",requirement);
        return "addRequirement";
    }

    @RequestMapping(value = "/Dashboard", method = RequestMethod.GET)
    public String showDashboard(ModelMap modelMap){

        return "dashboard";
    }

    @RequestMapping(value = "/add-entity", method = RequestMethod.GET)
    public String showAddEntityPage(ModelMap modelMap){
        modelMap.addAttribute("entity",new Entity());
        return "addEntity";
    }

    @RequestMapping(value = "/add-entity", method = RequestMethod.POST)
    public String addEntityPage(@Valid @ModelAttribute Entity entity, ModelMap modelMap) throws IOException {
        entityService.addEntity(entity.getLegalName(),"Nick",entity.getJurisdiction(),
                entity.getFormOfOrganization(),entity.getLegalAddress(),entity.getHeadQSameAsLegal(),entity.getHeadquartersAddress(),
                entity.getRegisteredAgent(), entity.getOtherNames(),entity.getTags(),entity.getNotes(),
                entity.getGroups(),entity.getIncorporationDate(),entity.isStatus(),entity.getLastUpdated(), entity.getFile());
        modelMap.addAttribute("entity",entity);
        return "entitydetails";
    }

    @RequestMapping(value = "/entitydetails", method = RequestMethod.GET)
    public String showEntityDetails(ModelMap modelMap,@RequestParam int id){
        modelMap.clear();
        Entity entity= entityService.retrieveEntity(id);
        modelMap.addAttribute("entity",entity);
        return "entitydetails";
    }

    @RequestMapping(value = "/delete-entity", method = RequestMethod.GET)
    public String deleteEntity(ModelMap model,@RequestParam int id){
        entityService.deleteEntity(id);
        model.clear();
        return "redirect:entities";
    }

    @RequestMapping(value = "/update-entity", method = RequestMethod.GET)
    public String updateEntity(ModelMap model,@RequestParam int id){
        model.clear();
        Entity entity= entityService.retrieveEntity(id);
        model.addAttribute("entity",entity);
        return "addEntity";
    }
    @RequestMapping(value = "/update-entity", method = RequestMethod.POST)
    public String updateEntity(@Valid Entity entity, ModelMap model, BindingResult result){
        if(result.hasErrors()){
            return "addEntity";
        }
        entity.setUser("Nick");
        entityService.updateEntity(entity);
        model.clear();
        return "redirect:entities";

    }
}
