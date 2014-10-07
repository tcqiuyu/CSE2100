import java.util.Scanner;
import java.util.Stack;

public class Arith_Exp {

	private Stack<BTree> tempStack;
	private Stack<String> calStack;
	private Scanner s = new Scanner(System.in);

	public Arith_Exp() {
		this.scan();
	}

	public void scan() {
		BTree tempBTree;
		tempStack = new Stack<BTree>();
		calStack = new Stack<String>();
		Integer result = 0;
		while (s.hasNext()) {
			tempBTree = new BTree();
			String temp = s.next();
			tempBTree.addRoot(temp);
			if (!temp.equalsIgnoreCase(")")) {
				tempStack.push(tempBTree);
				calStack.push(temp);
			} else if (temp.equalsIgnoreCase(")")) {
				BTree tmpRight = tempStack.pop();
				BTree tmpRoot = tempStack.pop();
				BTree tmpLeft = tempStack.pop();
				tempStack.pop();
				tmpRoot.attach(tmpRoot, tmpLeft, tmpRight);
				if (!tempStack.isEmpty()) {
					tempStack.push(tmpRoot);
				} else {
					// tmpRoot.postTraversal(tmpRoot.root());
					String output = tmpRoot.output();
					String newOutput = output.trim();
					System.out.print(newOutput + "\n");
				}

				Integer right = Integer.parseInt(calStack.pop());
				String operator = calStack.pop();
				Integer left = Integer.parseInt(calStack.pop());
				calStack.pop();
				if (operator.equalsIgnoreCase("+")) {
					result = left + right;
				} else if (operator.equalsIgnoreCase("-")) {
					result = left - right;
				} else if (operator.equalsIgnoreCase("*")) {
					result = left * right;
				} else if (operator.equalsIgnoreCase("/")) {
					result = left / right;
				}
				if (!calStack.isEmpty()) {
					calStack.push(result.toString());
				} else {
					System.out.print(result + "\n");
				}
			}

		}
	}

	private class BTNode {
		private String element;
		private BTNode left, right, parent;

		public BTNode() {

		}

		public BTNode(String e, BTNode parent, BTNode left, BTNode right) {
			setElement(e);
			setParent(parent);
			setLeft(left);
			setRight(right);
		}

		public void setRight(BTNode n) {
			right = n;
		}

		public void setLeft(BTNode n) {
			left = n;
		}

		public void setParent(BTNode n) {
			parent = n;
		}

		public void setElement(String e) {
			element = e;
		}

		public String element() {
			return element;
		}

		public BTNode getLeft() {
			return left;
		}

		public BTNode getRight() {
			return right;
		}

		public BTNode getParent() {
			return parent;
		}
	}

	private class BTree {
		private BTNode root;
		private String output = "";
		private int size;

		public BTree() {
			root = null;
			size = 0;
		}

		public int size() {
			return size;
		}

		public BTNode root() {
			return root;
		}

		public BTNode left(BTNode v) {
			return v.getLeft();
		}

		public BTNode right(BTNode v) {
			return v.getRight();
		}

		public boolean isRoot(BTNode v) {
			return (v == root());
		}

		public boolean isInternal(BTNode v) {
			return (hasLeft(v) || hasRight(v));
		}

		public boolean hasLeft(BTNode v) {
			return (v.getLeft() != null);
		}

		public boolean hasRight(BTNode v) {
			return (v.getRight() != null);
		}

		public BTNode addRoot(String e) {
			size = 1;
			root = createNode(e, null, null, null);
			return root;
		}

		public BTNode insertLeft(BTNode v, String e) {
			BTNode leftPos = createNode(e, v, null, null);
			v.setLeft(leftPos);
			size++;
			return leftPos;
		}

		public BTNode insertRight(BTNode v, String e) {
			BTNode rightPos = createNode(e, v, null, null);
			v.setRight(rightPos);
			size++;
			return rightPos;
		}

		public BTNode createNode(String element, BTNode parent, BTNode left,
				BTNode right) {
			return new BTNode(element, parent, left, right);
		}

		public void attach(BTree root, BTree T1, BTree T2) {
			root.root().setLeft(T1.root());
			root.root().setRight(T2.root());
		}

		public void postTraversal(BTNode root) {
			if (this.isInternal(root)) {
				postTraversal(root.getLeft());
				postTraversal(root.getRight());
			}
			// System.out.print(root.element() + " ");
			output = new StringBuilder().append(output + " ")
					.append(root.element()).toString();
		}

		public String output() {
			postTraversal(this.root());
			return output;
		}
	}

	public static void main(String[] args) {
		new Arith_Exp();
	}
}
