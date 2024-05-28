package org.example.repositorioArquivos.ui;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;

public class Menu extends JFrame{
    private JPanel mainPanel;
    private JTree tree1;
    private JTextField textField1;
    private JTextField textField2;

    public Menu() {

        this.setTitle("Titulo da janela");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(300,300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);

//        JFrame f;
//        f=new JFrame();
//        DefaultMutableTreeNode style=new DefaultMutableTreeNode("Style");
//        DefaultMutableTreeNode color=new DefaultMutableTreeNode("color");
//        DefaultMutableTreeNode font=new DefaultMutableTreeNode("font");
//        style.add(color);
//        style.add(font);
//        DefaultMutableTreeNode red=new DefaultMutableTreeNode("red");
//        DefaultMutableTreeNode blue=new DefaultMutableTreeNode("blue");
//        DefaultMutableTreeNode black=new DefaultMutableTreeNode("black");
//        DefaultMutableTreeNode green=new DefaultMutableTreeNode("green");
//        color.add(red); color.add(blue); color.add(black); color.add(green);
//        tree1 =new JTree(style);
//        f.add(tree1);
//        f.setSize(200,200);
//        f.setVisible(true);

    }
}
