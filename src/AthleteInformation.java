import java.util.Scanner;

class AthleteInformation {

    private String name;
    private double currentWeight;
    private int selectWeightCategory;
    private String trainingPlan;
    private int numOfComs;
    private int coachingHrs;
    private String athleteChoice ="";

    public AthleteInformation(String name, double currentWeight, int selectWeightCategory, String trainingPlan, int numOfComs,
            int coachingHrs) {
        this.name = name;
        this.currentWeight = currentWeight;
        this.selectWeightCategory = selectWeightCategory;
        this.trainingPlan = trainingPlan;
        this.numOfComs = numOfComs;
        this.coachingHrs = coachingHrs;

    }
    //gettters
    public String getName() {
        return name;
    }
    public double getCurrentWeight() {
        return currentWeight;
    }
    public int getSelectWeightCategory() {
        return selectWeightCategory;
    }
    public String getTrainingPlan() {
        return trainingPlan;
    }
    public int getNumOfComs() {
        return numOfComs;
    }
    public int getCoachingHrs() {
        return coachingHrs;
    }
    public String getAthleteChoice() {
        return athleteChoice;
    }
    public void setName(String name) {
        this.name = name;
    }
    //Setters
    public void setCurrentWeight(double currentWeight) {
        this.currentWeight = currentWeight;
    }
    public void setSelectWeightCategory(int selectWeightCategory) {
        this.selectWeightCategory = selectWeightCategory;
    }
    public void setTrainingPlan(String trainingPlan) {
        this.trainingPlan = trainingPlan;
    }
    public void setNumOfComs(int numOfComs) {
        this.numOfComs = numOfComs;
    }
    public void setCoachingHrs(int coachingHrs) {
        this.coachingHrs = coachingHrs;
    }

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
    //Method to validate double input
    public static double validateDoubleInput(Scanner scanner, String prompt) {
        double input;
        boolean isValid;
        do {
            System.out.println(prompt);
            while (!scanner.hasNextDouble()) {
                System.out.println("Invalid input. Please enter only positive numbers.");
                scanner.next();
            }
            input = scanner.nextDouble();
            isValid = input > 0; // Validate that the input is positive
        } while (!isValid);
        scanner.nextLine(); // Consume the newline character
        return input;
    }

    public void inputAthleteInformation(Scanner scanner){
                
        name = validateStringInput(scanner, "Enter your name: ");
        System.out.println("---------------------------------------------------------");

        currentWeight = validateDoubleInput(scanner, "Enter your current weight in kilograms: ");
        System.out.println("---------------------------------------------------------");

        do {
            selectWeightCategory = validateIntegerInput(scanner, "Please select your competition weight category:\n(1) Heavyweight-over 100kg\n(2) Light-Heavyweight-100kg\n(3) Middleweight-90kg\n(4) Light-Middleweight-81kg\n(5) Lightweight-73kg\n(6) Flyweight-66kg");
            System.out.println("---------------------------------------------------------");

            if (selectWeightCategory >= 7) {
                System.out.println("Please enter a valid option.");
            }
        }while (selectWeightCategory >= 7);
        
        displayTrainingPlan();
        trainingPlan = validateStringInput(scanner, "Enter your training plan: ");
        System.out.println("---------------------------------------------------------");
        if (trainingPlan.equalsIgnoreCase("Intermediate") || trainingPlan.equalsIgnoreCase("Elite")) {
            do {
                System.out.printf("You are eligble to enter the competitions held by our Judo.");
                System.out.println("(Competition entry fee per competition-$22.00)");
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
                System.out.println("You can get maximum 5 hours of private coaching in a week.");
                coachingHrs = validateIntegerInput(scanner,
                        "How many hours of private coaching do you want? (1, 2, 3, 4, 5):");

                System.out.println("---------------------------------------------------------");
                if (coachingHrs > 5) {
                    System.out
                            .println("You can only have up to maximum 5 hours of private coaching. Please try again.");
                }
            } while (coachingHrs > 5);
        }
    }

