import java.util.Arrays;

public class LC_475 {
	public int findRadius(int[] houses, int[] heaters) {
		int max = Integer.MIN_VALUE;
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int beforeHeater = 0;
        int afterHeater = 0;
        for (int i = 0; i < houses.length; i++) {
			
		}
		return max;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// initializing unsorted int array
		   int intArr[] = {30,20,5,12,55};

		   // sorting array
		   Arrays.sort(intArr);

		   // let us print all the elements available in list
		   System.out.println("The sorted int array is:");
		   for (int number : intArr) {
		   System.out.println("Number = " + number);
		   }

		   // entering the value to be searched
		   int searchVal = 32;

		   int retVal = Arrays.binarySearch(intArr,searchVal);
			
		   System.out.println("The index of element 32 is : " + retVal);
	}

}
