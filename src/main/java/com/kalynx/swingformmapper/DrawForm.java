package com.kalynx.swingformmapper;

import javax.imageio.ImageIO;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DrawForm {

    public DrawForm(FormReader reader) throws IOException {
        BufferedImage img = new BufferedImage(reader.getBounds().width, reader.getBounds().height, BufferedImage.TYPE_INT_RGB);
        Graphics graphics = img.getGraphics();

        for (ComponentData componentData : reader.getComponentDataMap()) {
            graphics.drawString(componentData.getComponentName(), componentData.getBounds().x, componentData.getBounds().y + componentData.getBounds().height / 2);
            graphics.drawRect(componentData.getBounds().x, componentData.getBounds().y, componentData.getBounds().width, componentData.getBounds().height);
        }
        ImageIO.write(img, "png", new File("form.png"));
    }
}
