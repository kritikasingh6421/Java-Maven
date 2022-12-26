## Advance Java Assignment - 4

### Assignment :

Implement a product search Web Application using Spring, Hibernate technology  that lists matching products for a customer 
who are looking to buy T-shirts. Instead of providing input on console, users will use a web application to input. 
The web application must be developed using Spring MVC. 
Spring and Hibernate integration has to be implemented.

#### Problem Statement :
 
     Input :
         Program should accept 4 input parameters

         * Color
         * Size
         * Gender
         * Output Preference 

        “Gender” - is a String which has two possible values like ‘M’ and ‘F’. M=Male and F=Female.
        “Output Preference” is a String which suggests whether the results should be sorted only by Price or by Rating 
          or by both  Price and Rating.

     Output:
         Program should display the list of available T-shirts with details on web for provided user inputs.

#### Expected Behavior and Output:

     * Program should be written considering that there could be more csv files and at runtime program should load the files. 
     * Please make use of Thread which will look for any new file at particular location after some configurable time 
        and load the provided file.
     * Create a login Page for the application and after successful login Product Search Screen will be displayed.
     * Search screen should have all input parameters specified in previous slides as Color, Size, Gender and output preference.
     * Once Search is triggered after specifying the search parameters, program will display the search results from the database 
        using hibernate.
     * Use Spring MVC and Spring - Hibernate Integration
     * Spring version 3 or 4 should be used

### Technology Used :
    
       * Advance Java
       * Meven
       * Hibernate
       * Spring MVC
       
### Database Used :
       * MySql
           ** Database Name - spring_shop_hib
           ** Table Name - user and tshirts



