public class counting {
    
    static int[] counting_sort(int arr[]){
        int count[] = sort(achamaior(arr), arr);
        return build(arr, count);

    }

    static int achamaior(int arr[]){
        int maior = arr[0];

        for(int i = 1; i < arr.length; i++){
            if(arr[i] > maior) maior = arr[i];
        }

        return maior;
    }

    static int count(int arr[], int x){
        int qnt = 0;
        for(int i = 0; i < arr.length; i++){
            if(arr[i] == x){
                qnt++;
            }
        }
        return qnt;
    }
    static int[] sort(int maior, int arr[]){
        int count[] = new int[maior+1];

        for(int i = 0; i <= maior; i++){
            count[i] = count(arr, i);
        }
            return count;
    }

    static int[] build(int arr[], int count[]){
        int out[] = new int[arr.length];
        int i = 0;
        int j = 0;
        while(i < count.length){
            int k = count[i];
            while(k > 0){
                out[j] = i;
                j++;
                k--;
            }
            i++;
        }
        return out;
    }

    public static void main(String[] args) {
        int arr[] = {4,1,7,9,1,4,2,2,5,5};
        arr = counting_sort(arr);
        for(int x : arr){
            System.out.println(x);
        }
    }
}
