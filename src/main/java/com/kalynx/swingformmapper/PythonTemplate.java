package com.kalynx.swingformmapper;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.Objects;

public class PythonTemplate implements Templater {
    Configuration cfg;
    Template template;
    PythonTemplate(Configuration cfg) throws IOException {
        this.cfg = Objects.requireNonNull(cfg);
        template = cfg.getTemplate("pythonmodel.ftl");
    }

    public void generate(FormReader mapping) throws TemplateException, IOException {
        Writer out = new OutputStreamWriter(System.out);
        template.process(mapping, out);
    }
}
