import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormEjemploCorp {

    private JPanel panel1;
    private JTextField nombreTxtF;
    private JTextField emailTxtF;
    private JTextField tlfTxtF;
    private JTextField dirTxtF;
    private JTextArea msgTxtA;
    private JCheckBox boletinCBox;
    private JCheckBox promoCBox;
    private JRadioButton mascRBtn;
    private JRadioButton femRBtn;
    private JRadioButton otroRBtn;
    private JButton enviarButton;
    private JMenuBar mBar;
    private JMenu menu;
    private JMenuItem iniItem, servicioItem, acercaDeNosotrosItem, contactoItem;
    public JPanel getPanel1() {
        return panel1;
    }

    FormEjemploCorp(JFrame frame){
        mBar = new JMenuBar();
        menu = new JMenu("Inicio");
        iniItem = new JMenuItem("Inicio");
        servicioItem = new JMenuItem("Servicios");
        acercaDeNosotrosItem = new JMenuItem("Acerca de nosotros");
        contactoItem = new JMenuItem("Contacto");
        mBar.add(menu);
        menu.add(iniItem);
        menu.add(servicioItem);
        menu.add(acercaDeNosotrosItem);
        menu.add(contactoItem);

        frame.setJMenuBar(mBar);

        ButtonGroup radioGrp = new ButtonGroup();
        radioGrp.add(mascRBtn);
        radioGrp.add(femRBtn);
        radioGrp.add(otroRBtn);
        otroRBtn.setSelected(true);

        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String res = "";
                if(nombreTxtF.getText().isEmpty() || dirTxtF.getText().isEmpty() || tlfTxtF.getText().isEmpty() ||
                msgTxtA.getText().isEmpty() || emailTxtF.getText().isEmpty()){
                    res = "Rellene todos los campos, por favor";
                }else{
                    res = "Nombre: " + nombreTxtF.getText() + "\n"
                        + "Correo electrónico: " + emailTxtF.getText() +"\n"
                        + "Teléfono: " + tlfTxtF.getText() + "\n"
                        + "Dirección: " + dirTxtF.getText() + "\n"
                        + "Mensaje: " + msgTxtA.getText() + "\n"
                        + "Subscripción al boletín: " + boletinCBox.isSelected() + "\n"
                        + "Recibir promociones: " + promoCBox.isSelected() + "\n"
                        + "Género: ";

                    if(mascRBtn.isSelected())
                        res += "Masculino";
                    else if(femRBtn.isSelected())
                        res += "Femenino";
                    else
                        res += "Otro";

                }

                JOptionPane.showMessageDialog(panel1, res);
            }
        });
    }

}
