import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Q3 {

	public static void main(String[] args) {
		// 请按照格式更新q3.txt以测试程序

		List<String> list = FileUtil.getInput("q3.txt");

		Map<Integer, LinkedHashSet<Integer>> map = genMap(list);
		if (map == null) {
			System.out.print("Not a tree");
			return;
		}

		LinkedList<Integer> nodes = bfs(map);

		if (nodes != null) {
			int index = 0;
			for (int node : nodes) {
				index++;
				System.out.print(node);
				if (index < nodes.size()) {
					System.out.print(",");
				}
			}

		} else {
			System.out.print("Not a tree");
		}

	

	}

	public static LinkedList<Integer> bfs(Map<Integer, LinkedHashSet<Integer>> map) {

		LinkedList<Integer> treeNodes = new LinkedList<Integer>();
		LinkedList<Integer> queue = new LinkedList<Integer>();
		int root = map.get(0).iterator().next();
		map.remove(0);
		queue.offer(root); // 首先将根节点存入队列
		while (queue.size() > 0) {

			int node = queue.poll();

			if (map.containsKey(node)) {

				for (int r : map.get(node)) {

					queue.offer(r);
				}
				map.remove(node);

			}

			treeNodes.offer(node);

		}

		if (map.size() > 0) {
			treeNodes = null;
		}

		return treeNodes;

	}

	static Map<Integer, LinkedHashSet<Integer>> genMap(List<String> list) {

		Map<Integer, LinkedHashSet<Integer>> map = new LinkedHashMap<Integer, LinkedHashSet<Integer>>();
		Map<Integer, Integer> parentMap = new HashMap<Integer, Integer>();

		int root = 0;

		for (String str : list) {

			String[] arr = str.split(",");
			int key = Integer.parseInt(arr[0]);
			int value = Integer.parseInt(arr[1]);
			LinkedHashSet<Integer> set = null;
			if (map.containsKey(key)) {
				set = map.get(key);
				set.add(value);
				map.put(key, set);
			} else {
				set = new LinkedHashSet<Integer>();
			}

			if (parentMap.containsKey(value) && parentMap.get(value) != key) {
				return null;
			} else {
				parentMap.put(value, key);
			}

			set.add(value);
			map.put(key, set);

			if (!parentMap.containsKey(key)) {
				root = key;
			}

		}

		// System.out.print(root);
		if (root > 0) {
			LinkedHashSet<Integer> rootSet = new LinkedHashSet<Integer>();
			rootSet.add(root);
			map.put(0, rootSet);
		}

		return map;
		
	}

}
