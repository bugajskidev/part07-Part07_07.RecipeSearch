
import java.util.Scanner;


public class RecipeSearch {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RecipesManager manager = new RecipesManager();
        
        UserInterface ui = new UserInterface(scanner, manager);
        
        ui.start();
        

    }
}
