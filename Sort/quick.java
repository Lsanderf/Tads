public class quick {

    static void quicks(int arr[]){
        quicksort(arr, 0, arr.length - 1);
    }

    static void quicksort(int arr[], int esq, int dir){
        int i = esq; int j = dir; int pivo = arr[(esq + dir)/2];

        while(i <= j){

            while(arr[i] < pivo) i++;
            while(arr[j] > pivo) j--;

            if(i <= j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;j--;
            }

            if(dir > i) quicksort(arr, esq, i);
            if(esq < j) quicksort(arr, j, dir);
        }

    }

    public static void main(String[] args) {
        int arr[] = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        quicks(arr);
        for(int x : arr) System.out.print(x + " ");
    }
}
