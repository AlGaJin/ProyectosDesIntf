import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de JFileChooser y JMenuBar");
        frame.getContentPane().add(new FormConfgPref(frame).getPanel());
        frame.setSize(350,350);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
