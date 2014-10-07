import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.TreeSet;

public class Computer_Cluster {

	private Scanner s = new Scanner(System.in);
	private LinkedList<TreeSet<Integer>> treeset;
	private int totalNum;

	public Computer_Cluster() {
		treeset = new LinkedList<>();
		this.readData();
		int maxSize = 0, setNum;
		Iterator<TreeSet<Integer>> tempiter = treeset.iterator();
		while (tempiter.hasNext()) {
			int tempsize = tempiter.next().size();
			totalNum = totalNum - tempsize;
			if (tempsize > maxSize) {
				maxSize = tempsize;
			}
		}
		setNum = treeset.size() + totalNum - 1;

		System.out.print(maxSize + " " + setNum + "\n");
	}

	public void readData() {
		totalNum = s.nextInt();
		s.nextLine();
		while (s.hasNextLine() && s.hasNextInt()) {

			Integer c1, c2;
			// int status = 0;
			c1 = s.nextInt();
			c2 = s.nextInt();
			Iterator<TreeSet<Integer>> treeIterator = treeset.iterator();
			TreeSet<Integer> tempSet1 = new TreeSet<Integer>();
			TreeSet<Integer> tempSet2 = new TreeSet<Integer>();
			while (treeIterator.hasNext()) {
				int tmp = 0;
				while (tmp < 2 && treeIterator.hasNext()) {
					TreeSet<Integer> currentSet = treeIterator.next();
					if (currentSet.contains(c1)) {
						tempSet1 = currentSet;
						tmp++;
					}
					if (currentSet.contains(c2)) {
						tempSet2 = currentSet;
						tmp++;
					}

				}
			}
			if (!tempSet1.isEmpty() && tempSet2.isEmpty()) {
				tempSet1.add(c2);
			} else if (tempSet1.isEmpty() && !tempSet2.isEmpty()) {
				tempSet2.add(c1);
			} else if (!tempSet1.isEmpty() && !tempSet2.isEmpty()
					&& tempSet1 != tempSet2) {
				if (tempSet1.size() >= tempSet2.size()) {
					tempSet1.addAll(tempSet2);
					treeset.remove(tempSet2);
				} else {
					tempSet2.addAll(tempSet1);
					treeset.remove(tempSet1);
				}
			} else if (tempSet1.isEmpty() && tempSet2.isEmpty()) {
				TreeSet<Integer> newSet = new TreeSet<Integer>();
				newSet.add(c1);
				newSet.add(c2);
				treeset.add(newSet);
			}

		}
	}

	public static void main(String[] args) {
		new Computer_Cluster();
	}
}
