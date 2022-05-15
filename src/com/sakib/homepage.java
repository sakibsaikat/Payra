package com.sakib;

import com.sakib.SwingModel;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import java.awt.*;
import java.awt.dnd.DragSourceDragEvent;
import java.awt.dnd.DragSourceMotionListener;
import java.awt.event.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class homepage {
    JFrame frame;
    private int mx,my;

    public static void main(String[] args) {
        homepage ob = new homepage();
        ob.createHome();
    }
    public void createHome(){
        frame = new JFrame();
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setTitle("Payra");
        frame.setSize(650,450);
        frame.setLayout(null);
        frame.setBounds(300,200,650,450);
        loadHome();

        frame.setVisible(true);
    }

    public void loadHome(){
        JPanel loginpanel = new JPanel();
        loginpanel.setLayout(null);
        loginpanel.setBounds(0,0,650,450);
        loginpanel.setBackground(new Color(0,0,0));


        SwingModel ob = new SwingModel();
        SwingModel ob2 = new SwingModel();
        SwingModel ob3 = new SwingModel();

        ob.CreateButton(605,0,45,30,"x");
        ob.button.setForeground(Color.WHITE);
        ob.button.setBackground(new Color(204,0,0));
        ob.button.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.BLACK));
        ob.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        ob.CreateImage(275,70,100,120,"C:\\Users\\Farzana\\IdeaProjects\\Payra\\src\\pr.png");

        String[] user = {"User","Admin"};
        ob2.CreateCombo(290,185,70,20,user);
        ob2.box.setBackground(new Color(0,0,0));
        ob2.box.setForeground(Color.WHITE);
        ob2.box.setEditable(false);
        ob2.box.setUI(new BasicComboBoxUI() {
            @SuppressWarnings({"serial"})
            @Override
            protected ComboPopup createPopup() {
                return new BasicComboPopup(ob2.box) {
                    {
                        //---style popup anyway you like
                        this.setBorder(BorderFactory.createLineBorder(new Color(0,102,204), 1));//---popup's border color
                    }
                };
            }
            int ch = 161;
            char c = (char)ch;
            String dn = String.valueOf(c);
            @Override
            protected JButton createArrowButton() {
                //---style arrow button anyway you like
                JButton result = new JButton(dn);
                result.setBackground(Color.BLACK);//---button's color
                result.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.BLACK));
                result.setForeground(Color.white);
                return result;
            }
        });
        ob2.box.setRenderer(new ListCellRenderer<String>() {
            @Override
            public Component getListCellRendererComponent(JList<? extends String> list, String value, int index,
                                                          boolean isSelected, boolean cellHasFocus) {
                JLabel result = new JLabel(value);
                result.setOpaque(true);
                result.setForeground(Color.WHITE);
                result.setBackground(isSelected ? new Color(0,102,204) : Color.BLACK ); //---item background color
                return result;
            }
        });

        ob.CreateTextfield(200,200,250,40,"Email");
        ob.textField.setForeground(Color.WHITE);;
        ob.textField.setBackground(new Color(0,0,0));

        ob2.CreateTextfield(200,250,250,40,"Password");
        ob2.textField.setForeground(Color.WHITE);;
        ob2.textField.setBackground(new Color(0,0,0));

        ob2.CreateHoverPanel(270,320,120,30);
        ob2.CreateLabel(40,0,120,30,"Log In","Arial",12);
        ob2.label.setForeground(Color.WHITE);
        ob3.CreateLabel(270,360,130,50,"Create New Account","Algerian",12);
        ob3.label.setForeground(new Color(0,102,204));
        Cursor cursor =ob3.label.getCursor();
        ob3.label.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        ob3.label.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                SingUp obx = new SingUp();
                obx.createSignUp();
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });

        ob2.hoverpanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String designation = ob2.box.getSelectedItem().toString();
                String username = ob.textField.getText();
                String password = ob2.textField.getText();

                if(designation.equals("Admin")){
                    String cmd = "SELECT * FROM admin";
                    SwingModel obn1 = new SwingModel();
                    ResultSet rz = obn1.GetData(cmd);

                    try{
                        while(rz.next()){
                            String user = rz.getString("USERNAME");
                            String pass = rz.getString("PASSWORD");

                            if(user.equals(username) && pass.equals(password)){
                                AdminDashboard obadmin = new AdminDashboard();
                                obadmin.CreateAdmin();
                                break;
                            }
                        }
                    } catch (SQLException throwables) {
                        throwables.printStackTrace();
                    }
                }
            }
        });

        ob2.hoverpanel.add(ob2.label);
        loginpanel.add(ob2.box);
        loginpanel.add(ob.button);
        loginpanel.add(ob2.hoverpanel);
        loginpanel.add(ob3.label);
        loginpanel.add(ob.textField);
        loginpanel.add(ob2.textField);
        loginpanel.add(ob.image_label);

        frame.add(loginpanel);

    }
}
