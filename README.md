# Automatic-Document-Revision-Control

CONTENTS OF THIS FILE
---------------------

 * Introduction
 * Requirements
 * Installation


INTRODUCTION
------------

The automatic revision control will automatically increase the revision on a document everytime its uploaded by the user by an increment of 1. Once it is implemented, it will lock the revision and it will appear as "Auto" during the onload screen. As soon as the document is uploaded, the numerical revision will show. 

The help guide located on this repository will walk you further on how the process works om new and previous documents. 



REQUIREMENTS
------------

This control requires the following items:

 * Post Load.groovy
 * On Load.groovy
 * Edit Attributes Onload Trigger
 * Publish Documents Onload Trigger
 * Publish Documents Post Load Trigger


INSTALLATION
------------
 
 1. Create a system task that executes a groovy script and paste the text from the On Load.groovy script. Name it "Automatic Revision Control On Load"

 2. Create a system task that executes a groovy script and paste the text from the Post Load.groovy script. Name it "Automatic Revision Control Post Load"

 3. Create a trigger with the following values: 
	- Name: Automatic Revision Control Edit Attributes
	- Conditions: *Folder where the revision control will be applied*
	- Event: Edit Attributes
	- Task Mode: Onload
	- Task: Automatic Revision Control On Load

 3. Create a second trigger with the following values: 
	- Name: Automatic Revision Control On Load
	- Conditions: *Folder where the revision control will be applied*
	- Event: Publish Documents
	- Task Mode: Onload
	- Task: Automatic Revision Control On Load

 4. Create a third trigger with the following values: 
	- Name: Automatic Revision Control Post Load 
	- Conditions: *Folder where the rev control will be applied*
	- Event: Publish Documents
	- Task Mode: Post
	- Task: Automatic Revision Control On Load

Congratulations! Your folder should have the revision control.
