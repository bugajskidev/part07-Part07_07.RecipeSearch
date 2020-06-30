
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private Scanner reader;
    private RecipesManager manager;
    private ArrayList<String> recipesAssList;

    public UserInterface(Scanner scanner, RecipesManager manager) {
        this.reader = scanner;
        this.manager = manager;
        this.recipesAssList = new ArrayList<>();

    }

    public void start() {
        readFileAssList();
        manager.addRecipeFromList(recipesAssList);
        manager.setNameAndTime();
        System.out.println("Commands: ");
        System.out.println("list - list the recipes");
        System.out.println("stop - stops the program");
        System.out.println("find name - searches recipes by name");
        System.out.println("find cooking time - searches recipes by cooking timee");
        System.out.println("");
        while (true) {

            System.out.print("Enter command: ");
            String command = reader.nextLine();
            System.out.println("");

            if (command.equals("Stop")) {
                break;
            } else if (command.equals("list")) {
                System.out.println("Recipes: ");
                manager.printRecipes();
            } else if (command.equals("find name")) {
                searchByName();
            } else if (command.equals("find cooking time")) {
                searchByTime();
            } else if (command.equals("find ingredient")) {
                searchByIngredient();
            } else {
                break;
            }
        }
    }

    public void searchByName() {
        System.out.print("Searched word: ");
        String word = reader.nextLine();
        System.out.println("");
        System.out.println("Recipes: ");
        manager.searchByName(word);
        System.out.println("");
    }

    public void readFileAssList() {
        System.out.print("File to read: ");
        String fileToRead = reader.nextLine();
        System.out.println("");

        try (Scanner scanner = new Scanner(Paths.get(fileToRead))) {
            while (scanner.hasNextLine()) {
                recipesAssList.add(scanner.nextLine());
            }

        } catch (Exception e) {
            System.out.println("Error!");
        }
    }

    public void searchByTime() {
        System.out.print("Max cooking time: ");
        int time = Integer.valueOf(reader.nextLine());
        System.out.println("");
        System.out.println("Recipes: ");
        manager.searchByTime(time);
        System.out.println("");

    }
    public void searchByIngredient() {
        System.out.print("Ingredient: ");
        String ingredient = reader.nextLine();
        System.out.println("");
        System.out.println("Recipes: ");
        manager.searchByIngredient(ingredient);
        System.out.println("");

    }
}
