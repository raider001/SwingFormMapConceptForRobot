package com.kalynx.swingformmapper;

import com.google.gson.Gson;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.text.JTextComponent;

import java.awt.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class FormReader implements Serializable {

    private String formName;
    private Rectangle bounds;
    private List<ComponentData> componentDataMap = new ArrayList<>();

    public FormReader(JFrame container) {
        bounds = container.getBounds();
        formName = container.getTitle();
        container.repaint();

        Rectangle innerBounds = container.getRootPane().getBounds();
        traverse(container, innerBounds.x, innerBounds.y);
        System.out.println("Form Name: " + formName + " Complete");
    }

    public void traverse(Container container, int offsetX, int offsetY) {
        for (Component component : container.getComponents()) {
            Rectangle bounds = new Rectangle(component.getBounds());
            bounds.x = bounds.x + offsetX;
            bounds.y = bounds.y + offsetY;
            if (component instanceof JTextComponent) {
                JTextComponent textComponent = (JTextComponent) component;

                componentDataMap.add(new ComponentData(textComponent.getName(), bounds, textComponent.isEditable(), ComponentType.TextField));
            } else if (component instanceof JComboBox<?>) {
                JComboBox<?> comboBox = (JComboBox<?>) component;
                componentDataMap.add(new ComponentData(comboBox.getName(), bounds, comboBox.isEditable(), ComponentType.ComboBox));
            } else if (component instanceof JCheckBox) {
                JCheckBox checkBox = (JCheckBox) component;
                componentDataMap.add(new ComponentData(checkBox.getName(), bounds, checkBox.isEnabled(), ComponentType.CheckBox));
            }
            else if (component instanceof Container) {
                traverse((Container) component, bounds.x, bounds.y);
            }
        }
    }

    public String toJSON() {
        Gson gson = new Gson();
        return gson.toJson(this);
    }

    public String getFormName() {
        return formName;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public List<ComponentData> getComponentDataMap() {
        return componentDataMap;
    }
}
