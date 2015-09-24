
package groupproject2;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Thomas O Halloran
 * Student Number : R00050862
 * Group Project 2
 */
public class GroupProject2 {

     /**
     * This program takes in the students name, student number and telephone number. It then puts the user into the
     * menu and allows the user to pick multiple items and choose whether to have them delivered or not. The program then 
     * prints out the receipt which is nicely formatted to show the students name in uppercase, order number, list of items chosen
     * and the price for each item and the total cost for the transaction. The user is then prompted whether they want another transaction.
     * If the user chooses "yes" they go through the menu option again and a new receipt is printed for the new transaction but the 
     * student details will remain the same until they quit the program.
     */
    public static void main(String[] args) {
        
		String custName;			//String to hold customers name ( first + last )
		String blank = " ";			//String to hold the value of a space
		String custNameUpperCase;		//String to hold customers name in uppercase
		String nameNoSpaces;			//String to hold customers name with no spaces
		String firstName;			//String to hold the first name substring of full name
		String lastName;			//String to hold the last name substring of full name
	        String firstInitial;			//String to hold the first letter of first name
        	String lastInitial;			//String to hold the first letter of last name
		String studentNum;                      //String tp hold the student number
		String secondPart;                      //String to hold the second section of the student number eg R"12345678"
		String endOfStudentNum;                 //String to hold the last 4 digits of the student number
                String mobileNum;                       //String to hold the users mobile number
		String orderNum;                        //String to hold the order number
                String selection;                      //String used as a selection choice
                int findblank;				//Int used to locate the first occurence of a space in the full name
	        int studentNumSize;                     //Int to hold the length of the student number
                //The following two lines are the counters used to keep track of the users tea + coffee choices 
        	int bewleyTeaCounter, pepperTeaCounter, camoTeaCounter;
        	int cappCounter, latteCounter, espressoCounter, americanoCounter;
                //the following two lines are the constans used for the prices of the tea + coffee items on the menu
        	final double BEWLEY_PRICE = 1.80, PEPPER_PRICE = 1.50, CAMO_PRICE = 1.50;
		final double CAPP_PRICE = 2.00, LATTE_PRICE = 2.00, ESPRESSO_PRICE = 1.50, AMERICANO_PRICE = 1.70;
                final double DELIVERY_PRICE = 1.00;     //Constant to hold the value of the delivery cost
                boolean correctName = false;		//Boolean used to loop "do while" statement to validate users name entry
                boolean correctStudentNum = false;      //Boolean to confirm that the student number entered is correct
                boolean correctMobNum = false;          //Boolean to confirm that the phone number entered is correct
                boolean deliverLab = false;             //Boolean used to confirm if delivery is wanted or not
        	boolean orderComplete = false;          //Boolean used to confimr if the order is completed or not
		boolean quit = false;                   //Boolean used to confirm if user wants to quit
        	boolean validOrder;                     //Boolean used to confirm if the order is valid or not
                boolean finalOption;                    //Boolean used to loop final option menu 
                
		DecimalFormat df = new DecimalFormat("##.00");      //This is used to format figures to 2 decimal places
		Scanner scanner = new Scanner(System.in);           //This is the scanner item used to take users keyboard entries
       
	//This do while loop takes in the users name and continually loops until the user
	//enters a valid name
       do 
	{
        	System.out.println("Enter your name: eg Thomas Tomlinson\n"
                                 + "Or enter 'q' to quit");
        	        
		custName = scanner.nextLine();
                nameNoSpaces = custName.replaceAll(" ", "");	//Creates new string of customers name without spaces
                correctName = true;				//Set boolean to true and will only be set to false if name doesn't pass validation steps below.

                //This method allows the user to choose "q" and quit the application        
                if( custName.equalsIgnoreCase("q"))
                    {
                        System.out.println( "|----------  Call back soon   ----------|   " );
                        System.out.println( "|----------  Have a nice day  ----------|   " );
                        System.out.println( "|---------------------------------------|   " );
                        System.exit(0);
                    }
                
                //This method checks the name string with no spaces for letters only.
                if( nameNoSpaces.matches("[a-zA-Z]+"))
                    {
                        correctName = true;
                    }
                        else
                            {
                                System.out.println("Name must only contain letters");
                                correctName = false;
                            }

                //Method checks to see if the first and last blank  are in the same position
                //This allows validation to ensire only one space is between first + last name
		if( custName.indexOf(blank) != custName.lastIndexOf(blank) )
                    {
                        System.out.println("Please ensure that there is only one space between\n"
                                         + "your first and last name : eg Tom Tomlinson");
                        correctName = false;                    
                    }
                
		//Method checks to see if there is a blank in the name string 
		if( custName.indexOf(blank) == -1 )
                    {
                        System.out.println("You must enter first + last name: eg Tom Tomlinson");
                        correctName = false;                    
                    }
                
       } while ( correctName == false);
       
		findblank = custName.indexOf(blank);				//Finds the position of the first blank in the name string
		custNameUpperCase = custName.toUpperCase();			//Creates new string of customers name all in upper case
		firstName = custNameUpperCase.substring(0, findblank);		//Creates first name substring up to the first blank position
		lastName = custNameUpperCase.substring(findblank + 1);		//Creates last name substring from the position after the blank space in the name string
		firstInitial = firstName.substring(0, 1);			//Creates substring of first name to get the first letter
		lastInitial = lastName.substring(0, 1);				//Creates substring of last name to get the first letter

	//This do while loop takes in the users student number and continually loops until the user
	//enters a valid student number
	do
        {
        	System.out.println("Please enter your Student ID : eg R12345678");
        
		studentNum = scanner.nextLine();
                studentNumSize = studentNum.length();		//Methods gets the length of the student number

                //This method allows the user to choose "q" and quit the application        
                if( custName.equalsIgnoreCase("q"))
                    {
                        System.out.println( "|----------  Call back soon   ----------|   " );
                        System.out.println( "|----------  Have a nice day  ----------|   " );
                        System.out.println( "|---------------------------------------|   " );
                        System.exit(0);
                    }
                
                //This method checks that the student number is 9 characters in length
        	if ( studentNumSize != 9 )
                    {
                        System.out.println("Student Number must begin with R followed by 8 numbers eg/ R12345678");
                        correctStudentNum = false;	
                    }
                        else if ( !studentNum.startsWith("R")  )
                            {
                                System.out.println("Student Number must start with Capital R");
                                correctStudentNum = false;
                            }
                                else
                                    {
                                        correctStudentNum = true;
                                    }

		//Create substring of student number from 2nd position to last
		secondPart = studentNum.substring(1);
		
                //This method checks that all characters in the substring secondPart are letters
		if( !secondPart.matches("[0-9]+") )
                    {
                        correctStudentNum = false;
                    }		
                
        } while ( correctStudentNum == false );
        
		//Student number is set to always be 9 characters long and this creates substring to get last 4 numbers
        	endOfStudentNum = studentNum.substring(5, 9);
        
		//Order Number is created from the intital of the users first + last name with an "_" and then the last 4 digits of the student number
        	orderNum = ( firstInitial + lastInitial + "_" + endOfStudentNum );
                
        //This do loop gets the user to enter their phone number
	do
	{
        	System.out.println("Please enter your phone number : eg 0861234567");
        	
		mobileNum = scanner.nextLine();
		correctMobNum = true;

                //This method allows the user to choose "q" and quit the application        
                if( custName.equalsIgnoreCase("q"))
                    {
                        System.out.println( "|----------  Call back soon   ----------|   " );
                        System.out.println( "|----------  Have a nice day  ----------|   " );
                        System.out.println( "|---------------------------------------|   " );
                        System.exit(0);
                    }

                //This method validates users phone number to ensure only numbers are entered
		if (!mobileNum.matches("[0-9]+"))
			{
				System.out.println(" Please only enter numbers, No letters or special characters!!! ");
				correctMobNum = false;	
			}
                
	} while ( correctMobNum == false );

        //This loop will continue to produce the main menu while quit is not equal to true
	while ( quit != true )
        {
            //This will reset all counters when a user chooses to do another transaction
            bewleyTeaCounter = 0; 
            pepperTeaCounter = 0; 
            camoTeaCounter = 0;
            cappCounter = 0; 
            latteCounter = 0; 
            espressoCounter = 0; 
            americanoCounter = 0;
            validOrder = false;
            
            
            //This do while loop allows the user to choose multiple products from the tea + coffee menus    
            do
                {
                    System.out.println("Please choose the applicable number for your selection:\n"
                            	+ "[1] Tea\n"
                            	+ "[2] Coffee\n"
                            	+ "[3] Complete order and print receipt\n"
                            	+ "[4] Cancel Transaction");
                
                    selection=scanner.nextLine();
                
                switch (selection)
                    {       
                        //This is the main menu for tea options
                        case "1":System.out.println("Please choose the applicable number for your selection:");
                         System.out.println("[1] Bewley's Breakfast Tea ( Pot for €1.80)");
                         System.out.println("[2] Peppermint (€1.50)");
                         System.out.println("[3] Camomile (€1.50)");
                         System.out.println("[4] Return to Main Menu");
                           
                         selection=scanner.nextLine();   
                  
				//This is the sub menu for the different tea options
                                switch ( selection){
                            
                                    		case "1":System.out.println("Bewley's Breakfast Tea has been added.");
                                        	bewleyTeaCounter++;
                                                validOrder = true;
                                        	break;
                         
                                  		case "2":System.out.println("Peppermint Tea has been added.");
                                    		pepperTeaCounter++;
                                                validOrder = true;
                                        	break;
                                        
                                        	case "3":System.out.println("Camomile Tea has been added.");
                                        	camoTeaCounter++;
                                                validOrder = true;
                                        	break;
                                            
                                            	case "4":System.out.println("Welcome back to the Main Menu");
                                            	break;
                                            
                                                default:System.out.println("Please enter a valid selection.");
                        			   }
                        break;
                        
                        //This the main menu for coffee items
                        case "2":System.out.println("Please choose the applicable number for your selection:");
                         System.out.println("[1] Cappuccino (€2.00)");
                         System.out.println("[2] Latte (€2.00)");
                         System.out.println("[3] Espresso (€1.50)");
                         System.out.println("[4] Americano (€1.70)");
                         System.out.println("[5] Return to Main Menu");
                           
                         selection=scanner.nextLine();
                         
                                switch ( selection){   
                                    		case "1":System.out.println("Cappuccino has been added.");
                                        	cappCounter++;
                                                validOrder = true;
                                        	break;
                                        
                                        	case "2":System.out.println("Latte has been added.");
                                        	latteCounter++;
                                                validOrder = true;
                                        	break;
                                            
                                            	case "3":System.out.println("Espresso has been added.");
                                        	espressoCounter++;
                                                validOrder = true;
                                        	break;
                                                
                                                case "4":System.out.println("Americano has been added.");
                                        	americanoCounter++;
                                                validOrder = true;
                                        	break;
                                                    
                                            	case "5":System.out.println("Welcome back to the Main Menu");
                                            	break;
                                            
                                                default:System.out.println("Please enter a valid selection.");
                                		   }
                  	break;

                        case "3":
                  	quit = true;
                  	orderComplete = true;
                 	break;
                      
                        case "4":System.out.println("Transaction has been cancelled");
                        System.out.println( "|----------  Call back soon   ----------|   " );
                        System.out.println( "|----------  Have a nice day  ----------|   " );
                        System.out.println( "|---------------------------------------|   " );
                        System.exit(0);
                      
                        default:System.out.println("Please enter a valid selection.");
                    }
                }while ( quit != true );

                //The following if statement will only be actioned if the user chooses at least 1 item from the menu.
                //If the user does not choose anything it reverts the user back to the main menu.   
        if ( validOrder != true && orderComplete == true)
            {
                System.out.println("You have ordered nothing, please start again");
                quit = false;
            }
                else if ( validOrder == true && orderComplete == true)
                    {
                        do
                            {
                                quit = false;
                            
                                System.out.println("Please choose the applicable number for your selection:\n"
                                    + "[1] Deliver Current Order to Lab 1.2 (+€1.00)\n"
                                    + "[2] Collect Current Order at Canteen ( Free )");
                            
                                selection=scanner.nextLine();
                                
                                switch (selection)
                                    {
                                        case "1": //Order will be delivered to Lab 1.2:
                                        deliverLab = true;
                                        quit = true;
                                        break;
                                        
                                        case "2": //Order is waiting for you at the Canteen
                                        deliverLab = false;
                                        quit = true;
                                        break; 
                                        
                                        default:System.out.println("Please enter a valid selection.");
                                    }
                            }while (quit != true);
                    }
         
            //If the user opts to complete the order and has picked at least 1 item then a 
            //receipt is printed to the screen
            if( quit != false)
            {
                    System.out.println( "|---------------------------------------|   " );
                    System.out.println( "|-------------  Toms Cafe  -------------|   " );
                    System.out.println( "|       Order Number: "+ orderNum +"           | " );
                    System.out.println( "                   ~ ~" );
                    System.out.println( " Customers Name: " + custNameUpperCase );
                    System.out.println( "                   ~ ~" );
                    
                    //The following for loops print a list of each item the user has chosen.
                    for( int printCounter = 0; printCounter < bewleyTeaCounter; printCounter++  ){
            			System.out.println ( "| Bewley's Tea: €" + df.format(BEWLEY_PRICE) );
        		}
                    for( int printCounter = 0; printCounter < pepperTeaCounter; printCounter++  ){
            			System.out.println ( "| Peppermint Tea: €" + df.format(PEPPER_PRICE) );
        		}
                    for( int printCounter = 0; printCounter < camoTeaCounter; printCounter++  ){
            			System.out.println ( "| Camomile Tea: €" + df.format(CAMO_PRICE) );
        		}
                    for( int printCounter = 0; printCounter < cappCounter; printCounter++  ){
            			System.out.println ( "| Cappuccino: €" + df.format(CAPP_PRICE) );
        		}
                    for( int printCounter = 0; printCounter < latteCounter; printCounter++  ){
            			System.out.println ( "| Latte: €" + df.format(LATTE_PRICE) );
        		}
                    for( int printCounter = 0; printCounter < espressoCounter; printCounter++  ){
            			System.out.println ( "| Espresso: €" + df.format(ESPRESSO_PRICE) );
        		}
                    for(int printCounter = 0; printCounter < americanoCounter; printCounter++  ){
            			System.out.println ( "| Americano: €" + df.format(AMERICANO_PRICE) );
        		}
                
                    //This is the total of the order formatted to two decimal places.
                    double totalDrinksPrice = ( (bewleyTeaCounter*BEWLEY_PRICE)+( pepperTeaCounter*PEPPER_PRICE )+
                                            ( camoTeaCounter*CAMO_PRICE )+( cappCounter*CAPP_PRICE )+( latteCounter*LATTE_PRICE )
                                            +( espressoCounter*ESPRESSO_PRICE )+( americanoCounter*AMERICANO_PRICE ));
        
                    //This double holds the total value of the users order including the delivery cost.
                    double totalPrice = (totalDrinksPrice + DELIVERY_PRICE);

                    //If the user chooses delivery it prints it to the screen otherwise advises the user to collect the order from
                    //the canteen and give the user the order number
                    if( deliverLab == true )
                        {
                            System.out.println( "                   ~ ~" );
                            System.out.println("| Your Order will be delivered to\n"
                                     + "  Lab 1.2: €" + df.format(DELIVERY_PRICE));
                            System.out.println( "        *** Total Price: €" + df.format(totalPrice) + " *** " );
                            System.out.println( "                   ~ ~" );
                            System.out.println( "|----------  Have a nice day  ----------|   " );
                            System.out.println( "|---------------------------------------|   " );
                        }
                            else
                                {
                                    System.out.println( "                   ~ ~" );
                                    System.out.println("| Your Order is waiting for you at\n"
                                             + "  the Canteen");
                                    System.out.println("| Please give your order number to\n "
                                             + "  the server: " + orderNum);
                                    System.out.println( "                   ~ ~" );
                                    System.out.println( "        *** Total Price: €" + df.format(totalDrinksPrice) + " *** " );
                                    System.out.println( "                   ~ ~" );
                                    System.out.println( "|----------  Have a nice day  ----------|   " );
                                    System.out.println( "|---------------------------------------|   " );
                                }
            do{
                finalOption = false;
                
                //If the user completed a valid transaction a menu for another transaction appears where the user details
                //will reamin the same but the 
                if ( validOrder == true && orderComplete == true)
                    {
                        System.out.println("Please choose the applicable number for your selection:\n"
                                    + "[1] Make another tranaction\n"
                                    + "[2] Quit");
                            
                    
                        selection=scanner.nextLine();
                    
                        switch (selection)
                            {          
                                case "1": 
                                quit = false;
                                finalOption = true;
                                break;
                                
                                case "2":System.out.println( "|---------------------------------------|   " );
                                System.out.println( "|----------  Call back soon   ----------|   " );
                                System.out.println( "|----------  Have a nice day  ----------|   " );
                                System.out.println( "|---------------------------------------|   " );
                                quit = true;
                                finalOption = true;
                                break;
                            
                                default:System.out.println("Please enter a valid selection.");
                            }
                    }
            } while ( finalOption != true);
        }
        }
    }
}
    
