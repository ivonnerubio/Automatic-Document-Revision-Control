def execute(){

    //Create a json object with the details of the current file
    JsonArray attributeDetailsList = new JsonArray();
    
    DocumentVO document = documentService.getDocumentDetails();
                   
    //Set the default value for the revision as Auto
    String revDefaultValue = "Auto";
    
    attributeDetailsList.add(getAttributeJSON(IDocumentAttribute.REV, IDocumentAttribute.STANDARD, IDocumentAttribute.READ_ONLY, revDefaultValue)); // Params: Attribute Name, Type Of Atribute, Editable/Read Only, default value

    //Set the revision
    document.setResponseStatus(false);
    
    document.setDynamicObject(attributeDetailsList.toString());
    
    return document;
    
}

     
// This is a generic method to prepare JSON object. No need to do any change in this method.
private JsonObject getAttributeJSON(String attributeName, boolean isCustomAttribute, boolean editOption, String defaultValue) {

    JsonObject attribute =  new JsonObject();

    attribute.addProperty("attributeName", attributeName);

    attribute.addProperty("isEditable", false);

    attribute.addProperty("isCustomAttribute", isCustomAttribute);

    attribute.addProperty("defaultValue", defaultValue);

    return attribute;

}
