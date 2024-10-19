import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;


public class KeypadGUI {

    private static JTextField inputField;

    public KeypadGUI() {
        // Create the keypad frame
        JFrame frame = new JFrame("Dialer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 500);
        frame.setResizable(false);

        frame.setLayout(new BorderLayout());

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());

        inputField = new JTextField();
        inputField.setHorizontalAlignment(JTextField.CENTER);
        inputField.setFont(new Font("Arial", Font.PLAIN, 16));
        inputField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));

        bottomPanel.add(inputField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 10, 10));

        // Create Cancel and Send buttons
        JButton cancelButton = new JButton("Cancel");
        JButton sendButton = new JButton("Send");
        buttonPanel.add(cancelButton);
        buttonPanel.add(sendButton);
        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        // Create a panel for the 3x4 number grid (number pad with *, 0, #)
        JPanel numberGrid = new JPanel(new GridLayout(4, 3, 10, 10));

        // Add buttons for 1 to 9
        for (int i = 1; i <= 9; i++) {
            String num = String.valueOf(i);
            JButton numberButton = new JButton(num);
            numberButton.setFont(new Font("Arial", Font.BOLD, 20));
            numberButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    appendToInputField(num);
                }
            });
            numberGrid.add(numberButton);
        }

        // Add *, 0, # buttons to the grid
        JButton starButton = new JButton("*");
        starButton.setFont(new Font("Arial", Font.BOLD, 20));
        starButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appendToInputField("*");
            }
        });
        numberGrid.add(starButton);

        JButton zeroButton = new JButton("0");
        zeroButton.setFont(new Font("Arial", Font.BOLD, 20));
        zeroButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appendToInputField("0");
            }
        });
        numberGrid.add(zeroButton);

        JButton hashButton = new JButton("#");
        hashButton.setFont(new Font("Arial", Font.BOLD, 20));
        hashButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                appendToInputField("#");
            }
        });
        numberGrid.add(hashButton);
        frame.add(numberGrid, BorderLayout.NORTH);

        // Set ActionListener for Cancel button
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Operation canceled.");
                frame.dispose();
            }
        });

        // Set ActionListener for Send button
        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                if (input.equals("#808*")) {
                    frame.dispose();
                    new MainMenuGUI();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid input. Please enter #808* to proceed.");
                }
            }
        });
        
        frame.setVisible(true);
    }

    private static void appendToInputField(String num) {
        inputField.setText(inputField.getText() + num);
    }

    public static void main(String[] args) {
        new KeypadGUI();
    }
}
