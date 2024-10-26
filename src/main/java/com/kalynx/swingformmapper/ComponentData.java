package com.kalynx.swingformmapper;

import java.awt.Rectangle;

public class ComponentData {
    private String componentName;
    private Rectangle bounds;

    private boolean readonly;

    private ComponentType type;

    public ComponentData(String componentName, Rectangle bounds, boolean readonly, ComponentType type) {
        this.componentName = componentName;
        this.bounds = bounds;
        this.readonly = readonly;
        this.type = type;
    }

    public String getComponentName() {
        return componentName;
    }

    public Rectangle getBounds() {
        return bounds;
    }

    public boolean isReadonly() {
        return readonly;
    }

    public ComponentType getType() {
        return type;
    }
}
