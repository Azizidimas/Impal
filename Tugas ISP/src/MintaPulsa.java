import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MintaPulsa {

    public MintaPulsa(MainMenuGUI mainMenu) {
        JFrame mintaFrame = new JFrame("Minta Pulsa - Step 1");
        mintaFrame.setSize(400, 200);
        mintaFrame.setResizable(false);
        mintaFrame.setLayout(new BorderLayout());

        JLabel mintaLabel = new JLabel("Silahkan masukkan nomor dari siapa Anda minta pulsa:");
        mintaLabel.setHorizontalAlignment(SwingConstants.CENTER);
        mintaLabel.setFont(new Font("Arial", Font.BOLD, 14));
        mintaFrame.add(mintaLabel, BorderLayout.NORTH);

        JTextField recipientField = new JTextField(20);
        recipientField.setHorizontalAlignment(JTextField.CENTER);
        recipientField.setFont(new Font("Arial", Font.PLAIN, 14));
        recipientField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));

        JPanel centerPanel = new JPanel();
        centerPanel.add(recipientField);
        mintaFrame.add(centerPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 10, 10));

        JButton cancelButton = new JButton("Cancel");
        JButton nextButton = new JButton("Next");

        buttonPanel.add(cancelButton);
        buttonPanel.add(nextButton);

        mintaFrame.add(buttonPanel, BorderLayout.SOUTH);

        cancelButton.addActionListener(e -> mintaFrame.dispose());

        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String recipient = recipientField.getText();
                if (recipient.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid recipient number.");
                } else {
                    mintaFrame.dispose();
                    new AmountMintaPulsa(mainMenu, recipient);
                }
            }
        });

        mintaFrame.setVisible(true);
    }
}
