import java.util.*;

public class Application {
    public static void main(String[] args) {

        ArrayList<AthleteInformation> athletes = new ArrayList<AthleteInformation>();
        athletes.add(new AthleteInformation("Eaint Thiri Mon", 62.5, 3, "Beginner", 0, 3));
        athletes.add(new AthleteInformation("John Doe", 95.6, 4, "Intermediate", 1, 4));
        athletes.add(new AthleteInformation("Alice Smith", 105.1, 5, "Elite", 2, 5));
        athletes.add(new AthleteInformation("Michael Johnson", 90.3, 2, "Beginner", 0, 3));
        athletes.add(new AthleteInformation("Emily Brown", 55.9, 1, "Intermediate", 2, 4));
        athletes.add(new AthleteInformation("David Wilson", 75.4, 2, "Elite", 3, 2));

        Scanner scan = new Scanner(System.in);
        AthleteInformation athleteInformation = new AthleteInformation(null, 0, 0, null, 0, 0);
        String athleteChoice = athleteInformation.getAthleteChoice();
        System.out.println("Welcome to the North Sussux Judo!");

        // Check if the user is a new user
        /*
         * do-while looping is used to check the user's response and restrict any input
         * apart from Yes/No
         */
        String isNewUser;
        do {
            System.out.println("Are you a new user? (Yes/No)");
            isNewUser = scan.nextLine();
            System.out.println("---------------------------------------------------------");

            if (!isNewUser.equalsIgnoreCase("Yes") && !isNewUser.equalsIgnoreCase("No")) {
                System.out.println("Please enter only Yes or No.");
            }
        } while (!isNewUser.equalsIgnoreCase("Yes") && !isNewUser.equalsIgnoreCase("No"));
        // User is a new user
        if (isNewUser.equalsIgnoreCase("Yes")) {
            //User input
            athleteInformation.inputAthleteInformation(scan);
            // User is not a new user
        } else {
            // Display already registered information
            checkOldAthlete(athletes);
            registerMore(args);
        }

        // Adding the new athletes to the arraylist
        athletes.add(athleteInformation);

        // Displaying the details of the athlete information
        athleteInformation.outputAthleteInformation();

        // Calculate and display total cost for a new athlete
        double totalCostNewAthlete = calculateTotalCost(athleteInformation, athleteInformation.getTrainingPlan(),
                athleteChoice,
                athleteInformation.getNumOfComs(), athleteInformation.getCoachingHrs(), true);

        System.out.println("Total cost: $" + totalCostNewAthlete + "0");
        System.out.println("---------------------------------------------------------");

        displayRegisterList(athletes);
        // Ask if user wants to register more
        registerMore(args);
        scan.close();
    }

    /*
     * Method to check if the old registered athlete exists.
     * This method will check the registered name of the athlete and compare it with
     * the name entered by the user.
     * If the name matches, the details of the registered athlete will be displayed.
     */
    static void checkOldAthlete(ArrayList<AthleteInformation> athletes) {
        Scanner sc = new Scanner(System.in);
        String oldAthleteName = AthleteInformation.validateStringInput(sc, "What is your registered name?");
        System.out.println("---------------------------------------------------------");

        // Displaying the details of the user whose name matches the input
        boolean found = false;
        for (AthleteInformation athleteInfo : athletes) {
            if (athleteInfo.getName().equals(oldAthleteName)) {
                System.out.println("Your registered information is here...");
                System.out.println("---------------------------------------------------------");
                System.out.println("Name: " + athleteInfo.getName());
                System.out.println("Your Current Weight: " + athleteInfo.getCurrentWeight());
                System.out.printf("According to our weight category, ");

                athleteInfo.compareWeights();
                athleteInfo.weightCategory(athleteInfo.getCurrentWeight());

                System.out.println("Training Plan: " + athleteInfo.getTrainingPlan());
                System.out.println("Number of Competitions: " + athleteInfo.getNumOfComs());
                System.out.println("Coaching Hours: " + athleteInfo.getCoachingHrs());
                // Calculate total cost
                double totalCostOldAthlete = calculateTotalCost(athleteInfo, athleteInfo.getTrainingPlan(),
                        athleteInfo.getAthleteChoice(),
                        athleteInfo.getNumOfComs(), athleteInfo.getCoachingHrs(), false);

                System.out.println("Total cost: $" + totalCostOldAthlete + "0");
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
    }
    /*
     * Method to calculate total cost. This method calculates the total cost based
     * on the athlete's selected items:
     * training plan fees, competition fees, and coaching fees based on hours. This
     * method works for both new athletes
     * old registered athletes.
     */
    private static double calculateTotalCost(AthleteInformation athleteInfo, String trainingPlan, String athleteChoice,
            int numOfComs,
            int coachingHours, boolean isNewAthlete) {
        double trainingPlanCost = 0;
        double competitionCost = 0;
        double coachingCost = 0;
        int weeks = 4;

        // Accessing attributes of the AthleteInformation object
        String t_Plan = athleteInfo.getTrainingPlan();
        // Calculate training plan cost
        if (t_Plan.equalsIgnoreCase("Beginner")) {
            trainingPlanCost = 25.00 * weeks;
            System.out.println("Training Plan Cost: $100.00 per month");
        } else if (t_Plan.equalsIgnoreCase("Intermediate")) {
            trainingPlanCost = 30.00 * weeks;
            System.out.println("Training Plan Cost: $120.00 per month");
        } else {
            trainingPlanCost = 35.00 * weeks;
            System.out.println("Training Plan Cost: $140.00 per month");
        }

        // Calculate competition cost based on athlete choice
        if (athleteInfo.getAthleteChoice().equalsIgnoreCase("Yes")) {
            competitionCost = numOfComs * 22.00;
            System.out.println("Competition Cost: $" + competitionCost + "0");
        }

        // Calculate coaching cost
        coachingCost = 9.00 * coachingHours;
        if (coachingHours >= 1) {
            System.out.println("Coaching Cost: " + coachingCost + "0 per week");
        } else {
            System.out.println("Private Coaching Cost: None");
        }

        // Calculate total cost
        double totalCost = trainingPlanCost + competitionCost + coachingCost;
        return totalCost;
    }
    static void displayRegisterList(ArrayList<AthleteInformation> athletes) {
        System.out.println("Newly Registered Athletes:");
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------");
        System.out.printf("| %-20s | %-15s | %-20s | %-15s | %-10s | %-10s |\n", "Name", "Current Weight",
                "Weight Category", "Training Plan", "Competitions", "Coaching Hours");
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------");
        for (AthleteInformation athlete : athletes) {
            System.out.printf("| %-20s | %-15.2f | %-20s | %-15s | %-12d | %-16d |\n", athlete.getName(),
                    athlete.getCurrentWeight(), AthleteInformation.displayCategory(athlete.getCurrentWeight()), athlete.getTrainingPlan(),
                    athlete.getNumOfComs(), athlete.getCoachingHrs());

        }
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------------");
    }

}
