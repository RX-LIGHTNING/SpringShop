package com.stationary.shop.controllers;

import com.stationary.shop.entities.Incom;
import com.stationary.shop.entities.Provider;
import com.stationary.shop.services.IncomService;
import com.stationary.shop.services.ProductService;
import com.stationary.shop.services.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProviderController {

    @Autowired
    IncomService incomService;
    @Autowired
    ProductService productService;
    @Autowired
    ProviderService providerService;

    @GetMapping("/AdminPanel/Providers")
    public String getAdminIncomViewPage(Model model){
        model.addAttribute("providers", providerService.getProviders());
        return "/AdminPanel/ProviderCRUD/providerList";
    }
    @GetMapping("/AdminPanel/provider/add")
    public String getProductAddPage(Model model){
        model.addAttribute("Provider", new Provider());
        return "/AdminPanel/ProviderCRUD/providerAdd";
    }
    @GetMapping("/AdminPanel/provider/edit")
    public String getProductEditPage(Model model, @RequestParam(name="id", required = true)long id){
        model.addAttribute("Provider", providerService.getProviderRepo().findById(id).get());
        return "/AdminPanel/ProviderCRUD/providerEdit";
    }
    @GetMapping("/AdminPanel/provider/delete")
    public String deleteUser(Model model, @RequestParam(name="id", required = true)long id){
        providerService.deleteProvider(id);
        return "redirect:/AdminPanel/Providers";
    }
    @PostMapping("/AdminPanel/provider/add/accept")
    public String productAddAccept(Model model, @ModelAttribute("Provider") Provider provider){
        providerService.saveProvider(provider);
        return "redirect:/AdminPanel/Providers";
    }
    @PostMapping("/AdminPanel/provider/edit/accept")
    public String incomEditAccept(Model model, @ModelAttribute("Provider") Provider provider){
        providerService.saveProvider(provider);
        return "redirect:/AdminPanel/Providers";
    }
}
