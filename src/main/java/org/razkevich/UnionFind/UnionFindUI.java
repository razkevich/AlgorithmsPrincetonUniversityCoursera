package org.razkevich.UnionFind;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UnionFindUI {
    public static void main(String[] args) throws IOException {
        System.out.println("Choose implementation: [*QuickFind], [QuickUnion]");
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String command = console.readLine();
        UnionFind unionFind;
        switch (command) {
            case "QuickFind":
                unionFind = new QuickFind(10);
                break;
            case "QuickUnion":
                unionFind = new QuickFind(10);//todo: tbd
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
                for (int i = 0; i < unionFind.getId().length; i++) {
                    System.out.print(i + "\t");
                }
                System.out.println();
                for (int i = 0; i < unionFind.getId().length; i++) {
                    System.out.print(unionFind.getId()[i] + "\t");
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
