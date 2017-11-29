/* Mathew Cunningham
   November 27, 2017
   Purpose: To compare ArrayList with LinkedList
   Inputs: Item list file, User input for number of teams and index number
   Output: Time taken for operations and items retrieved
*/
package collections;
import java.util.*;
import java.io.*;

public class Scavenger 
{
    public static void main(String[] args) 
    {
        System.out.println("Part 3 : Scavenger Hunt");
        
        // Loads list with 100 items for scavenger hunt
        List<String> items = new LinkedList<>(); // Run as ArrayList and LinkedList
        try(Scanner fin = new Scanner(new File("ScavHunt.txt")))
        {
            while(fin.hasNext())
            {
                items.add(fin.nextLine());
            }             
        }
        catch(FileNotFoundException ex)
        {
            System.out.println(ex.getMessage());
        }
        
        // Prints which type of list is being used
        if (items instanceof ArrayList)
        {
            System.out.println("Using ArrayList");
        }
        else
        {
            System.out.println("Using LinkedList");
        }
        
        ListIterator<String> iter = items.listIterator();
        long time1 = System.nanoTime();
        while(iter.hasNext())
        {
            iter.next();
        }
        while(iter.hasPrevious())
        {
            iter.previous();
        }
        long time2 = System.nanoTime();
        System.out.println("Time for traversing forwards and backwards is " + (time2-time1) + " nanoseconds");
        
        int numTeams = 0;
        while(numTeams <= 0)
        {
            try
            {
                Scanner in = new Scanner(System.in);
                System.out.println("How many teams? : ");
                numTeams = in.nextInt();
                if(numTeams <= 0)
                {
                    throw new InputMismatchException();
                }
            }
            catch(InputMismatchException ex)
            {
                System.out.println("You must enter a positive integer");
            }
        }
        
        // Using Map to store each team, each team has it's own shuffled item list
        Map<Integer, List> teams = new HashMap<>();
        time1 = System.nanoTime();
        for(int i = 1; i <= numTeams; i++)
        {
            List<String> teamItems = new LinkedList<>(); // Run as ArrayList and LinkedList
            teamItems.addAll(items);
            Collections.shuffle(teamItems);
            teams.put(i, teamItems);
        }
        time2 = System.nanoTime();
        System.out.println("Time for adding items to all teams is " + (time2-time1) + " nanoseconds"); 
        
        
        int elem = -1;
        while(!((elem >= 0) && (elem < 100)))
        {
            try
            {
                Scanner in = new Scanner(System.in);
                System.out.println("\nEnter a position number to retrieve and insert elements : ");
                elem = in.nextInt();
                if(!((elem >= 0) && (elem < 100)))
                {
                    throw new InputMismatchException();
                }
            }
            catch(InputMismatchException ex)
            {
                System.out.println("You must enter a number 0-99");
            }
        }

        // Retrieves item located in the element given by user input, from each team
        time1 = System.nanoTime();
        for(int team : teams.keySet())
        {
            List value = teams.get(team);
            Object element = value.get(elem);
            System.out.println("Team " + team + ": " + element);
        }
        time2 = System.nanoTime();    
        System.out.println("Time for retrieving item from all teams is " + (time2-time1) + " nanoseconds\n");
        
        // Adds item to index specified by user input
        time1 = System.nanoTime();
        for(int team : teams.keySet())
        {
            List value = teams.get(team);
            value.add(elem, "dog bone");
        }
        time2 = System.nanoTime();    
        System.out.println("Time for inserting item (dog bone) to all teams at index " + elem + " is " + (time2-time1) + " nanoseconds\n");

        // Retrieves random item from each team
        Random r = new Random();
        int rand = r.nextInt(101);
        System.out.println("Retrieving random items...");
        time1 = System.nanoTime();
        for(int team : teams.keySet())
        {
            List value = teams.get(team);
            Object element = value.get(rand);
            System.out.println("Team " + team + ": " + element);
        }
        time2 = System.nanoTime();    
        System.out.println("Time for retrieving random item from all teams is " + (time2-time1) + " nanoseconds");  
    } 
}
