
import java.nio.file.Paths;
import java.util.Scanner;

public class UserInterface {

    private Scanner scanner;
    private RecipesManager manager;
    private String recipes;

    public UserInterface(RecipesManager manager) {
        this.scanner = new Scanner(System.in);
        this.manager = manager;
        this.recipes = "";
    }

    public void start() {
        readFile();
        addRecipeToManager();
        System.out.println("Commands: ");
        System.out.println("list - list the recipes");
        System.out.println("stop - stops the program");
        while (true) {
            
            System.out.println("Enter command: ");
            String command = scanner.nextLine();

            if (command.equals("Stop")) {
                break;
            }
            if (command.equals("list")) {
                System.out.println("Recipes: ");
                manager.printRecipes();
            }
        }
    }

    //reading file and save ass string
    public void readFile() {
        Scanner scann = new Scanner(System.in);
        System.out.println("File to read: ");
        String fileToRead = scann.nextLine();

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
}
