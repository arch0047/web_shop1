package com.example.web_shop1.repository;



import com.example.web_shop1.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements ICrudRepository<Product> {

    //collection for handling test data
    private List<Product> products = new ArrayList<>();

    public ProductRepository() {

        // adding test data into the list
        this.products.add(new Product( 1,"cloths", 200.99 ,"Woollen"));
        this.products.add(new Product( 2,"Shoe", 89.00 ,"Boots"));
        this.products.add(new Product( 3,"Lipstick", 100.99 ,"Make-up"));
        this.products.add(new Product( 4,"Foods", 99.99 ,"Food"));
    }

    @Override
    //adding new product to collection(List)
    public void create(Product product) {
        products.add(product);

    }

    @Override
    public List<Product> readAll()
    {
        return products;
    }

    @Override
    public Product read(long id) {
        //  finding element by id
        int i =0;
        while (i<products.size()){
            if(products.get(i).getId()==id)
                return products.get(i);
            i++;
        }
        return null;
    }

    @Override
    public boolean update(Product product) {

        // finding the element that needs to be updated
        for(int i =0; i <products.size();i++){
            if(products.get(i).getId()== product.getId()){
              //  updating product with new edition
                products.set(i,product);
                return true;
            }
        }
        // if element not found
        return false;
    }

    @Override
    public boolean delete(long id) {
        int i = 0;
        while (i < products.size()) {
            if (products.get(i).getId() == id){
                products.remove(i);
            return true;
        }
        i++;
    }
        return false;
    }
}

