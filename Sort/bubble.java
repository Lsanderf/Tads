public class bubble{
    
    static void bubblesort(int arr[]){
        for(int i = 0; i < arr.length;i++){
            for(int j = 0; j < arr.length - 1 - i; j++){
                if(arr[j+1] < arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = {9, 8, 7 ,4 ,2 ,1};
        bubblesort(arr);

        for(int x : arr){
            System.out.print(x + " ");
        }
        System.out.println();
    }
}
