import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class FormularioGestorCont {
    private JPanel panel1;
    private JTextField txtFNombre;
    private JTextField txtFieldEmail;
    private JButton agregarButton;
    private JButton editarButton;
    private JButton eliminarButton;
    private JTable table1;
    private DefaultTableModel tableModel = new DefaultTableModel();
    public JPanel getPanel1() {
        return panel1;
    }

    public FormularioGestorCont(){
        table1.setModel(tableModel);
        tableModel.addColumn("Nombre");
        tableModel.addColumn("Email");

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nombre = txtFNombre.getText();
                String email = txtFieldEmail.getText();

                if(!nombre.isEmpty() && !email.isEmpty()){
                    tableModel.addRow(new String[]{nombre, email});
                    txtFNombre.setText("");
                    txtFieldEmail.setText("");
                }
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectRow = table1.getSelectedRow();
                if(selectRow != -1){
                    tableModel.removeRow(selectRow);
                }
            }
        });

        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectRow = table1.getSelectedRow();
                String nombre = txtFNombre.getText();
                String email = txtFieldEmail.getText();

                if(selectRow != -1 && !nombre.isEmpty() && !email.isEmpty()){
                    tableModel.removeRow(selectRow);
                    tableModel.addRow(new String[]{nombre, email});
                    txtFNombre.setText("");
                    txtFieldEmail.setText("");
                }
            }
        });
    }
}
