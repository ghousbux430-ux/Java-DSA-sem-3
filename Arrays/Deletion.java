public class Deletion{

    public static int[] delete(int[] arr, int index){
        if(index<0 || index>=arr.length){
            System.out.println("INVALID INDEX");
            return arr;
        }

        int[] newArray = new int[arr.length-1];

        for(int i=0; i<index; i++){
            newArray[i] = arr[i];
        }

        for(int i=index; i<arr.length; i++){
            newArray[i-1] = arr[i];
        }

        return newArray;
    }
    public static void main(String[] args) {
        int[] arr = {10,20,25,30,40,50};
        int index = 3;

        System.out.println("Before deletion");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }

        System.out.println();
        arr = delete(arr,index);
        
        System.out.println("After deletion");
        for(int i=0; i<arr.length; i++){
            System.out.print(arr[i] + " ");
        }
        
    }
}