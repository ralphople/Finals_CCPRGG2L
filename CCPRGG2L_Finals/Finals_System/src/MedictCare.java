import java.awt.*;
import java.awt.event.*; 
import javax.swing.*;

public class MedictCare {
    public static void main (String args[]) {
        GUI1 finalsGUI = new GUI1();
    }
}

class GUI1 implements ActionListener {
    JFrame frame1 = new JFrame("MedictCare - Login");

    public GUI1() {
        frame1.setSize(1000, 600);
        frame1.setLocationRelativeTo(null);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame1.setLayout(new GridLayout(1, 2));

        ImageIcon windowIcon = new ImageIcon("MedictCare Logo.png");
        JPanel leftPanel = createFormPanel();
        ImagePanel rightPanel = new ImagePanel("MedictCare LogReg.jpg");

        frame1.add(leftPanel);
        frame1.add(rightPanel);
        frame1.setIconImage(windowIcon.getImage());

        frame1.setVisible(true);
    }

    JButton loginBtn;
    JButton signUpBtn;
    private JPanel createFormPanel() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Color.WHITE);
        GridBagConstraints gbc = new GridBagConstraints();

        // Layout style
        gbc.gridx = 0;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.insets = new Insets(5, 50, 5, 50);
        gbc.weightx = 1.0;
        
        int row = 0;

        // Logo Placeholder
        ImageIcon logoIcon = new ImageIcon("D:\\Finals_CCPRGG2L\\CCPRGG2L_Finals\\Finals_System\\src\\MedictCare Logo.png");
        Image scaledLogo = logoIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon finalLogo = new ImageIcon(scaledLogo);
        JLabel logo = new JLabel("MedictCare", finalLogo, SwingConstants.LEFT);
        logo.setFont(new Font("SansSerif", Font.BOLD, 32));
        logo.setForeground(new Color(108, 209, 96));
        gbc.gridy = row++;
        gbc.insets = new Insets(20, 50, 20, 50);
        panel.add(logo, gbc);

        // Subtext
        JLabel subText = new JLabel("<html> Please enter your details to proceed with your appointment.</html>");
        subText.setFont(new Font("SansSerif", Font.PLAIN, 12));
        gbc.gridy = row++;
        gbc.insets = new Insets(0, 50, 20, 50);
        panel.add(subText, gbc);

        // Username Label
        gbc.gridy = row++;
        gbc.insets = new Insets(0, 50, 5, 50);
        panel.add(new JLabel("Username:"), gbc);

        // Username Field
        JTextField userField = new JTextField();
        userField.setBorder(BorderFactory.createCompoundBorder(
            BorderFactory.createLineBorder(Color.GRAY, 1),
            BorderFactory.createEmptyBorder(5, 5, 5, 5)
        ));
        gbc.gridy = row++;
        gbc.insets = new Insets(0, 50, 20, 50);
        panel.add(userField, gbc);

        // Password Label
        gbc.gridy = row++;
        gbc.insets = new Insets(5, 50, 5, 50);
        panel.add(new JLabel("Password:"), gbc);

        
        JPanel passPanel = new JPanel(new BorderLayout());
        passPanel.setBackground(Color.WHITE);
        passPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1)); 

        // Create the Password Field 
        JPasswordField passfield = new JPasswordField();
        passfield.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 0));
        
        // Toggle Button
        JToggleButton showPassBtn = new JToggleButton("Show");
        showPassBtn.setFont(new Font("SansSerif", Font.BOLD, 10));
        showPassBtn.setForeground(Color.GRAY);
        showPassBtn.setBackground(Color.WHITE);
        showPassBtn.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        showPassBtn.setFocusPainted(false);
        showPassBtn.setContentAreaFilled(false);
        showPassBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        char defaultEchoChar = passfield.getEchoChar();

        showPassBtn.addActionListener(e -> {
            if (showPassBtn.isSelected()) {
                passfield.setEchoChar((char) 0); // Show password
                showPassBtn.setText("Hide");
            } else {
                passfield.setEchoChar(defaultEchoChar); // Hide password
                showPassBtn.setText("Show");
            }
        });

        passPanel.add(passfield, BorderLayout.CENTER);
        passPanel.add(showPassBtn, BorderLayout.EAST);

        gbc.gridy = row++;
        gbc.insets = new Insets(0, 50, 5, 50);
        panel.add(passPanel, gbc);
        

        // Forgot Password
        JLabel forgotPass = new JLabel("Forget Password?", SwingConstants.RIGHT);
        forgotPass.setFont(new Font("SansSerif", Font.PLAIN, 11));
        forgotPass.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        gbc.gridy = row++;
        gbc.insets = new Insets(5, 50, 20, 50);
        panel.add(forgotPass, gbc);

        // Log In 
        loginBtn = new JButton("Log In");
        loginBtn.addActionListener(this);
        loginBtn.setBackground(new Color(52, 72, 222));
        loginBtn.setForeground(Color.WHITE);
        loginBtn.setFocusPainted(false);
        gbc.gridy = row++;
        gbc.insets = new Insets(10, 50, 10, 50);
        panel.add(loginBtn, gbc);

        // Sign Up Button
        signUpBtn = new JButton("Sign Up");
        signUpBtn.setBackground(new Color(108, 209, 96));
        signUpBtn.setFocusPainted(false);
        signUpBtn.setForeground(Color.WHITE);

        signUpBtn.addActionListener(this);

        gbc.gridy = row++;
        panel.add(signUpBtn, gbc);

        // Checkboxes (Terms and Email notifications)
        gbc.insets = new Insets(10, 50, 2,50);
        JCheckBox termsCb = new JCheckBox("<html> By clicking, you agree to our <u> Terms & Conditions</u>  & <u> Privacy Policy</u>");
        termsCb.setBackground(Color.WHITE);
        termsCb.setFont(new Font("SansSerif", Font.PLAIN,10));
        gbc.gridy = row++;
        panel.add(termsCb, gbc);

        JCheckBox notifyCb = new JCheckBox("Send me notifications on my registered mobile number");
        notifyCb.setBackground(Color.WHITE);
        notifyCb.setFont(new Font("SansSerif", Font.PLAIN, 10));
        gbc.gridy = row++;
        panel.add(notifyCb, gbc);
      
        // Spacer
        gbc.gridy = row;
        gbc.weighty = 1.0;
        panel.add(Box.createVerticalGlue(), gbc);

        return panel;
    }

    @Override
    public void actionPerformed(ActionEvent a){
        if(a.getSource() == loginBtn){
            //JOptionPane.showMessageDialog(frame1, "BTN1");
            Dashboard dash = new Dashboard();
            frame1.dispose(); // Close the login window
        }else if(a.getSource() == signUpBtn){
            //JOptionPane.showMessageDialog(frame1, "BTN2");
            new RegistrationGUI();
                frame1.dispose();
        }
    }
}

// This class is made to handle High-quality image scale
class ImagePanel extends JPanel {
    private Image img;

    public ImagePanel(String path) {
        this.img = new ImageIcon("D:\\Finals_CCPRGG2L\\CCPRGG2L_Finals\\Finals_System\\src\\MedictCare LogReg.jpg").getImage();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        g2d.drawImage(img, 0, 0, getWidth(), getHeight(), this);
    }
}

