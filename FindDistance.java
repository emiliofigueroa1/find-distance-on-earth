import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class FindDistance extends JFrame {
    private JTextField startCityField;
    private JTextField endCityField;
    private JButton submitButton;
    private JLabel resultLabel;
    private JLabel warningLabel;

    public FindDistance() {
        setTitle("Find Distance");
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Panel for input fields
        JPanel inputPanel = new JPanel(new GridLayout(2, 2));
        JLabel startCityLabel = new JLabel("Start City:");
        startCityField = new JTextField();
        JLabel endCityLabel = new JLabel("End City:");
        endCityField = new JTextField();

        inputPanel.add(startCityLabel);
        inputPanel.add(startCityField);
        inputPanel.add(endCityLabel);
        inputPanel.add(endCityField);

        // Panel for the button and warning label
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS));
        buttonPanel.add(Box.createVerticalGlue()); // Add vertical glue to push components to the center

        submitButton = new JButton("Submit");
        submitButton.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the button
        buttonPanel.add(submitButton);

        // Add space between the button and the label
        buttonPanel.add(Box.createVerticalStrut(5)); // Add vertical space of 10 pixels

        warningLabel = new JLabel(
                "Results are NOT ALWAYS ACCURATE. results may be: 100 miles < REALITY < 100 miles",
                SwingConstants.CENTER);
        warningLabel.setAlignmentX(Component.CENTER_ALIGNMENT); // Center the warning label
        buttonPanel.add(warningLabel);

        buttonPanel.add(Box.createVerticalGlue()); // Add vertical glue to push components to the center

        // Result label
        resultLabel = new JLabel("Result will be shown here", SwingConstants.CENTER);

        // Add panels to frame
        add(inputPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.CENTER); // Add the button panel to the center
        add(resultLabel, BorderLayout.SOUTH);

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String startCity = startCityField.getText();
                String endCity = endCityField.getText();

                GeoInformation info = new GeoInformation(startCity, endCity);
                DistanceCalculatorEarth distance;
                try {
                    String startLat = info.getCoordinatesStart().getLatitude();
                    String startLon = info.getCoordinatesStart().getLongitude();
                    String endLat = info.getCoordinatesEnd().getLatitude();
                    String endLon = info.getCoordinatesEnd().getLongitude();

                    distance = new DistanceCalculatorEarth(Double.parseDouble(startLat), Double.parseDouble(endLat),
                            Double.parseDouble(startLon), Double.parseDouble(endLon));
                    resultLabel.setText("Kilometers: " + distance.getDistanceKilometers() + ", Miles: "
                            + distance.getDistanceMiles());
                } catch (IOException a) {
                    System.err.println();
                }

            }
        });

        setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new FindDistance();
    }
}
