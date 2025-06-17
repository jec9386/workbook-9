package com.pluralsight.NorthwindTradersAPI.controllers;

import com.pluralsight.NorthwindTradersAPI.models.Category;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CategoriesController {

    @RequestMapping(path="/categories", method = RequestMethod.GET)
    public List<Category> getCategories(){
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category(1,"Food" ));
        categories.add(new Category(2,"Drinks" ));
        categories.add(new Category(3,"Clothing" ));
        return categories;
    }



    @RequestMapping(path="/categories/{id}", method = RequestMethod.GET)
    public List<Category> getCategories( @PathVariable int categoryId){
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category(1,"Food" ));
        categories.add(new Category(2,"Drinks" ));
        categories.add(new Category(3,"Clothing" ));


        return categories.stream().filter(c -> c.getCategoryID() == categoryId).toList();
    }

    @RequestMapping(path="/categories/name/{name}", method = RequestMethod.GET)
    public List<Category> getCategoriesName( @PathVariable String name){
        ArrayList<Category> categories = new ArrayList<>();
        categories.add(new Category(1,"Food" ));
        categories.add(new Category(2,"Drinks" ));
        categories.add(new Category(3,"Clothing" ));


        for(Category c : categories){
            if(c.getCategoryName().equalsIgnoreCase(name)){
                ArrayList<Category> resultingCategories = new ArrayList<>();
                resultingCategories.add(c);
                return resultingCategories;
            }
        }

        return new ArrayList<Category>();
    }
}
