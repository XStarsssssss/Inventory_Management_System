package model;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private int id;
    private String name;
    private List<SubCategory> subCategories = new ArrayList<>();

    private int subCategoryId = 1;

    public Category(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() { return id; }
    public String getName() { return name; }

    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public SubCategory addSubCategory(String name) {
        SubCategory sub = new SubCategory(subCategoryId++, name);
        subCategories.add(sub);
        return sub;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void removeSubCategory(int subId) {
        subCategories.removeIf(s -> s.getId() == subId);

        for (int i = 0; i < subCategories.size(); i++) {
            subCategories.get(i).setId(i + 1);
        }

        subCategoryId = subCategories.size() + 1;
    }

    public void updateName(String name) {
        this.name = name;
    }


}