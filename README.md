java - cxfrest
==============

cxfrest - RestFul Service using Apache CXF + Maven + Eclipse


Required: 
Java 7+ and Eclipse Luno

Step 1: Add Maven Archetype Catelog into Eclipse

Windows->Preference->Maven->ArcheTypes - Add Remote Catalog "http://repo1.maven.org/maven2/archetype-catalog.xml"

Step 2: Create New Maven Project - Select Archetype "cxf-jaxrs-service"

Step 3: Copy "HelloWord.java" from cxfrest and replace in your maven project

Step 4: Maven Clean, Install and Maven Build with goad - tomcat7:run-war

Step 5: Test Rest Service using REST Client (Chrome Web App - Advacnce REST Client)
1) /hello/echo/{input} - Simple HTTP GET

2) /hello/jsonBean  - HTTP POST - Accepts and Produce JSON

3) /hello/image - HTTP Multipart/Form-Data - File(Image) Upload







