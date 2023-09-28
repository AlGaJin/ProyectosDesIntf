import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Ejemplo de JFileChooser y JMenuBar");
        frame.getContentPane().add(new FormulariTxtEdt(frame).getPanel1());
        frame.setSize(600,600);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
