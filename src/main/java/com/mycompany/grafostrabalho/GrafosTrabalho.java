package com.mycompany.grafostrabalho;

public class GrafosTrabalho {

    public static void main(String[] args) {

        Grafo g = new Grafo(false);

        // Grafo de cidades (exemplo)
        g.adicionarAresta("A", "B", 5);
        g.adicionarAresta("A", "C", 2);
        g.adicionarAresta("B", "D", 4);
        g.adicionarAresta("C", "D", 1);
        g.adicionarAresta("D", "E", 3);

        // Mostrar grafo
        g.exibir();

        // Algoritmos
        g.bfs("A");
        g.dfs("A");
        g.dijkstra("A");
    }
}
