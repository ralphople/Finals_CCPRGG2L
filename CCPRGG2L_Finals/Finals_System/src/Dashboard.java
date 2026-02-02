import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Dashboard {
    public Dashboard() {
        JFrame frame = new JFrame("Dashboard");
        ImageIcon windowIcon = new ImageIcon(
                "D:\\Finals_CCPRGG2L\\CCPRGG2L_Finals\\Finals_System\\src\\MedictCare Logo.png");
        frame.setIconImage(windowIcon.getImage());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1000, 600);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        // Navigation Bar
        JPanel topNav = new JPanel(new BorderLayout());
        topNav.setBackground(new Color(55, 78, 210)); // blue
        //topNav.setPreferredSize(new Dimension(0, 80));
        topNav.setBorder(BorderFactory.createEmptyBorder(15, 25, 15, 25));

        // Logo and User Info
        JPanel leftNav = new JPanel();
        leftNav.setOpaque(false);
        leftNav.setLayout(new FlowLayout(FlowLayout.LEFT, 15, 5));

        ImageIcon logoIcon = new ImageIcon(
                "D:\\Finals_CCPRGG2L\\CCPRGG2L_Finals\\Finals_System\\src\\MedictCare Logo.png");
        Image scaledLogo = logoIcon.getImage().getScaledInstance(40, 40, Image.SCALE_SMOOTH);
        ImageIcon finalLogo = new ImageIcon(scaledLogo);

        JPanel userInfo = new JPanel();
        userInfo.setOpaque(false);
        userInfo.setLayout(new BoxLayout(userInfo, BoxLayout.Y_AXIS));

        JLabel userLabel = new JLabel("David_8");
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(new Font("SansSerif", Font.BOLD, 14));

        JLabel welcomeLabel = new JLabel("Welcome, David Walter M. Labor!");
        welcomeLabel.setForeground(Color.WHITE);
        welcomeLabel.setFont(new Font("SansSerif", Font.BOLD, 20));

        userInfo.add(userLabel);
        userInfo.add(welcomeLabel);

        leftNav.add(new JLabel(finalLogo));
        leftNav.add(userInfo);

        // Navigation Links
        JPanel rightNav = new JPanel(new FlowLayout(FlowLayout.RIGHT, 20, 18));
        JPanel contentWrapper = new JPanel(new BorderLayout());
        rightNav.setOpaque(false);

        JLabel homeLink = createNavLink("Home");
        homeLink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showPanel(contentWrapper, createHomePanel());
            }
        });
        rightNav.add(homeLink);

        JLabel appointmentsLink = createNavLink("Appointments");
        appointmentsLink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showPanel(contentWrapper, createAppointmentPanel());
            }
        });

        rightNav.add(appointmentsLink);

        JLabel doctorsLink = createNavLink("Doctors");
        doctorsLink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showPanel(contentWrapper, createDoctorsPanel());
            }
        });
        rightNav.add(doctorsLink);

        JLabel aboutUsLink = createNavLink("About Us");
        aboutUsLink.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                showPanel(contentWrapper, createAboutUsPanel());
            }
        });
        rightNav.add(aboutUsLink);

        topNav.add(leftNav, BorderLayout.WEST);
        topNav.add(rightNav, BorderLayout.EAST);

        // Content Area
        contentWrapper.setBackground(new Color(120, 210, 90)); // green
        contentWrapper.setBorder(BorderFactory.createEmptyBorder(25, 25, 25, 25));

        JPanel whiteContent = new JPanel();
        whiteContent.setBackground(Color.WHITE);

        contentWrapper.add(whiteContent, BorderLayout.CENTER);

        // Frame add
        frame.add(topNav, BorderLayout.NORTH);
        frame.add(contentWrapper, BorderLayout.CENTER);

        frame.setVisible(true);
    }

    // create navigation link label
    private JLabel createNavLink(String text) {
        JLabel link = new JLabel(text);
        link.setForeground(Color.WHITE);
        link.setFont(new Font("SansSerif", Font.BOLD, 20));
        link.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        return link;
    }

    //Appointment Panel in Dashboard
    private JPanel createAppointmentPanel() {
        JPanel appointmentPanel = new JPanel();
        appointmentPanel.setLayout(new BorderLayout());
        appointmentPanel.setBackground(Color.WHITE);
        appointmentPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        // Main Text
        JLabel mainText = new JLabel("Book an appointment with your doctor");
        mainText.setFont(new Font("SansSerif", Font.BOLD, 24));
        mainText.setForeground(new Color(55, 78, 210)); // blue
        mainText.setHorizontalAlignment(SwingConstants.CENTER);

        // SubText
        JLabel subText = new JLabel(
                "Book and set a scheduled appointment with your doctor on your preferred date and time");
        subText.setFont(new Font("SansSerif", Font.PLAIN, 16));
        subText.setHorizontalAlignment(SwingConstants.CENTER);

        // Booking Button
        JButton bookButton = new JButton("BOOK AN APPOINTMENT");
        bookButton.setFont(new Font("SansSerif", Font.BOLD, 18));
        bookButton.setBackground(Color.BLACK);
        bookButton.setForeground(Color.WHITE);
        bookButton.setFocusPainted(false);

        // Text Panel Layout
        JPanel textPanel = new JPanel();
        textPanel.setLayout(new BoxLayout(textPanel, BoxLayout.Y_AXIS));
        textPanel.setOpaque(false);
        textPanel.add(mainText);
        textPanel.add(Box.createVerticalStrut(15));
        textPanel.add(subText);
        textPanel.add(Box.createVerticalStrut(30));
        textPanel.add(bookButton);

        appointmentPanel.add(textPanel, BorderLayout.CENTER);

        return appointmentPanel;
    }

    // Home Panel in Dashboard
    private JPanel createHomePanel() {
        JPanel homePanel = new JPanel();
        homePanel.setLayout(new BorderLayout());
        homePanel.setBackground(Color.WHITE);
        homePanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        JPanel userProfile = new JPanel ();
        userProfile.setLayout(new BoxLayout(homePanel, BoxLayout.Y_AXIS));
        userProfile.setBackground(Color.GRAY);
        userProfile.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        
        return homePanel;
    }

    // Doctors Panel in Dashboard
    private JPanel createDoctorsPanel() {
        JPanel doctorsPanel = new JPanel();
        doctorsPanel.setLayout(new BorderLayout());
        doctorsPanel.setBackground(Color.WHITE);
        doctorsPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        return doctorsPanel;
    }

    // About Us Panel in Dashboard
    private JPanel createAboutUsPanel() {
        JPanel aboutUsPanel = new JPanel();
        aboutUsPanel.setLayout(new BorderLayout());
        aboutUsPanel.setBackground(Color.WHITE);
        aboutUsPanel.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));
        return aboutUsPanel;
    }

    // Show designated panel in dashboard content area
    private void showPanel(JPanel contentWrapper, JPanel panelToShow) {
        contentWrapper.removeAll();
        contentWrapper.add(panelToShow, BorderLayout.CENTER);
        contentWrapper.revalidate();
        contentWrapper.repaint();
    }

}
