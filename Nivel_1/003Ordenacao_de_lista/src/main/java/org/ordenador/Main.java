package org.ordenador;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean continuar = true;
        System.out.println("Bem-vindo ao programa de ordenação de lista!");

        ListaOrdenacao listaOrdenacao = new ListaOrdenacao();

        while (continuar){
            listaOrdenacao.lerEntrada();

            System.out.println("Escolha o algoritmo de ordenação:");
            System.out.println("1. Bubble Sort");
            System.out.println("2. Merge Sort");
            System.out.println("3. Quick Sort");
            System.out.println("4. Heap Sort");
            System.out.println("5. Insertion Sort");
            System.out.println("6. Selection Sort");
            System.out.println("7. Shell Sort");
            System.out.println("8. Counting Sort");
            System.out.println("9. Radix Sort");
            System.out.println("10. Help");
            System.out.println("0. Sair");

            Scanner scanner = new Scanner(System.in);
            int escolha = scanner.nextInt();

            switch (escolha) {
                case 0:
                    continuar = false;
                    break;
                case 1:
                    listaOrdenacao.ordenarLista(new BubbleSort());
                    break;
                case 2:
                    listaOrdenacao.ordenarLista(new MergeSort());
                    break;
                case 3:
                    listaOrdenacao.ordenarLista(new QuickSort());
                    break;
                case 4:
                    listaOrdenacao.ordenarLista(new HeapSort());
                    break;
                case 5:
                    listaOrdenacao.ordenarLista(new InsertionSort());
                    break;
                case 6:
                    listaOrdenacao.ordenarLista(new SelectionSort());
                    break;
                case 7:
                    listaOrdenacao.ordenarLista(new ShellSort());
                    break;
                case 8:
                    listaOrdenacao.ordenarLista(new CountingSort());
                    break;
                case 9:
                    listaOrdenacao.ordenarLista(new RadixSort());
                    break;
                case 10:
                    exibirAjuda();
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
            if (escolha != 0) {
                if (escolha != 10) {
                    listaOrdenacao.imprimirLista();
                }else {
                    System.out.println("\n");
                }
            } else {
                System.out.println("Obrigado por utilizar o Ordenador! Até a próxima!");
            }
        }
    }
    private static void exibirAjuda() {
        System.out.println("=== Ajuda ===");
        System.out.println("1. Bubble Sort:");
        System.out.println("   - Quando usar: O Bubble Sort é adequado para pequenas listas ou quando a simplicidade de implementação é mais importante do que a eficiência.");
        System.out.println("   - Por que escolher: É fácil de entender e implementar.");
        System.out.println("   - Como é feito: O Bubble Sort compara pares de elementos adjacentes e os troca se estiverem na ordem errada, repetindo esse processo até que a lista esteja ordenada.");
        System.out.println("2. Merge Sort:");
        System.out.println("   - Quando usar: O Merge Sort é eficaz para ordenar grandes listas ou quando a eficiência é uma prioridade.");
        System.out.println("   - Por que escolher: Possui uma complexidade de tempo O(n log n) garantida e é estável.");
        System.out.println("   - Como é feito: O Merge Sort divide recursivamente a lista em sublistas, ordena cada sublista e, em seguida, combina as sublistas ordenadas.");
        System.out.println("3. Quick Sort:");
        System.out.println("   - Quando usar: O Quick Sort é rápido e eficiente para grandes conjuntos de dados, mas pode ter um desempenho ruim em conjuntos de dados quase ordenados.");
        System.out.println("   - Por que escolher: Possui uma complexidade de tempo O(n log n) em média e é in-place (não requer espaço adicional).");
        System.out.println("   - Como é feito: O Quick Sort seleciona um elemento como pivô e rearranja os elementos ao redor do pivô de forma que os elementos menores do que o pivô estejam à esquerda e os maiores estejam à direita.");
        System.out.println("4. Heap Sort:");
        System.out.println("   - Quando usar: Heap Sort é eficiente e é útil quando o espaço é limitado, pois tem uma complexidade de espaço O(1).");
        System.out.println("   - Por que escolher: Possui uma complexidade de tempo O(n log n) garantida e é in-place.");
        System.out.println("   - Como é feito: O Heap Sort constrói uma árvore binária (um heap) a partir da lista, em seguida, remove iterativamente o maior elemento (raiz) e reconstrói o heap.");
        System.out.println("5. Insertion Sort:");
        System.out.println("   - Quando usar: Insertion Sort é eficiente para ordenar listas pequenas ou quase ordenadas.");
        System.out.println("   - Por que escolher: É simples de implementar e tem um baixo overhead de memória.");
        System.out.println("   - Como é feito: O Insertion Sort constrói a lista ordenada um elemento de cada vez, inserindo cada novo elemento na posição correta.");
        System.out.println("6. Selection Sort:");
        System.out.println("   - Quando usar: Selection Sort é útil para pequenas listas ou quando a memória é limitada, pois possui um baixo overhead de memória.");
        System.out.println("   - Por que escolher: É fácil de implementar e tem um desempenho estável para listas pequenas.");
        System.out.println("   - Como é feito: O Selection Sort seleciona iterativamente o menor elemento da lista não ordenada e o troca com o primeiro elemento não ordenado.");
        System.out.println("7. Shell Sort:");
        System.out.println("   - Quando usar: Shell Sort é eficaz para listas de tamanho moderado a grande.");
        System.out.println("   - Por que escolher: Possui uma boa combinação de desempenho e simplicidade.");
        System.out.println("   - Como é feito: O Shell Sort divide a lista em subgrupos menores e ordena esses subgrupos usando o Insertion Sort, reduzindo gradualmente o tamanho dos subgrupos até que toda a lista esteja ordenada.");
        System.out.println("8. Counting Sort:");
        System.out.println("   - Quando usar: Counting Sort é adequado para ordenar listas de inteiros quando o intervalo de valores é conhecido e não é muito grande.");
        System.out.println("   - Por que escolher: É eficiente quando o intervalo de valores é pequeno em comparação com o tamanho da lista e é estável.");
        System.out.println("   - Como é feito: O Counting Sort conta o número de ocorrências de cada valor na lista e, em seguida, reconstrói a lista ordenada com base nesses contadores.");
        System.out.println("9. Radix Sort:");
        System.out.println("   - Quando usar: Radix Sort é eficaz para ordenar listas de inteiros não negativos de tamanho moderado a grande.");
        System.out.println("   - Por que escolher: Tem uma complexidade de tempo O(nk) garantida, onde n é o número de elementos e k é o número de dígitos dos números de entrada.");
        System.out.println("   - Como é feito: O Radix Sort ordena os números de entrada com base nos dígitos individuais, começando pelo dígito menos significativo e trabalhando em direção ao mais significativo.");
    }
}