public class Main {
    public static final Scanner scanner = new Scanner(System.in);
    public static ArrayList<ArrayList<Integer>> relationshipGraph = new ArrayList<>();
    public static void main(String[] args) {

    }

    public static void displayMenu() {
        System.out.println("- - - - - - - - - - - - - - - -");
        System.out.println("             MCO2");
        System.out.println("- - - - - - - - - - - - - - - -");
        System.out.println("\n1. Display Friend List");
        System.out.println("2. Display Connections");
        System.out.println("0. Exit Program");
        System.out.println("- - - - - - - - - - - - - - - -");
        System.out.println("\nEnter choice: ");
        int choice = scanner.nextInt();

        switch(choice) {
            case 1: displayFriendList();
            break;
            case 2: displayConnections();
            break;
            case 0: System.exit(0);
            break;
        }

    }

    /*
        PART 2: Display Friend List
        - input ID number of a person
        - if ID number does not exist, display an error WITHOUT TERMINATING PROGRAM
        - otherwise, program must display the following:
            > friends of the person
            > total number of friends
         */
    public static void displayFriendList() {
        System.out.print("Input ID number: ");
        int idNum = scanner.nextInt();

        if (idNum < 0 || idNum >= relationshipGraph.size() || relationshipGraph.get(idNum).isEmpty()) {
            System.out.println("Error: ID number does not exist or has no friends.");
            return;
        }

        ArrayList<Integer> friends = relationshipGraph.get(idNum);
        System.out.println("Friends of " + idNum + ":");
        for (int friend : friends) {
            System.out.println("- " + friend);
        }
        System.out.println("Total number of friends: " + friends.size());
    }

    /*
        PART 3: Display Connections
        - input two ID numbers (x and y)
        - if ID number x or y does not exist, display an error WITHOUT TERMINATING PROGRAM
        - otherwise, program must display the connections (IDK HOW TO EXPLAIN)
         */
    public static void displayConnections() {
        System.out.print("Input first ID number: ");
        int idNum1 = scanner.nextInt();
        System.out.print("Input second ID number: ");
        int idNum2 = scanner.nextInt();
    }
}
