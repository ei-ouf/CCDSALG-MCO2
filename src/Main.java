
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static final Scanner scanner = new Scanner(System.in);
    public static ArrayList<ArrayList<Integer>> relationshipGraph = new ArrayList<>();
    public static void main(String[] args) {
        /*
        PART 1: Loading the Graph
        - must accept as input the file name or file path of the text file
        - must be stored in appropriate data structure after reading
        - must display a menu for two features
            > display friend list
            > display connections
         */
        FileReader fr = new FileReader();

        //Read file into relationships array

        RelationshipRecord[] relationships = fr.readFile("data/Harvard1.txt");

        //Add an arrayList of integers (empty) to each node
        for (int j = 0; j <= relationships.length; j++){
            relationshipGraph.add(new ArrayList<>());
        }


        for (RelationshipRecord relationship : relationships) {
            // relationships[i] = (1, 2)

            int person1 = relationship.getPerson1();
            int person2 = relationship.getPerson2();


            if(!relationshipGraph.get(person1).contains(person2) && !relationshipGraph.get(person2).contains(person1)) {
                relationshipGraph.get(person1).add(person2);
                relationshipGraph.get(person2).add(person1);
            }
        }

/*
        for (int k = 0; k <relationships.length; k++){
            int[] friends = new int[2500];
            int number = 0;


            for (int l = 0; l < relationshipGraph.get(k).size(); l++){
                friends[l] = relationshipGraph.get(k).get(l);
                number += 1;
            }

            System.out.println("friend of "+ k + "is ");

            for (int m = 0; m < number ; m++){
                System.out.println(friends[m]);
            }
       }

 */

        displayMenu();
    }

    public static void displayMenu() {

        while (true) {
            System.out.println("- - - - - - - - - - - - - - - -");
            System.out.println("             MCO2");
            System.out.println("- - - - - - - - - - - - - - - -");
            System.out.println("\n1. Display Friend List");
            System.out.println("2. Display Connections");
            System.out.println("0. Exit Program");
            System.out.println("- - - - - - - - - - - - - - - -");
            System.out.print("\nEnter choice: ");
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


        if (idNum1 < 0 || idNum1 >= relationshipGraph.size() || relationshipGraph.get(idNum1).isEmpty()) {
            System.out.println("Error: ID number does not exist or has no friends.");
            return;
        }

        System.out.print("Input second ID number: ");
        int idNum2 = scanner.nextInt();

        if (idNum2 < 0 || idNum2 >= relationshipGraph.size() || relationshipGraph.get(idNum2).isEmpty()) {
            System.out.println("Error: ID number does not exist or has no friends.");
            return;
        }

        ArrayList<Integer> mutualFriends = new ArrayList<>();

        ArrayList<Integer> friendsOfOne = relationshipGraph.get(idNum1);
        ArrayList<Integer> friendsOfTwo = relationshipGraph.get(idNum2);

        //loop sa friends of 1
        for (Integer friendOne : friendsOfOne) {
            //loop sa friends 2 while checking for each friends of 1
            for (Integer friendsTwo : friendsOfTwo){
                //checking
                if (friendOne.equals(friendsTwo) && !mutualFriends.contains(friendOne)){
                    mutualFriends.add(friendOne);
                }
            }
        }

        System.out.printf("Mutual Connections: %d\n", mutualFriends.size());
        if(mutualFriends.isEmpty()){
            System.out.println("No mutual connections found.");
        }else{
            for (Integer mutualFriendsId : mutualFriends){
                System.out.println("- " + mutualFriendsId);
            }
        }

    }
}
