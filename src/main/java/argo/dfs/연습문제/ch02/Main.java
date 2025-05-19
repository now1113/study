package argo.dfs.연습문제.ch02;

import java.util.ArrayList;
import java.util.List;

public class Main {

    static boolean[] visited = new boolean[5];
    static List<Integer>[] graph = new List[5];

    public static void dfs(int node) {
        visited[node] = true;
        System.out.println(node);

        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }

        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 5; i++) {
            graph[i] = new ArrayList<>();
        }

        graph[1].add(2);
        graph[1].add(3);
        graph[2].add(4);

        dfs(1);
    }
}
