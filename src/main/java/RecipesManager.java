
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

    public void addRecipe(String recipeAssString) {
        Recipe recipe = new Recipe();
        String[] lines = recipeAssString.split("\n");

        for (int i = 0; i < 2 ; i++) {
            recipe.setName(lines[0]);
            recipe.setCookingTime(Integer.valueOf(lines[1]));
        }
        for (int i = 2; i < lines.length ; i++) {
            recipe.addIngredients(lines[i]);
        }
        recipes.add(recipe);

    }

    public void printRecipes() {
        for (Recipe recipe : recipes) { 
            System.out.println(recipe.toString());
        }
    }

}
