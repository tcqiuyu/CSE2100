public class InvertSequence {

	private Sequence test;

	public InvertSequence() {
		this.initiate();
		test.print(test.first());
		System.out.print("\n");
		this.invert();
		test.print(test.first());
	}

	public void initiate() {
		test = new Sequence();

		for (int i = 0; i < 10; i++) {
			test.insertLast(i);
		}
	}

	public void invert() {
		Sequence tmp = new Sequence();
		Sequence tmp2 = new Sequence();
		int size = test.size();
		for (int i = 0; i < size; i++) {
			Node first = test.first();
			Integer e = test.remove(first).getElement();
			tmp.insertFirst(e);
		}

		for (int i = 0; i < size; i++) {
			Node first = tmp.first();
			Integer e = tmp.remove(first).getElement();
			tmp2.insertFirst(e);
		}

		for (int i = 0; i < size; i++) {
			Node first = tmp2.first();
			Integer e = tmp2.remove(first).getElement();
			test.insertFirst(e);
		}
	}

	private class Node {
		private Integer element;
		private Node prev, next;

		public Node() {
			this(null, null, null);
		}

		public Node(Integer e, Node p, Node n) {
			element = e;
			prev = p;
			next = n;
		}

		public Integer getElement() {
			return element;
		}

		public Node getPrev() {
			return prev;
		}

		public Node getNext() {
			return next;
		}

		public void setPrev(Node n) {
			prev = n;
		}

		public void setNext(Node n) {
			next = n;
		}
	}

	private class Sequence {
		private Node header, trailer;
		private int size;

		public Sequence() {
			header = new Node(null, null, null);
			trailer = new Node(null, header, null);
			header.setNext(trailer);
		}

		public void insertFirst(Integer i) {
			Node tmp = header.getNext();
			Node n = new Node(i, header, tmp);
			header.setNext(n);
			tmp.setPrev(n);
			size++;
		}

		public void insertLast(Integer i) {
			Node tmp = trailer.getPrev();
			Node n = new Node(i, tmp, trailer);
			trailer.setPrev(n);
			tmp.setNext(n);
			size++;
		}

		public Node remove(Node n) {
			Node prev = n.getPrev();
			Node next = n.getNext();
			prev.setNext(next);
			next.setPrev(prev);
			size--;
			return n;
		}

		public Node first() {
			if (size == 0) {
				return null;
			} else {
				return header.getNext();
			}
		}

		public int size() {
			return size;
		}

		public void print(Node start) {
			if (start != null) {
				System.out.print(start.getElement() + " ");
				print(start.getNext());
			} else {
				System.out.print(" ");
			}
		}
	}

	public static void main(String[] args) {
		new InvertSequence();
	}
}
