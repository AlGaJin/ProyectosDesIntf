import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class FormulariTxtEdt{

    private JPanel panel1;

    public JPanel getPanel1() {
        return panel1;
    }
    private JTextArea textArea1;
    private JFileChooser fCh;
    private JMenuBar mBar;
    private JMenu mMenu;
    private JMenuItem mAbrir, mGuardar;
    FormulariTxtEdt(JFrame frame){
        fCh = new JFileChooser();
        mMenu = new JMenu("Archivos");
        mBar = new JMenuBar();
        mAbrir = new JMenuItem("Abir");
        mGuardar = new JMenuItem("Guardar");

        frame.setJMenuBar(mBar);
        mBar.add(mMenu);
        mMenu.add(mAbrir);
        mMenu.add(mGuardar);

        mAbrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(fCh.showOpenDialog(frame) != JFileChooser.CANCEL_OPTION){
                    File f = fCh.getSelectedFile();
                    try {
                        FileReader fR = new FileReader(f.getAbsolutePath());
                        BufferedReader bfR = new BufferedReader(fR);
                        String linea;
                        while((linea = bfR.readLine()) != null){
                            textArea1.append(linea+"\n");
                        }
                        fR.close();
                        bfR.close();
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(panel1,"Error inesperado");
                    }
                }
            }
        });

        mGuardar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(fCh.showOpenDialog(frame) != JFileChooser.CANCEL_OPTION){
                    File f = fCh.getSelectedFile();
                    try{
                        if(f.createNewFile()){
                            FileWriter fW = new FileWriter(f.getAbsolutePath());
                            fW.write(textArea1.getText());
                            fW.close();
                        }else
                            JOptionPane.showMessageDialog(panel1,"No se ha podido guardar el archivo");
                    }catch (Exception exc){
                        JOptionPane.showMessageDialog(panel1,"Error inesperado.");
                    }
                }
            }
        });
    }
}
