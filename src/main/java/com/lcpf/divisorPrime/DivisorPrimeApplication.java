package com.lcpf.divisorPrime;
/** please find the least prime factor for given two numbers  */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Scanner;

@SpringBootApplication
public class DivisorPrimeApplication {

	public static void main(String[] args) {
		SpringApplication.run(DivisorPrimeApplication.class, args);
		Scanner myObj = new Scanner(System.in);
		// prompt user
		System.out.println("Please input two integers to find the least prime factor");
		int x = myObj.nextInt();
		int y = myObj.nextInt();
		myObj.close();
		Calculate calc = new Calculate();
		
		System.out.println("LCPF is " + calc.divisorPrime(x,y));
	}

}

class Calculate{
	
	public int divisorPrime(int x, int y)
	{
		int small = 0, large = 0, lcpf = 0;
		if (x<y)
		{
			small = x;
			large = y;
		}
		else
		{
			small = y;
			large = x;
		}
		// taking the small number check the prime factor for it
		for (int i=2; i<=small; i++) // when checking GCPF use for\(int i=small;i>=2;i--\)
		{
			int count = 0, prime = 0;
			// check if the number is prime 
			for(int j=1;j<=i;j++)
			{
				if (i%j==0)
				{
					count++;
					prime = i;
				}
			}
			if (count == 2)
			{
				// check if the prime number is prime factor for the other number too
				if (large % prime == 0)
				{
					lcpf = prime;
				}
			}
		}
		return lcpf;
	}
}
