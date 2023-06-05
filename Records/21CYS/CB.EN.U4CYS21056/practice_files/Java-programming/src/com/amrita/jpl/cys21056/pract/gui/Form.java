
package com.amrita.jpl.cys21056.pract.gui ;

import javax.swing.*;
import java.awt.BorderLayout;


public class Form {
    public static void main(String[] args) {
        // Create a JFrame to hold the form components
        JFrame frame = new JFrame("Form Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create the form components
        JLabel nameLabel = new JLabel("Name:");
        JTextField nameField = new JTextField(20);

        JLabel emailLabel = new JLabel("Email:");
        JTextField emailField = new JTextField(20);

        JLabel passwordLabel = new JLabel("Password:");
        JPasswordField passwordField = new JPasswordField(20);

        JButton submitButton = new JButton("Submit");

        // Create a panel and set the layout manager
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());

        // Add the components to the panel
        panel.add(nameLabel, BorderLayout.WEST);
        panel.add(nameField, BorderLayout.CENTER);

        panel.add(emailLabel, BorderLayout.WEST);
        panel.add(emailField, BorderLayout.CENTER);

        panel.add(passwordLabel, BorderLayout.WEST);
        panel.add(passwordField, BorderLayout.CENTER);

        panel.add(submitButton, BorderLayout.SOUTH);

        // Add the panel to the frame
        frame.getContentPane().add(panel);

        // Set the frame size and make it visible
        frame.setSize(300, 200);
        frame.setVisible(true);
    }
}
