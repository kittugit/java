java - cxfrest
==============

cxfrest - RestFul Service using Apache CXF + Maven + Eclipse


Required: 
Java 7+ and Eclipse Luno

Step 1: Add Maven Archetype Catelog into Eclipse

Windows->Preference->Maven->ArcheTypes - Add Remote Catalog "http://repo1.maven.org/maven2/archetype-catalog.xml"

Step 2: Create New Maven Project - Select Archetype "cxf-jaxrs-service"

Step 3: Copy "HelloWord.java" from cxfrest and replace in your maven project

Step 4:  Run Maven Clean, Install and Maven Build with goal - tomcat7:run-war

Step 5: Test REST Service using REST Client (like Chrome Web App - Advacnce REST Client)

1) http://localhost:13000/jaxrs-service/hello/echo/{input} - Simple HTTP GET

2) http://localhost:13000/jaxrs-service//hello/jsonBean  - HTTP POST - Accepts and Produce JSON

3) http://localhost:13000/jaxrs-service//hello/image - HTTP Multipart/Form-Data - File(Image) Upload







