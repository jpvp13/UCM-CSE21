
public class FindDuplicateCount {

	public static void main(String[] args) {
		int[] arr = {1, 2, 2, 3, 4, 2, 4, 3, 0, 5, 3, 2};
		int i = 0;
		while (i < arr.length){
			int count = 0;
			int j = arr.length - 1;
			while(j > i){
				if (arr[i] == arr[j]){
					count++;
				}
				j--;
			}
				
			if (count == 1){
				System.out.println("There is only " + count + " more occurence of value " + arr[i] + " starting at index " + i);
			}
			
			 if (count > 1){
				System.out.println("There are " + count + " more occurrences of value " + arr[i] + " starting at index " + i);
				
			}
			
			if (count == 0){
				System.out.println("No duplicates with value " + arr[i] + " beyond index " + i);
				
			}
			i++;
		}


	}

};
