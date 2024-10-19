import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MainMenuGUI {

    // A list to store transaction history
    private ArrayList<String> history = new ArrayList<>();

    public MainMenuGUI() {
        JFrame frame = new JFrame("Selamat Datang Di Menu 808");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 400);
        frame.setResizable(false);

        frame.setLayout(new BorderLayout());

        JLabel topLabel = new JLabel("Mau Dapat Uang Cepat? Daftarkan KTP Anda di 808");
        topLabel.setHorizontalAlignment(SwingConstants.CENTER);
        topLabel.setFont(new Font("Arial", Font.PLAIN, 9));
        topLabel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10)); 
        frame.add(topLabel, BorderLayout.NORTH);

        JTextArea menuArea = new JTextArea(
                "1. Transfer Pulsa\n" +
                "2. Minta Pulsa\n" +
                "3. Auto Bayar\n" +
                "4. Delete Auto Bayar\n" +
                "5. Riwayat\n" +
                "6. Daftar KTP\n" +
                "7. Exit"
        );
        menuArea.setEditable(false);
        menuArea.setFont(new Font("Arial", Font.PLAIN, 16));
        menuArea.setMargin(new Insets(10, 10, 10, 10)); 
        frame.add(menuArea, BorderLayout.CENTER);

        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout());

        JTextField inputField = new JTextField();
        inputField.setHorizontalAlignment(JTextField.CENTER);
        inputField.setFont(new Font("Arial", Font.PLAIN, 16)); 
        inputField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 2)); 
        bottomPanel.add(inputField, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 2, 10, 10)); 

        JButton cancelButton = new JButton("Cancel");
        JButton sendButton = new JButton("Send");

        buttonPanel.add(cancelButton);
        buttonPanel.add(sendButton);

        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);
        frame.add(bottomPanel, BorderLayout.SOUTH);

        cancelButton.addActionListener(e -> frame.dispose());

        sendButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = inputField.getText();
                handleMenuSelection(input);
            }
        });

        frame.setVisible(true);
    }

    // add details to the transaction history
    public void addHistory(String transaction) {
        history.add(transaction);
    }

    // handle the user input
    private void handleMenuSelection(String input) {
        switch (input) {
            case "1":
                new TransferPulsa(this);
                break;
            case "2":
                new MintaPulsa(this);
                break;
            case "3":
                new AutoBayar();
                history.add("Auto Bayar subscribed.");
                break;
            case "4":
                new DeleteAutoBayar();
                history.add("Auto Bayar canceled.");
                break;
            case "5":
                if (history.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Riwayat kosong. Tidak ada transaksi yang dilakukan.");
                } else {
                    new Riwayat(history.toArray(new String[0]));
                }
                break;
            case "6":
                new DaftarKTP();
                break;
            case "7":
                JOptionPane.showMessageDialog(null, "Exiting the application.");
                System.exit(0);
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid selection.");
                break;
        }
    }
    
    public static void main(String[] args) {
        new MainMenuGUI();
    }
}
