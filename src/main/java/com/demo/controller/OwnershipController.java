package com.demo.controller;

import com.demo.model.Entity;
import com.demo.model.Ownership;
import com.demo.model.Requirement;
import com.demo.service.EntityService;
import com.demo.service.OwnershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes("name")
public class OwnershipController {

    @Autowired
    private OwnershipService ownershipService;

    @Autowired
    private EntityService entityService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat,false));
    }

    @RequestMapping(value = "/ownership", method = RequestMethod.GET)
    public String showOwnership(ModelMap modelMap, @RequestParam String type,
                                @RequestParam Boolean active){
        modelMap.addAttribute("ownerships",
                ownershipService.retrieveAllOwnerships(type, active));
        return "ownership";
    }

    /**
     * This method gets called when Add ownership button is clicked
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/add-ownership", method = RequestMethod.GET)
    public String showAddOwnershipPage(ModelMap modelMap){
        Ownership ownership=new Ownership();
        modelMap.addAttribute("ownership",ownership);
        return "addOwnership";
    }

    /**
     * This method gets called when Add ownership Submit button is clicked
     * @param ownership
     * @param modelMap
     * @return
     */
    @RequestMapping(value = "/add-ownership", method = RequestMethod.POST)
    public String addOwnership(@Valid Ownership ownership, ModelMap modelMap){
        Entity entity= entityService.retrieveEntity(ownership.getEntity().getLegalName());
        modelMap.clear();
        ownership.setEntity(entity);
        ownershipService.addOwnership(ownership);
        List<Ownership> ownerships= ownershipService.retrieveAllOwnerships(null, null);
        modelMap.addAttribute("ownerships", ownerships);
        return "ownership";
    }

}
