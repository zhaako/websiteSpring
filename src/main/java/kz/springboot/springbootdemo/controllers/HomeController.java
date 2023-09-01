package kz.springboot.springbootdemo.controllers;

import kz.springboot.springbootdemo.db.DBManager;
import kz.springboot.springbootdemo.db.Items;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class HomeController {
    @GetMapping(value = "/")
    public String index(Model model){
        ArrayList<Items> items = DBManager.getItems();
        model.addAttribute("tovary", items);
        return "index";
    }

    @GetMapping(value = "/about")
    public String about(){
        return "about";
    }

    @PostMapping(value = "/additem")
    public String addItem(@RequestParam(name = "item_name", defaultValue = "No item") String name,
                          @RequestParam(name = "item_price", defaultValue = "0") int price){
        DBManager.addItem(new Items(null,name,price));
        return "redirect:/";
    }
}
