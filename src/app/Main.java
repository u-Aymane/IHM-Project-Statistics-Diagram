package app;
import javax.swing.*;
import gui.MainWindow;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                createAndShowGUI();
            }
        });
    }

    private static void createAndShowGUI() {
        MainWindow mainWindow = new MainWindow();
        mainWindow.setVisible(true);
    }
}
