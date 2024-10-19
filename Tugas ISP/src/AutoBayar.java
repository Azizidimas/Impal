import javax.swing.*;

public class AutoBayar {

    public AutoBayar() {
        int choice = JOptionPane.showConfirmDialog(null,
                "Apakah Anda ingin mendaftar untuk Akses Internet Unlimited sebesar 80.000 pulsa/bulan?",
                "Auto Bayar Subscription",
                JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Anda telah berhasil mendaftar Auto Bayar sebesar 80.000 pulsa/bulan.");
        } else if (choice == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Auto Bayar dibatalkan.");
        }
    }
}
