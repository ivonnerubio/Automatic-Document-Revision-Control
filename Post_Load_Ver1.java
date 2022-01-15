def execute(){
    // Get the current revision of the document and initialize a global revision variable that will be applied to the file
    DocumentVO document = documentService.getDocumentDetails();
    
    String revision_new = document.getRevision();
    
    String doc_publisher = document.getPublisherName();
    
    if(revision_new=="Auto"){
        
        revision_new ="00";
    }
    
    // Hash map to retrieve the previous revision
    HashMap<Object, Object> optionMap = new HashMap();

    optionMap.put(RevisionOption.GET_REVISIONS, RevisionOption.PREVIOUS_REVISION);
 
    optionMap.put(RevisionDetailsOption.BASIC_DETAILS, true);

    optionMap.put(RevisionOption.INCLUDE_DEACTIVATED, false);

    // Here revisionsMap will have issue number as key and DocumentVO as value.
    Map<String, DocumentVO> revisionsMap = documentService.getDocumentRevisionDetail(document, optionMap); 
  
    // If statement to see if this is a new file or an existing file. If true, it retrieves the revision and save into a String variable
    if(!doc_publisher.equals("Workflow Agent System")){
        if(!revisionsMap.isEmpty()){
            Map.Entry<String, DocumentVO> entry = revisionsMap.entrySet().iterator().next();

            String docRef_revision = entry.getKey();

            DocumentVO document_previous = entry.getValue();

            String revision_previous = document_previous.getRevision();
            
            if(isInteger(revision_previous)){
                // Convert the string into an integer and add one
                int revision_pre = Integer.parseInt(revision_previous);
                revision_pre = revision_pre + 1;

                // Turn the revision to an integer and set the new revision number
                if (revision_pre <= 9) {
                    revision_new = "0" + revision_pre.toString();
                }
                else{
                    revision_new = revision_pre.toString();
                  } 
            }
            else{
                revision_new = "00";
            }
        }
    }

    // Apply the new revision to the file
    documentContext.getDocVO().revision = revision_new;   

    documentService.updateDocument(documentContext);

}

public static boolean isInteger(String s) {
    try { 
        Integer.parseInt(s); 
    } catch(NumberFormatException e) { 
        return false; 
    } catch(NullPointerException e) {
        return false;
    }
    return true;
}
