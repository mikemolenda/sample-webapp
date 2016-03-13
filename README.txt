CIS 419 Web Application Development, Winter 2016  
Final Project 
Northwestern University  
March 13, 2016  

Mike Molenda  
michaelmolenda2014@u.northwestern.edu   

---

# Deployment

Deploy the app by copying the contents of Deploy/widecast to: 
{TOMCAT_HOME}/webapps/widecast 

The application context should look like the following:



---

# Running

Run the application by navigating to http://{HOSTNAME}/wirecast/index.jsp


## Logging in

Login credentials for all roles: 

There are two sample users for each role. Usernames match the role type:

Customers:
  - customer1
  - customer2

Managers:
  - manager1
  - manager2

Technicians: 
  - technician1
  - technician2

Account Specialists:
  - admin1
  - admin2

All sample users have the same password, regardless of role: cis419

All users are assigned a role type. Logging in automatically takes the user to the appropriate homepage for their role.

---

#  Statistics

## Lines of Code (incl. whitespace & comments)

TOTAL: 

index.jsp:  



## Requirements Implemented

I. Orders  
  A. TV plan enrollment - 3 packages                    IMPLEMENTED CORRECTLY  
  B. Internet plan Enrollment - 2 packages              IMPLEMENTED CORRECTLY  
  C. PPV Live Sports Events - Hard-Code 10 Events       IMPLEMENTED CORRECTLY
  D. PPV Movies - Hard-Code 20 Movies                   IMPLEMENTED CORRECTLY

II. Roles   
  A. Manager
    1. Has all privileges                               IMPLEMENTED CORRECTLY  
    2. Cancel/update/delete any order                   IMPLEMENTED CORRECTLY  
  B. Account Specialist
    1. Create new customer account                      IMPLEMENTED CORRECTLY  
    2. Update existing customer account                 IMPLEMENTED CORRECTLY  
    3. Create incident ticket & assign to Technician    IMPLEMENTED CORRECTLY        
    4. Place PPV order                                  IMPLEMENTED CORRECTLY    
  C. Technician
    1. Schedule incident ticket                         IMPLEMENTED CORRECTLY    
    2. Close incident ticket                            IMPLEMENTED CORRECTLY    
    3. Cancel incident ticket                           IMPLEMENTED CORRECTLY    
  D. Customer
    1. Update personal info                             IMPLEMENTED CORRECTLY  
    2. Pay Monthly Bill                                 IMPLEMENTED CORRECTLY    
    3. Order PPV event                                  IMPLEMENTED CORRECTLY    
    4. Cancel ordered PPV (> 24 hrs b/f PPV date)       IMPLEMENTED CORRECTLY  
    5. Change/Cancel/Add TV or Internet plan            IMPLEMENTED CORRECTLY  
  E. All users
    1. Have login & password (hard code in Map)         IMPLEMENTED CORRECTLY  
IV. Search Autocomplete                                 IMPLEMENTED CORRECTLY    

