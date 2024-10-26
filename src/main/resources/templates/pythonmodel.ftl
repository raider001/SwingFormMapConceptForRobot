from robot.api.deco import keyword

class ${formName?replace(" ", "")}Model:

    @keyword
    def create_${formName?replace(" ", "_")}_model(self, <#list componentDataMap as item>${item.componentName}:str=""<#sep>, </#sep></#list>) -> dict:
        return locals().items()

