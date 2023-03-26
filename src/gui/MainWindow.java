package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

import utils.DiagramGenerator;
import utils.ExcelReader;

public class MainWindow extends JFrame {
    private JButton loadExcelButton;
    private JButton generateDiagramButton;
    private JPanel mainPanel;
    private JLabel statusLabel;

    private ExcelReader excelReader;
    private DiagramGenerator diagramGenerator;
    private List<Double> dataPoints;

    public MainWindow() {
        setTitle("Statistic Diagram Generator");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new BorderLayout());

        mainPanel = new JPanel();
        add(mainPanel, BorderLayout.CENTER);

        loadExcelButton = new JButton("Load Excel File");
        loadExcelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    File selectedFile = fileChooser.getSelectedFile();
                    excelReader = new ExcelReader(selectedFile.getAbsolutePath());
                    statusLabel.setText("Excel file loaded: " + selectedFile.getName());
                }
            }
        });

        generateDiagramButton = new JButton("Generate Diagram");
        generateDiagramButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (excelReader != null) {
                    try {
                        dataPoints = excelReader.readDataFromColumn(0);
                        diagramGenerator = new DiagramGenerator();
                        JFreeChart chart = diagramGenerator.createBarChart("Example Chart", "Categories", "Values", dataPoints);
                        ChartPanel chartPanel = new ChartPanel(chart);
                        mainPanel.removeAll();
                        mainPanel.add(chartPanel);
                        mainPanel.revalidate();
                        mainPanel.repaint();
                        statusLabel.setText("Diagram generated.");
                    } catch (IOException ex) {
                        statusLabel.setText("Error: " + ex.getMessage());
                    }
                } else {
                    statusLabel.setText("Error: No Excel file loaded.");
                }
            }
        });

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(loadExcelButton);
        buttonPanel.add(generateDiagramButton);
        add(buttonPanel, BorderLayout.NORTH);

        statusLabel = new JLabel("Ready.");
        add(statusLabel, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                MainWindow mainWindow = new MainWindow();
                mainWindow.setVisible(true);
            }
        });
    }
}
