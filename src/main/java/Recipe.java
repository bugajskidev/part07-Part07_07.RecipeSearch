
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author admin
 */
public class Recipe {

    private String name;
    private int cookingTime;
    private ArrayList<String> recipeLines;
    private ArrayList<String> ingredients;

    public Recipe() {
        this.name = "";
        this.cookingTime = 0;
        this.ingredients = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCookingTime() {
        return cookingTime;
    }

    public ArrayList<String> getIngredients() {
        return ingredients;
    }

    public void setName() {
        this.name = ingredients.get(0);
        ingredients.remove(0);
    }

    public void setCookingTime() {
        this.cookingTime = Integer.valueOf(ingredients.get(1));
        ingredients.remove(1);
    }

    public void addLines(String line) {
        this.recipeLines.add(line);
    }

    public void printIgredients() {
        int i = 0;
        for (String line: ingredients){
            System.out.println(line);
        }
    }

    @Override
    public String toString() {
        return this.name + ", cooking time: " + cookingTime;
    }

    public void addIngredients(String ingredient) {
        this.ingredients.add(ingredient);

    }
    
}
