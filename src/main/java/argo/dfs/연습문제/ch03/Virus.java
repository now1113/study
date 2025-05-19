package argo.dfs.연습문제.ch03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Virus {

    static List<Integer>[] graph;
    static boolean[] visited;
    static int infectedCount = 0;

    public static void dfs(int node) {
        visited[node] = true;

        for (int next : graph[node]) {
            if (!visited[next]) {
                infectedCount++;
                dfs(next);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int computerCount = sc.nextInt();
        int connectionCount = sc.nextInt();

        graph = new ArrayList[computerCount + 1];
        visited = new boolean[computerCount + 1];

        for (int i = 1; i <= computerCount; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < connectionCount; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();

            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(1);
        System.out.println(infectedCount);
    }
}
