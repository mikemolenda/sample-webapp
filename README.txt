CIS 419 Web Application Development, Winter 2016  
Final Project 
Northwestern University  
March 13, 2016  

Mike Molenda  
michaelmolenda2014@u.northwestern.edu   

---

# Deployment

Deploy the app by copying the contents of Deploy/wirecast to: 
{TOMCAT_HOME}/webapps/wirecast 

The application context should look like the following:



---

# Running

Run the application by navigating to http://{HOSTNAME}/wirecast/index.jsp


## Logging in

Login credentials for all roles: 

There are two sample users for each role. Usernames match the role type:

- customer1
- customer2
- manager1
- manager2
- technician1
- technician2
- accountadmin1
- accountadmin2

All sample users have the same password, regardless of role: cis419

All users are assigned a role type. Logging in automatically takes the user to the appropriate homepage for their role.

---

#  Statistics

## Total Lines of Code (incl. whitespace & comments)

index.jsp:  

TOTAL:      


## Requirements Implemented

I. Enrollment                                           IMPLEMENTED  
  A. TV plan enrollment                                 IMPLEMENTED  
    1. Basic                                            IMPLEMENTED  
    2. BasicPlus                                        IMPLEMENTED  
    3. Ultimate                                         IMPLEMENTED  
  B. Internet plan Enrollment                           IMPLEMENTED  
    a. SpeedLane                                        IMPLEMENTED  
    b. LightLane                                        IMPLEMENTED  

II. Ordering                                            IMPLEMENTED  
  A. PPV Live Sports Events                             IMPLEMENTED  
    1. Hard-Code 10 Events                              IMPLEMENTED
  B. PPV Movies                                         IMPLEMENTED  
    1. Hard-Code 20 Movies                              IMPLEMENTED

III. Roles
  A. Manager
    1. Has all privileges                               NOT ATTEMPTED  
    2. Cancel/update/delete any order                   NOT ATTEMPTED  
  B. Account Specialist
    1. Create new customer account                      NOT ATTEMPTED  
    2. Update existing customer account                 NOT ATTEMPTED  
    3. Create incident ticket & assign to Technician    NOT ATTEMPTED        
    4. Place PPV order                                  NOT ATTEMPTED  
  C. Technician
    1. Schedule incident ticket                         NOT ATTEMPTED  
    2. Close incident ticket                            NOT ATTEMPTED  
    3. Cancel incident ticket                           NOT ATTEMPTED  
  D. Customer
    1. Update personal info                             IMPLEMENTED  
    2. Pay Monthly Bill                                 IMPLEMENTED    
    3. Order PPV event                                  IMPLEMENTED    
    4. Cancel ordered PPV (> 24 hrs b/f PPV date)       IMPLEMENTED  
    5. Change/Cancel/Add TV or Internet plan            IMPLEMENTED  
  E. All users
    1. Have login & password (hard code in Map)         IMPLEMENTED  
IV. Search Autocomplete                                 STARTED  

