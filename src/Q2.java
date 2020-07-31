import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class Q2 {

	static int min = 100;
	static Set<String> minSet = new TreeSet<String>();

	public static void main(String[] args) {
		 // 请按照格式更新q2.txt以测试程序

		List<String> list = FileUtil.getInput("q2.txt");
         //时间复杂度为O(n^2)，有时间需要考虑一种更好的算法
		for (int i = 0; i < list.size() - 1; i++) {

			for (int j = i + 1; j < list.size(); j++) {

				String[] arr1 = list.get(i).split(" ");
				Q2DanMu d1 = new Q2DanMu();
				d1.start = Integer.parseInt(arr1[0]);
				d1.end = Integer.parseInt(arr1[1]);

				String[] arr2 = list.get(j).split(" ");
				Q2DanMu d2 = new Q2DanMu();
				d2.start = Integer.parseInt(arr2[0]);
				d2.end = Integer.parseInt(arr2[1]);

				minDanMu(d1, d2);

			}

		}

		
		for(String s:minSet) {
			System.out.println(s);
		}

	}

	static void minDanMu(Q2DanMu d1, Q2DanMu d2) {

		Q2DanMu dm = null;
		String str = "";
		int start = max(d1.start, d2.start);
		int end = min(d1.end, d2.end);

		int dvalue = 100;

		if (start < end) {
			// 有交集
			dm = new Q2DanMu();
			dm.start = start;
			dm.end = end;
			dvalue = end - start;
			str = dm.start + " " + dm.end;
			if (dvalue < min) {
				min = end - start;
				minSet = new TreeSet<String>();
				minSet.add(str);

			} else if (dvalue == min) {
				minSet.add(str);
			}

		} else {
			// 无交集
			dvalue = d1.end - d1.start;
			str = d1.start + " " + d1.end;
			if (dvalue < min) {
				min = dvalue;
				minSet = new TreeSet<String>();
				minSet.add(str);

			} else if (dvalue == min) {
				minSet.add(str);
			}

			dvalue = d2.end - d2.start;
			str = d2.start + " " + d2.end;

			if (dvalue < min) {
				min = dvalue;
				minSet = new TreeSet<String>();
				minSet.add(str);

			} else if (dvalue == min) {
				minSet.add(str);
			}

		}

	}
	

	

}
