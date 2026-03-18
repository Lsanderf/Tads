public class heap {
 //Dica, desenhe uma arvore e aplique o metodo heap de ordenação para entender 100%!
    public static void main(String[] args) {
        int[] vetor = {10, 7, 8, 9, 1, 5};

        heapSort(vetor);

        System.out.println("Vetor ordenado:");
        mostrar(vetor);
    }

    // Função principal do Heap Sort
    public static void heapSort(int[] arr) {
        int n = arr.length;

        // 1. Construir o heap (reorganizar o vetor)
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        // 2. Extrair elementos do heap um por um
        for (int i = n - 1; i > 0; i--) {
            trocar(arr, 0, i); // joga o maior pro final
            heapify(arr, i, 0); // reorganiza o heap reduzido
        }
    }

    // Função que garante a propriedade do heap
    public static void heapify(int[] arr, int n, int i) {
        int maior = i;        // raiz
        int esquerda = 2 * i + 1;
        int direita = 2 * i + 2;

        // verifica se filho esquerdo é maior
        if (esquerda < n && arr[esquerda] > arr[maior]) {
            maior = esquerda;
        }

        // verifica se filho direito é maior
        if (direita < n && arr[direita] > arr[maior]) {
            maior = direita;
        }

        // se maior não for a raiz, troca e continua
        if (maior != i) {
            trocar(arr, i, maior);
            heapify(arr, n, maior);
        }
    }

    // Função para trocar elementos
    public static void trocar(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    // Função para mostrar o vetor
    public static void mostrar(int[] arr) {
        int i = 0;
        while (i < arr.length) {
            System.out.print(arr[i] + " ");
            i++;
        }
    }
}