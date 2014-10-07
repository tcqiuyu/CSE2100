//import java.io.*;
//import java.util.Scanner;
//
//public class Test
//{
//
//    public static void main (String[] args)
//    {
//        Scanner input = new Scanner(System.in);
//        int i = input.nextInt();
//        while(input.hasNextInt())
//        {
//            int x = input.nextInt();
//            if (x%2 == 0)
//            {
//                System.out.println("No");
//            }
//            else
//            {
//                System.out.println("Yes");
//            }
//        }
//        System.out.print(111);
//    }
//        
//}

//import java.util.*; 
//    public class Test { 
//        public static void main(String args[]) { 
//             System.out.println("请输入若干个数,每输入一个数用回车确认"); 
//             System.out.println("最后输入一个非数字结束输入操作"); 
//             Scanner reader = new Scanner(System.in); 
//            double sum = 0; 
//            int m = 0; 
//         while (reader.hasNextDouble()) { 
//             double x = reader.nextDouble(); 
//              m = m + 1; 
//              sum = sum + x; 
//          } 
//          System.out.printf("%d个数的和为%f\n", m, sum); 
//          System.out.printf("%d个数的平均值是%f\n", m, sum / m); 
//      } 
// }


public class Test {

	/** Set a value for target sum */
	public static final int TARGET_SUM = 4;
	int count = 0;

	public void populateSubset(final int[] data, int fromIndex,
			final int[] stack, final int stacklen, final int target) {
		if (target == 0) {
			// exact match of our target. Success!
			// printResult(Arrays.copyOf(stack, stacklen));
			count++;
			return;
		}

		while (fromIndex < data.length && data[fromIndex] > target) {
			// take advantage of sorted data.
			// we can skip all values that are too large.
			fromIndex++;
		}

		while (fromIndex < data.length && data[fromIndex] <= target) {
			// stop looping when we run out of data, or when we overflow our
			// target.
//			stack[stacklen] = data[fromIndex];
			populateSubset(data, fromIndex + 1, stack, stacklen + 1, target
					- data[fromIndex]);
			fromIndex++;
		}
	}

	public int getCount() {
		return count;
	}

	// private void printResult(int[] copyOf) {
	// StringBuilder sb = new StringBuilder();
	// sb.append(TARGET_SUM).append(" = ");
	// for (Integer i : copyOf) {
	// sb.append(i).append("+");
	// }
	// System.out.println(sb.deleteCharAt(sb.length() - 1).toString());
	// }

	private static final int[] DATA = { 2,3,4,5 };

	public static void main(String[] args) {
		Test example = new Test();
		example.populateSubset(DATA, 0, new int[DATA.length], 0, 4);
		System.out.print(example.getCount());
	}

}
