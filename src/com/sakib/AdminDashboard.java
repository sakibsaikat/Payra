package com.sakib;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.ResultSet;

public class AdminDashboard {
    JFrame frame;

    public static void main(String[] args) {
        AdminDashboard ob = new AdminDashboard();
        ob.CreateAdmin();
    }
    public void CreateAdmin(){
        frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setUndecorated(true);
        frame.setTitle("Payra");
        frame.setSize(1650,1080);
        frame.setLayout(null);
        frame.setBackground(new Color(0,0,0,0));
        loadAdmin();
        frame.setVisible(true);
    }

    public void loadAdmin(){
        SwingModel mainpanel = new SwingModel();
        SwingModel title = new SwingModel();

        title.CreatePanel(0,0,1650,30);
        title.panel.setBackground(Color.DARK_GRAY);

        title.CreateButton(1320,0,50,30,"x");
        title.button.setBackground(Color.red);
        title.button.setForeground(Color.WHITE);
        title.button.setFocusable(false);
        title.button.setBorder(null);
        title.button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        title.CreateLabel(650,0,300,30,"Payra Admin Panel","Cursive",13);
        title.label.setForeground(Color.LIGHT_GRAY);


        title.panel.add(title.button);
        title.panel.add(title.label);


        mainpanel.CreatePanel(0,30,1650,1050);
//        mainpanel.panel.setBackground(Color.BLACK);
        mainpanel.panel.setBackground(new Color(0,0,0));



        SwingModel ob1 = new SwingModel();
        SwingModel ob2 = new SwingModel();
        SwingModel ob3 = new SwingModel();
        SwingModel ob4 = new SwingModel();
        SwingModel ob5 = new SwingModel();

        ob1.CreatePanel(0,0,270,1050);
        ob1.panel.setBackground(new Color(0,0,0));
//        ob1.panel.setBackground(Color.BLACK);

        ob1.CreateImage(70,30,100,100,"C:\\Users\\Farzana\\IdeaProjects\\Payra\\src\\pr.png");


        ob2.CreatePanel(270,0,1380,1050);
        ob2.panel.setBackground(new Color(1,4,17));

        ob2.CreateHoverPanelCustom(0,150,268,50);
        ob2.CreateResizeImage(40,8,25,25,"C:\\Users\\Farzana\\IdeaProjects\\Payra\\src\\layout.png");
        ob2.CreateLabel(80,8,120,30,"Dashboard","Verdana",16);
        ob2.label.setForeground(Color.LIGHT_GRAY);
        ob2.hoverpanel.add(ob2.label);
        ob2.hoverpanel.add(ob2.image_label);

        ob3.CreateHoverPanelCustom(0,200,268,50);
        ob3.CreateResizeImage(40,8,25,25,"C:\\Users\\Farzana\\IdeaProjects\\Payra\\src\\user.png");
        ob3.CreateLabel(80,8,120,30,"User List","Verdana",16);
        ob3.label.setForeground(Color.LIGHT_GRAY);
        ob3.hoverpanel.add(ob3.label);
        ob3.hoverpanel.add(ob3.image_label);
        ob3.hoverpanel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                userListpanel(ob2.panel);
            }
        });



        ob1.panel.add(ob2.hoverpanel);
        ob1.panel.add(ob3.hoverpanel);






        ob1.panel.add(ob1.image_label);
        mainpanel.panel.add(ob1.panel);
        mainpanel.panel.add(ob2.panel);
        frame.add(mainpanel.panel);
        frame.add(title.panel);


    }

    public void userListpanel(JPanel parentpanel){
        SwingModel userlists = new SwingModel();
        userlists.CreatePanel(0,0,1380,1050);
        userlists.panel.setBackground(new Color(1,4,17));

        ResultSet rz= userlists.GetData("SELECT * FROM users");

        userlists.CreateTable(120,180,870,500,rz);
        userlists.scrollPane.setBorder(BorderFactory.createMatteBorder(0,0,0,0,Color.BLACK));
        userlists.scrollPane.getViewport().setBackground(new Color(1,4,29));
        userlists.table.setBackground(new Color(1,4,29));

        userlists.panel.add(userlists.scrollPane);
        parentpanel.add(userlists.panel);

    }
}
