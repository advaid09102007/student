import ui.LoginScreen;

public class Main {

    public static void main(String[] args) {

        // Start the application from Login Screen
        javax.swing.SwingUtilities.invokeLater(() -> {
            new LoginScreen();
        });
    }
}