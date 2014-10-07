import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;

public class Voting {

	private HashMap<Integer, Integer> VotingPool;
	private Scanner s = new Scanner(System.in);
	private int totalNum;

	public Voting() {
		VotingPool = new HashMap<Integer, Integer>();
		readData();
		int result = findMajority(VotingPool);
		if (result < 0) {
			System.out.print("no candidate received a majority of the votes"
					+ "\n");
		} else {
			System.out.print(result + " wins with " + VotingPool.get(result)
					+ " votes out of " + totalNum+"\n");
		}
	}

	public void readData() {
		totalNum = s.nextInt();
		while (s.hasNextLine()) {
			s.nextLine();
			if (s.hasNextInt()) {
				Integer voter = s.nextInt();
				if (VotingPool.containsKey(voter)) {
					Integer count = VotingPool.get(voter) + 1;
					VotingPool.put(voter, count);
				} else {
					VotingPool.put(voter, 1);
				}
			}
		}
	}

	public int findMajority(HashMap<Integer, Integer> m) {
		Iterator<Integer> i = m.keySet().iterator();
		while (i.hasNext()) {
			int thisKey = i.next();
			if (m.get(thisKey) > Math.floor(totalNum/2)) {
				return thisKey;
			}
		}
		return -1;
	}

	public static void main(String[] args) {
		new Voting();
	}
}