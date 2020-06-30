
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
public class RecipesManager {

    ArrayList<Recipe> recipes;

    public RecipesManager() {
        recipes = new ArrayList<>();
    }

    public void printRecipes() {
        for (Recipe recipe : recipes) {
            System.out.println(recipe.toString());

        }
    }

    public void searchByName(String word) {
        for (Recipe recipe : recipes) {
            if (recipe.getName().contains(word)) {
                System.out.println(recipe.toString());
            }
        }
    }
     public void searchByTime(int time) {
        for (Recipe recipe : recipes) {
            if (recipe.getCookingTime() <= time) {
                System.out.println(recipe.toString());
            }
        }
    }

    public void addRecipeFromList(ArrayList<String> recipesAssList) {
        Recipe recipe = new Recipe();
        for (String line : recipesAssList) {
            if (line.isEmpty()) {
                recipes.add(recipe);
                recipe = new Recipe();
                continue;
            }
            recipe.addIngredients(line);

        }
        recipes.add(recipe);
    }
    
    public void setNameAndTime(){
        for (Recipe recipe: recipes){
            recipe.setCookingTime();
            recipe.setName();
        }
    }
    
    public void searchByIngredient(String ingredient) {
        for (Recipe recipe : recipes) {
            if (recipe.getIngredients().contains(ingredient)) {
                System.out.println(recipe.toString());
            }
        }
    }

}
