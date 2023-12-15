import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
                }else
                    JOptionPane.showMessageDialog(panel1,"Introduzca los datos necesarios");
            }
        });

        eliminarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectRow = table1.getSelectedRow();
                if(selectRow != -1){
                    tableModel.removeRow(selectRow);
                }else
                    JOptionPane.showMessageDialog(panel1,"No ha seleccionado ningún contacto");
            }
        });

        editarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectRow = table1.getSelectedRow();
                String nombre = txtFNombre.getText();
                String email = txtFieldEmail.getText();

                if(selectRow != -1){
                    if(!nombre.isEmpty())
                        tableModel.setValueAt(nombre,selectRow,0);
                    if(!email.isEmpty())
                        tableModel.setValueAt(email,selectRow,1);

                    txtFNombre.setText("");
                    txtFieldEmail.setText("");
                }else
                    JOptionPane.showMessageDialog(panel1,"No ha seleccionado ningún contacto");
            }
        });
    }
}
