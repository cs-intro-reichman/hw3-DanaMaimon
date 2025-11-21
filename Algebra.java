// Implements algebraic operations and the square root function without using 
// the Java operations a + b, a - b, a * b, a / b, a % b, and without calling 
// Math.sqrt. All the functions in this class operate on int values and
// return int values.

public class Algebra {
	public static void main(String args[]) {
	    // Tests some of the operations

		 System.out.println(plus(2,3));   // 2 + 3
	    System.out.println(minus(7,2));  // 7 - 2
   		System.out.println(minus(2,7));  // 2 - 7
 		System.out.println(times(3,4));  // 3 * 4
   		System.out.println(plus(2,times(4,2)));  // 2 + 4 * 2
   		System.out.println(pow(5,3));  // 5^3
   		System.out.println(pow(3,5));   // 3^5
   		System.out.println(div(12,3));   // 12 / 3    
   		System.out.println(div(5,5));    // 5 / 5  
   		System.out.println(div(25,7));   // 25 / 7
   		System.out.println(mod(25,7));   // 25 % 7
   		System.out.println(mod(120,6));  // 120 % 6    
   		System.out.println(sqrt(36));
		System.out.println(sqrt(263169));
   		System.out.println(sqrt(76123));
	}  

	// Returns x1 + x2
	public static int plus(int x1, int x2) 
	{
		if (x2 == 0) 
		{
			return x1;
		}
		else if (x2 < 0)
		{
			for (int i=x2; i<0; i++)
			{
				x1--;
			} 
		}
		else
		{
			for (int i=0; i<x2; i++)
			{
					x1++;
			}
		}
		return x1;
	}

	// Returns x1 - x2
	public static int minus(int x1, int x2) 
	{
		if (x2 == 0) 
		{
			return x1;
		}
		else if (x2 < 0)
		{
			for (int i=x2; i<0; i++)
			{
				x1++;
			} 
		}
		else
		{
			for (int i=0; i<x2; i++)
			{
					x1--;
			}
		}
		return x1;
	}

	// Returns x1 * x2
	public static int times(int x1, int x2) 
	{
		int sum = 0;
		if (x1 == 0 || x2 == 0)
		{
			return 0;
		}
		else if (x2 > 0)
		for (int i=0; i<x2; i++)
		{
			sum = plus(sum, x1);
		}
		else
		{
			for (int i=x2; i<0; i++)
			{					
				sum = minus(sum, x1);
			} 
		}
		return sum;
	}

	// Returns x^n (for n >= 0)
	public static int pow(int x, int n) 
	{
		int mult = 1;
		if (n == 0)
		{
			return 1;
		}
		for (int i=0; i<n; i++)
		{
			mult = times(mult, x);
		}
		return mult;
	}

	// Returns the integer part of x1 / x2 
	public static int div(int x1, int x2) 
	{
		if (x1 == 0 || x2 == 0) 
		{
			return 0;	
		}
		boolean positivX1 = true;
		boolean positivX2 = true;
		if (x1 < 0) 
		{
			x1 = minus(0, x1);
			positivX1 = false;
		}
		if (x2 < 0)
		{
			x2 = minus(0, x2);
			positivX2 = false;
		}
		int div = x1;
		int count = 0;
		while (div >= x2 && div > 0) 
		{
			div = minus(div, x2);
			count++;	
		}
		if ((positivX1 == true && positivX2 == true) || (positivX1 == false && positivX2 == false)) 
		{
			return count;	
		}
		else 
		{
			count = minus(0, count);
			return count;
		}
	}

	// Returns x1 % x2
	public static int mod(int x1, int x2) 
	{
		if (x1 == 0 || x2 == 0) 
		{
			return 0;	
		}
		boolean positivX1 = true;
		if (x1 < 0) 
		{
			x1 = minus(0, x1);
			positivX1 = false;
		}
		if (x2 < 0)
		{
			x2 = minus(0, x2);
		}
		if (x1 == x2) 
		{
			return 0;	
		}
		int div = div(x1, x2);
		if (div == 0) 
		{
			if (positivX1 == true) 
			{
				return x1;	
			}
			else 
			{
				x1 = minus(0, x1);
				return x1;
			}
		}
		for (int i=0; i < div; i++)
		{
			x1 = minus(x1, x2);
		}
		if (positivX1 == false) 
		{
			x1 = minus(0, x1);
			return x1;	
		}
		else 
		{
			return x1;
		}	
	}	

	// Returns the integer part of sqrt(x) 
	public static int sqrt(int x) 
	{
		if (x < 0) 
		{
			return 0;	
		}
		if (x == 1 || x == 0) 
		{
			return x;	
		}
		int l = 1;
		int h = x;
		int result = 1;
		int middle;
		int mSquared;
		while (l <= h) 
		{
			middle = div(plus(l, h), 2);
			mSquared = times(middle, middle);
			if (mSquared == x) 
			{
				return middle;
			}
			if (mSquared < x) 
			{
				result = middle;
				l = plus(middle, 1);
			}
			else
			{
				h = minus(middle, 1);
			}
		}
		return result;
	}	  	  
}