import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class MyFrame extends JFrame implements ActionListener {
    JLabel email;
    JLabel pass;
    JTextField temail;
    JPasswordField tpass;

    public MyFrame() {
        setTitle("Login Form");
        setBounds(200, 80, 800, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        // Define custom colors
        Color bgColor = new Color(185, 217, 235);
        Color btnColor = new Color(0, 123, 255);
        Color btnTextColor = new Color(231, 227, 254);
        Color labelColor = new Color(60, 60, 60);

        // Set background color
        getContentPane().setBackground(bgColor);

        email = new JLabel("Email: ");
        email.setForeground(labelColor);
        email.setFont(new Font("Serif", Font.BOLD, 16));
        email.setSize(100, 30);
        email.setLocation(100, 100);
        add(email);

        temail = new JTextField();
        temail.setFont(new Font("Serif", Font.PLAIN, 16));
        temail.setSize(190, 30);
        temail.setLocation(200, 100);
        add(temail);

        pass = new JLabel("Password: ");
        pass.setForeground(labelColor);
        pass.setFont(new Font("Serif", Font.BOLD, 16));
        pass.setSize(100, 30);
        pass.setLocation(100, 150);
        add(pass);

        tpass = new JPasswordField();
        tpass.setFont(new Font("Serif", Font.PLAIN, 16));
        tpass.setSize(190, 30);
        tpass.setLocation(200, 150);
        add(tpass);

        JButton loginButton = new JButton("Login");
        loginButton.setFont(new Font("Serif", Font.PLAIN, 16));
        loginButton.setBackground(btnColor);
        loginButton.setForeground(btnTextColor);
        loginButton.setSize(100, 30);
        loginButton.setLocation(200, 200);
        add(loginButton);

        JCheckBox showPasswordCheckBox = new JCheckBox("Show Password");
        showPasswordCheckBox.setFont(new Font("Serif", Font.ITALIC, 14));
        showPasswordCheckBox.setForeground(labelColor);
        showPasswordCheckBox.setSize(120, 30);
        showPasswordCheckBox.setLocation(400, 150);
        add(showPasswordCheckBox);

        loginButton.addActionListener(this); // Register ActionListener
        showPasswordCheckBox.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (showPasswordCheckBox.isSelected()) {
                    tpass.setEchoChar((char) 0);
                } else {
                    tpass.setEchoChar('*');
                }
            }
        });

        // Call setVisible(true) after adding all components
        setVisible(true);
    }

    // Implement the actionPerformed method for ActionListener
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Login")) {
            String userEmail = temail.getText();
            String userPass = new String(tpass.getPassword());

            // Add login logic here
            if (isValidLogin(userEmail, userPass)) {
                JOptionPane.showMessageDialog(this, "Login successful!");
            } else {
                JOptionPane.showMessageDialog(this, "Login failed. Please try again.");
            }
        }
    }

    private boolean isValidLogin(String email, String tpass) {
        return !email.isEmpty() && !tpass.isEmpty();
    }

    public static void main(String[] args) {
        new MyFrame(); 
    }
}
