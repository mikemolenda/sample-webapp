# Deployment

Create a new directory in tomcat/webapps called Widecast.

Copy the directories css, img, includes, and js to the document root of the web app.

Copy the *contents* of the jsp directory directly into the document root.

Compile Java files to the appropriate subdirectory of /WEB-INF/classes, e.g. compile java/\*.java to /WEB-INF/classes/\*.class, java/controllers/includes/\*.java to /WEB-INF/classes//controllers/includes/\*.class.

Copy web.xml into WEB-INF

---

# Running

## Logging in

Login credentials for all roles:

By default, there are two sample users for each role:

### Customers:
-  username: customer1 / password: cis419
-  username: customer2 / password: cis419

### Managers:
-  username: manager1 / password: cis419
-  username: manager2 / password: cis419

### Technicians:
-  username: technician1 / password: cis419
-  username: technician2 / password: cis419

### Account Specialists:
-  username: admin1 / password: cis419
-  username: admin2 / password: cis419

Each user's name matches their role.  
All users share the password cis419 by default.

All users are assigned a role type.  
Logging in automatically takes user to the appropriate homepage for their role.

---

## Completed as part of academic coursework:

CIS 419 Web Application Development, Winter 2016  
Final Project  
Northwestern University  
March 13, 2016  

Mike Molenda  
michaelmolenda2014@u.northwestern.edu
