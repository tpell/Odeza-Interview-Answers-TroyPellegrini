
class SolutionThree {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // We'll return the true root at the end, but creating this initial placeholder
        // to keep the main loop more straight forward
        ListNode root = new ListNode(0);
        ListNode head = root;

        int carry = 0;
        // Add each "place" value pair together. ones place, tens place, hundredths etc.
        while ((l1 != null) || (l2 != null)) {
            // Handle cases where the inputs don't have the same number of digits
            int valA, valB = 0;
            valA = (l1 == null) ? 0 : l1.val;
            valB = (l2 == null) ? 0 : l2.val;
            // Use integer division + modulo to grab the
            // carry bit + remainder respectively
            int digitSum = valA + valB + carry;
            carry = digitSum / 10;
            int digitRem = digitSum % 10;
            head.next = new ListNode(digitRem);

            if (l1 != null) {l1 = l1.next;}
            if (l2 != null) {l2 = l2.next;}
            head = head.next;
        }

        // Could be one last carry bit to include
        if (carry > 0) {head.next = new ListNode(carry);}
        return root.next;
    }
}

// Below here purely for testing
public class QuestionThree {
    public static void main(String[] args) {
        NodeTestHelper.runTestThree(new int[]{2,4,3}, new int[]{5,6,4}, new int[]{7,0,8});
        NodeTestHelper.runTestThree(new int[]{1}, new int[]{9,9}, new int[]{0,0,1});
        NodeTestHelper.runTestThree(new int[]{1}, new int[]{9,9,9,9,9,9}, new int[]{0,0,0,0,0,0,1});
        NodeTestHelper.runTestThree(new int[]{9,9}, new int[]{8,8,8,8,8}, new int[]{7,8,9,8,8});
        NodeTestHelper.runTestThree(new int[]{9,9,9,9}, new int[]{9,9,9}, new int[]{8,9,9,0,1});
    }
}

