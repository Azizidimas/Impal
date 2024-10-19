import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TransferPulsa {

    public TransferPulsa(MainMenuGUI mainMenu) {
        // Create a new frame for the recipient input
        JFrame transferFrame = new JFrame("Transfer Pulsa - Step 1");
        transferFrame.setSize(400, 200);
        transferFrame.setResizable(false);
        transferFrame.setLayout(new BorderLayout());
        
        JLabel transferLabel = new JLabel("Silahkan masukkan nomor tujuan Transfer Pulsa:");
        transferLabel.setHorizontalAlignment(SwingConstants.CENTER);
        transferLabel.setFont(new Font("Arial", Font.BOLD, 14));
        transferFrame.add(transferLabel, BorderLayout.NORTH);
        
        JTextField recipientField = new JTextField(20);
        recipientField.setHorizontalAlignment(JTextField.CENTER);
        recipientField.setFont(new Font("Arial", Font.PLAIN, 14));
        recipientField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));


        JPanel centerPanel = new JPanel();
        centerPanel.add(recipientField);
        transferFrame.add(centerPanel, BorderLayout.CENTER);


        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 10, 10));

        JButton cancelButton = new JButton("Cancel");
        JButton nextButton = new JButton("Next");

        buttonPanel.add(cancelButton);
        buttonPanel.add(nextButton);

        transferFrame.add(buttonPanel, BorderLayout.SOUTH);

        cancelButton.addActionListener(e -> transferFrame.dispose());

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String recipient = recipientField.getText();
                if (recipient.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid recipient number.");
                } else {
                    transferFrame.dispose();
                    new AmountPulsa(mainMenu, recipient);
                }
            }
        });

        transferFrame.setVisible(true);
    }
}
