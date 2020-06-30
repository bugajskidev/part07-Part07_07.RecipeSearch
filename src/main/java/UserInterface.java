
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private RecipesManager manager;
    private String recipes;
    private ArrayList<String> recipesAssList;

    public UserInterface(Scanner scanner, RecipesManager manager) {
        this.scanner = scanner;
        this.manager = manager;
        this.recipes = "";
        this.recipesAssList = new ArrayList<>();

    }

    public void start() {
        readFileAssList();
        manager.addRecipeFromList(recipesAssList);
        //addRecipeToManager();
        System.out.println("Commands: ");
        System.out.println("list - list the recipes");
        System.out.println("stop - stops the program");
        System.out.println("find name - searches recipes by name");
        System.out.println("");
        while (true) {

            System.out.print("Enter command: ");
            String command = scanner.nextLine();
            System.out.println("");

            if (command.equals("Stop")) {
                break;
            }
            if (command.equals("list")) {
                System.out.println("Recipes: ");
                manager.printRecipes();
//                System.out.println("");
//                   for (String line: recipesAssList){
//                       System.out.println(line);
//                   }

            }
            if (command.equals("find name")) {
                searchByName();
                

            }
        }
    }

    //reading file and save ass string
    public void readFile() {
        System.out.print("File to read: ");
        String fileToRead = scanner.nextLine();
        System.out.println("");

        try (Scanner reader = new Scanner(Paths.get(fileToRead))) {
            while (reader.hasNextLine()) {
                recipes = recipes + reader.nextLine() + "\n";
            }

        } catch (Exception e) {
            System.out.println("Error!");
        }
    }

    public void addRecipeToManager() {
        String[] singleRecipe = recipes.split("\n\n");
        for (int i = 0; i < singleRecipe.length; i++) {
            manager.addRecipe(singleRecipe[i]);
        }
    }

    public void searchByName() {
        System.out.print("Searched word: ");
        String word = scanner.nextLine();
        System.out.println("");
        System.out.println("Recipes: ");
        System.out.println(manager.searchByName(word));
        System.out.println("");
    }

    public void readFileAssList() {
        System.out.print("File to read: ");
        String fileToRead = scanner.nextLine();
        System.out.println("");

        try (Scanner reader = new Scanner(Paths.get(fileToRead))) {
            while (reader.hasNextLine()) {
                recipesAssList.add(reader.nextLine());
            }

        } catch (Exception e) {
            System.out.println("Error!");
        }
    }

}
