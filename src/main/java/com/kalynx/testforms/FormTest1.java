package com.kalynx.testforms;

import net.miginfocom.swing.MigLayout;

import javax.swing.*;

public class FormTest1 extends JFrame {

    public FormTest1() {
        super("Form Test 1");
        setTitle("Form Test 1");
        setSize(500, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new MigLayout("","[][][][]","[][][]"));

        JTextField textField = new JTextField();
        textField.setName("textField1");
        textField.setColumns(20);
        add(textField, "cell 1 1");

        JPanel panel = new JPanel();
        JComboBox<String> comboBox = new JComboBox<>();
        comboBox.setName("comboBox1");
        comboBox.addItem("Item 1");
        comboBox.addItem("Item 2");
        comboBox.addItem("Item 3");
        panel.add(comboBox);
        add(panel, "cell 1 2");

        JCheckBox checkBox = new JCheckBox("Check Box 1");
        checkBox.setName("checkBox1");
        add(checkBox, "cell 1 3");


        setVisible(true);
    }

    public static void main(String[] args) {
        new FormTest1();
    }
}
