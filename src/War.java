import java.util.Scanner;

public class War {

	private Scanner s = new Scanner(System.in);
	private int r;

	public War() {
		inputToDeque(s);
	}

	public void inputToDeque(Scanner scanner) {

		while (scanner.hasNextLine()) {
			Scanner tempScanner = new Scanner(scanner.nextLine());
			mDeque tempDeque = new mDeque();
			mDeque p1 = new mDeque();
			mDeque p2 = new mDeque();
			r = 0;
			while (tempScanner.hasNext()) {
				if (tempScanner.hasNextInt()) {
					int i = tempScanner.nextInt();
					tempDeque.addLast(i);
					// System.out.print(i+" ");
				} else if (tempScanner.hasNext()) {
					String s = tempScanner.next();

					if (s.equalsIgnoreCase("J")) {
						tempDeque.addLast(11);
					} else if (s.equalsIgnoreCase("Q")) {
						tempDeque.addLast(12);
					} else if (s.equalsIgnoreCase("K")) {
						tempDeque.addLast(13);
					} else if (s.equalsIgnoreCase("A")) {
						tempDeque.addLast(14);
					}
				}
			}
			tempScanner.close();
			while (tempDeque.size() >= 2) {
				p1.addLast(tempDeque.removeFirst());
				p2.addLast(tempDeque.removeFirst());
			}
			// p1.printout(p1.getHeader().getNext());
			// System.out.print("\n");
			// p2.printout(p2.getHeader().getNext());
			// System.out.print("\n");

			this.play(p1, p2);

		}
	}

	public void play(mDeque p1, mDeque p2) {
		while (p1.size() > 0 && p2.size() > 0 && r <= 10000) {
			mDeque temp = new mDeque();
			// System.out.print("Round " + r + " " + p1.size() + " " + p2.size()
			// + "\n");
			// p1.printout(p1.getHeader().getNext());
			// System.out.print("\n");
			// p2.printout(p2.getHeader().getNext());
			// System.out.print("\n");
			while (p1.size() > 0 && p2.size() > 0
					&& p1.getLast() == p2.getLast()) {
				temp.addFirst(p1.removeLast());
				temp.addFirst(p2.removeLast());
				if (p1.size() == 0 && p2.size() != 0) {
					// System.out.print("2 wins after " + r + " rounds");
					// return;
				} else if (p1.size() != 0 && p2.size() == 0) {
					// System.out.print("1 wins after " + r + " rounds");
					// return;
				} else if (p1.size() != 0 && p2.size() != 0) {
					temp.addFirst(p1.removeLast());
					temp.addFirst(p2.removeLast());
				}
			}
			if (p1.size() > 0 && p2.size() > 0) {
				if (p1.getLast() > p2.getLast()) {
					temp.addFirst(p1.removeLast());
					temp.addFirst(p2.removeLast());
					while (temp.size() > 0) {
						p1.addFirst(temp.removeLast());
					}
				} else if (p1.getLast() < p2.getLast()) {
					temp.addFirst(p1.removeLast());
					temp.addFirst(p2.removeLast());
					while (temp.size() > 0) {
						p2.addFirst(temp.removeLast());
					}
				}
			}
			r++;
		}
		if (p1.size() == 0 && p2.size() != 0) {
			System.out.print("2 wins after " + r + " rounds" + "\n");
		}

		if (p1.size() != 0 && p2.size() == 0) {
			System.out.print("1 wins after " + r + " rounds" + "\n");
		}

		if (p1.size() == 0 && p2.size() == 0) {
			System.out.print("draw after " + r + " rounds" + "\n");
		}

		if (r >= 10000) {
			System.out.print("draw after 10000 rounds" + "\n");
			return;
		}
	}

	private class DNode {

		private Integer element;
		private DNode next, prev;

		public DNode() {
			this(null, null, null);
		}

		public DNode(Integer i, DNode p, DNode n) {
			element = i;
			prev = p;
			next = n;
		}

		public Integer getElement() {
			return element;
		}

		public DNode getPrev() {
			return prev;
		}

		public DNode getNext() {
			return next;
		}

		public void setElement(Integer e) {
			element = e;
		}

		public void setPrev(DNode p) {
			prev = p;
		}

		public void setNext(DNode n) {
			next = n;
		}

	}

	private class mDeque {
		protected DNode header, trailer;
		protected int size;

		public mDeque() {
			header = new DNode();
			trailer = new DNode();
			header.setNext(trailer);
			trailer.setPrev(header);
			size = 0;
		}

		public int size() {
			return size;
		}

		public boolean isEmpty() {
			if (header.getElement() == null) {
				return true;
			}
			return false;
		}

		public void addFirst(Integer i) {
			DNode second = header.getNext();
			DNode first = new DNode(i, header, second);
			second.setPrev(first);
			header.setNext(first);
			size++;
		}

		public void addLast(Integer i) {
			DNode secondLast = trailer.getPrev();
			DNode last = new DNode(i, secondLast, trailer);
			secondLast.setNext(last);
			trailer.setPrev(last);
			size++;
		}

		public Integer removeFirst() {
			DNode first = header.getNext();
			DNode second = first.getNext();
			Integer i = first.getElement();
			header.setNext(second);
			second.setPrev(header);
			size--;
			return i;
		}

		public Integer removeLast() {
			DNode last = trailer.getPrev();
			DNode secondLast = last.getPrev();
			Integer i = last.getElement();
			trailer.setPrev(secondLast);
			secondLast.setNext(trailer);
			size--;
			return i;
		}

		public Integer getFirst() {
			return header.getNext().getElement();
		}

		public Integer getLast() {
			return trailer.getPrev().getElement();
		}

		public DNode getHeader() {
			return header;
		}

		public void printout(DNode start) {
			if (start.getElement() != null) {
				System.out.print(start.getElement() + " ");
				printout(start.getNext());
			}
		}
	}

	public static void main(String[] args) {
		new War();
	}
}