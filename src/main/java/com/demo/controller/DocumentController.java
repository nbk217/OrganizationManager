package com.demo.controller;

import com.demo.model.Document;
import com.demo.model.Entity;
import com.demo.model.Ownership;
import com.demo.service.DocumentService;
import com.demo.service.EntityService;
import com.demo.service.OwnershipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes("name")
public class DocumentController {

    @Autowired
    private DocumentService documentService;

    @Autowired
    private EntityService entityService;

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(
                dateFormat,false));
    }

    @RequestMapping(value = "/documents", method = RequestMethod.GET)
    public String showDocuments(ModelMap modelMap, @RequestParam Long entityId){
        modelMap.addAttribute("documents",
                documentService.retrieveAllDocuments(entityId));
        modelMap.addAttribute("entityId", entityId);
        return "documents";
    }

    @RequestMapping(value = "/add-document", method = RequestMethod.GET)
    public String showAddDocumentPage(ModelMap modelMap, @RequestParam Long entityId){
        Document document=new Document();
        Entity entity= entityService.retrieveEntity(entityId);
        document.setEntity(entity);
        modelMap.addAttribute("document",document);
        return "addDocument";
    }

    @RequestMapping(value = "/add-document", method = RequestMethod.POST)
    public String addOwnership(@Valid @ModelAttribute Document document, ModelMap modelMap){
//        Entity entity= entityService.retrieveEntity(document.getEntity().getId());
//        document.setEntity(entity);
//        modelMap.clear();
        documentService.addDocument(document);
        List<Document> documents= documentService.retrieveAllDocuments(document.getEntity().getId());
        modelMap.addAttribute("documents", documents);
        modelMap.addAttribute("entityId", document.getEntity().getId());
        return "documents";
    }

}
