import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class roldepagos extends JFrame {
    private JTabbedPane tabbedPane1;
    private JPanel panelApp;
    private JTextField textFieldCedula;

       //
    private JTextField textFieldNombre;
    private JTextField textFieldSueldo;
    private JButton registrarUsuarioButton;
    private JTextField textFieldCedulaR;
    private JTextField textFieldNombreR;
    private JTextField textFieldSueldoR;
    private JButton modificarUsuarioButton;
    private JButton ImprimirListaButton;
    private JTextArea textArea1;
    private JButton ImprimirInformeButton;
    private JTextArea textArea2;
    Institucion fu = new Institucion();

    public roldepagos() {
        setContentPane(panelApp);

        registrarUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                registrarEmpleado();
            }
        });
        modificarUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                modificarEmpleado();
            }
        });
        ImprimirListaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verLista();
            }
        });
        ImprimirInformeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verInforme();
            }
        });
        textFieldCedula.addKeyListener(new KeyAdapter() {
        });
        textFieldCedula.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                    char c = e.getKeyChar();
                    if (!Character.isDigit(c)) {
                        e.consume();
                    }
                }
        });
        textFieldCedula.addKeyListener(new KeyAdapter() {
        });
        textFieldNombre.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isDigit(c)) {
                    e.consume();
                }

            }
        });
        textFieldSueldo.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }

            }
        });
        textFieldCedulaR.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
        textFieldSueldoR.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
        textFieldNombreR.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (Character.isDigit(c)) {
                    e.consume();
                }
            }
        });
        textFieldCedulaR.addKeyListener(new KeyAdapter() {
        });
        textFieldCedulaR.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || textFieldCedulaR.getText().length() >= 10) {
                    e.consume();
                }
            }
        });
        textFieldCedula.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if (!Character.isDigit(c) || textFieldCedula.getText().length() >= 10) {
                    e.consume();
                }
            }
        });
    }

    public void registrarEmpleado(){
        if(fu.registrarEmpleado(textFieldCedula.getText(), textFieldNombre.getText(), Double.parseDouble(textFieldSueldo.getText()))){
            JOptionPane.showMessageDialog(null, "Funcionario Agregado con éxito");
        }else{
            JOptionPane.showMessageDialog(null, "El funcionario ya está en el sistema");
        }
    }

    public void modificarEmpleado(){
        if(fu.modificarFuncionario(textFieldCedulaR.getText(), textFieldNombreR.getText(), Double.parseDouble(textFieldSueldoR.getText())) == null){
            JOptionPane.showMessageDialog(null, "No se ha registrado un funcionario con esa cédula");
        }else{
            JOptionPane.showMessageDialog(null, "El funcionario con cédula: " + textFieldCedula.getText() + " se ha modificado correctamente");
        }
    }

    public void verLista(){
        if (fu.listarFuncionarios().equals("")) {
            textArea1.setText("No hay funcionarios");
        } else {
            textArea1.setText(fu.listarFuncionarios());
        }
    }

    public void verInforme(){
        if (fu.generarInforme().equals("")) {
            textArea2.setText("No se han registrado funcionarios");
        } else {
            textArea2.setText(fu.generarInforme());
        }
    }

}