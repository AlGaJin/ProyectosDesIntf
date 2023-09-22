import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lista {
    private JPanel panel1;
    private JTextField textField1;
    private JButton eliminarButton;
    private JButton agregarButton;
    private JList list1;
    public JPanel getPanel1() {
        return panel1;
    }
    private DefaultListModel<String> listModel = new DefaultListModel<>();
    public Lista() {
        list1.setModel(listModel);

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nuevoElemento = textField1.getText().trim();

                if(!nuevoElemento.isEmpty()){
                    listModel.addElement(nuevoElemento);
                    textField1.setText("");
                }
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int elementoSelec = list1.getSelectedIndex();
                if(elementoSelec >= 0)
                    listModel.remove(elementoSelec);
            }
        });
    }
}
