
public class insertion{

    public static void sort(int arr[], int tam){
        for(int i = 1; i < tam; i++){
            int temp = arr[i];
            int j = i - 1;

            while(j >= 0 && arr[j] > temp){
                arr[j+1] = arr[j];
                j--; 
            }
              arr[j+1] = temp;
        }
        
    }



    public static void main(String args[]){
        int arr[] = {4, 2, 1, 3};
        sort(arr,4);
        for(int x : arr){
            System.out.print(x + ", ");
        }
    }
}