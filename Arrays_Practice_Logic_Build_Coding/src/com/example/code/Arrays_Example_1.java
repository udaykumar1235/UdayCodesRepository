package com.example.code;

public class Arrays_Example_1 {

	//Q: “Find sum of positive numbers”
	
	//coding template steps for arrays
	
	//Step2 : 
	
	public static int solve(int arr[]) {
		
		//step 3: edge cases
		
		if(arr == null || arr.length == 0) {
			
			return 0;
		}
		
		
		//Main Logic
		
		int sum = 0; //step 4
		
		for(int i=0; i<arr.length; i++) { //step 5
			
			//condition //step 6
			
			if(arr[i] > 0) {
				
				sum = sum + arr[i];
			}
			
		}
		
		//Return //step 7
		return sum;
		
	}
	
	public static void main(String[] args) {
		
		//step 8
		
		int[] arr = {1,2,3 ,4,6};
		
		int result = solve(arr);
		
		System.out.println(result);
		
	}
	
	
}
