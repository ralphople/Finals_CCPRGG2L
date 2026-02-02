import java.awt.*;
import java.awt.event.*;
import java.util.Calendar;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;

public class RegistrationGUI {
    
    JFrame frame;

    JTextField txtLastName, txtFirstName, txtMiddleName, txtUsername, txtContact;
    JPasswordField txtPassword, txtConfirmPassword;
    
    JComboBox<String> cmbPrefix; 
    JComboBox<String> cmbSuffix;
    JComboBox<String> cmbMonth, cmbDay, cmbYear;

    Color mainBlue = new Color(52, 72, 222);
    Color fieldColor = new Color(193, 238, 246);
    Color btnGreen = new Color(108, 209, 96);
    Color btnGray = new Color(105, 105, 105);

    public RegistrationGUI() {
        frame = new JFrame("MedictCare - Registration");
        frame.setSize(1200, 800); 
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ImageIcon appIcon = new ImageIcon("MedictCare Logo.png");
        frame.setIconImage(appIcon.getImage());

        txtLastName = new JTextField();
        txtFirstName = new JTextField();
        txtMiddleName = new JTextField();
        txtContact = new JTextField();
        txtUsername = new JTextField();
        txtPassword = new JPasswordField();
        txtConfirmPassword = new JPasswordField();

        String[] countryCode = {"+63"};
        cmbPrefix = new JComboBox<>(countryCode);

        String[] suffixes = {"None", "Jr.", "Sr.", "II", "III", "IV", "V"};
        cmbSuffix = new JComboBox<>(suffixes);

        String[] months = {"Month", "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        cmbMonth = new JComboBox<>(months);

        String[] days = new String[32];
        days[0] = "Day";
        for(int i=1; i<=31; i++) days[i] = String.valueOf(i);
        cmbDay = new JComboBox<>(days);

        String[] years = new String[101];
        years[0] = "Year";
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        for(int i=0; i<100; i++) years[i+1] = String.valueOf(currentYear - i);
        cmbYear = new JComboBox<>(years);

        JPanel backgroundPanel = new JPanel(new GridBagLayout());
        backgroundPanel.setBackground(new Color(235, 245, 255));

        JPanel card = new JPanel(new GridBagLayout());
        card.setBackground(Color.WHITE);
        card.setBorder(new EmptyBorder(40, 60, 40, 60));

        GridBagConstraints bgGbc = new GridBagConstraints();
        bgGbc.gridx = 0; 
        bgGbc.gridy = 0;
        bgGbc.weightx = 1.0; 
        bgGbc.weighty = 1.0; 
        bgGbc.fill = GridBagConstraints.BOTH; 
        bgGbc.insets = new Insets(50, 100, 50, 100); 

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(15, 20, 15, 20); 
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridx = 0; gbc.gridy = 0;
        gbc.gridwidth = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.CENTER;

        JPanel headerPanel = new JPanel(new BorderLayout());
        headerPanel.setBackground(Color.WHITE);

        ImageIcon logoIcon = new ImageIcon("MedictCare Logo.png");
        if (logoIcon.getIconWidth() > 0) {
            Image scaledLogo = logoIcon.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH); 
            JLabel logoLabel = new JLabel(new ImageIcon(scaledLogo));
            logoLabel.setBorder(new EmptyBorder(0, 0, 0, 0));
            headerPanel.add(logoLabel, BorderLayout.WEST);
        }

        JLabel title = new JLabel("Registration", SwingConstants.CENTER);
        title.setFont(new Font("SansSerif", Font.BOLD, 40)); 
        title.setForeground(mainBlue);
        headerPanel.add(title, BorderLayout.CENTER);

        JLabel Spacer = new JLabel();
        Spacer.setPreferredSize(new Dimension(70, 70));
        headerPanel.add(Spacer, BorderLayout.EAST);

        card.add(headerPanel, gbc);

        gbc.gridwidth = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        gbc.gridy = 1;

        gbc.gridx = 0; gbc.weightx = 1.0;
        card.add(wrapComponent("Last Name", txtLastName), gbc);

        gbc.gridx = 2; 
        card.add(createBirthdayPanel("Birthday"), gbc);

        gbc.gridy = 2;

        gbc.gridx = 0;
        card.add(wrapComponent("First Name", txtFirstName), gbc);

        gbc.gridx = 2;
        card.add(createContactPanel("Contact Number", txtContact), gbc);

        gbc.gridy = 3;

        gbc.gridx = 0;
        card.add(wrapComponent("Middle Name", txtMiddleName), gbc);

        gbc.gridx = 1; gbc.weightx = 0.2; 
        card.add(wrapComponent("Suffix", cmbSuffix), gbc);

        gbc.gridx = 2; gbc.weightx = 1.0;
        card.add(wrapComponent("Username", txtUsername), gbc);

        gbc.gridy = 4;
        gbc.gridx = 0;
        gbc.gridwidth = 3; 
        
        JPanel passwordRowPanel = new JPanel(new GridLayout(1, 2, 15, 0));
        passwordRowPanel.setBackground(Color.WHITE);
        
        passwordRowPanel.add(wrapPasswordComponent("Password", txtPassword));
        passwordRowPanel.add(wrapPasswordComponent("Confirm Password", txtConfirmPassword));
        
        card.add(passwordRowPanel, gbc);

        gbc.gridy = 5; gbc.gridx = 0; gbc.gridwidth = 3;
        JLabel loginLink = new JLabel("<html> <u> Already have an account? Log-in instead</u> </html>", SwingConstants.CENTER);
        loginLink.setFont(new Font("SansSerif", Font.BOLD, 14)); 
        loginLink.setCursor(new Cursor(Cursor.HAND_CURSOR));
        
        loginLink.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                new GUI1(); 
                frame.dispose();
            }
        });
        card.add(loginLink, gbc);
        
        gbc.gridy = 6;

        JButton backBtn = new JButton("BACK");
        styleButton(backBtn, btnGray);
        gbc.gridx = 0; gbc.gridwidth = 1; gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.NONE;
        backBtn.addActionListener(e -> {
            new GUI1();
            frame.dispose();
        });
        card.add(backBtn, gbc);

        JButton nextBtn = new JButton("NEXT");
        styleButton(nextBtn, btnGreen);
        gbc.gridx = 2; gbc.anchor = GridBagConstraints.EAST;
        
        nextBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (validateForm()) {
                    JOptionPane.showMessageDialog(frame, "Registration Successful!");
                    new GUI1();
                    frame.dispose();
                }
            }
        });

        card.add(nextBtn, gbc);

        frame.add(backgroundPanel);
        backgroundPanel.add(card, bgGbc); 
        frame.setVisible(true);
    } 

    private boolean validateForm() {
        String lname = txtLastName.getText().trim();
        String fname = txtFirstName.getText().trim();
        String contact = txtContact.getText().trim();
        String user = txtUsername.getText().trim();
        String pass = new String(txtPassword.getPassword());
        String cpass = new String(txtConfirmPassword.getPassword());
        
        boolean isBirthdayValid = cmbMonth.getSelectedIndex() != 0 && 
                                  cmbDay.getSelectedIndex() != 0 && 
                                  cmbYear.getSelectedIndex() != 0;

        if (lname.isEmpty() && fname.isEmpty() && !isBirthdayValid && 
            contact.isEmpty() && user.isEmpty() && pass.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "All fields are required.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        else if (lname.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Last Name is required.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if (fname.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "First Name is required.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if (!isBirthdayValid) {
            JOptionPane.showMessageDialog(frame, "Please select a valid Birthday (Month, Day, Year).", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if (contact.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Contact Number is required.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if (user.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Username is required.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if (pass.isEmpty()) {
            JOptionPane.showMessageDialog(frame, "Password is required.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if (!contact.matches("\\d+")) { 
            JOptionPane.showMessageDialog(frame, "Contact number must contain digits only.", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        else if (!pass.equals(cpass)) {
            JOptionPane.showMessageDialog(frame, "Passwords do not match!", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }

        return true; 
    }

    private JPanel wrapPasswordComponent(String labelText, JPasswordField field) {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBackground(Color.WHITE);
        
        JLabel label = new JLabel(labelText, SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 14)); 
        panel.add(label, BorderLayout.NORTH);

        field.setOpaque(false);
        field.setBorder(new EmptyBorder(8, 15, 8, 0)); 
        field.setFont(new Font("SansSerif", Font.PLAIN, 14)); 
        
        char defaultEchoChar = field.getEchoChar();

        JToggleButton showHideBtn = new JToggleButton("Show");
        showHideBtn.setOpaque(false);
        showHideBtn.setContentAreaFilled(false);
        showHideBtn.setBorder(new EmptyBorder(0, 10, 0, 10)); 
        showHideBtn.setFocusPainted(false);
        showHideBtn.setCursor(new Cursor(Cursor.HAND_CURSOR));
        showHideBtn.setFont(new Font("SansSerif", Font.BOLD, 11));
        showHideBtn.setForeground(btnGray);

        showHideBtn.addActionListener(e -> {
            if (showHideBtn.isSelected()) {
                field.setEchoChar((char) 0); 
                showHideBtn.setText("Hide");
            } else {
                field.setEchoChar(defaultEchoChar); 
                showHideBtn.setText("Show");
            }
        });

        JPanel container = new FieldPanel(fieldColor);
        container.setLayout(new BorderLayout());
        container.add(field, BorderLayout.CENTER);
        container.add(showHideBtn, BorderLayout.EAST); 
        
        container.setPreferredSize(new Dimension(300, 50)); 

        panel.add(container, BorderLayout.CENTER);
        return panel;
    }

    private JPanel wrapComponent(String labelText, JComponent field) {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBackground(Color.WHITE);
        
        JLabel label = new JLabel(labelText, SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 14)); 
        panel.add(label, BorderLayout.NORTH);

        if (field instanceof JTextField) {
            ((JTextField)field).setOpaque(false);
            ((JTextField)field).setBorder(new EmptyBorder(8, 15, 8, 15));
            ((JTextField)field).setFont(new Font("SansSerif", Font.PLAIN, 14)); 
        } else if (field instanceof JComboBox) {
            ((JComboBox<?>)field).setUI(new FlatComboBoxUI());
            ((JComboBox<?>)field).setBackground(fieldColor);
            ((JComboBox<?>)field).setBorder(new EmptyBorder(0, 5, 0, 5));
            ((JComboBox<?>)field).setFont(new Font("SansSerif", Font.PLAIN, 14)); 
            ((JComboBox<?>)field).setRenderer(new DefaultListCellRenderer() {
                @Override
                public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                    super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                    setBackground(isSelected ? new Color(200, 200, 200) : fieldColor);
                    return this;
                }
            });
        }

        JPanel container = new FieldPanel(fieldColor);
        container.setLayout(new BorderLayout());
        container.add(field, BorderLayout.CENTER);
        
        container.setPreferredSize(new Dimension(300, 50)); 

        panel.add(container, BorderLayout.CENTER);
        return panel;
    }

    private JPanel createBirthdayPanel(String labelText) {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBackground(Color.WHITE);

        JLabel label = new JLabel(labelText, SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 14));
        panel.add(label, BorderLayout.NORTH);

        styleBirthdayCombo(cmbMonth);
        styleBirthdayCombo(cmbDay);
        styleBirthdayCombo(cmbYear);

        JPanel container = new FieldPanel(fieldColor);
        container.setLayout(new GridLayout(1, 3, 5, 0));
        
        container.add(cmbMonth);
        container.add(cmbDay);
        container.add(cmbYear);
        
        container.setPreferredSize(new Dimension(300, 50)); 
        panel.add(container, BorderLayout.CENTER);
        return panel;
    }

    private void styleBirthdayCombo(JComboBox<String> box) {
        box.setUI(new FlatComboBoxUI());
        box.setBackground(fieldColor);
        box.setFont(new Font("SansSerif", Font.PLAIN, 13)); 
        box.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0));
        box.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                setBackground(isSelected ? new Color(200, 200, 200) : fieldColor);
                return this;
            }
        });
    }

    private JPanel createContactPanel(String labelText, JTextField field) {
        JPanel panel = new JPanel(new BorderLayout(5, 5));
        panel.setBackground(Color.WHITE);

        JLabel label = new JLabel(labelText, SwingConstants.CENTER);
        label.setFont(new Font("SansSerif", Font.BOLD, 14));
        panel.add(label, BorderLayout.NORTH);

        cmbPrefix.setUI(new FlatComboBoxUI());
        cmbPrefix.setFont(new Font("SansSerif", Font.PLAIN, 14));
        cmbPrefix.setBackground(fieldColor); 
        cmbPrefix.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 0)); 
        
        cmbPrefix.setPreferredSize(new Dimension(80, 50)); 

        field.setOpaque(false);
        field.setBorder(new EmptyBorder(8, 5, 8, 15));
        field.setFont(new Font("SansSerif", Font.PLAIN, 14));
        
        JPanel container = new FieldPanel(fieldColor);
        container.setLayout(new BorderLayout());
        
        container.add(cmbPrefix, BorderLayout.WEST); 
        container.add(field, BorderLayout.CENTER);   
        
        container.setPreferredSize(new Dimension(300, 50)); 

        panel.add(container, BorderLayout.CENTER);
        return panel;
    }

    private void styleButton(JButton btn, Color bg) {
        btn.setBackground(bg);
        btn.setForeground(Color.WHITE); 
        btn.setFocusPainted(false);
        btn.setFont(new Font("SansSerif", Font.BOLD, 14));
        btn.setPreferredSize(new Dimension(150, 50));
        btn.setBorderPainted(false);
    }

    class FieldPanel extends JPanel {
        private Color bgColor;
        
        public FieldPanel(Color color) {
            this.bgColor = color;
            setOpaque(false); 
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2.setColor(bgColor);
            g2.fillRect(0, 0, getWidth(), getHeight());
        }
    }

    class FlatComboBoxUI extends BasicComboBoxUI {
        @Override
        protected JButton createArrowButton() {
            BasicArrowButton button = new BasicArrowButton(
                BasicArrowButton.SOUTH,
                fieldColor, fieldColor, new Color(100, 100, 100), fieldColor
            );
            button.setBorder(BorderFactory.createEmptyBorder());
            return button;
        }

        @Override
        public void paintCurrentValueBackground(Graphics g, Rectangle bounds, boolean hasFocus) {
            g.setColor(fieldColor);
            g.fillRect(bounds.x, bounds.y, bounds.width, bounds.height);
        }
    }
}