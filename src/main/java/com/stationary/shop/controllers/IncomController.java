package com.stationary.shop.controllers;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.stationary.shop.entities.Incom;
import com.stationary.shop.entities.Order;
import com.stationary.shop.entities.Product;
import com.stationary.shop.services.CategoryService;
import com.stationary.shop.services.IncomService;
import com.stationary.shop.services.ProductService;
import com.stationary.shop.services.ProviderService;
import com.stationary.shop.utils.WordHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.ByteArrayInputStream;
import java.io.IOException;

@Controller
public class IncomController {

    @Autowired
    IncomService incomService;
    @Autowired
    ProductService productService;
    @Autowired
    ProviderService providerService;

    @GetMapping("/AdminPanel/Incoms")
    public String getAdminIncomViewPage(Model model) {
        model.addAttribute("incoms", incomService.getIncoms());
        return "/AdminPanel/ProductIncomCRUD/incomList";
    }

    @GetMapping("/AdminPanel/incom/add")
    public String getIncomAddPage(Model model) {
        model.addAttribute("Incom", new Incom());
        model.addAttribute("products", productService.getProducts());
        model.addAttribute("providers", providerService.getProviders());
        return "/AdminPanel/ProductIncomCRUD/incomAdd";
    }

    @GetMapping("/AdminPanel/incom/edit")
    public String getIncomEditPage(Model model, @RequestParam(name = "id", required = true) long id) {
        model.addAttribute("Incom", incomService.getIncomRepo().findById(id).get());
        model.addAttribute("products", productService.getProducts());
        model.addAttribute("providers", providerService.getProviders());
        return "/AdminPanel/ProductIncomCRUD/incomEdit";
    }

    @GetMapping(value = "/AdminPanel/incom/getdoc",
            produces = "application/vnd.openxmlformats-"
                    + "officedocument.wordprocessingml.document")
    public ResponseEntity<InputStreamResource> word(@RequestParam(name = "id", required = true) long id)
            throws IOException, InvalidFormatException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {

        ByteArrayInputStream bis = WordHelper.generateWord(incomService.getIncomRepo().findById(id).get());
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition",
                "inline; filename=mydoc.docx");
        return ResponseEntity.ok().headers(headers).
                body(new InputStreamResource(bis));
    }

    @GetMapping("/AdminPanel/incom/delete")
    public String deleteIncom(Model model, @RequestParam(name = "id", required = true) long id) {
        incomService.deleteIncom(id);
        return "redirect:/AdminPanel/Incoms";
    }

    @PostMapping("/AdminPanel/incom/add/accept")
    public String incomAddAccept(Model model, @ModelAttribute("Incom") Incom incom) {
        incomService.saveIncom(incom);
        return "redirect:/AdminPanel/Incoms";
    }

    @PostMapping("/AdminPanel/incom/edit/accept")
    public String incomEditAccept(Model model, @ModelAttribute("Incom") Incom incom) {
        incomService.saveIncom(incom);
        return "redirect:/AdminPanel/Incoms";
    }
}
