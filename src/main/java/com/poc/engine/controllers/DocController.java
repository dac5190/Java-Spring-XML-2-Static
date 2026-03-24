package com.poc.engine.controllers;

import com.poc.engine.models.Doc;
import com.poc.engine.services.DocService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Collection;

@Controller
public class DocController {

    private final DocService docService;

    // Spring injects the Service here
    public DocController(DocService docService) {
        this.docService = docService;
    }

    // Home page / List of all documents
    @GetMapping({"/", "/index.html"})
    public String listDocs(Model model) {
        Collection<Doc> docs = docService.getAll();
        model.addAttribute("docs", docs);
        // This looks for templates/docs/list.html
        return "docs/list";
    }

    // Individual Document View (The Switcharoo Mapping)
    @GetMapping({"/docs/{id}", "/docs/{id}/index.html"})
    public String viewDoc(@PathVariable String id, Model model) {
        Doc doc = docService.getById(id);
        
        if (doc == null) {
            return "error/404"; // You can create a simple 404.html later
        }

        model.addAttribute("doc", doc);
        // This looks for templates/docs/view.html
        return "docs/view";
    }
}