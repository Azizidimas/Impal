import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DaftarKTP {

    public DaftarKTP() {
        JFrame ktpFrame = new JFrame("Daftar KTP");
        ktpFrame.setSize(400, 200);
        ktpFrame.setResizable(false);
        ktpFrame.setLayout(new BorderLayout());

        JLabel ktpLabel = new JLabel("Silahkan masukkan nomor KTP Anda (16 digit):");
        ktpLabel.setHorizontalAlignment(SwingConstants.CENTER);
        ktpLabel.setFont(new Font("Arial", Font.BOLD, 14));
        ktpFrame.add(ktpLabel, BorderLayout.NORTH);

        JTextField ktpField = new JTextField(20);
        ktpField.setHorizontalAlignment(JTextField.CENTER);
        ktpField.setFont(new Font("Arial", Font.PLAIN, 14));
        ktpField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2));

        JPanel centerPanel = new JPanel();
        centerPanel.add(ktpField);
        ktpFrame.add(centerPanel, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 10, 10));

        JButton cancelButton = new JButton("Cancel");
        JButton submitButton = new JButton("Submit");

        buttonPanel.add(cancelButton);
        buttonPanel.add(submitButton);

        ktpFrame.add(buttonPanel, BorderLayout.SOUTH);

        cancelButton.addActionListener(e -> ktpFrame.dispose());

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String ktpNumber = ktpField.getText();

                // Check if the input is exactly 16 digits and numeric
                if (ktpNumber.matches("\\d{16}")) {
                    JOptionPane.showMessageDialog(null, "KTP Anda valid. Terima kasih telah mendaftar!");
                    ktpFrame.dispose(); // Close the window on successful validation
                } else {
                    JOptionPane.showMessageDialog(null, "Nomor KTP tidak valid. Pastikan 16 digit dan hanya angka.");
                }
            }
        });

        ktpFrame.setVisible(true);
    }
}
