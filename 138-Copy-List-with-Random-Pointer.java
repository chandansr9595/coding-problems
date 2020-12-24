/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> nodeMap = new HashMap<>();
        
        Node temp = head;
        while(temp != null){
            nodeMap.put(temp, new Node(temp.val));
            temp = temp.next;
        }
        
        temp = head;
        Node currentHead = nodeMap.get(temp);
        Node newTemp = currentHead;
        while(temp != null){
            if(temp.next != null){
                newTemp.next = nodeMap.get(temp.next);
            } else {
                newTemp.next = null;
            }
            
            //System.out.println("Temp.random : " + temp.random);
            if(temp.random != null){
                newTemp.random = nodeMap.get(temp.random);
            } else {
                newTemp.random = null;
            }
            temp = temp.next;
            newTemp = newTemp.next;
        }
        return currentHead;
    }
}