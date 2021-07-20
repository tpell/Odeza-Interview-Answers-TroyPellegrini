class SolutionTwo {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // We'll return the true root at the end, but creating this initial placeholder
        // to keep the main loop more straight forward
        ListNode root = new ListNode(0);
        ListNode head = root;

        // While both input chains have values left to use,
        // keep comparing their front values
        while ((l1 != null) && (l2 != null)) {
            if (l1.val <= l2.val) {
                head.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            else {
                head.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            head = head.next;
        }

        // Once one input chain is depleted,
        // we can use the remainder of the other chain without comparisons
        ListNode lastChain = null;
        if (l1 == null) { lastChain = l2;}
        else { lastChain = l1; }

        while (lastChain != null) {
            head.next = new ListNode(lastChain.val);
            lastChain = lastChain.next;
            head = head.next;
        }

        // Return the actual root without the initial placeholder node
        return root.next;
    }
}

// Below here purely for testing
public class QuestionTwo {
    public static void main(String[] args) {
        NodeTestHelper.runTestTwo(new int[]{1, 2, 4}, new int[]{1, 3, 4}, new int[]{1, 1, 2, 3, 4, 4});
        NodeTestHelper.runTestTwo(new int[]{3}, new int[]{1, 2, 5, 8}, new int[]{1, 2, 3, 5, 8});
        NodeTestHelper.runTestTwo(new int[]{7}, new int[]{1, 2, 5}, new int[]{1, 2, 5, 7});
        NodeTestHelper.runTestTwo(new int[]{4, 7, 12}, new int[]{1}, new int[]{1, 4, 7, 12});

        NodeTestHelper.runTestTwo(new int[]{1, 2, 3}, new int[]{4, 5, 6}, new int[]{1, 2, 3, 4, 5, 6});
        NodeTestHelper.runTestTwo(new int[]{}, new int[]{1}, new int[]{1});
        NodeTestHelper.runTestTwo(new int[]{2}, new int[]{}, new int[]{2});
        NodeTestHelper.runTestTwo(new int[]{}, new int[]{}, new int[]{});
    }
}

class NodeTestHelper {
    public static ListNode createChain(int[] values) {
        ListNode root = new ListNode(0);
        ListNode head = root;
        for (int val : values) {
            head.next = new ListNode(val);
            head = head.next;
        }
        return root.next;
    }
    public static boolean compareChains(ListNode expected, ListNode actual) {
        while ((expected != null) && (actual != null)) {
            if (expected.val != actual.val) {
                return false;
            }
            expected = expected.next;
            actual = actual.next;
        }
        // Chains weren't same length
        if ((expected != null) || (actual != null)) {
            return false;
        }
        return true;
    }
    public static void runTestTwo(int[] inputA, int[] inputB, int[] solution) {
        SolutionTwo sol2 = new SolutionTwo();
        ListNode expected = createChain(solution);
        ListNode actual = sol2.mergeTwoLists(createChain(inputA), createChain(inputB));

        if (compareChains(expected, actual)) {
            System.out.println("Pass");
        }
        else {
            System.out.println("Fail");
        }
        printChain(expected);
        System.out.println();
        printChain(actual);
        System.out.println();
    }
    public static void runTestThree(int[] inputA, int[] inputB, int[] solution) {
        SolutionThree sol3 = new SolutionThree();
        ListNode expected = createChain(solution);
        ListNode actual = sol3.addTwoNumbers(createChain(inputA), createChain(inputB));

        if (compareChains(expected, actual)) {
            System.out.println("Pass");
        }
        else {
            System.out.println("Fail");
        }
        printChain(expected);
        System.out.println();
        printChain(actual);
        System.out.println();
    }

    public static void printChain(ListNode toPrint) {
        while (toPrint != null) {
            System.out.print(toPrint.val + ", ");
            toPrint = toPrint.next;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

