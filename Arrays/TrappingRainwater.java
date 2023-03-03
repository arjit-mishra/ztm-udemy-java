import java.util.Arrays;

public class TrappingRainwater {

    public static void main(String[] args) {
        int[] elevationArray = { 0, 1, 0, 2, 1, 0, 3, 1, 0, 1, 2 };
        int[] elevationArray2 = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
        int[] elevationArray3 = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };

        System.out.println("Brute force");
        System.out
                .println("Max water that can be trapped in " + Arrays.toString(elevationArray) + " is: "
                        + getRainwaterBrute(elevationArray) + " units");
        System.out
                .println("Max water that can be trapped in " + Arrays.toString(elevationArray2) + " is: "
                        + getRainwaterBrute(elevationArray2) + " units");
        System.out
                .println("Max water that can be trapped in " + Arrays.toString(elevationArray3) + " is: "
                        + getRainwaterBrute(elevationArray3) + " units");

        System.out.println("\nOptimal");
        System.out
                .println("Max water that can be trapped in " + Arrays.toString(elevationArray) + " is: "
                        + getRainwaterOptimal(elevationArray) + " units");
        System.out
                .println("Max water that can be trapped in " + Arrays.toString(elevationArray2) + " is: "
                        + getRainwaterOptimal(elevationArray2) + " units");
        System.out
                .println("Max water that can be trapped in " + Arrays.toString(elevationArray3) + " is: "
                        + getRainwaterOptimal(elevationArray3) + " units");
    }

    private static int getRainwaterBrute(int[] elevationArray) {
        int totalWater = 0;

        for (int p = 0; p < elevationArray.length; p++) {
            int lp = p, rp = p, maxL = 0, maxR = 0;
            // find maxL
            while (lp >= 0) {
                maxL = Math.max(maxL, elevationArray[lp]);
                lp--;
            }

            // find maxR
            while (rp < elevationArray.length) {
                maxR = Math.max(maxR, elevationArray[rp]);
                rp++;
            }

            // calculate water with formula and add to the solution
            int currentWater = Math.min(maxL, maxR) - elevationArray[p];

            if (currentWater >= 0)
                totalWater += currentWater;
        }

        return totalWater;
    }

    private static int getRainwaterOptimal(int[] elevationArray) {
        int totalWater = 0;
        int lp = 0, rp = elevationArray.length - 1, maxL = 0, maxR = 0;

        while (lp < rp) {
            // decide if we work with left pointer or right
            if (elevationArray[lp] <= elevationArray[rp]) {
                // work with left

                // decide if update maxL or total water
                if (elevationArray[lp] >= maxL)
                    maxL = elevationArray[lp]; // update maxL as there is 0 unit water on top of elevationArray[lp].
                else
                    totalWater += maxL - elevationArray[lp];

                lp++;
            } else {
                // work with right

                // decide if update maxL or total water
                if (elevationArray[rp] >= maxR)
                    maxR = elevationArray[rp]; // update maxR as there is 0 unit water on top of elevationArray[lp].
                else
                    totalWater += maxR - elevationArray[rp];

                rp--;
            }
        }

        return totalWater;
    }

}
