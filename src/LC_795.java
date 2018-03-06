
public class LC_795 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int A[] = {2,1,4,3};
		System.out.println(numSubarrayBoundedMax(A, 2, 3));
	}
	public static int numSubarrayBoundedMax(int[] A, int L, int R) {
        int counter = 0;
        int result = 0;
        for(int i = 0; i < A.length; i++){
            if(A[i] > R || A[i] < L){
                result += counter * (counter + 1) / 2;
                counter = 0;
            }else
                counter ++;
        }
        return result;
    }
}
