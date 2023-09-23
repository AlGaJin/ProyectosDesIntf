import javax.swing.*;

public class Main {
    public static void main(String[] args){
        JFrame frame = new JFrame("Gestor de contactos");
        frame.getContentPane().add(new FormularioGestorCont().getPanel1());
        frame.setSize(500,400);

        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
}
