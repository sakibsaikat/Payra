package com.sakib;

import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Calendar;
import java.util.Random;

public class SingUp {
    JFrame frame;

    public static void main(String[] args) {
        SingUp ob = new SingUp();
        ob.createSignUp();
    }

    public void createSignUp(){
        frame = new JFrame();
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setTitle("Payra");
        frame.setSize(650,610);
        frame.setLayout(null);
        frame.setBounds(300,50,650,610);
        loadSignUp();

        frame.requestFocusInWindow();
        frame.setVisible(true);

    }
    public void loadSignUp(){
        JPanel loginpanel = new JPanel();
        loginpanel.setLayout(null);
        loginpanel.setBounds(0,0,650,610);
        loginpanel.setBackground(new Color(0,0,0));
//        loginpanel.setBackground(new Color(32,32,32));

        SwingModel ob = new SwingModel();
        SwingModel ob2 = new SwingModel();
        SwingModel ob3 = new SwingModel();
        SwingModel ob4 = new SwingModel();
        SwingModel ob5 = new SwingModel();

        ob.CreateButton(605,0,45,30,"x");
        ob.button.setForeground(Color.WHITE);
        ob.button.setBackground(new Color(204,0,0));
        ob.button.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.BLACK));
        ob.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });

        ob.CreateImage(275,60,100,120,"C:\\Users\\Farzana\\IdeaProjects\\Payra\\src\\pr.png");

        ob.CreateTextfield(200,170,250,40,"Full Name");
        ob.textField.setForeground(Color.WHITE);
//        ob.textField.setForeground(new Color(0,102,204));
//        ob.textField.setBackground(new Color(32,32,32));
        ob.textField.setBackground(new Color(0,0,0));

        ob2.CreateTextfield(200,220,250,40,"Email");
        ob2.textField.setForeground(Color.WHITE);;
//        ob2.textField.setForeground(new Color(0,102,204));
//        ob2.textField.setBackground(new Color(32,32,32));
        ob2.textField.setBackground(new Color(0,0,0));

        ob3.CreateTextfield(200,270,250,40,"New Password");
        ob3.textField.setForeground(Color.WHITE);;
