import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AmountMintaPulsa {

    public AmountMintaPulsa(MainMenuGUI mainMenu, String recipient) {
        JFrame amountFrame = new JFrame("Minta Pulsa - Step 2");
        amountFrame.setSize(400, 200);
        amountFrame.setResizable(false);
        amountFrame.setLayout(new BorderLayout());

        JLabel amountLabel = new JLabel("Masukkan jumlah pulsa yang ingin diminta dari nomor: " + recipient);
        amountLabel.setHorizontalAlignment(SwingConstants.CENTER);
        amountLabel.setFont(new Font("Arial", Font.BOLD, 14));
        amountFrame.add(amountLabel, BorderLayout.NORTH);

        JTextField amountField = new JTextField(10);
        amountField.setHorizontalAlignment(JTextField.CENTER);
        amountField.setFont(new Font("Arial", Font.PLAIN, 14));
        amountField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));

        JPanel centerPanel = new JPanel();
        centerPanel.add(amountField);
        amountFrame.add(centerPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 10, 10));

        JButton cancelButton = new JButton("Cancel");
        JButton sendButton = new JButton("Send");

        buttonPanel.add(cancelButton);
        buttonPanel.add(sendButton);

        amountFrame.add(buttonPanel, BorderLayout.SOUTH);

        cancelButton.addActionListener(e -> amountFrame.dispose());

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String amount = amountField.getText();
                if (amount.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter a valid amount.");
                } else {
                    mainMenu.addHistory("Minta Pulsa sebesar " + amount + " dari nomor " + recipient);
                    JOptionPane.showMessageDialog(null, "Permintaan Pulsa sebesar " + amount + " dari nomor " + recipient + " telah dikirim.");
                    amountFrame.dispose();
                }
            }
        });

        amountFrame.setVisible(true);
    }
}
