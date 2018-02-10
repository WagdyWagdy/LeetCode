import java.util.LinkedList;
import java.util.Queue;

public class CirclePetrol {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] input = {4 ,6 ,6 ,5 ,7 ,3 ,4,5};
		int[] input = {98, 18, 82, 72, 10, 76, 68, 28, 98, 57, 87, 54, 7, 66, 20, 84, 29, 25, 33, 72, 4, 30, 71, 20, 9, 69, 41, 16, 97, 50, 19, 24, 47, 46, 22, 52, 80, 56, 65, 89, 42, 29, 94, 51, 35, 1, 25, 65, 88, 15, 44, 57, 28, 92, 60, 66, 33, 37, 38, 52, 76, 29, 75, 8};
		int[] petrol = new int[input.length/2];
		int[] distance = new int[input.length/2];
		int j = 0;
		for (int i = 0; i < input.length-2; i+=2) {			
			petrol[j] = input[i];
			distance[j] = input[i+1];
			j++;
		}
		System.out.println(tour2(petrol, distance));
	}
	public static int tour(int petrol[], int distance[])
    {
	// Your code here
	    loop1: for(int i = 0;i < petrol.length; i++){
	    	int carPetrol = 0;
            if(petrol[i] < distance[i]){
                continue;
            }
            int j = i;
            do{
                carPetrol += petrol[j];
                carPetrol -= distance[j];
                if(carPetrol < 0){
                    continue loop1;
                }
                j = ++j % petrol.length;
            }while(j != i);
            return i;
	    }
	    return -1;
    }
	
	public static int tour2(int petrol[], int distance[]){
		int start = 0;
		int end = 1;
		int carPetrol = petrol[start] - distance[start];
		while(start!= end || carPetrol < 0){
			while(start != end && carPetrol < 0){
				carPetrol-= petrol[start] - distance[start];
				start = ++start % petrol.length;
				if(start == 0)
					return -1;
			}
			carPetrol+= petrol[end] - distance[end];
			end = ++end%petrol.length;
		}
		return start;
		
	}
}
