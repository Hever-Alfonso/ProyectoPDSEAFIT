package frontend;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class LoginPage {

    public static void main(String[] args) {
        // Crear el frame principal con título y configuración básica
        JFrame frame = new JFrame("Bienvenido/a");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setLayout(new BorderLayout());

        // Panel para el título en la parte superior
        JPanel titlePanel = new JPanel();
        JLabel titleLabel = new JLabel("Bienvenido/a");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 32));
        titlePanel.add(titleLabel);
        frame.add(titlePanel, BorderLayout.NORTH);

        // Panel que contendrá los formularios de registro e inicio de sesión
        JPanel formsPanel = new JPanel(new GridLayout(1, 2, 20, 0)); // 1 fila, 2 columnas, espacio horizontal
        frame.add(formsPanel, BorderLayout.CENTER);

        // -------------------------------------------
        // Panel de Registro (lado izquierdo)
        // -------------------------------------------
        JPanel registerPanel = new JPanel(new GridBagLayout());
        registerPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Márgenes alrededor del panel
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10); // Espacio entre componentes
        gbc.fill = GridBagConstraints.HORIZONTAL;
        formsPanel.add(registerPanel);

        // Añadir componentes al panel de registro
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        registerPanel.add(new JLabel("<html>¿Es la primera vez que vas a ingresar a nuestra página web?</html>"), gbc);

        gbc.gridy++; gbc.gridwidth = 1;
        registerPanel.add(new JLabel("Correo electrónico:"), gbc);
        gbc.gridx = 1;
        JTextField registerEmail = new JTextField(20);
        registerPanel.add(registerEmail, gbc);

        gbc.gridx = 0; gbc.gridy++;
        registerPanel.add(new JLabel("Contraseña:"), gbc);
        gbc.gridx = 1;
        JPasswordField registerPassword = new JPasswordField(20);
        registerPanel.add(registerPassword, gbc);

        gbc.gridx = 0; gbc.gridy++; gbc.gridwidth = 2;
        registerPanel.add(new JLabel("¿Cuál es tu rol académico?"), gbc);

        gbc.gridy++;
        // Crear los JRadioButton y el ButtonGroup
        JRadioButton docenteRadio = new JRadioButton("Docente");
        JRadioButton estudianteRadio = new JRadioButton("Estudiante");
        ButtonGroup roleGroup = new ButtonGroup();
        roleGroup.add(docenteRadio);
        roleGroup.add(estudianteRadio);

        JPanel rolePanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 10, 0));
        rolePanel.add(docenteRadio);
        rolePanel.add(estudianteRadio);
        registerPanel.add(rolePanel, gbc);

        gbc.gridy++;
        JButton registerButton = new JButton("Registrarme por primera vez");
        registerButton.setForeground(Color.BLACK); // Texto en negro
        registerButton.setBackground(Color.WHITE); // Fondo en blanco
        registerButton.setFocusPainted(false);
        registerButton.setPreferredSize(new Dimension(220, 40)); // Tamaño más grande para registro
        registerPanel.add(registerButton, gbc);

        // -------------------------------------------
        // Panel de Inicio de Sesión (lado derecho)
        // -------------------------------------------
        JPanel loginPanel = new JPanel(new GridBagLayout());
        loginPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20)); // Márgenes alrededor del panel
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.insets = new Insets(10, 10, 10, 10);
        gbc2.fill = GridBagConstraints.HORIZONTAL;
        formsPanel.add(loginPanel);

        // Añadir componentes al panel de inicio de sesión
        gbc2.gridx = 0; gbc2.gridy = 0; gbc2.gridwidth = 2;
        loginPanel.add(new JLabel("¿Ya estás registrado?"), gbc2);

        gbc2.gridy++; gbc2.gridwidth = 1;
        loginPanel.add(new JLabel("Correo electrónico:"), gbc2);
        gbc2.gridx = 1;
        JTextField loginEmail = new JTextField(20);
        loginPanel.add(loginEmail, gbc2);

        gbc2.gridx = 0; gbc2.gridy++;
        loginPanel.add(new JLabel("Contraseña:"), gbc2);
        gbc2.gridx = 1;
        JPasswordField loginPassword = new JPasswordField(20);
        loginPanel.add(loginPassword, gbc2);

        gbc2.gridy++; gbc2.gridx = 1;
        JButton loginButton = new JButton("Iniciar sesión");
        loginButton.setForeground(Color.BLACK); // Texto en negro
        loginButton.setBackground(Color.WHITE); // Fondo en blanco
        loginButton.setFocusPainted(false);
        loginButton.setPreferredSize(new Dimension(150, 40)); // Tamaño más pequeño para login
        loginPanel.add(loginButton, gbc2);

        gbc2.gridy++; gbc2.gridx = 0; gbc2.gridwidth = 2;
        JLabel noteLabel = new JLabel("<html>Nota: Si olvidaste tu contraseña puedes ponerte en contacto con nosotros por medio de<br/>el siguiente correo para enviarte tu contraseña: soporte@empresa.com</html>");
        noteLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        loginPanel.add(noteLabel, gbc2);

        // -------------------------------------------
        // Acciones de los botones
        // -------------------------------------------

        // Acción del botón de registro
        registerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = registerEmail.getText();
                String password = new String(registerPassword.getPassword());
                boolean isDocente = docenteRadio.isSelected();
                boolean isEstudiante = estudianteRadio.isSelected();

                // Verificar que los campos no estén vacíos y que se seleccione un rol
                if (email.isEmpty() || password.isEmpty() || (!isDocente && !isEstudiante)) {
                    JOptionPane.showMessageDialog(frame, "Por favor, completa todos los campos y selecciona tu rol académico.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Aquí iría la lógica para registrar al usuario
                    String rol = isDocente ? "Docente" : "Estudiante";
                    JOptionPane.showMessageDialog(frame, "Registro exitoso como " + rol + ".", "Registro", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Acción del botón de inicio de sesión
        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String email = loginEmail.getText();
                String password = new String(loginPassword.getPassword());

                // Verificar que los campos no estén vacíos
                if (email.isEmpty() || password.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Por favor, ingresa tu correo electrónico y contraseña.", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    // Aquí iría la lógica para autenticar al usuario
                    JOptionPane.showMessageDialog(frame, "Inicio de sesión exitoso.", "Login", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        // Mostrar la ventana principal
        frame.setVisible(true);
    }
}