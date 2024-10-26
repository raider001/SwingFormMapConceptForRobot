package com.kalynx.swingformmapper;

import com.kalynx.testforms.FormTest1;
import freemarker.template.TemplateException;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException, TemplateException {
        FormTest1 formTest1 = new FormTest1();
        FormReader formReader = new FormReader(formTest1);
        DrawForm drawForm = new DrawForm(formReader);
        TemplateEngine templateEngine = new TemplateEngine();
        templateEngine.generateTemplates(formReader);
    }
}
