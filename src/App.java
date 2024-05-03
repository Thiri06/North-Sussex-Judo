import java.util.*;

class AthleteInfo {
    private String name;
    private double currentWeight;
    private double competitionWeight;
    private String t_Plan;
    private int numOfComs;
    private int coachingHrs;

    public AthleteInfo(String name, double currentWeight, double competitionWeight, String t_Plan, int numOfComs,
            int coachingHrs) {
        this.name = name;
        this.currentWeight = currentWeight;
        this.competitionWeight = competitionWeight;
        this.t_Plan = t_Plan;
        this.numOfComs = numOfComs;
        this.coachingHrs = coachingHrs;
    }

    public String getName() {
        return name;
    }

    public double getCurrentWeight() {
        return currentWeight;
    }

    public double getCompetitionWeight() {
        return competitionWeight;
    }

    public String getT_Plan() {
        return t_Plan;
    }

    public int getNumOfComs() {
        return numOfComs;
    }

    public int getCoachingHrs() {
        return coachingHrs;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }

    public void setCompetitionWeight(double competitionWeight) {
        this.competitionWeight = competitionWeight;
    }

    public void setT_Plan(String t_Plan) {
        this.t_Plan = t_Plan;
    }

    public void setNumOfComs(int numOfComs) {
        this.numOfComs = numOfComs;
    }

    public void setCoachingHrs(int coachingHrs) {
        this.coachingHrs = coachingHrs;
    }

    /*
     * Method to compare current weight with competition weight.
     * This method will display the result according to the weight categories table.
     */

    public void compareWeights() {
        if (currentWeight > competitionWeight) {
            System.out.println("Your current weight is higher than your competition weight.");
        } else if (currentWeight < competitionWeight) {
            System.out.println("Your current weight is lower than your competition weight.");
        } else {
            System.out.println("Your current weight is the same as your competition weight.");
        }

        System.out.printf("Based on our Judo's weight categories table,");
        if (competitionWeight > 100) {
            System.out.println(" You are in Heavyweight category.");
        } else if (competitionWeight <= 100 && competitionWeight > 90) {
            System.out.println(" You are in Light-Heavyweight category.");
        } else if (competitionWeight <= 90 && competitionWeight > 81) {
            System.out.println(" You are in Middleweight category.");
        } else if (competitionWeight <= 81 && competitionWeight > 73) {
            System.out.println(" You are in Light-Middleweight category.");
        } else if (competitionWeight <= 73) {
            System.out.println(" You are in Lightweight category.");
        } else {
            System.out.println(" You are in Flyweight category.");
        }
    }
}

