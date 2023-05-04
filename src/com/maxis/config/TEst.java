package com.maxis.config;

import java.util.Scanner;

public class TEst {
	
	public static void main(String args[]){
		
		Scanner input= new Scanner(System.in);
		//int n=input.nextInt();
		int n=10;
		int k=1;
		int z=1;
		for(int i=1; i<n; i++){
			if(i%2==0){
				System.out.println("inside if");

				for(int j=i;j>=1;j--,k++){
					z=k+j;
					System.out.print(z);
					
			}
				
					
					
			}
			else{
				System.out.println("inside else");
				
				for(int j=1;j<=i;j++,k++){
					System.out.print(k);
				}
		}
			
			System.out.println();
		}
	}

}
