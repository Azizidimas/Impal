import javax.swing.*;
import java.awt.*;

public class Riwayat {

    public Riwayat(String[] history) {
        JFrame riwayatFrame = new JFrame("Riwayat Transaksi");
        riwayatFrame.setSize(400, 300);
        riwayatFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea historyArea = new JTextArea();
        historyArea.setEditable(false);
        historyArea.setFont(new Font("Arial", Font.PLAIN, 14));

        for (String entry : history) {
            historyArea.append(entry + "\n");
        }

        JScrollPane scrollPane = new JScrollPane(historyArea);
        riwayatFrame.add(scrollPane);
        riwayatFrame.setVisible(true);
    }
}
