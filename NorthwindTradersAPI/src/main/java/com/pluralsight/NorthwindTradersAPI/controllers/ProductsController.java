package com.pluralsight.NorthwindTradersAPI.controllers;


import com.pluralsight.NorthwindTradersAPI.models.Product;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ProductsController {

    @RequestMapping(path="/products", method = RequestMethod.GET)
    public List<Product> getProducts(){
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Milk", 2, 5.99));
        products.add(new Product(2, "Bread", 1, 5.99));
        products.add(new Product(3, "Water", 2, 5.99));
        products.add(new Product(4, "Pants", 3, 5.99));
        products.add(new Product(5, "TShirt", 3, 5.99));
        return products;
    }



    @RequestMapping(path="/products/{id}", method = RequestMethod.GET)
    public List<Product> getProducts( @PathVariable int id){
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(1, "Milk", 1, 5.99));
        products.add(new Product(2, "Bread", 1, 5.99));
        products.add(new Product(3, "Water", 1, 5.99));
        products.add(new Product(4, "Pants", 2, 5.99));
        products.add(new Product(5, "TShirt", 2, 5.99));

        for(Product p : products){
            if(p.getProductId() == id){
                ArrayList<Product> resultingProducts = new ArrayList<>();
                resultingProducts.add(p);
                return resultingProducts;
            }
        }

        return new ArrayList<Product>();
    }

//    @RequestMapping(path="/products/{id}/{name}/{price}", method = RequestMethod.GET)
//    public List<Product> getProductsNameCategoryIdPrice( @PathVariable int id, @PathVariable String name, @PathVariable double price){
//        ArrayList<Product> products = new ArrayList<>();
//        products.add(new Product(1, "Milk", 1, 5.99));
//        products.add(new Product(2, "Bread", 1, 5.99));
//        products.add(new Product(3, "Water", 1, 5.99));
//        products.add(new Product(4, "Pants", 2, 5.99));
//        products.add(new Product(5, "TShirt", 2, 5.99));
//
//        for(Product p : products){
//            if(p.getCategoryId() == id && p.getProductName().equalsIgnoreCase(name) && p.getUnitPrice() == price){
//                ArrayList<Product> resultingProducts = new ArrayList<>();
//                resultingProducts.add(p);
//                return resultingProducts;
//            }
//        }
//
//        return new ArrayList<Product>();
//    }





}