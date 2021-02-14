import java.util.*;

public class Main {
    private static final Map<Long, Long> numberOfWaysMap = new HashMap<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int heightOfStairCase = scanner.nextInt();
        List<Integer> possibleStepsSet = new ArrayList<>();
        System.out.println("Enter -1 to stop entering numbers into possible steps set");
        do {
            possibleStepsSet.add(scanner.nextInt());

        } while (!possibleStepsSet.contains(-1));
        possibleStepsSet.remove(Integer.valueOf(-1));
        System.out.println(getNumberOfWays(heightOfStairCase, possibleStepsSet));

    }
    private static long getNumberOfWays(long heightOfStairCase, List<Integer> possibleStepsSet) {
        //System.out.println("height Of StairCase = " + heightOfStairCase);
        List<Long> integersToBeCalled = new ArrayList<>();
        long numberOfWays = 0;
        for (Integer i : possibleStepsSet) {
            //System.out.println("heightOfStairCase - i = " + heightOfStairCase + " - " + i + " = " + (heightOfStairCase - i));
            integersToBeCalled.add(heightOfStairCase - i);
        }
        for (Integer i : possibleStepsSet) {
            if (i == heightOfStairCase) {
                //System.out.println("i = heightOfStairCase = " + i);
                numberOfWays++;
                //System.out.println("Number of ways increased to " + numberOfWays);
            }
        }
        for (Long i : integersToBeCalled) {
            if (i > 0) {
                if (numberOfWaysMap.containsKey(i)) {
                    numberOfWays += numberOfWaysMap.get(i);
                    //System.out.println("Got from Map");
                }
                else {
                    numberOfWays += getNumberOfWays(i, possibleStepsSet);
                }
            }
        }
        //System.out.println("numberOfWays for height " + heightOfStairCase + " = " + numberOfWays);
        //System.out.println("Putting in map");
        numberOfWaysMap.put(heightOfStairCase, numberOfWays);
        //System.out.println("Kept in map");
        //System.out.println("height = " + heightOfStairCase);
        //System.out.println("number of ways = " + numberOfWays);
        //System.out.println("Returning from height = " + heightOfStairCase + " where number of ways = " + numberOfWays);
        return numberOfWays;
    }
}
