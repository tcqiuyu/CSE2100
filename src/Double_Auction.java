import java.util.Map.Entry;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Double_Auction {

	private PriorityQueue<order> sellPool, buyPool;
	private Scanner s = new Scanner(System.in);
	private int totalAmount, totalPrice;

	public Double_Auction() {
		sellPool = new PriorityQueue<order>();
		buyPool = new PriorityQueue<order>();
		readData();
		System.out.print("shares exchanged " + totalAmount + " total value "
				+ totalPrice + "\n");
	}

	public void readData() {
		while (s.hasNextLine()) {
			int sign;
//			Scanner thisLine = new Scanner(s.nextLine());
			if (s.next().equalsIgnoreCase("buy")) {
				sign = -1; // buy
			} else {
				sign = 1; // sell
			}
			int amount = s.nextInt();
			s.next();
			s.next();
			int price = s.nextInt() * sign;
			s.nextLine();
			// while (thisLine.hasNext()) {
			// thisLine.next();
			// }
			order o = new order(price, amount);

			if (sign > 0) {// sell order
				if (buyPool.isEmpty()) {
					sellPool.add(o);
				} else {
					while ((!buyPool.isEmpty())&&Math.abs(buyPool.peek().getKey()) >= Math.abs(o.getKey())&&o.getValue()>0) {
						if (o.getValue() >= buyPool.peek().getValue()) {
							totalAmount = totalAmount
									+ buyPool.peek().getValue();
							totalPrice = totalPrice + buyPool.peek().getValue()
									* Math.abs(buyPool.peek().getKey());
							o.setValue(o.getValue()-buyPool.peek().getValue());
							buyPool.remove();
//							if(buyPool.isEmpty()){
//								sellPool.add(o);
//							}
						} else {
							totalAmount = totalAmount + o.getValue();
							totalPrice = totalPrice + o.getValue()
									* Math.abs(buyPool.peek().getKey());
							buyPool.peek().setValue(
									buyPool.peek().getValue() - o.getValue());
							o.setValue(0);
						}
					}
					if (o.getValue() > 0) {
						sellPool.add(o);
					}
				}

			} else {// buy order
				if (sellPool.isEmpty()) {
					buyPool.add(o);
				} else {
					while ((!sellPool.isEmpty())&&Math.abs(sellPool.peek().getKey()) <= Math.abs(o.getKey())&&o.getValue()>0) {
						if (o.getValue() >= sellPool.peek().getValue()) {
							totalAmount = totalAmount
									+ sellPool.peek().getValue();
							totalPrice = totalPrice
									+ sellPool.peek().getValue() * Math.abs(o.getKey());
							o.setValue(o.getValue()-sellPool.peek().getValue());
							sellPool.remove();
//							if(sellPool.isEmpty()){
//								buyPool.add(o);
//							}
						} else {
							totalAmount = totalAmount + o.getValue();
							totalPrice = totalPrice + o.getValue() * Math.abs(o.getKey());
							sellPool.peek().setValue(
									sellPool.peek().getValue() - o.getValue());
							o.setValue(0);
						}
					}
					if (o.getValue() > 0) {
						buyPool.add(o);
					}
				}

			}
//			thisLine.close();
		}
	}

	public static void main(String[] args) {
		new Double_Auction();
	}

	private class order implements Entry<Integer, Integer>, Comparable<order> {

		private Integer price, amount;

		public order(Integer p, Integer n) {
			price = p;
			amount = n;
		}

		@Override
		public Integer getKey() {
			return price;
		}

		@Override
		public Integer getValue() {
			return amount;
		}

		@Override
		public Integer setValue(Integer value) {
			Integer removedValue = amount;
			amount = value;
			return removedValue;
		}

		@Override
		public int compareTo(order o) {
			if (this.getKey() > o.getKey()) {
				return 1;
			} else if (this.getKey() < o.getKey()) {
				return -1;
			}
			return 0;
		}

	}
}
