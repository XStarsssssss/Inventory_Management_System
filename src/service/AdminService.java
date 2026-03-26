package service;

import model.Category;
import model.SubCategory;
import repository.CategoryRepository;

public class AdminService {

    private CategoryRepository repo;

    public AdminService(CategoryRepository repo) {
        this.repo = repo;
    }

    public void createCategory(String name) {
        repo.createCategory(name);
        System.out.println("----------------------------------------");
        System.out.println("Category created!");

    }

    public void createSubCategory(int cid, String name) {
        Category c = repo.findCategoryById(cid);
        if (c == null) {
            System.out.println("----------------------------------------");
            System.out.println("Category not found!");
            System.out.println("----------------------------------------");
            return;
        }

        repo.createSubCategory(c, name);
        System.out.println("----------------------------------------");
        System.out.println("SubCategory created!");
        System.out.println("----------------------------------------");
    }

    public void viewCategories() {
        System.out.println();
        System.out.println("Categories");
        System.out.println("----------------------------------------");
        for (Category c : repo.getCategories()) {
            System.out.println(c.getId() + " - " + c.getName());
        }
        System.out.println("----------------------------------------");

    }

    public void viewSubCategories(int cid) {
        Category c = repo.findCategoryById(cid);

        if (c == null) {
            System.out.println("----------------------------------------");
            System.out.println("Category not found!");
            System.out.println("----------------------------------------");
            return;
        }

        for (SubCategory s : c.getSubCategories()) {
            System.out.println(s.getId() + " - " + s.getName());
        }
    }
}