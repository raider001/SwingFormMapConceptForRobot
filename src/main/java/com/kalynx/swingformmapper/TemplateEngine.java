package com.kalynx.swingformmapper;


import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import freemarker.template.TemplateExceptionHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.TimeZone;

public class TemplateEngine {
    Configuration cfg = new Configuration(Configuration.VERSION_2_3_30);
    List<Templater> templaters = new ArrayList<>();
    public TemplateEngine() throws IOException {
        cfg.setClassForTemplateLoading(TemplateEngine.class, "/templates");
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER);
        cfg.setLogTemplateExceptions(false);
        cfg.setWrapUncheckedExceptions(true);
        cfg.setFallbackOnNullLoopVariable(false);
        cfg.setSQLDateAndTimeTimeZone(TimeZone.getDefault());
        templaters.add(new PythonTemplate(cfg));
        templaters.add(new RobotResourceTemplate(cfg));
    }

    public void generateTemplates(FormReader formReader) throws TemplateException, IOException {
        for (Templater templater : templaters) {
            templater.generate(formReader);
        }
    }
}