    public void compareWeights(){
        double weight = getCurrentWeight(); // Get the current weight
    
        if (weight > 100){
            System.out.println("You are in Heavyweight category");
        } else if (weight <= 100 && weight > 90){
            System.out.println("You are in Light-Heavyweight category");
        } else if (weight <= 90 && weight > 81){ 
            System.out.println("You are in Middleweight category");
        } else if (weight <= 81 && weight > 73){ 
            System.out.println("You are in Light-Middleweight category");
        } else if (weight <= 73 && weight > 66){ 
            System.out.println("You are in Lightweight category");
        } else if (weight <= 66){ 
            System.out.println("You are in Flyweight category");
        } else {
            System.out.println("You are below Flyweight category");
        }
    }
    
    
    //method to compare the current weight and the competition weight category
    public void weightCategory(double currentWeight) {
        double optionOne = 100;
        double optionTwo = 100;
        double optionThree = 90;
        double optionFour = 81;
        double optionFive = 73;
        double optionSix = 66;
        double result;
    
        if (selectWeightCategory == 1) {
            result = currentWeight - optionOne; // Calculate the difference
            if (currentWeight < optionOne) {
                System.out.println("Weight Category Comparison: You need to gain " + Math.abs(result) + "kg to match with your competitive weight category (over 100kg)");
            } else {
                System.out.println("Weight Category Comparison: You need to lose " + Math.abs(result) + "kg to match with your competitive weight category (over 100kg)");
            }
        } else if (selectWeightCategory == 2) {
            result = currentWeight - optionTwo;
            if (currentWeight < optionTwo) {
                System.out.println("Weight Category Comparison: You need to gain " + Math.abs(result) + "kg to match with your competitive weight category (100kg)");
            } else {
                System.out.println("Weight Category Comparison: You need to lose " + Math.abs(result) + "kg to match with your competitive weight category (100kg)");
            }
        } else if (selectWeightCategory == 3) {
            result = currentWeight - optionThree;
            if (currentWeight < optionThree) {
                System.out.println("Weight Category Comparison: You need to gain " + Math.abs(result) + "kg to match with your competitive weight category (90kg)");
            } else {
                System.out.println("Weight Category Comparison: You need to lose " + Math.abs(result) + "kg to match with your competitive weight category (90kg)");
            }
        } else if (selectWeightCategory == 4) {
            result = currentWeight - optionFour;
            if (currentWeight < optionFour) {
                System.out.println("Weight Category Comparison: You need to gain " + Math.abs(result) + "kg to match with your competitive weight category (81kg)");
            } else {
                System.out.println("Weight Category Comparison: You need to lose " + Math.abs(result) + "kg to match with your competitive weight category (81kg)");
            }
        } else if (selectWeightCategory == 5) {
            result = currentWeight - optionFive;
            if (currentWeight < optionFive) {
                System.out.println("Weight Category Comparison: You need to gain " + Math.abs(result) + "kg to match with your competitive weight category (73kg)");
            } else {
                System.out.println("Weight Category Comparison: You need to lose " + Math.abs(result) + "kg to match with your competitive weight category (73kg)");
            }
        } else {
            result = currentWeight - optionSix;
            if (currentWeight < optionSix) {
                System.out.println("Weight Category Comparison: You need to gain " + Math.abs(result) + "kg to match with your competitive weight category (66kg)");
            } else {
                System.out.println("Weight Category Comparison: You need to lose " + Math.abs(result) + "kg to match with your competitive weight category (66kg)");
            }
        }
    }
    public static String displayCategory(double currentWeight) {
        if (currentWeight > 100) {
            return "Heavyweight";
        } else if (currentWeight > 90) {
            return "Light-Heavyweight";
        } else if (currentWeight > 81) {
            return "Middleweight";
        } else if (currentWeight > 73) {
            return "Light-Middleweight";
        } else if (currentWeight > 66) {
            return "Lightweight";
        } else {
            return "Flyweight";
        }
    }
    
    public void outputAthleteInformation(){

        System.out.println("You have registered successfully!!!");
        System.out.println("---------------------------------------------------------");
        System.out.println("Name: " + getName());
        System.out.println("Your current weight: "+getCurrentWeight());
        System.out.printf("According to our weight category, ");
        compareWeights();
        weightCategory(getCurrentWeight());
        System.out.println("Training Plan: " + getTrainingPlan());
        if (!getAthleteChoice().isEmpty()) {
            System.out.println("Competitions Entered: " + (getAthleteChoice().equalsIgnoreCase("Yes") ? numOfComs : "None"));
        } else {
            System.out.println("Competitions Entered: None");
        }
        if (coachingHrs > 0) {
            System.out.println("Private Coaching Hours: " + coachingHrs + " hour(s) per week");
        } else {
            System.out.println("Private Coaching Hours: None");
        }
    }


    public void displayTrainingPlan(){
        // Training plan table
        String[][] tableData = new String[3][2];

        tableData[0][0] = "Beginner (2 sessions per week)-weekly fee";
        tableData[0][1] = "$25.00";
        tableData[1][0] = "Intermediate (3 sessions per week)-weekly fee";
        tableData[1][1] = "$30.00";
        tableData[2][0] = "Elite (5 sessions per week)-weekly fee";
        tableData[2][1] = "$35.00";

        // Welcoming message is here.....
        System.out.println("Please choose the desired training plan from below: ");

        // Training plan table output
        System.out.println("-----------------------------------------------------------------------------");
        System.out.printf("| %-50s | %-20s |\n", "Training Plan", "Prices ($USD)");
        System.out.println("-----------------------------------------------------------------------------");
        for (int i = 0; i < tableData.length; i++) {
            System.out.printf("| %-50s | %-20s |\n", tableData[i][0], tableData[i][1]);
        }
        System.out.println("-----------------------------------------------------------------------------");
    }


}
    

    

