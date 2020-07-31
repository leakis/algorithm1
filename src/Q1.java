import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q1 {

	static int n;
	static int m;

	@SuppressWarnings("resource")
	public static void main(String[] args) {
     //请按照5 2的格式在控制台输入数值
		Scanner scan = new Scanner(System.in);

		if (scan.hasNext()) {
			String input = scan.nextLine();
			String[] arr = input.split(" ");
			n = Integer.parseInt(arr[0]);
			m = Integer.parseInt(arr[1]);

		}

		if (n > 15 || m > 5) {
			System.out.print("第一个数值不能大于15，第二个数值不能大于5");
			return;
		}

		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < n; i++) {
			queue.add(i + 1);
		}

		Queue<Integer> q = answer(queue, 1);
		System.out.println(q.poll());

	}

	public static Queue<Integer> answer(Queue<Integer> queue, int t) {
		int size = queue.size();

		if (size == 1) {
			return queue;
		}

		int c = 0;
		int pos = (int) Math.pow(m, t);
		while (c < pos) {
			c++;
			int q = queue.poll();
			if (pos == c) {
				answer(queue, t + 1);
			} else {
				queue.add(q);
			}

		}
		return queue;
	}

}
