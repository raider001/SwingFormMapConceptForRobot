package com.kalynx.swingformmapper;

import freemarker.template.TemplateException;

import java.io.IOException;

public interface Templater {
    void generate(FormReader mapping) throws TemplateException, IOException;

}
