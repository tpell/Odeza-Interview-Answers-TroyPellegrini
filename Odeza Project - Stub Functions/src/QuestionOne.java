
class SolutionOne {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{};
    }
}

// Below here purely for testing
public class QuestionOne {
    public static void main(String[] args) {
        int[][][] testCases = {
                {{2, 7, 11, 15}, {9}, {0, 1}},
                {{3, 7, 1, 10}, {8}, {1, 2}},
                {{2, 2}, {4}, {0, 1}},
                {{2, -7, 5, -30}, {-25}, {2 ,3}}
        };
        runTests(testCases);
    }

    public static void runTests(int[][][] testCases) {
        SolutionOne sol = new SolutionOne();
        for (int i = 0; i < testCases.length; i++) {
            int[] actualAns = sol.twoSum(testCases[i][0], testCases[i][1][0]);
            int[] expectedAns = testCases[i][2];
            if ((expectedAns[0] == actualAns[0]) && (expectedAns[1] == actualAns[1])) {
                System.out.println("Pass");
            }
            else {
                System.out.println("Test " + i + ": Expected: [" + expectedAns[0] + ", " + expectedAns[1] + "] Actual: [" +
                        actualAns[0] + ", " + actualAns[1] + "]");
            }
        }
    }
}


