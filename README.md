CIS 419 Web Application Development, Winter 2016  
Final Project
Northwestern University
March 13, 2016

Mike Molenda
michaelmolenda2014@u.northwestern.edu

---

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

#  Statistics

## Lines of Code (incl. whitespace & comments)

### GRAND TOTAL: 5428 Lines

#### SERVLET TOTAL:                                                   2737 LINES
controllers/Account.java ............................................. 156 LINES
controllers/AddOrder.java ............................................ 119 LINES
controllers/AddTicket.java ........................................... 111 LINES
controllers/AutoComplete.java ........................................ 104 LINES
controllers/Home.java ................................................  79 LINES
controllers/ItemList.java ............................................  73 LINES
controllers/Login.java ...............................................  71 LINES
controllers/Logout.java ..............................................  44 LINES
controllers/ModifyOrder.java ......................................... 118 LINES
controllers/NewCustomer.java ......................................... 101 LINES
controllers/PayBill.java .............................................  85 LINES
controllers/UpdateCustomer.java ......................................  71 LINES
controllers/ViewCustomers.java .......................................  81 LINES
controllers/ViewInvoice.java ......................................... 128 LINES
controllers/ViewOrders.java ..........................................  82 LINES
controllers/ViewTickets.java ......................................... 128 LINES
controllers/includes/AlertMessage.java ...............................  58 LINES
controllers/includes/CustomerTable.java .............................. 104 LINES
controllers/includes/CustomerUIPanels.java ...........................  72 LINES
controllers/includes/InvoiceAction.java ..............................  79 LINES
controllers/includes/InvoiceTable.java ...............................  84 LINES
controllers/includes/ItemOrderTable.java .............................  81 LINES
controllers/includes/ListButton.java .................................  60 LINES
controllers/includes/NavBar.java .....................................  63 LINES
controllers/includes/OrderTable.java ................................. 118 LINES
controllers/includes/SelectCustomer.java .............................  76 LINES
controllers/includes/SelectItem.java ................................. 128 LINES
controllers/includes/SelectTechnician.java ...........................  75 LINES
controllers/includes/TicketTable.java ................................ 188 LINES

#### MODEL CLASSES TOTAL:                                             1258 LINES
model/EntityData.java ................................................ 606 LINES
model/items/InternetPlan.java ........................................  30 LINES
model/items/Item.java ................................................  73 LINES
model/items/PPVLiveEvent.java ........................................  53 LINES
model/items/PPVMovie.java ............................................  31 LINES
model/items/TVPlan.java ..............................................  30 LINES
model/roles/AccountSpecialist.java ...................................  29 LINES
model/roles/Customer.java ............................................  45 LINES
model/roles/Manager.java .............................................  29 LINES
model/roles/Technician.java ..........................................  29 LINES
model/roles/User.java ................................................  93 LINES
model/system/Order.java ..............................................  93 LINES
model/system/Ticket.java ............................................. 117 LINES

#### JSP TOTAL:                                                        881 LINES
account-info.jsp .....................................................  71 LINES
add-customer.jsp .....................................................  49 LINES
add-order.jsp ........................................................  26 LINES
customer-list.jsp ....................................................  31 LINES
index-account-specialist.jsp .........................................  46 LINES
index-customer.jsp ...................................................  34 LINES
index-manager.jsp ....................................................  49 LINES
index-technician.jsp .................................................  33 LINES
invoice.jsp ..........................................................  32 LINES
item-list.jsp ........................................................  20 LINES
login.jsp ............................................................  40 LINES
modify-order.jsp .....................................................  32 LINES
order-list.jsp .......................................................  31 LINES
payment-confirmation.jsp .............................................  19 LINES
payment-failure.jsp ..................................................  21 LINES
search.jsp ...........................................................  40 LINES
ticket-form.jsp ......................................................  32 LINES
tickets.jsp ..........................................................  31 LINES
includes/action-button.jsp ...........................................   3 LINES
includes/alert.jsp ...................................................   3 LINES
includes/footer.jsp ..................................................   5 LINES
includes/header.jsp ..................................................  15 LINES
includes/header-search.jsp ...........................................  15 LINES
includes/nav-account-specialist.jsp ..................................  25 LINES
includes/nav-customer.jsp ............................................  30 LINES
includes/nav-login.jsp ...............................................  18 LINES
includes/nav-manager.jsp .............................................  26 LINES
includes/nav-technician.jsp ..........................................  24 LINES
includes/table-head-4.jsp ............................................   9 LINES
includes/table-head-5.jsp ............................................  10 LINES
includes/table-tr-form-4.jsp .........................................  17 LINES
includes/table-tr-form-5.jsp .........................................  18 LINES
includes/ui-panel.jsp ................................................  26 LINES

#### MISCELLANEOUS CODE TOTAL:                                         552 LINES
css/main.css .........................................................  39 LINES
js/autocomplete.js ................................................... 130 LINES
web.xml .............................................................. 383 LINES
