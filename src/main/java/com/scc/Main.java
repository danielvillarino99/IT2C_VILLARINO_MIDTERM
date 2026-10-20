import com.scc.ui.ScenarioMenu;

public class Main {
    public static void main(String[] args) {
        // Launch UI Menu (Database and tables initialize automatically via DAO layer)
        ScenarioMenu menu = new ScenarioMenu();
        menu.displayMenu();
    }
}