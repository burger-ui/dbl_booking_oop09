import javax.swing.SwingUtilities;

public class dbrun {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BookingManager manager = new BookingManager();
            BookingUI ui = new BookingUI(manager);
            ui.setVisible(true);
        });
    }
}
