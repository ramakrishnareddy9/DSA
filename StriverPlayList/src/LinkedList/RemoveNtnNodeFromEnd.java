package LinkedList;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class RemoveNtnNodeFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = new ListNode(0 , head);
        ListNode temp1 = temp;
        for(int  i = 0;i < n;i++){
            head = head.next;
        }
        while(head != null){
            head = head.next;
            temp1 = temp1.next;
        }
        temp1.next = temp1.next.next;
        return temp.next;
    }
}
