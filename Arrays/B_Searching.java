public class B_Searching {

    public static int BinSearch(int[] arr, int target){
        int p=0;
        int q=arr.length-1;

        while(p<=q){

            int i = (p+q)/2;

            if(arr[i]==target){
                return i;
            }

            if(arr[i]<target){
                p = i+1;
            }else{
                q=i-1;
            }
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] array = {6,7,12,17,23,24,33,45,55,78,90,122};
        int target = 55;

        int index = BinSearch(array,target);

        if(index != -1){
            System.out.println("Element found at the index "+index);
        }else{
            System.out.println("Element not found");
        }
    }
}
