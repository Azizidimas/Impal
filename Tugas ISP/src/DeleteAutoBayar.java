import javax.swing.*;

public class DeleteAutoBayar {

    public DeleteAutoBayar() {
        int choice = JOptionPane.showConfirmDialog(null,
                "Apakah Anda ingin membatalkan langganan Auto Bayar untuk Akses Internet Unlimited sebesar 80.000 pulsa/bulan?",
                "Hapus Auto Bayar",
                JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {
            JOptionPane.showMessageDialog(null, "Anda telah berhasil membatalkan langganan Auto Bayar.");
        } else if (choice == JOptionPane.NO_OPTION) {
            JOptionPane.showMessageDialog(null, "Auto Bayar tetap aktif.");
        }
    }
}
