import java.util.Stack;

public class DepthFirstSearch {

    public static void main(String[] args) {
        // Пример графа в виде матрицы смежности
        int[][] graph = {
                {0, 1, 1, 0, 0, 0},
                {1, 0, 0, 1, 0, 0},
                {1, 0, 0, 1, 1, 1},
                {0, 1, 1, 0, 1, 0},
                {0, 0, 1, 1, 0, 1},
                {0, 0, 1, 0, 1, 0}
        };

        // Начинаем обход в глубину с вершины 0
        depthFirstSearch(graph, 0);
    }

    private static void depthFirstSearch(int[][] graph, int startVertex) {
        int vertices = graph.length;
        boolean[] visited = new boolean[vertices];

        Stack<Integer> stack = new Stack<>();
        stack.push(startVertex);

        System.out.println("Обход в глубину начиная с вершины " + startVertex + ":");

        while (!stack.isEmpty()) {
            int currentVertex = stack.pop();

            if (!visited[currentVertex]) {
                System.out.print(currentVertex + " ");
                visited[currentVertex] = true;
            }

            for (int neighbor = vertices - 1; neighbor >= 0; neighbor--) {
                if (graph[currentVertex][neighbor] == 1 && !visited[neighbor]) {
                    stack.push(neighbor);
                }
            }
        }
    }
}