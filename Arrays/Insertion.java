public class Insertion{

    public static int[] insertion(int array[], int val, int index){

        if(index < 0 || index > array.length){
            System.out.println("INVALID INDEX");
            return array;
        }

        int newArray[] = new int[array.length + 1];

        for(int i=0; i<index; i++){
            newArray[i] = array[i];
        }

        newArray[index] = val;

        for(int i=index; i<array.length; i++){
            newArray[i+1] = array[i];
        }

        return newArray;
    }
    public static void main(String[] args){
        int array[] = {1,2,3,4,6};

        array = insertion(array, 5, 4);
        for(int i=0; i<array.length; i++){
            System.out.println(array[i]);
        }
    }
}