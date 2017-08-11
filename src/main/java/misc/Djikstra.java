package misc;

import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.stream.IntStream;

public class Djikstra {
    private static final int MAX_VALUE = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException, URISyntaxException {
        Graph g = new Graph();
        initGraph(g, "D:\\graph.txt");
        int[] rs = shortestPaths(g, 1);
        int[] pos = {7, 37, 59, 82, 99, 115, 133, 165, 188, 197};
        IntStream.of(pos).forEach(x -> System.out.print(String.format("%d,", rs[x])));
    }

    private static void initGraph(Graph g, String path) throws URISyntaxException, IOException {
        List<String> files = Files.readAllLines(Paths.get(path));
        for (int i = 0; i < files.size(); i++) {
            String[] rs = files.get(i).split("\t");
            final int k = i + 1;
            IntStream.range(1, rs.length).forEach(j ->
                    g.addEdge(k,
                            Integer.parseInt(rs[j].split(",")[0]),
                            Integer.parseInt(rs[j].split(",")[1])));
        }
    }

    private static int[] shortestPaths(Graph g, int from) {
        int[] shortestPaths = new int[201];
        IntStream.range(2, 201).forEach(i -> shortestPaths[i] = MAX_VALUE);
        PriorityQueue<Edge> priorityQueue = new PriorityQueue<>();
        g.getEdges(from).stream().forEach(e -> priorityQueue.add(new Edge(e.src, e.dst, shortestPaths[e.src] + e.weight)));
        while (!priorityQueue.isEmpty()) {
            Edge e = priorityQueue.remove();
            shortestPaths[e.dst] = shortestPaths[e.dst] > e.weight ? e.weight : shortestPaths[e.dst];
            g.getEdges(e.dst).stream().forEach(ed -> {
                if (shortestPaths[ed.dst] != MAX_VALUE) {
                    return;
                }
                priorityQueue.add(new Edge(ed.src, ed.dst, shortestPaths[ed.src] + ed.weight));
            });
        }
        return shortestPaths;
    }

    private static class Graph {
        List<Edge>[] adjactionList = (List<Edge>[]) new List[201];

        void addEdge(int i, int j, int weight) {
            if (adjactionList[i] == null) {
                adjactionList[i] = new ArrayList<>();
            }
            adjactionList[i].add(new Edge(i, j, weight));
        }

        List<Edge> getEdges(int i) {
            return adjactionList[i] == null ? new ArrayList<>() : adjactionList[i];
        }
    }

    private static class Edge implements Comparable<Edge> {
        int src;
        int dst;
        int weight;

        Edge(int s, int d, int w) {
            src = s;
            dst = d;
            weight = w;
        }

        @Override
        public int compareTo(Edge o) {
            return weight - o.weight;
        }
    }
}
