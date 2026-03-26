package repository;

import model.Category;
import model.SubCategory;

import java.util.ArrayList;
import java.util.List;

public class CategoryRepository {

    private static CategoryRepository instance;
    private List<Category> categories = new ArrayList<>();
    private int categoryId = 1;
    private int subCategoryId = 1;

    private CategoryRepository() {}

    public static CategoryRepository getInstance() {
        if (instance == null) {
            instance = new CategoryRepository();
        }
        return instance;
    }

    public Category createCategory(String name) {
        Category c = new Category(categoryId++, name);
        categories.add(c);
        return c;
    }

    public SubCategory createSubCategory(Category category, String name) {
        return category.addSubCategory(name);
    }

    public List<Category> getCategories() {
        return categories;
    }

    public Category findCategoryById(int id) {
        for (Category c : categories) {
            if (c.getId() == id) return c;
        }
        return null;
    }

    public SubCategory findSubCategoryById(Category category, int id) {
        if (category == null) return null;
        for (SubCategory s : category.getSubCategories()) {
            if (s.getId() == id) return s;
        }
        return null;
    }
    public void deleteCategory(int id) {
        categories.removeIf(c -> c.getId() == id);

        for (int i = 0; i < categories.size(); i++) {
            categories.get(i).setId(i + 1);
        }

        categoryId = categories.size() + 1;
        System.out.println("-----------------------------");
        System.out.println("Category deleted successfully");
        System.out.println("-----------------------------");
    }

    public void updateCategory(int id, String name) {
        Category c = findCategoryById(id);
        if (c != null) {
            c.updateName(name);
            System.out.println("-----------------------------");
            System.out.println("Category updated successfully!");
            System.out.println("-----------------------------");
        }
    }

    public void deleteSubCategory(Category c, int subId) {
        if (c != null) {
            c.removeSubCategory(subId);
            System.out.println("-----------------------------");
            System.out.println("SubCategory deleted successfully!");
            System.out.println("-----------------------------");
        }
    }

    public void updateSubCategory(Category c, int subId, String name) {
        if (c != null) {
            for (SubCategory s : c.getSubCategories()) {
                if (s.getId() == subId) {
                    s.setName(name);
                    System.out.println("-----------------------------");
                    System.out.println("SubCategory updated successfully!");
                    System.out.println("-----------------------------");
                    break;
                }
            }
        }
    }
}