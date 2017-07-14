package com.algorithms;

import com.datastructures.lists.LinkedList;
import com.datastructures.lists.Node;

/**
 * Created by Hisoka on 2017-07-12.
 */
public class LinkedListAlgorithms {

    /**
     * <b>2.1</b><br/>
     * Remove Duplicates
     * <br/>
     * Write code to remove duplicates from an unsorted linked list.
     * <p>
     * <br/>
     * <p>
     * Follow up:<br/>
     * How would you solve this problem if a temporary buffer is not allowed?
     * </p>
     *
     * @param linkedList
     */
    public void removeDuplicates(LinkedList linkedList) {

        if (linkedList == null && linkedList.getSize() <= 1) {
            return;
        }

        int position = 1;
        Node currNode = linkedList.get(0);
        while (currNode != null) {
            Node traversalNode = currNode.getNext();
            int counter = position;
            while (traversalNode != null) {
                if (traversalNode.getData() == currNode.getData()) {
                    traversalNode = traversalNode.getNext();
                    linkedList.remove(counter);
                } else {
                    traversalNode = traversalNode.getNext();
                    counter++;
                }
            }

            currNode = currNode.getNext();
            position++;
        }
    }

    /**
     * <b>2.2</b><br/>
     * Return Kth to Last: Implement an algorithm to find the kth to last element of a singly linked list.
     *
     * @param linkedList
     * @return
     */
    public void getKthToLast(int k, LinkedList<Integer> linkedList) {
        LinkedList<Integer> lastElements = new LinkedList<>();

        Node currNode = linkedList.getHead();
        while (currNode != null && k > 0) {
            currNode = currNode.getNext();
            k--;
        }

        linkedList.setHead(currNode);
    }

    /**
     * <b>2.3</b><br/>
     * Delete Middle Node: Implement an algorithm to delete a node in the middle
     * (i.e., any node but the first and last node, not necessarily the exact middle)
     * of a singly linked list, given only access to that node.
     * <br/>
     * EXAMPLE
     * Input: the node c from the linked list a -> b -> c -> d -> e -> f<br/>
     * Result: nothing is returned, but the new linked list looks like a -> b-> d -> e-> f
     */
    public void deleteMiddleNode(final LinkedList<String> linkedList) {
        Node prev = null;
        Node curr = linkedList.getHead();
        Node next = curr.getNext().getNext();

        while (next != null) {
            prev = curr;
            curr = curr.getNext();

            if (next.getNext() != null) {
                next = next.getNext().getNext();
            } else {
                next = next.getNext();
            }
        }

        prev.setNext(curr.getNext());
        curr.setNext(null);
    }

    /**
     * <b>2.4</b><br/>
     * Partition: Write code to partition a linked list around a value x, such that all nodes less than
     * x come before all nodes greater than or equal to x. lf x is contained within the list, the values
     * of x only need to be after the elements less than x (see below).The partition element x can appear
     * anywhere in the "right partition"; it does not need to appear between the left and right partitions.
     * <br/>
     * EXAMPLE
     * <br/>
     * Input: 3 -> 5 -> 8 -> 5 ->10 -> 2 -> 1 [partition=5]
     * <br/>
     * Output: 3 -> 1 -> 2 -> 10 -> 5 -> 5 -> 8
     *
     * @param linkedList
     */
    public void partition(LinkedList<Integer> linkedList) {

    }

    /**
     * <b>2.5</b><br/>
     * Sum Lists: You have two numbers represented by a linked list, where each node contains a single digit. The
     * digits are stored in reverse order, such that the 1's digit is at the head of the list. Write a function that
     * adds the two numbers and returns the sum as a linked list.
     * <br/>
     * EXAMPLE
     * <br/>
     * Input: (7 -> 1 -> 6) + (5 -> 9 -> 2).    That is, 617 + 295.
     * <br/>
     * Output: 2 -> 1 -> 9. That is, 912.
     * <br/>
     * <br/>
     * FOLLOW UP
     * <br/>
     * Suppose the digits are stored in forward order. Repeat the above problem. EXAMPLE
     * Input: (6 -> 1 -> 7) + (2 -> 9 -> 5).    That is, 617 + 295.
     * <br/>
     * Output: 9 -> 1 -> 2. That is, 912.
     *
     * @param firstList
     * @param secondList
     * @return
     */
    public LinkedList<Integer> sumListsBackwards(LinkedList<Integer> firstList, LinkedList<Integer> secondList) {
        int firstSum = getBackwardsLinkedListSum(firstList.getHead());
        int secondSum = getBackwardsLinkedListSum(secondList.getHead());
        int total = firstSum + secondSum;

        LinkedList<Integer> sumLists = new LinkedList<>();
        addSumBackwardsToLinkedList(total, sumLists);

        return sumLists;
    }

    private int getBackwardsLinkedListSum(Node currNode) {
        int sum = 0;
        int factor = 1;
        while (currNode != null)  {
            sum += (int) currNode.getData() * factor;
            currNode = currNode.getNext();
            factor *= 10;
        }

        return sum;
    }

    private void addSumBackwardsToLinkedList(int value, final LinkedList<Integer> linkedList) {
        int factor = (int) Math.pow(10, (Integer.toString(value).length() - 1));

        while (factor > 0) {
            linkedList.add(value / factor);
            value %= factor;
            factor /= 10;
        }
    }
}
