
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

    public ArrayList<String> getIngrredients() {
        return ingredients;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCookingTime(int cookingTime) {
        this.cookingTime = cookingTime;
    }

    public void addLines(String line) {
        this.recipeLines.add(line);
    }

    public void printIgredients() {
        int i = 0;
        while (i < recipeLines.size()) {
            System.out.println(i + ": " + recipeLines.get(i));
            i++;
        }
    }

    @Override
    public String toString() {
        return this.name + ", coocking time: " + cookingTime;
    }

    public void addIngredients(String ingredient) {
        this.ingredients.add(ingredient);

    }
}
