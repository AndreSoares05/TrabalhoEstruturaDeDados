package com.mycompany.grafostrabalho;

import java.util.*;

public class Grafo {

    private Map<String, List<Aresta>> adj = new HashMap<>();
    private boolean direcionado;

    public Grafo(boolean direcionado) {
        this.direcionado = direcionado;
    }

    // ADICIONAR VÉRTICE
    public void adicionarVertice(String v) {
        adj.putIfAbsent(v, new ArrayList<>());
    }

    // ADICIONAR ARESTA
    public void adicionarAresta(String origem, String destino, int peso) {
        adicionarVertice(origem);
        adicionarVertice(destino);

        adj.get(origem).add(new Aresta(destino, peso));

        if (!direcionado) {
            adj.get(destino).add(new Aresta(origem, peso));
        }
    }

    // EXIBIR
    public void exibir() {
        System.out.println("=== GRAFO ===");
        for (String v : adj.keySet()) {
            System.out.print(v + " -> ");
            for (Aresta a : adj.get(v)) {
                System.out.print(a + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // ✅ BFS
    public void bfs(String inicio) {
        System.out.println("BFS a partir de " + inicio);
        Queue<String> fila = new LinkedList<>();
        Set<String> visitado = new HashSet<>();

        fila.add(inicio);
        visitado.add(inicio);

        while (!fila.isEmpty()) {
            String atual = fila.poll();
            System.out.print(atual + " ");

            for (Aresta a : adj.get(atual)) {
                if (!visitado.contains(a.destino)) {
                    visitado.add(a.destino);
                    fila.add(a.destino);
                }
            }
        }
        System.out.println("\n");
    }

    // ✅ DFS
    public void dfs(String inicio) {
        System.out.println("DFS a partir de " + inicio);
        Set<String> visitado = new HashSet<>();
        dfsRec(inicio, visitado);
        System.out.println("\n");
    }

    private void dfsRec(String v, Set<String> visitado) {
        visitado.add(v);
        System.out.print(v + " ");

        for (Aresta a : adj.get(v)) {
            if (!visitado.contains(a.destino)) {
                dfsRec(a.destino, visitado);
            }
        }
    }

    // ✅ DIJKSTRA
    public void dijkstra(String inicio) {
        System.out.println("Dijkstra a partir de " + inicio);

        Map<String, Integer> dist = new HashMap<>();
        PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparing(dist::get));

        // inicia distâncias
        for (String v : adj.keySet()) {
            dist.put(v, Integer.MAX_VALUE);
        }

        dist.put(inicio, 0);
        pq.add(inicio);

        while (!pq.isEmpty()) {
            String atual = pq.poll();

            for (Aresta a : adj.get(atual)) {
                int novaDist = dist.get(atual) + a.peso;

                if (novaDist < dist.get(a.destino)) {
                    dist.put(a.destino, novaDist);
                    pq.add(a.destino);
                }
            }
        }

        // Mostrar resultado
        for (String v : dist.keySet()) {
            System.out.println("Distância até " + v + ": " + dist.get(v));
        }
        System.out.println();
    }
}
