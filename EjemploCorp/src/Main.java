import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("EjemploCorp");
        frame.getContentPane().add(new FormEjemploCorp(frame).getPanel1());
        frame.setSize(600,350);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
