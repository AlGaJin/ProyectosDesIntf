import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormConfgPref {
    private JTextField textField1;
    private JCheckBox habNotfChBx;
    private JRadioButton opc1RBtn;
    private JRadioButton opc2RBtn;
    private ButtonGroup rBtnGroup;
    private JSpinner nElmtSpinner;
    private JButton guardarPrefBtn;
    private JPanel panel;
    public JPanel getPanel() {
        return panel;
    }
    private JMenuBar mBar;
    private JMenu menu;
    private JMenuItem guardarPrefMItm;
    private void guardarPref(){
        if (!textField1.getText().isEmpty()){
            String finalText = "Nombre: " + textField1.getText() + "\n" +
                    "Notificaciones habilitadas: ";

            if (habNotfChBx.isSelected())
                finalText += "Sí";
            else
                finalText += "No";

            finalText += "\nOpción seleccionada: ";

            String opcSelec = opc1RBtn.isSelected() ? "Opción 1" : "Opción 2";

            finalText += opcSelec + "\nNúmero de elementos: " + (int) nElmtSpinner.getValue();

            JOptionPane.showMessageDialog(panel, finalText);
        }else
            JOptionPane.showMessageDialog(panel, "Introduce todos los datos");
    }
    FormConfgPref(JFrame frame){
        habNotfChBx.setSelected(true);
        rBtnGroup = new ButtonGroup();
        rBtnGroup.add(opc1RBtn);
        rBtnGroup.add(opc2RBtn);
        opc1RBtn.setSelected(true);

        nElmtSpinner.setModel(new SpinnerNumberModel(1,1,10,1));

        mBar = new JMenuBar();
        menu = new JMenu("Archivo");
        guardarPrefMItm = new JMenuItem("Guardar preferencias");
        frame.setJMenuBar(mBar);
        mBar.add(menu);
        menu.add(guardarPrefMItm);

        guardarPrefMItm.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarPref();
            }
        });

        guardarPrefBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                guardarPref();
            }
        });
    }
}
