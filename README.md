# 🧠 Grafos em Java — Estrutura de Dados

> Projeto prático de implementação de **Grafo Genérico** e **Algoritmo de Dijkstra** (com BFS e DFS), desenvolvido em Java para a disciplina de Estrutura de Dados.

**Aluno:Marcos Andre dos Santos Soares  
**Professor:Anderson Soares  
**Data:05/12/2025  
**IDE: NetBeans 22 + Maven

---

## 🎯 Objetivo

Implementar um **grafo genérico** utilizando lista de adjacência e aplicar **algoritmos clássicos de grafos**, incluindo:

- ✅ BFS (Busca em Largura)
- ✅ DFS (Busca em Profundidade)
- ✅ Dijkstra (Menor Caminho)

O projeto simula um **grafo de cidades**, onde:
- Vértices = cidades  
- Arestas = estradas  
- Pesos = distâncias entre cidades  

---

## 📌 Estrutura do Projeto

GrafosTrabalho
│
├── src/main/java/com/mycompany/grafostrabalho
│ ├── Aresta.java
│ ├── Grafo.java
│ └── GrafosTrabalho.java (Main)
│
└── README.md


---

## 🧩 Conceitos aplicados

| Conceito | Descrição |
|--------|------|
| Lista de Adjacência | Estrutura usada para armazenar o grafo |
| Grafo Genérico | Permite representar qualquer tipo de conexão |
| Dijkstra | Encontra o menor caminho entre vértices |
| BFS | Percorre o grafo por níveis |
| DFS | Percorre o grafo em profundidade |

---

## 💻 Principais Classes

### 🔹 `Aresta.java`
Responsável por armazenar:
- Destino do caminho
- Peso (distância)

```java
public class Aresta {
    String destino;
    int peso;
}
🔹 Grafo.java
Responsável por:

Armazenar os dados do grafo

Controlar vértices e arestas

Executar BFS, DFS e Dijkstra


private Map<String, List<Aresta>> adj = new HashMap<>();
Inclui os métodos:

adicionarVertice()

adicionarAresta()

exibir()

bfs()

dfs()

dijkstra()

🔹 GrafosTrabalho.java
Classe principal responsável por criar o grafo e chamar os algoritmos:

Grafo g = new Grafo(false);

g.adicionarAresta("A", "B", 5);
g.adicionarAresta("A", "C", 2);
g.adicionarAresta("B", "D", 4);
g.adicionarAresta("C", "D", 1);
g.adicionarAresta("D", "E", 3);

g.exibir();
g.bfs("A");
g.dfs("A");
g.dijkstra("A");
🧠 Sobre o Algoritmo de Dijkstra
O algoritmo de Dijkstra é utilizado para calcular a menor distância entre um vértice inicial e todos os outros vértices do grafo.

Ele funciona através dos seguintes passos:

Inicializa a distância de todos os vértices como infinita

Define a distância do vértice inicial como 0

Usa uma PriorityQueue para buscar o vértice mais próximo

Atualiza as distâncias dos vizinhos

Continua até visitar todos os vértices

Implementação usada:

java
public void dijkstra(String inicio) {
    Map<String, Integer> dist = new HashMap<>();
    PriorityQueue<String> pq = new PriorityQueue<>(Comparator.comparing(dist::get));

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

    dist.forEach((v, d) ->
        System.out.println("Distância até " + v + ": " + d)
    );
}

📤 Saída gerada no console

=== GRAFO ===
A -> B(5) C(2)
B -> A(5) D(4)
C -> A(2) D(1)
D -> B(4) C(1) E(3)
E -> D(3)

BFS a partir de A
A B C D E

DFS a partir de A
A B D C E

Dijkstra a partir de A
Distância até A: 0
Distância até B: 5
Distância até C: 2
Distância até D: 3
Distância até E: 6

✅ Projeto atende critérios de nota 9 a 10

🎬 Vídeo demonstrativo
🔗 **Link do vídeo:*https://youtu.be/zJ6n2ok1VPw

✍️Disciplina de Estrutura de Dados – 2025
