package org.example.controller;

import lombok.RequiredArgsConstructor;
import org.example.model.Contact;
import org.example.service.impl.DatabasesContactService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class ContactController {

    private final DatabasesContactService databasesContactService;

//    private final ContactService inContactService;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("contact", databasesContactService.findAll());
        return "index";
    }

    @GetMapping("/contact/create")
    public String addForm(Model model) {
        model.addAttribute("contact", new Contact());
        return "create";
    }


    @PostMapping("/contact/create")
    public String create(@ModelAttribute("contact") Contact contact) {
        databasesContactService.save(contact);
        return "redirect:/";
    }

    @GetMapping("/contact/edit/{id}")
    public String editForm(@PathVariable long id, Model model) {
        Contact contact = databasesContactService.findById(id);
        model.addAttribute("contact", contact);
        return "edit";
    }

    @PostMapping("/contact/edit/{id}")
    public String edit(@PathVariable long id, @ModelAttribute("contact") Contact contact) {
        contact.setId(id);
        databasesContactService.update(contact);
        return "redirect:/";
    }

    @GetMapping("/contact/delete/{id}")
    public String delete(@PathVariable long id) {
        databasesContactService.deleteById(id);
        return "redirect:/";
    }
}
