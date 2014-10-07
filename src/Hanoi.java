import java.util.Scanner;

public class Hanoi {

	private mStack a, b, c;
	private int n;
	private int r = 0;

	public Hanoi() {
		this.getInput();
		this.initiate();
		this.printout();
		r++;
		System.out.print("Start moving..." + "\n");
		this.move(n, a, b, c);
	}

	public void getInput() {
		System.out
				.print("Type the number of sticks to move from peg a to peg c (too large number may take enormous time):");
		Scanner s = new Scanner(System.in);
		n = s.nextInt();
		s.close();
	}

	public void initiate() {
		a = new mStack();
		b = new mStack();
		c = new mStack();

		for (int i = n; i > 0; i--) {
			a.push(i);
		}
	}

	public void move(int n, mStack x, mStack y, mStack z) {

		if (n == 1) {
			z.push(x.pop());
			this.printout();
			r++;
			
		} else {
			move(n - 1, x, z, y);
			z.push(x.pop());
			this.printout();
			r++;
			move(n - 1, y, x, z);
		}

	}

	public void printout() {
		System.out.print("Round " + r + ": Peg a(");
		a.print(a.getTop());
		System.out.print("), b(");
		b.print(b.getTop());
		System.out.print("), c(");
		c.print(c.getTop());
		System.out.print(")" + "\n");
		
	}

	private class mNode {
		private Integer element;
		private mNode next;

		public mNode() {
			this(null, null);
		}

		public mNode(Integer i, mNode n) {
			element = i;
			next = n;
		}

		public void setElement(Integer i) {
			element = i;
		}

		public void setNext(mNode n) {
			next = n;
		}

		public Integer getElement() {
			return element;
		}

		public mNode getNext() {
			return next;
		}
	}

	private class mStack {
		protected mNode top;
		protected int size;

		public mStack() {
			top = null;
			size = 0;
		}

		public boolean isEmpty() {
			if (size == 0)
				return true;
			return false;
		}

		public int size() {
			return size;
		}

		public mNode getTop() {
			return top;
		}

		public void push(Integer i) {
			top = new mNode(i, top);
			size++;
		}

		public Integer pop() {
			Integer tmp = top.getElement();
			top = top.getNext();
			size--;
			return tmp;
		}

		public void print(mNode start) {
			if (start != null) {
				System.out.print(start.getElement() + " ");
				print(start.getNext());
			} else {
				System.out.print("");
			}
		}
	}

	public static void main(String[] args) {
		new Hanoi();
	}
}