public class App {
    public static void main(String[] args) {
        // creating ArrayList to hold User objects
        ArrayList<AthleteInfo> athletes = new ArrayList<AthleteInfo>();

        // Adding users to the ArrayList
        athletes.add(new AthleteInfo("Eaint Thiri Mon", 70.8, 80.9, "Beginner", 0, 2));
        athletes.add(new AthleteInfo("John Doe", 80.5, 75.3, "Intermediate", 1, 4));
        athletes.add(new AthleteInfo("Alice Smith", 65.2, 70.7, "Elite", 2, 5));
        athletes.add(new AthleteInfo("Michael Johnson", 90.3, 85.8, "Beginner", 0, 3));
        athletes.add(new AthleteInfo("Emily Brown", 55.9, 60.2, "Intermediate", 2, 4));
        athletes.add(new AthleteInfo("David Wilson", 75.4, 70.9, "Elite", 3, 2));

        // declaration and initialization
        String athleteChoice = "";
        int numOfComs = 0;
        int coachingHrs = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the North Sussux Judo!");

        // Check if the user is a new user
        /*
         * do-while looping is used to check the user's response and restrict any input
         * apart from Yes/No
         */
        String isNewUser;
        do {
            System.out.println("Are you a new user? (Yes/No)");
            isNewUser = scanner.nextLine();
            System.out.println("---------------------------------------------------------");

            if (!isNewUser.equalsIgnoreCase("Yes") && !isNewUser.equalsIgnoreCase("No")) {
                System.out.println("Please enter only Yes or No.");
            }
        } while (!isNewUser.equalsIgnoreCase("Yes") && !isNewUser.equalsIgnoreCase("No"));
        //User is a new user
        if (isNewUser.equalsIgnoreCase("Yes")) {
            String infoDisplay;
            do {
                System.out.println(
                        "Do you want to look our training plan table, weight category table, and additional information? (Yes/No)");
                infoDisplay = scanner.nextLine();
                System.out.println("---------------------------------------------------------");
                if (!infoDisplay.equalsIgnoreCase("Yes") && !infoDisplay.equalsIgnoreCase("No")) {
                    System.out.println("Please enter only Yes or No.");
                }
            } while (!infoDisplay.equalsIgnoreCase("Yes") && !infoDisplay.equalsIgnoreCase("No"));
            if (infoDisplay.equalsIgnoreCase("Yes")) {
                // call the method to display information tables
                displayinformationTables();
            }
        //User is not a new user
        } else {
            // Display already registered information
            checkOldAthlete(athletes);
            registerMore(args);
        }

        // Input information for a new athlete
        String name = validateStringInput(scanner, "Enter your name:");
        System.out.println("---------------------------------------------------------");

        double currentWeight = validateIntegerInput(scanner, "Enter your current weight in kilograms:");
        System.out.println("---------------------------------------------------------");

        double competitionWeight = validateIntegerInput(scanner, "Enter your competition weight in kilograms:");
        System.out.println("---------------------------------------------------------");

        System.out.println(
                "What kind of training paln do you want from our Judo's training plans?\n-Beginner\n-Intermediate\n-Elite");
        String t_Plan = validateStringInput(scanner, "Enter your training plan (Beginner/Intermediate/Elite):");
        System.out.println("---------------------------------------------------------");

        // competitions entered
        
        if (t_Plan.equalsIgnoreCase("Intermediate") || t_Plan.equalsIgnoreCase("Elite")) {
            do {
                System.out.println("You are eligble to enter the competitions held by our Judo.");
                System.out.println("Do you want to enter the competitions held by our North Sussex Judo? (Yes/No)");
                athleteChoice = scanner.nextLine();
                System.out.println("---------------------------------------------------------");

                if (!athleteChoice.equalsIgnoreCase("Yes") && !athleteChoice.equalsIgnoreCase("No")) {
                    System.out.println("Please enter only Yes or No.");
                }
            } while (!athleteChoice.equalsIgnoreCase("Yes") && !athleteChoice.equalsIgnoreCase("No"));

            if (athleteChoice.equalsIgnoreCase("Yes")) {
                do {
                    numOfComs = validateIntegerInput(scanner, "How many competitions do you want to enter? (1, 2, 3):");
                    System.out.println("---------------------------------------------------------");
                    if (numOfComs > 3) {
                        System.out.println("You can participate in a maximum of 3 competitions. Please try again.");
                    }
                } while (numOfComs > 3);
            }
            
        }

        // Private Coaching
        String userAns;
        /*
         * do-while looping is used to check the user's response and restrict any input
         * apart from Yes/No
         */
        do {
            System.out.println("Do you want to get private coaching sessions? (Yes/No)");
            userAns = scanner.nextLine();
            System.out.println("---------------------------------------------------------");

            if (!userAns.equalsIgnoreCase("Yes") && !userAns.equalsIgnoreCase("No")) {
                System.out.println("Please enter only Yes or No.");
            }
        } while (!userAns.equalsIgnoreCase("Yes") && !userAns.equalsIgnoreCase("No"));

        if (userAns.equalsIgnoreCase("Yes")) {
            do {
                coachingHrs = validateIntegerInput(scanner,
                        "How many hours of private coaching do you want? (1, 2, 3, 4, 5):");

                System.out.println("---------------------------------------------------------");
                if (coachingHrs > 5) {
                    System.out
                            .println("You can only have up to maximum 5 hours of private coaching. Please try again.");
                }
            } while (coachingHrs > 5);
        }

        // Create AthleteInfo object for the new athlete and add it to the ArrayList
        AthleteInfo newAthlete = new AthleteInfo(name, currentWeight, 
                competitionWeight,
                t_Plan, numOfComs,
                coachingHrs);
        // Adding the new athletes to the arraylist.
        athletes.add(newAthlete);
        // Displaying the details of the new athlete
        System.out.println("New athlete registered successfully!");
        System.out.println("---------------------------------------------------------");
        System.out.println("Details of the new athlete:");
        System.out.println("---------------------------------------------------------");
        System.out.println("Name: " + newAthlete.getName());
        System.out.println("Current Weight: " + newAthlete.getCurrentWeight() + "kg");
        System.out.println("Competition Weight: " + newAthlete.getCompetitionWeight() + "kg");
        /*
         * call the method from AthleteInfo class to compare athlete's current weight
         * and competition weight and display result
         */
        newAthlete.compareWeights();

        System.out.println("Training Plan: " + newAthlete.getT_Plan());
        if (!athleteChoice.isEmpty()) {
            System.out.println("Competitions Entered: " + (athleteChoice.equalsIgnoreCase("Yes") ? numOfComs : "None"));
        } else {
            System.out.println("Competitions Entered: None");
        }
        if (coachingHrs > 0) {
            System.out.println("Private Coaching Hours: " + coachingHrs + " hour(s) per week");
        } else {
            System.out.println("Private Coaching Hours: None");
        }
        // Calculate and display total cost
        double totalCostNewAthlete = calculateTotalCost(t_Plan, athleteChoice, 
        numOfComs, coachingHrs, true); 

        System.out.println("Total cost: $" + totalCostNewAthlete);
        System.out.println("---------------------------------------------------------");

        // Displaying the details of newly registered athletes in a table format
        System.out.println("Newly Registered Athletes:");
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-20s | %-15s | %-20s | %-15s | %-10s | %-10s |\n", "Name", "Current Weight",
                "Competition Weight", "Training Plan", "Competitions", "Coaching Hours");
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------");
        for (AthleteInfo athlete : athletes) {
            System.out.printf("| %-20s | %-15.2f | %-20.2f | %-15s | %-12d | %-16d |\n", athlete.getName(),
                    athlete.getCurrentWeight(), athlete.getCompetitionWeight(), athlete.getT_Plan(),
                    athlete.getNumOfComs(), athlete.getCoachingHrs());
        }
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------");

