import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UnionFindUI {
	public static void main(String[] args) throws IOException {
		System.out.println("Choose implementation: [*1: QuickFind], [2: QuickUnion]");
		BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
		String command = console.readLine();
		UnionFind unionFind;
		switch (command) {
			case "1":
				unionFind = new QuickFind(10);//todo: tbd
				break;
			case "2":
				unionFind = new QuickUnion(10);
				break;
			default:
				unionFind = new QuickFind(10);
				break;
		}
		while (true) {
			System.out.println("\nChoose command: [union a b], [connected a b], [quit]");
			command = console.readLine();
			try {
				performWork(unionFind, command.split(" "));
			} catch (Exception e) {
				System.out.println("Error executing command: " + command);
				System.out.println(e.getClass().getName() + ":" + e.getMessage());
			} finally {
				for (int i = 0; i < unionFind.getElements().length; i++) {
					System.out.print(i + "\t");
				}
				System.out.println();
				for (int i = 0; i < unionFind.getElements().length; i++) {
					System.out.print(unionFind.getElements()[i] + "\t");
				}
			}
		}
	}

	private static void performWork(UnionFind unionFind, String[] arguments) {
		switch (arguments[0]) {
			case "union":
				unionFind.union(Integer.valueOf(arguments[1]), Integer.valueOf(arguments[2]));
				break;
			case "connected":
				System.out.println(unionFind.connected(Integer.valueOf(arguments[1]), Integer.valueOf(arguments[2])));
				break;
			case "quit":
				System.exit(0);
			default:
				throw new IllegalArgumentException("command not available");
		}
	}
}
