package kisinna.lesson;

public class CustomList<T> {
	class Node {
		private T value;
		private Node nextNode;
	}

	private Node firstNode;
	private Node lastNode;

	public void add(T value) {
		if (firstNode == null) {
			firstNode = new Node();
			firstNode.value = value;
			return;
		} else {
			Node newNode = new Node();
			newNode.value = value;
			Node node = firstNode;
			while (node.nextNode != null) {
				node = node.nextNode;
			}
			node.nextNode = newNode;
		}
	}

	public void reverceLink(Node last) {
		if (lastNode == null) {
			lastNode = last;
		} else {
			Node node = lastNode;
			while (node.nextNode != null) {
				node = node.nextNode;
			}
			node.nextNode = last;
			last.nextNode = null;
		}
	}

	public void reverse() {
		Node current = lastNode;
		while (firstNode != current) {
			// находим последний
			Node node = firstNode;
			while (node.nextNode != current) {
				node = node.nextNode;
			}
			reverceLink(node);
			current = node;
		}
		reverceLink(firstNode);
		firstNode = lastNode;
	}

	public void print() {
		Node node = firstNode;
		while (node != null) {
			System.out.print(node.value + "->");
			node = node.nextNode;
		}
		System.out.println();
	}
}
