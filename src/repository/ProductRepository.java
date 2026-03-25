package repository;

import model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {

    private static ProductRepository instance;
    private List<Product> products = new ArrayList<>();
    private int productId = 1;

    private ProductRepository() {
    }

    public static ProductRepository getInstance() {
        if (instance == null) {
            instance = new ProductRepository();
        }
        return instance;
    }

    public int generateId() {
        return productId++;
    }

    public void add(Product p) {
        products.add(p);
    }

    public List<Product> getAll() {
        return products;
    }

    public Product findById(int id) {
        for (Product p : products) {
            if (p.getId() == id) return p;
        }
        return null;
    }

    public void delete(int id) {
        products.removeIf(p -> p.getId() == id);


        for (int i = 0; i < products.size(); i++) {
            products.get(i).setId(i + 1);
        }


        productId = products.size() + 1;
    }
}