        // Ask if user wants to register more
        registerMore(args);
        scanner.close();

    } // main method ends here

    // Method to validate string input (accepts only letters and spaces)
    public static String validateStringInput(Scanner scanner, String prompt) {
        String input;
        boolean isValid;
        do {
            System.out.println(prompt);
            input = scanner.nextLine().trim();
            isValid = input.matches("[a-zA-Z ]+"); // Allow letters and spaces
            if (!isValid) {
                System.out.println("Invalid input. Please enter only letters.");
            }
        } while (!isValid);
        return input;
    }

    // Method to validate integer input (accepts only numbers)
    public static int validateIntegerInput(Scanner scanner, String prompt) {
        int input;
        boolean isValid;
        do {
            System.out.println(prompt);
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter only positive numbers.");
                scanner.next();
            }
            input = scanner.nextInt();
            isValid = input > 0; // Validate that the input is positive
        } while (!isValid);
        scanner.nextLine(); // Consume the newline character
        return input;
    }

    /*
     * Method to display training plan included competition fee, private coaching
     * fee, weight categories table,
     * and additional information.
     */
    public static void displayinformationTables() {
        // Training plan table
        String[][] tableData = new String[5][2];

        tableData[0][0] = "Beginner (2 sessions per week)-weekly fee";
        tableData[0][1] = "$25.00";
        tableData[1][0] = "Intermediate (3 sessions per week)-weekly fee";
        tableData[1][1] = "$30.00";
        tableData[2][0] = "Elite (5 sessions per week)-weekly fee";
        tableData[2][1] = "$35.00";
        tableData[3][0] = "Private tuition-per hour";
        tableData[3][1] = "$9.00";
        tableData[4][0] = "Competition entry fee-per competition";
        tableData[4][1] = "$22.00";

        // Welcoming message is here.....
        System.out.println("You can choose the desired training plan from below \"Training Plan Table\" ");

        // Training plan table output
        System.out.println("Training Plan Table:");
        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("| %-50s | %-20s |\n", "Training Plan", "Prices ($USD)");
        System.out.println("-----------------------------------------------------------------------------");
        for (int i = 0; i < tableData.length; i++) {
            System.out.printf("| %-50s | %-20s |\n", tableData[i][0], tableData[i][1]);
        }
        System.out.println("-----------------------------------------------------------------------------");

        // Table for weight categories
        String[][] weightData = new String[7][2];
        weightData[0][0] = "Categories";
        weightData[0][1] = "Upper Weight Limit (Kg)";
        weightData[1][0] = "Heavyweight";
        weightData[1][1] = "Unlimited (over 100)";
        weightData[2][0] = "Light-Heavyweight";
        weightData[2][1] = "100";
        weightData[3][0] = "Middleweight";
        weightData[3][1] = "90";
        weightData[4][0] = "Light-Middleweight";
        weightData[4][1] = "81";
        weightData[5][0] = "Lightweight";
        weightData[5][1] = "73";
        weightData[6][0] = "Flyweight";
        weightData[6][1] = "66";

        // weight categories table output
        System.out.println("Weight Categories Table:");
        System.out.println("---------------------------------------------------------");
        System.out.printf("| %-25s | %-25s |\n", "Weight Categories", "Kilogram");
        System.out.println("---------------------------------------------------------");
        for (int i = 0; i < weightData.length; i++) {
            System.out.printf("| %-25s | %-25s |\n", weightData[i][0], weightData[i][1]);
        }
        System.out.println("---------------------------------------------------------");
        // Additional information goes here
        System.out.println("Additional Rules:");
        System.out.println("1. Athletes can receive a maximum of five hours private coaching a week.");
        System.out.println("2. Only Intermediate and Elite athletes can enter competitions.");
        System.out.println("3. Competitions are held on the second Saturday of each month.");
    }

    /*
     * Method to check if the old registered athlete exists.
     * This method will check the registered name of the athlete and compare it with
     * the name entered by the user.
     * If the name matches, the details of the registered athlete will be displayed.
     */
    static void checkOldAthlete(ArrayList<AthleteInfo> athletes) {
        Scanner sc = new Scanner(System.in);
        String oldAthleteName = validateStringInput(sc, "What is your registered name?");
        System.out.println("---------------------------------------------------------");

        // Displaying the details of the user whose name matches the input
        boolean found = false;
        for (AthleteInfo athleteInfo : athletes) {
            if (athleteInfo.getName().equals(oldAthleteName)) {
                System.out.println("Your registered information is here...");
                System.out.println("---------------------------------------------------------");
                System.out.println("Name: " + athleteInfo.getName());
                System.out.println("Current Weight: " + athleteInfo.getCurrentWeight());
                System.out.println("Competition Weight: " + athleteInfo.getCompetitionWeight());

                // call the comparing weights method
                athleteInfo.compareWeights();

                System.out.println("Training Plan: " + athleteInfo.getT_Plan());
                System.out.println("Number of Competitions: " + athleteInfo.getNumOfComs());
                System.out.println("Coaching Hours: " + athleteInfo.getCoachingHrs());
                // Calculate total cost
                double totalCostOldAthlete = calculateTotalCost(athleteInfo.getT_Plan(), "No",
                        athleteInfo.getNumOfComs(), athleteInfo.getCoachingHrs(), false); // isNewAthlete = false

                System.out.println("Total cost: $" + totalCostOldAthlete+"0");
                found = true;
                System.out.println("---------------------------------------------------------");
                break;
            }
        }
        if (!found) {
            System.out.println("User not found. Please try again.");
        }
    }

    /*
     * Method to register more. This method recursively calls itself to start the
     * registration process again.
     * After registration is done, if user wants to register more, it will be called
     */
    static void registerMore(String[] args) {
        Scanner sc = new Scanner(System.in);
        String registeredMore;
        do {
            System.out.println("Do you want to register more? (Yes/No)");
            registeredMore = sc.nextLine();
            System.out.println("---------------------------------------------------------");
            if (!registeredMore.equalsIgnoreCase("Yes") && !registeredMore.equalsIgnoreCase("No")) {
                System.out.println("Please enter only Yes or No.");
            }
        } while (!registeredMore.equalsIgnoreCase("Yes") && !registeredMore.equalsIgnoreCase("No"));
        if (registeredMore.equalsIgnoreCase("Yes")) {
            main(args); // Recursively call main method to start registration again
        } else {
            System.out.println("Goodbye!");
            System.exit(0);
        }
        sc.close();
    }

    /*
     * Method to calculate total cost. This method calculates the total cost based
     * on the athlete's selected items:
     * training plan fees, competition fees, and coaching fees based on hours. This
     * method works for both new athletes
     * old registered athletes.
     */
    private static double calculateTotalCost(String t_Plan, String athleteChoice, int numOfComs,
            int coachingHours, boolean isNewAthlete) {
        double trainingPlanCost = 0;
        double competitionCost = 0;
        double coachingCost = 0;
        int weeks = 4;
        // Calculate training plan cost
        if (t_Plan.equalsIgnoreCase("Beginner")) {
            trainingPlanCost = 25.00 * weeks;
            System.out.println("Training Plan Cost: $25.00 per week");
        } else if (t_Plan.equalsIgnoreCase("Intermediate")) {
            trainingPlanCost = 30.00 * weeks;
            System.out.println("Training Plan Cost: $30.00 per week");
        } else {
            trainingPlanCost = 35.00 * weeks;
            System.out.println("Training Plan Cost: $35.00 per week");
        }
        // Calculate competition cost
        if (athleteChoice.equalsIgnoreCase("Yes")) {
            competitionCost = numOfComs * 22.00;
            System.out.println("Competition Cost: $" + competitionCost+"0");
        } else {
            competitionCost = 0;
        }
        // Calculate coaching cost
        coachingCost = 9.00 * coachingHours;
        if (coachingHours >= 1) {
            System.out.println("Coaching Cost: " + coachingCost + "0 per hour");
        } else {
            System.out.println("Private Coaching Cost: None");
        }
        // Calculate total cost
        double totalCost = trainingPlanCost + competitionCost + coachingCost;
        return totalCost;
    }
}
