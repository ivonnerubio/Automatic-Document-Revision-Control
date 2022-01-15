# Automatic-Document-Revision-Control

CONTENTS OF THIS FILE
---------------------

 * Introduction
 * Requirements
 * Installation


INTRODUCTION
------------

The automatic revision control will automatically increase the revision on a file everytime its uploaded by the user by an increment of 1. Once it is implemented, it will lock the revision and it will now appear as "Auto" during the onload screen. As soon as the file is uploaded it, the revision will show. The help guide located on this folder will walk you further on how the process will look like for both new and previous files. 



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
 
 1. Create a system task that executes a groovy script and paste the text from the On Load.groovy file. Name it "Automatic Revision Control On Load"

 2 . Create a system task that executes a groovy script and paste the text from the Post Load.groovy file. Name it "Automatic Revision Control Post Load"

 3. Create a trigger for with the following values: 
	- Name: Automatic Revision Control Edit Attributes
	- Conditions: *Folder where the rev control will be applied*
	- Event: Edit Attributes
	- Task Mode: Onload
	- Task: Automatic Revision Control On Load

 3. Create a second trigger for with the following values: 
	- Name: Automatic Revision Control On Load
	- Conditions: *Folder where the rev control will be applied*
	- Event: Publish Documents
	- Task Mode: Onload
	- Task: Automatic Revision Control On Load

 4. Create a third trigger for with the following values: 
	- Name: Automatic Revision Control Post Load 
	- Conditions: *Folder where the rev control will be applied*
	- Event: Publish Documents
	- Task Mode: Post
	- Task: Automatic Revision Control On Load

You're folder should now have the rev control :)