//        ob3.textField.setForeground(new Color(0,102,204));
//        ob3.textField.setBackground(new Color(32,32,32));
        ob3.textField.setBackground(new Color(0,0,0));


        ob5.CreateLabel(200,330,200,40,"Date Of Birth","Arial",14);
        ob5.label.setForeground(Color.WHITE);

        ob4.CreatePanel(210,360,250,35);
        String[] Day = {"Day","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        ob2.CreateCombo(0,0,70,35,Day);
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

        String[] Month = {"Month","January","February","March","April","May","June","July","August","September","October","November","December"};
        ob3.CreateCombo(70,0,100,35,Month);
        ob3.box.setBackground(new Color(0,0,0));
//        ob3.box.setBackground(new Color(32,32,32));
        ob3.box.setForeground(Color.WHITE);
        ob3.box.setEditable(false);
        ob3.box.setUI(new BasicComboBoxUI() {
            @SuppressWarnings({"serial"})
            @Override
            protected ComboPopup createPopup() {
                return new BasicComboPopup(ob3.box) {
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
        ob3.box.setRenderer(new ListCellRenderer<String>() {
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

        String[] Year = {"Year","1980","1981","1982","1983","1984","1985","1986","1987","1988","1989","1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020","2021","2022","2023"};
        ob4.CreateCombo(170,0,80,35,Year);
        ob4.box.setBackground(new Color(0,0,0));
//        ob4.box.setBackground(new Color(32,32,32));
        ob4.box.setForeground(Color.WHITE);
        ob4.box.setEditable(false);
        ob4.box.setUI(new BasicComboBoxUI() {
            @SuppressWarnings({"serial"})
            @Override
            protected ComboPopup createPopup() {
                return new BasicComboPopup(ob4.box) {
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
        ob4.box.setRenderer(new ListCellRenderer<String>() {
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


        ob4.panel.add(ob2.box);
        ob4.panel.add(ob3.box);
        ob4.panel.add(ob4.box);

//        ob4.CreateTextfield(200,400,250,40,"Gender");
//        ob4.textField.setForeground(Color.WHITE);;
//        ob4.textField.setBackground(new Color(0,0,0));

        ob3.CreateLabel(200,390,200,40,"Gender","Dialog",14);
//        ob3.label.setForeground(new Color(0,102,204));
        ob3.label.setForeground(Color.WHITE);

        JRadioButton btn = new JRadioButton("Male");
        btn.setBounds(210,420,70,40);
        btn.setBackground(Color.BLACK);
        btn.setForeground(Color.WHITE);
        btn.setFocusable(false);

        JRadioButton btn2 = new JRadioButton("Female");
        btn2.setBounds(280,420,70,40);
        btn2.setBackground(Color.BLACK);
        btn2.setForeground(Color.WHITE);
        btn2.setFocusable(false);


        ButtonGroup group = new ButtonGroup();
        group.add(btn);
        group.add(btn2);

        JCheckBox checkBox = new JCheckBox("I agree with all terms and conditions.");
        checkBox.setBounds(200,470,300,40);
        checkBox.setBackground(Color.BLACK);
        checkBox.setForeground(Color.WHITE);
        checkBox.setFocusable(false);



        ob2.CreateHoverPanel(240,520,160,30);
        ob2.CreateLabel(40,0,120,30,"Create Account","Arial",12);
        ob2.label.setForeground(Color.WHITE);
        ob2.hoverpanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                String nm = ob.textField.getText();
                String email = ob2.textField.getText();
                String pass = ob3.textField.getText();
                String day = ob2.box.getSelectedItem().toString();
                String month = ob3.box.getSelectedItem().toString();
                String year = ob4.box.getSelectedItem().toString();
                String monthNum="";

                switch (month){
                    case "January":{
                        monthNum="01";
                        break;
                    }case "February":{
                        monthNum="02";
                        break;
                    }case "March":{
                        monthNum="03";
                        break;
                    }case "April":{
                        monthNum="04";
                        break;
                    }case "May":{
                        monthNum="05";
                        break;
                    }case "June":{
                        monthNum="06";
                        break;
                    }case "July":{
                        monthNum="07";
                        break;
                    }case "August":{
                        monthNum="08";
                        break;
                    }case "September":{
                        monthNum="09";
                        break;
                    }case "October":{
                        monthNum="10";
                        break;
                    }case "November":{
                        monthNum="11";
                        break;
                    }case "December":{
                        monthNum="12";
                        break;
                    }
                }
                String dob = year+"-"+monthNum+"-"+day;
                String gender="";

                if(btn.isSelected()){
                    gender="MALE";
                }
                else if(btn2.isSelected()){
                    gender="FEMALE";
                }

                Random random = new Random();
                int min = 12000;
                int max = 20000;
                int value = random.nextInt(max + min) + min;
                String verify = String.valueOf(value);

                String command = "INSERT INTO users(name,email,password,gender,dob,status) VALUES('"+nm+"','"+email+"','"+pass+"','"+gender+"','"+dob+"','"+verify+"')";
                SwingModel obn2 = new SwingModel();
                obn2.SendData(command);
                JOptionPane.showMessageDialog(null,"Accound Has Been Created...");

            }
        });




        ob2.hoverpanel.add(ob2.label);
        loginpanel.add(ob5.label);
        loginpanel.add(ob3.label);
        loginpanel.add(ob.button);
        loginpanel.add(ob4.panel);
        loginpanel.add(ob2.hoverpanel);
        loginpanel.add(ob.textField);
        loginpanel.add(ob2.textField);
        loginpanel.add(ob3.textField);
        loginpanel.add(checkBox);
//        loginpanel.add(ob4.textField);
        loginpanel.add(btn);
        loginpanel.add(btn2);
        loginpanel.add(ob.image_label);

        frame.add(loginpanel);

    }
}
