import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

import org.ordenador.*;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ListaOrdenacaoTest {
    @Test
    public void testarLerEntrada() {
        ListaOrdenacao listaOrdenacao = new ListaOrdenacao();

        String input = "5, 1, 3, 3, 2, 7, 4, 9, 8, 0";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);

        listaOrdenacao.lerEntrada();

        assertEquals(Arrays.asList(5, 1, 3, 3, 2, 7, 4, 9, 8, 0), listaOrdenacao.getLista());

        System.setIn(System.in);
    }

    @Test
    public void testeBubbleSort() {
        ListaOrdenacao listaOrdenacao = new ListaOrdenacao();
        listaOrdenacao.getLista().add(4);
        listaOrdenacao.getLista().add(2);
        listaOrdenacao.getLista().add(7);
        listaOrdenacao.getLista().add(1);

        listaOrdenacao.ordenarLista(new BubbleSort());
        assertArrayEquals(new Integer[]{1, 2, 4, 7}, listaOrdenacao.getLista().toArray());
    }

    @Test
    public void testarMergeSort() {
        Integer[][] casosTeste = {
                {12, 10, 15, 3, 18, 2}, {6, 1, 8, 9, 2, 5, 9, 3, 0, 11, 21, 19, 12},
                {5, 4, 3, 2, 1}, {1, 2, 3, 4, 5}, {5,5,5,5,5,5,5,5,5,5},
                {9, 8, 7, 6, 5, 4, 3, 2, 1}, {1}, {2, 1}, {}
        };

        Integer[][] resultadosEsperados = {
                {2, 3, 10, 12, 15, 18}, {0, 1, 2, 3, 5, 6, 8, 9, 9, 11, 12, 19, 21},
                {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {5,5,5,5,5,5,5,5,5,5},
                {1, 2, 3, 4, 5, 6, 7, 8, 9}, {1}, {1, 2}, {}
        };

        for (int i = 0; i < casosTeste.length; i++) {
            Integer[] desordenado = Arrays.copyOf(casosTeste[i], casosTeste[i].length);

            ListaOrdenacao listaOrdenacao = new ListaOrdenacao();
            listaOrdenacao.getLista().addAll(Arrays.asList(desordenado));
            listaOrdenacao.ordenarLista(new MergeSort());

            assertEquals(Arrays.asList(resultadosEsperados[i]), listaOrdenacao.getLista());
        }
    }
    @Test
    public void testarQuickSort() {
        Integer[][] casosTeste = {
                {12, 10, 15, 3, 18, 2}, {6, 1, 8, 9, 2, 5, 9, 3, 0, 11, 21, 19, 12},
                {5, 4, 3, 2, 1}, {1, 2, 3, 4, 5}, {9, 8, 7, 6, 5, 4, 3, 2, 1}, {1},
                {2, 1}, {}, {1, 1, 1, 1, 1}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
        };

        Integer[][] resultadosEsperados = {
                {2, 3, 10, 12, 15, 18}, {0, 1, 2, 3, 5, 6, 8, 9, 9, 11, 12, 19, 21},
                {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5, 6, 7, 8, 9}, {1},
                {1, 2}, {}, {1, 1, 1, 1, 1}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
        };

        for (int i = 0; i < casosTeste.length; i++) {
            Integer[] desordenado = Arrays.copyOf(casosTeste[i], casosTeste[i].length);

            ListaOrdenacao listaOrdenacao = new ListaOrdenacao();
            listaOrdenacao.getLista().addAll(Arrays.asList(desordenado));
            listaOrdenacao.ordenarLista(new QuickSort());

            assertEquals(Arrays.asList(resultadosEsperados[i]), listaOrdenacao.getLista());
        }
    }

    @Test
    public void testarHeapSort() {
        Integer[][] casosTeste = {
                {12, 10, 15, 3, 18, 2}, {6, 1, 8, 9, 2, 5, 9, 3, 0, 11, 21, 19, 12},
                {5, 4, 3, 2, 1}, {1, 2, 3, 4, 5}, {9, 8, 7, 6, 5, 4, 3, 2, 1}, {1},
                {2, 1}, {}, {1, 1, 1, 1, 1}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
        };

        Integer[][] resultadosEsperados = {
                {2, 3, 10, 12, 15, 18}, {0, 1, 2, 3, 5, 6, 8, 9, 9, 11, 12, 19, 21},
                {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5, 6, 7, 8, 9}, {1},
                {1, 2}, {}, {1, 1, 1, 1, 1}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
        };

        for (int i = 0; i < casosTeste.length; i++) {
            Integer[] desordenado = Arrays.copyOf(casosTeste[i], casosTeste[i].length);

            List<Integer> listaDesordenada = Arrays.asList(desordenado);
            HeapSort heapSort = new HeapSort();
            heapSort.ordenar(listaDesordenada);

            assertEquals(Arrays.asList(resultadosEsperados[i]), listaDesordenada);
        }
    }

    @Test
    public void testarInsertionSort() {
        Integer[][] casosTeste = {
                {12, 10, 15, 3, 18, 2}, {6, 1, 8, 9, 2, 5, 9, 3, 0, 11, 21, 19, 12},
                {5, 4, 3, 2, 1}, {1, 2, 3, 4, 5}, {9, 8, 7, 6, 5, 4, 3, 2, 1}, {1},
                {2, 1}, {}, {1, 1, 1, 1, 1}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
        };

        Integer[][] resultadosEsperados = {
                {2, 3, 10, 12, 15, 18}, {0, 1, 2, 3, 5, 6, 8, 9, 9, 11, 12, 19, 21},
                {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5, 6, 7, 8, 9}, {1},
                {1, 2}, {}, {1, 1, 1, 1, 1}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
        };

        for (int i = 0; i < casosTeste.length; i++) {
            Integer[] desordenado = Arrays.copyOf(casosTeste[i], casosTeste[i].length);

            List<Integer> listaDesordenada = Arrays.asList(desordenado);
            InsertionSort insertionSort = new InsertionSort();
            insertionSort.ordenar(listaDesordenada);

            assertEquals(Arrays.asList(resultadosEsperados[i]), listaDesordenada);
        }
    }

    @Test
    public void testarSelectionSort() {
        Integer[][] casosTeste = {
                {12, 10, 15, 3, 18, 2}, {6, 1, 8, 9, 2, 5, 9, 3, 0, 11, 21, 19, 12},
                {5, 4, 3, 2, 1}, {1, 2, 3, 4, 5}, {9, 8, 7, 6, 5, 4, 3, 2, 1}, {1},
                {2, 1}, {}, {1, 1, 1, 1, 1}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
        };

        Integer[][] resultadosEsperados = {
                {2, 3, 10, 12, 15, 18}, {0, 1, 2, 3, 5, 6, 8, 9, 9, 11, 12, 19, 21},
                {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5, 6, 7, 8, 9}, {1},
                {1, 2}, {}, {1, 1, 1, 1, 1}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
        };

        for (int i = 0; i < casosTeste.length; i++) {
            Integer[] desordenado = Arrays.copyOf(casosTeste[i], casosTeste[i].length);

            List<Integer> listaDesordenada = Arrays.asList(desordenado);
            SelectionSort selectionSort = new SelectionSort();
            selectionSort.ordenar(listaDesordenada);

            assertEquals(Arrays.asList(resultadosEsperados[i]), listaDesordenada);
        }
    }

    @Test
    public void testarShellSort() {
        Integer[][] casosTeste = {
                {12, 10, 15, 3, 18, 2}, {6, 1, 8, 9, 2, 5, 9, 3, 0, 11, 21, 19, 12},
                {5, 4, 3, 2, 1}, {1, 2, 3, 4, 5}, {9, 8, 7, 6, 5, 4, 3, 2, 1}, {1},
                {2, 1}, {}, {1, 1, 1, 1, 1}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
        };

        Integer[][] resultadosEsperados = {
                {2, 3, 10, 12, 15, 18}, {0, 1, 2, 3, 5, 6, 8, 9, 9, 11, 12, 19, 21},
                {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5, 6, 7, 8, 9}, {1},
                {1, 2}, {}, {1, 1, 1, 1, 1}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
        };

        for (int i = 0; i < casosTeste.length; i++) {
            Integer[] desordenado = Arrays.copyOf(casosTeste[i], casosTeste[i].length);

            List<Integer> listaDesordenada = Arrays.asList(desordenado);
            ShellSort shellSort = new ShellSort();
            shellSort.ordenar(listaDesordenada);

            assertEquals(Arrays.asList(resultadosEsperados[i]), listaDesordenada);
        }
    }

    @Test
    public void testarCountingSort() {
        Integer[][] casosTeste = {
                {12, 10, 15, 3, 18, 2}, {6, 1, 8, 9, 2, 5, 9, 3, 0, 11, 21, 19, 12},
                {5, 4, 3, 2, 1}, {1, 2, 3, 4, 5}, {9, 8, 7, 6, 5, 4, 3, 2, 1}, {1},
                {2, 1}, {}, {1, 1, 1, 1, 1}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
        };

        Integer[][] resultadosEsperados = {
                {2, 3, 10, 12, 15, 18}, {0, 1, 2, 3, 5, 6, 8, 9, 9, 11, 12, 19, 21},
                {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5, 6, 7, 8, 9}, {1},
                {1, 2}, {}, {1, 1, 1, 1, 1}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
        };

        for (int i = 0; i < casosTeste.length; i++) {
            Integer[] desordenado = Arrays.copyOf(casosTeste[i], casosTeste[i].length);

            List<Integer> listaDesordenada = Arrays.asList(desordenado);
            CountingSort countingSort = new CountingSort();
            countingSort.ordenar(listaDesordenada);

            assertEquals(Arrays.asList(resultadosEsperados[i]), listaDesordenada);
        }
    }

    @Test
    public void testarRadixSort() {
        Integer[][] casosTeste = {
                {12, 10, 15, 3, 18, 2}, {6, 1, 8, 9, 2, 5, 9, 3, 0, 11, 21, 19, 12},
                {5, 4, 3, 2, 1}, {1, 2, 3, 4, 5}, {9, 8, 7, 6, 5, 4, 3, 2, 1}, {1},
                {2, 1}, {}, {1, 1, 1, 1, 1}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
        };

        Integer[][] resultadosEsperados = {
                {2, 3, 10, 12, 15, 18}, {0, 1, 2, 3, 5, 6, 8, 9, 9, 11, 12, 19, 21},
                {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5}, {1, 2, 3, 4, 5, 6, 7, 8, 9}, {1},
                {1, 2}, {}, {1, 1, 1, 1, 1}, {1, 2, 3, 4, 5, 6, 7, 8, 9, 10}
        };

        for (int i = 0; i < casosTeste.length; i++) {
            Integer[] desordenado = Arrays.copyOf(casosTeste[i], casosTeste[i].length);

            List<Integer> listaDesordenada = Arrays.asList(desordenado);
            RadixSort radixSort = new RadixSort();
            radixSort.ordenar(listaDesordenada);

            assertEquals(Arrays.asList(resultadosEsperados[i]), listaDesordenada);
        }
    }

}
