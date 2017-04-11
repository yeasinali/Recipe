package com.food.recipe.recipe.model;

/**
 * Created by pc on 3/29/2017.
 */

public class Recipe_model {
    private String name;
    private int image;

    public Recipe_model(String name, int image) {
        this.name = name;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
