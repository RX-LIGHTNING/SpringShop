package com.stationary.shop.controllers;

import com.stationary.shop.entities.Order;
import com.stationary.shop.entities.Product;
import com.stationary.shop.entities.enums.OrderStatus;
import com.stationary.shop.services.CategoryService;
import com.stationary.shop.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@Controller
public class ProductController {
    @Autowired
    ProductService productService;
    @Autowired
    CategoryService categoryService;
    @Value("${upload.path}")
    private String uploadPath;
    @GetMapping("/product/view")
    public String getProductViewPage(Model model, @RequestParam(name="id", required = true)long id){
        model.addAttribute("Order", new Order(productService.getProdRepo().findById(id).get()));
        model.addAttribute("Product", productService.getProdRepo().findById(id).get());
        return "ProductView";
    }
    @GetMapping("/AdminPanel/Products")
    public String getAdminProductViewPage(Model model){
        model.addAttribute("products", productService.getProducts());
        return "/AdminPanel/ProductCRUD/ProductList";
    }
    @GetMapping("/AdminPanel/product/add")
    public String getProductAddPage(Model model){
        model.addAttribute("Product", new Product());
        model.addAttribute("categories", categoryService.getCategoryRepo().findAll());
        return "/AdminPanel/ProductCRUD/ProductAdd";
    }
    @GetMapping("/AdminPanel/product/edit")
    public String getProductEditPage(Model model, @RequestParam(name="id", required = true)long id){
        model.addAttribute("Product", productService.getProdRepo().findById(id).get());
        model.addAttribute("categories", categoryService.getCategoryRepo().findAll());
        return "/AdminPanel/ProductCRUD/ProductEdit";
    }
    @GetMapping("/AdminPanel/product/delete")
    public String deleteUser(Model model, @RequestParam(name="id", required = true)long id){
       productService.deleteProduct(id);
        return "redirect:/AdminPanel/Products";
    }
    @PostMapping("/AdminPanel/product/add/accept")
    public String productAddAccept(@RequestParam("file") MultipartFile file, Model model, @ModelAttribute("Product") Product product) throws IOException {
        if (file != null && !file.getOriginalFilename().isEmpty()) {
            File uploadDir = new File(uploadPath);

            if (!uploadDir.exists()) {
                uploadDir.mkdir();
            }

            String uuidFile = UUID.randomUUID().toString();
            String resultFilename = uuidFile + "." + file.getOriginalFilename();

            file.transferTo(new File(uploadPath + "/" + resultFilename));

            product.setFilepath(resultFilename);
        }
        productService.saveProduct(product);
        return "redirect:/Store";
    }
    @PostMapping("/AdminPanel/product/edit/accept")
    public String productEditAccept(Model model, @ModelAttribute("Product") Product product){
        productService.updateProduct(product);
        return "redirect:/AdminPanel/Products";
    }
}