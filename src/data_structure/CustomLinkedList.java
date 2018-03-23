package data_structure;

public class CustomLinkedList
{
	// inner class for linked list node
	public class CustomNode {
		int data;
		CustomNode next;

		public CustomNode (int data) {
			this.data = data;
			this.next = null;
		}

		public void display() {
			System.out.print(data + " ");
		}
	}


	public CustomNode head;

	public CustomLinkedList() {

	}

	public void insertHead(CustomNode newNode) {
		if(head == null) {
			head = newNode;
		}
		else {
			newNode.next = head;
			head = newNode;
		}
	}

	public void insertHead(int data) {
		CustomNode newNode = new CustomNode(data);
		if(head == null) {
			head = newNode;
		}
		else {
			newNode.next = head;
			head = newNode;
		}
	}

	public void removeHead () {
		CustomNode temp = head; // Firstly, backup the one which need to be removed
		head = head.next;
		temp.next = null; // Finally, cut off the link
	}

	public boolean find(int data) {
		CustomNode current = head;
		while(current != null) {
			if(current.data == data) {
				System.out.println("Found value " + data);
				return true;
			}
			current = current.next;
		}
		System.out.println("Not Found value " + data);
		return false;
	}

	/**
	 * Compare value of current node with the value need to be deleted. ( previous.next = current.next )
	 * Note: if the removed ones contains head, need to change head point to the one who is next
	 * @param value
	 * @return
	 */
    public CustomNode deleteByComparingCurrent(int value) {
    	// special case: remove head
		while (head.data == value) {
			CustomNode originalHead = head;
			head = head.next;
			originalHead.next = null;
		}

//		CustomNode previous = new CustomNode(0);
//		previous.next = head;
//
//		CustomNode current = head;

		// NOTE: since we already dealed with head, we can start by comparing the next node of head
		CustomNode previous = head;
		CustomNode current = head.next;

		while (current != null) {
			if (current.data == value) {
				previous.next = current.next;
				current.next = null;

				// NOTE: current will increase, previous will stay the same
				current = previous.next;
			} else {
				// NOTE: only increase both current and previous when not equal
				current = current.next;
				previous = previous.next;
			}

//			previous = previous.next;
//			current = current.next;
		}
		return head;
	}

	/**
	 * Compare value of the next node with the one need to be deleted. (current.next = current.next.next)
	 * Note: Since the comparision start with current.next, so need to handle head node separately.
	 * @param value
	 * @return
	 */
	public CustomNode deleteByComparingCurrentNext(int value) {
    	// special case
		while (head.data == value) {
			CustomNode originalHead = head;
			head = head.next;
			originalHead.next = null;
		}

    	CustomNode current = head;
    	CustomNode originalCurrentNext;

    	while (current.next != null) {
    		if (current.next.data == value) {
    			originalCurrentNext = current.next;
    			current.next = current.next.next;
    			originalCurrentNext.next = null;
			} else {
				// NOTE: should only increase current when not equal. Because When current.next.data == value, the original
				// current.next was removed, so the current's new next is actually the next of the current's original next, thus no need
				// to increase current when current.next.data = value ;
    			current = current.next;
			}

//			current = current.next;
		}
    	return head;
	}

	public void display() {
		CustomNode current = head;

//		while (current.next != null) {
		while (current != null) {
			current.display();

			current = current.next;
		}
	}

	public static void main(String[] args) {
		CustomLinkedList classInstance = new CustomLinkedList();

		classInstance.insertHead(4);
		classInstance.insertHead(1);
		classInstance.insertHead(3);
		classInstance.insertHead(2);
		classInstance.insertHead(1);
		classInstance.insertHead(1);

//		classInstance.find(1);
//		classInstance.find(2);
//		classInstance.find(3);
//		classInstance.find(4);
//
		System.out.println("Before remove: ");
		classInstance.display();

		System.out.println("");
		System.out.println("After remove: ");
//		classInstance.deleteByComparingCurrent(1);
		classInstance.deleteByComparingCurrentNext(1);
		classInstance.display();
	}
}
