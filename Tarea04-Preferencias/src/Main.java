import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Configuración de preferencias");
        frame.getContentPane().add(new FormConfgPref(frame).getPanel());
        frame.setSize(350,350);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
