 

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.ArrayList;
import javax.swing.*;

class KasirBukuApp {
    private ArrayList<String[]> books = new ArrayList<>();

    public static void main(String[] args) {
        SwingUtilities.invokeLater(KasirBukuApp::new);
    }

    public KasirBukuApp() {
        initializeBooks();
        showLoginForm();
    }

    private void initializeBooks() {
        books.add(new String[]{"Antares", "50000", "D:/Kuliah/Semester 3/Pemograman Lanjut/UAP/Antares.jpg"});
        books.add(new String[]{"Mozachiko", "60000", "D:/Kuliah/Semester 3/Pemograman Lanjut/UAP/Mozachiko.jpg"});
        books.add(new String[]{"Titanic", "70000", "D:/Kuliah/Semester 3/Pemograman Lanjut/UAP/Titanic.jpg"});
    }

    private void showLoginForm() {
        JFrame loginFrame = new JFrame("Login Form");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(1400, 1024);
        loginFrame.setLocationRelativeTo(null);
        loginFrame.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setColor(Color.decode("#800000"));
                g2d.fillRect(0, 0, getWidth(), getHeight());
            }
        };
        mainPanel.setLayout(null);
        loginFrame.add(mainPanel, BorderLayout.CENTER);

        JLabel cartIcon = new JLabel();
        cartIcon.setIcon(new ImageIcon(new ImageIcon("D:/Kuliah/Semester 3/Pemograman Lanjut/UAP/Icon_Cart.png")
                .getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
        cartIcon.setBounds((1440 - 270) / 2, 200, 100, 100);
        mainPanel.add(cartIcon);

        

        JTextField txtUsername = new JTextField("Username");
        txtUsername.setBounds((1440 - 470) / 2, 350, 300, 40);
        txtUsername.setFont(new Font("Arial", Font.PLAIN, 16));
        txtUsername.setForeground(Color.GRAY);
        txtUsername.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (txtUsername.getText().equals("Username")) {
                    txtUsername.setText("");
                    txtUsername.setForeground(Color.BLACK);
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (txtUsername.getText().isEmpty()) {
                    txtUsername.setForeground(Color.GRAY);
                    txtUsername.setText("Username");
                }
            }
        });
        mainPanel.add(txtUsername);

        JPasswordField txtPassword = new JPasswordField("Password");
        txtPassword.setBounds((1440 - 470) / 2, 410, 300, 40);
        txtPassword.setFont(new Font("Arial", Font.PLAIN, 16));
        txtPassword.setForeground(Color.GRAY);
        txtPassword.setEchoChar((char) 0);
        txtPassword.addFocusListener(new FocusAdapter() {
            @Override
            public void focusGained(FocusEvent e) {
                if (String.valueOf(txtPassword.getPassword()).equals("Password")) {
                    txtPassword.setText("");
                    txtPassword.setForeground(Color.BLACK);
                    txtPassword.setEchoChar('•');
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                if (String.valueOf(txtPassword.getPassword()).isEmpty()) {
                    txtPassword.setForeground(Color.GRAY);
                    txtPassword.setText("Password");
                    txtPassword.setEchoChar((char) 0);
                }
            }
        });
        mainPanel.add(txtPassword);

        JButton btnLogin = new JButton("LOGIN");
        btnLogin.setBounds((1440 - 470) / 2, 470, 300, 40);
        btnLogin.setFont(new Font("Arial", Font.BOLD, 16));
        btnLogin.setBackground(Color.WHITE);
        btnLogin.setForeground(Color.decode("#800000"));
        btnLogin.addActionListener(e -> {
            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());

            if ("admin".equals(username) && "admin".equals(password)) {
                loginFrame.dispose();
                showHomePage();
            } else {
                JOptionPane.showMessageDialog(loginFrame, "Username atau Password salah!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });
        mainPanel.add(btnLogin);

        loginFrame.setVisible(true);
    }

    private void showHomePage() {
        JFrame homeFrame = new JFrame("Home Page");
        homeFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        homeFrame.setSize(1440, 1024);
        homeFrame.setLocationRelativeTo(null);
        homeFrame.setLayout(null);

        JPanel leftPanel = new JPanel();
        leftPanel.setBounds(0, 0, 400, 1024);
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setLayout(null);

        JLabel lblTitle = new JLabel("KASIR BUKU UMM");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setBounds(50, 50, 300, 30);
        leftPanel.add(lblTitle);

        JButton btnTransaksi = new JButton("Transaksi");
        btnTransaksi.setBounds(100, 150, 200, 50);
        leftPanel.add(btnTransaksi);

        JButton btnLogout = new JButton("Logout");
        btnLogout.setBounds(100, 250, 200, 50);
        btnLogout.addActionListener(e -> {
            homeFrame.dispose();
            showLoginForm();
        });
        leftPanel.add(btnLogout);

        homeFrame.add(leftPanel);

        JPanel rightPanel = new JPanel();
        rightPanel.setBounds(400, 0, 1040, 1024);
        rightPanel.setBackground(Color.decode("#800000"));
        homeFrame.add(rightPanel);

        btnTransaksi.addActionListener(e -> {
            homeFrame.dispose();
            showTransactionPage(homeFrame);
        });

        homeFrame.setVisible(true);
    }

    private void showTransactionPage(JFrame previousFrame) {
        JFrame transactionFrame = new JFrame("Transaksi");
        transactionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        transactionFrame.setSize(1440, 1024);
        transactionFrame.setLocationRelativeTo(null);
        transactionFrame.setLayout(null);

        JLabel lblTitle = new JLabel("Menu Transaksi");
        lblTitle.setFont(new Font("Arial", Font.BOLD, 24));
        lblTitle.setBounds(50, 20, 300, 30);
        transactionFrame.add(lblTitle);

        JComboBox<String> bookComboBox = new JComboBox<>();
        for (String[] book : books) {
            bookComboBox.addItem(book[0]);
        }
        bookComboBox.setBounds(50, 70, 300, 30);
        transactionFrame.add(bookComboBox);

        JLabel lblPrice = new JLabel("Harga: ");
        lblPrice.setBounds(50, 120, 300, 30);
        transactionFrame.add(lblPrice);

        JLabel lblImage = new JLabel();
        lblImage.setBounds(400, 70, 200, 300);
        transactionFrame.add(lblImage);

        JTextField txtQuantity = new JTextField();
        txtQuantity.setBounds(50, 170, 300, 30);
        transactionFrame.add(txtQuantity);

        JButton btnCalculate = new JButton("Hitung Total");
        btnCalculate.setBounds(50, 220, 150, 30);
        transactionFrame.add(btnCalculate);

        JLabel lblTotal = new JLabel("Total: ");
        lblTotal.setBounds(50, 270, 300, 30);
        transactionFrame.add(lblTotal);

        JButton btnSave = new JButton("Save");
        btnSave.setBounds(50, 320, 150, 30);
        transactionFrame.add(btnSave);

        JButton btnAdd = new JButton("Add Book");
        btnAdd.setBounds(50, 370, 150, 30);
        transactionFrame.add(btnAdd);

        JButton btnEdit = new JButton("Edit Book");
        btnEdit.setBounds(210, 370, 150, 30);
        transactionFrame.add(btnEdit);

        JButton btnDelete = new JButton("Delete Book");
        btnDelete.setBounds(50, 420, 150, 30);
        transactionFrame.add(btnDelete);

        JButton btnBack = new JButton("Back");
        btnBack.setBounds(210, 420, 150, 30);
        btnBack.addActionListener(e -> {
            transactionFrame.dispose();
            previousFrame.setVisible(true);
        });
        transactionFrame.add(btnBack);

        bookComboBox.addActionListener(e -> {
            int selectedIndex = bookComboBox.getSelectedIndex();
            lblPrice.setText("Harga: " + books.get(selectedIndex)[1]);
            lblImage.setIcon(new ImageIcon(new ImageIcon(books.get(selectedIndex)[2])
                    .getImage().getScaledInstance(200, 300, Image.SCALE_SMOOTH)));
        });

        btnCalculate.addActionListener(e -> {
            try {
                int quantity = Integer.parseInt(txtQuantity.getText());
                int price = Integer.parseInt(books.get(bookComboBox.getSelectedIndex())[1]);
                lblTotal.setText("Total: " + (quantity * price));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(transactionFrame, "Masukkan jumlah yang valid!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnSave.addActionListener(e -> {
            try {
                int selectedIndex = bookComboBox.getSelectedIndex();
                String bookName = books.get(selectedIndex)[0];
                String price = books.get(selectedIndex)[1];
                String quantity = txtQuantity.getText();
                String total = lblTotal.getText().split(": ")[1];

                File file = new File("D:/Buku/Transaksi.txt");
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file, true))) {
                    writer.write("Buku: " + bookName);
                    writer.newLine();
                    writer.write("Harga: " + price);
                    writer.newLine();
                    writer.write("Jumlah: " + quantity);
                    writer.newLine();
                    writer.write("Total: " + total);
                    writer.newLine();
                    writer.write("=================================");
                    writer.newLine();
                }

                JOptionPane.showMessageDialog(transactionFrame, "Transaksi berhasil disimpan!", "Sukses", JOptionPane.INFORMATION_MESSAGE);
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(transactionFrame, "Gagal menyimpan transaksi!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnAdd.addActionListener(e -> {
            String name = JOptionPane.showInputDialog(transactionFrame, "Masukkan nama buku:");
            String price = JOptionPane.showInputDialog(transactionFrame, "Masukkan harga buku:");
            String imagePath = JOptionPane.showInputDialog(transactionFrame, "Masukkan path gambar buku:");
            if (name != null && price != null && imagePath != null) {
                books.add(new String[]{name, price, imagePath});
                bookComboBox.addItem(name);
            }
        });

        btnEdit.addActionListener(e -> {
            int selectedIndex = bookComboBox.getSelectedIndex();
            String name = JOptionPane.showInputDialog(transactionFrame, "Edit nama buku:", books.get(selectedIndex)[0]);
            String price = JOptionPane.showInputDialog(transactionFrame, "Edit harga buku:", books.get(selectedIndex)[1]);
            String imagePath = JOptionPane.showInputDialog(transactionFrame, "Edit path gambar buku:", books.get(selectedIndex)[2]);
            if (name != null && price != null && imagePath != null) {
                books.set(selectedIndex, new String[]{name, price, imagePath});
                bookComboBox.insertItemAt(name, selectedIndex);
                bookComboBox.removeItemAt(selectedIndex + 1);
            }
        });

        btnDelete.addActionListener(e -> {
            int selectedIndex = bookComboBox.getSelectedIndex();
            books.remove(selectedIndex);
            bookComboBox.removeItemAt(selectedIndex);
        });

        transactionFrame.setVisible(true);
    }
}