package com.huan.controller;


import com.huan.model.Product;
import com.huan.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;


    @RequestMapping
    public ModelAndView getAllProducts(@PageableDefault(size = 5) Pageable pageable) {
        Page<Product> list = productService.findAll(pageable);
        ModelAndView modelAndView = new ModelAndView("/list", "products", list);
        return modelAndView;
    }

    @GetMapping("/add-to-cart/{id}")
    public ModelAndView getCart(@PathVariable Long id, @CookieValue(value = "Idea-7eee433f", defaultValue = "") String cookie
            , HttpServletResponse response, HttpServletRequest request) {
        ModelAndView modelAndView =null;
        Cookie[] cookies=request.getCookies();
        for (Cookie ck:cookies){
            if (ck.getName().equals(cookie)){

                Product product=productService.findOne(id);
                ck.
                modelAndView=new ModelAndView("/cart");
                modelAndView.addObject("cookieValue",ck);
                modelAndView.addObject("product",product);


            }
        }


        return modelAndView;
    }


}
