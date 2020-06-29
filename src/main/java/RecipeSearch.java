
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class RecipeSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RecipesManager manager = new RecipesManager();
        String recipes = "";

        System.out.println("File to read: ");
        String fileToRead = scanner.nextLine();

        try (Scanner reader = new Scanner(Paths.get(fileToRead))) {
            while (scanner.hasNextLine()) {
                recipes = recipes + reader.nextLine() + "\n";
            }

        } catch (Exception e) {
        }

        // Spliting to single recipes
        String[] singleRecipe = recipes.split("\n\n");

        // Adding recipe to RecipeManager List
        for (int i = 0; i < singleRecipe.length; i++) {
            manager.addRecipe(singleRecipe[i]);
        }

        System.out.println("Commands: ");
        System.out.println("list - list the recipes");
        System.out.println("stop - stops the program");

        while (true) {
            Scanner scann = new Scanner(System.in);
            System.out.println("Enter command: ");
            String command = scann.nextLine();

            if (command.equals("Stop")) {
                break;
            }
            if (command.equals("list")) {
                System.out.println("Recipes: ");
                manager.printRecipes();
            }
        }
    }
}
