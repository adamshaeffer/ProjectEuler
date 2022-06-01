import java.util.Arrays;
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.IOException;

class euler {
	public static void main(String[] args) throws IOException {
        System.out.println();
		// System.out.println(euler30(5)); // Solved 27/01/22
		// System.out.println(euler29(100)); // Solved 27/01/22
		// System.out.println(euler28(1001)); // Solved 13/11/21
		// // System.out.println(euler27(80)); // Unsolved -----
		// // System.out.println(euler26(1000)); // Unsolved -----
		// System.out.println(euler25(3)); // Solved 13/11/21
		// System.out.println(euler24(1000000)); // Solved 13/11/21
		// // System.out.println(euler23(28123)); // Solved 13/11/21 Takes a REALLY long time -----
		// System.out.println(euler22("lib/names22.txt")); // Solved 17/5/22
		// System.out.println(euler21(10000)); // Solved 11/11/21
		// System.out.println(euler20(100)); // Solved 12/11/21
		// System.out.println(euler19()); // Solved 15/01/19
		// // System.out.println(euler18()); // Unsolved -----
		// System.out.println(euler17()); // Solved 16/01/19
		// System.out.println(euler16(1000)); // Solved 15/11/21
		// // System.out.println(euler15()); // Unsolved Method doesn't exist -----
		// // System.out.println(euler14()); // Solved 23/08/18 Method doesn't exist -----
		// // System.out.println(euler13()); // Solved 18/08/18 Method doesn't exist -----
		// // System.out.println(euler12()); // Solved 08/12/17 Method doesn't exist -----
		// // System.out.println(euler11()); // Solved 07/12/17 Method doesn't exist -----
		// System.out.println(euler10(2000000L)); // Solved 30/11/17 Takes a REALLY long time
		// System.out.println(euler9(1000)); // Solved 29/11/17
		// System.out.println(euler8(13)); // Solved 29/11/17
		// System.out.println(euler7(10001)); // Solved 26/11/17
		// System.out.println(euler6(100)); // Solved 26/11/17
		// System.out.println(euler5(20)); // Solved 26/11/17
		// System.out.println(euler4(1000)); // Solved 26/11/17
		// System.out.println(euler3(600851475143L)); // Solved 26/11/17
		// System.out.println(euler2(4000000)); // Solved 26/11/17
		// System.out.println(euler1(1000)); // Solved 26/11/17 
	}

	public static int euler30(int power) { // Returns the sum of all the numbers that can be written as the sum of the fifth power of their digits.
		int total = 0;
		int sum = 0;
		int count = 0;
		int num;
		int len;
		int pow;
		String numStr = "";
		char spot = ' ';
		int[] digits = new int[6];
		int[] numbers = new int[20];

		for(int i=2; i<1000000; i++) {
			sum = 0;
			num = i;
			numStr = String.valueOf(num);
			len = numStr.length();
			for(int j=0; j<len; j++) {
				spot = numStr.charAt(j);
				digits[j] = Character.getNumericValue(spot);
				pow = digits[j];
				for(int k=1; k<power; k++) {
					pow *= digits[j];
				}
				sum += pow;
			}
			if(sum == num) {
				total += num;
				numbers[count] = num;
				count++;
				// System.out.println("HEY");
			}
		}
		
		for(int i=0; i<20; i++) {
			// System.out.print(numbers[i] + ", ");
		}
		// System.out.println("");
		return total;
	}
	
	public static int euler29(int power) { //Returns the total number of unique integers formed by all combinations of 'number' to the 'number' when 'number' is less 
		//than variable 'power'
		int count = 0;
		int a;
		int b;
		int possible = (power-1)*(power-1);
		int places = 30;
		int[][] all = new int[possible][places];

		for(a=2; a<=power; a++) { //Calculates and assigns all the possible numbers formed (not removing duplicates)
		for(b=2; b<=power; b++) {
			all[count][places-1] = a;
			for(int i=1; i<b; i++) {
			for(int j=places-1; j>=0; j--) {
				all[count][j] *= a;
			}
			for(int j=places-1; j>0; j--) {
				if(all[count][j] > 10000000) {
					all[count][j-1] += all[count][j]/10000000;
					all[count][j] %= 10000000;
				}
			}
			}
			count++;
		}
		}

		for(int i=0; i<possible-2; i++) { //Comparing and removing all duplicate numbers
		for(int j=i+1; j<possible-1; j++) {
			if(Arrays.equals(all[i], all[j])) {
				count--;
				// System.out.println(i + " " + j);
				for(int k=0; k<places; k++) {
					all[i][k] = 1;
				}
				j = possible;
			}
		}
		}

/*		for(int i=0; i<possible; i++) { //Printing out the whole array.
			for(int j=0; j<places; j++) {
				System.out.print(all[i][j] + ", ");
			}
			System.out.println("");
		}
*/		return count;
		/*int total = 0; //Attempt #1
		int place = 30;
		int possible = (power-1)*(power-1); // the total number of possible integers formed, including repeats
		int[] blah = new int[place];
		int[] blah2 = new int[place];
		int[][] repeats = new int[possible][place]; //int array to keep every single integer formed. Will compare later to remove any repeats 
		boolean rep = false;
		for(int a=2; a<=power; a++) {
			for(int b=2; b<=power; b++) {
				repeats[total][place-1] = a;
				for(int i=1; i<b; i++) {
					for(int j=place-1; j>=0; j--) {
						repeats[total][j] *= a;
					}
					for(int j=place-1; j>=0; j--) {
						if(repeats[total][j]>=10000000 && j>0) {
						repeats[total][j-1] += repeats[total][j]/10000000;
						repeats[total][j] = repeats[total][j]%10000000;
						}
					}
				}
				total++;	
				//System.out.println(a + " " + b);
			}
		}
		for(int i=0; i<possible; i++) {
			for(int j=i+1; j<possible; j++) {
				if(repeats[i][0] != 123) {
				if(Arrays.equals(repeats[i], repeats[j])) {// && !Arrays.equals(repeats[j], blah2)) {
					total--;
					rep = true;

				}
				} else 
					j = possible-1;
			}
			if(rep == true) {
			for(int k=0; k<place; k++) {
				repeats[i][k] = 0;
				System.out.print(repeats[i][k] + " ");
				rep = false;
			}
			repeats[i][0] = 123;
			System.out.println();
			}
		}
		return total;*/
	}

	public static int euler28(int size) { //Starting at the center and spiraling outwards clockwise, draws a square of increasing numbers of size 'size' and returns the sum of the diagonals
		int sum1 = 0;
		int x = ((size-1)/2);
		int y = x;
		int direction = 0; //Determines the direction the spiral is currently moving in. 0 = right, 1 = down, 2 = left, 3 = up
		int turn = 0;
		int count = 1;
		int[][] square = new int[size][size];
		square[y][x] = count;
		x++;
		count++; 
		while(x<size && y<size) {
			square[y][x] = count;
			count++;
			if(direction == 0) {
				turn = square[y+1][x];
				if(turn == 0) {
					direction++;
					y++;
				} else
					x++;
			}else if(direction == 1) {
				turn = square[y][x-1];
				if(turn == 0) {
					direction++;
					x--;
				} else
					y++;
			}else if(direction == 2) {
				turn = square[y-1][x];
				if(turn == 0) {
					direction++;
					y--;
				} else
					x--;
			}else if(direction == 3) {
				turn = square[y][x+1];
				if(turn == 0) {
					direction = 0;
					x++;
				} else
					y--;
			}
		}
/*		for(int i=0; i<size; i++) {
			for(int j=0; j<size; j++) {
				System.out.print(square[i][j] + " ");
			}
			System.out.println("");
		}
*/		int x1 = 0;
		int x2 = size-1;
		int y1 = 0;
		for(int i=0; i<size; i++) {
			sum1 += square[x1][y1];
			sum1 += square[x2][y1];
			x1++;
			y1++;
			x2--;
		}
		sum1--;
//		System.out.println(square[0][size-1]);
		return sum1;
	}

	public static int euler27(int max) { //I don't understand this problem at all, so I'm not even gonna try. :D
		return 1;
	}

	public static int euler26(double d) { //Returns the value of the denominator < variable 'd' for which 1/denominator contains the longest recurring cycle in its decimal.
		//Current issue: it just doesn't work like it should and its soooo tedious. For some reason the doubles stop at a decimal smallest than the max, and it doesn't consider when the actual recurring number starts.
		double cycle = 1;
		String cyc = "";
		String cycl = "";
		// String cyclee = "";
		int len = cyc.length();
		int point;
		int i = 2;
		int max = 0;
		int value = 0;
		for(i=2; i<=d; i++) {
			cycle = 1;
			cycle/=i;
			cyc = Double.toString(cycle);
			len = cyc.length();
			point = cyc.indexOf('.');
			cyc = cyc.substring(point+1, len);
			len = cyc.length();
			for(int j=3; j<=len; j++) {
				cycl = cyc.substring(0,j);
				if(j<len/2) {
				// if(cyc.substring(j,j+j).equals(cycl) || cyc.substring(j+1,j+j).equals(cycl.substring(1,cycl.length())) || cyc.substring(j+2,j+j).equals(cycl.substring(2,cycl.length())))
					// cyclee = cycl;
				}
			}
			// System.out.println(i + " " + cycl);
			if(cycl.length() > max) {
				max = cycl.length();
				value = i;
			}
		}
		return value;
	}

	public static int euler25(int digit) { //Evaluates the first fibonacci number with 'digit' number of digits
		int term = 2;
		int a[] = new int[112];
		int b[] = new int[112];
		int c[] = new int[112];
		int digpos = 111;
		int dig = 1;
		a[111] = 1;
		b[111] = 1;
		c[111] = 1;
		while(digit>9) {
			digit-=9;
			digpos--;
		}
		if(digit<=9) {
			for(int i=1; i<digit; i++) {
				dig*=10;
			}
		}
		while(a[digpos]<dig) {
			for(int i=111; i>=0; i--) {
				a[i] = b[i]+c[i];
			}
			for(int i=111; i>=0; i--) {
				if(a[i]>=1000000000 && i>0) {
					a[i-1] += a[i]/1000000000;
					a[i] = a[i]%1000000000;
				}
				c[i] = b[i];
				b[i] = a[i];
			}
			term++;
		}
		return term;
	}
	
	public static String euler24(int goal) {
		String perm = "";
		int[] choice =  new int[]{0,1,2,3,4,5,6,7,8,9};
		int len = choice.length;
		int x = 0;
		for(int a=0; a<len; a++) {
			for(int b=0; b<len; b++) {
				for(int c=0; c<len; c++) {
					for(int d=0; d<len; d++) {
					for(int e=0; e<len; e++) {
					for(int f=0; f<len; f++) {
					for(int g=0; g<len; g++) {
					for(int h=0; h<len; h++) {
					for(int i=0; i<len; i++) {
					for(int j=0; j<len; j++) {
					if(a!=b&&a!=c&&a!=d&&a!=e&&a!=f&&a!=g&&a!=h&&a!=i&&a!=j && b!=c&&b!=d&&b!=e&&b!=f&&b!=g&&b!=h&&b!=i&&b!=j) {
					if(c!=d&&c!=e&&c!=f&&c!=g&&c!=h&&c!=i&&c!=j && d!=e&&d!=f&&d!=g&&d!=h&&d!=i&&d!=j && e!=f&&e!=g&&e!=h&&e!=i&&e!=j) {
					if(f!=g&&f!=h&&f!=i&&f!=j && g!=h&&g!=i&&g!=j && h!=i&&h!=j && i!=j) {
						perm = "" + a + b + c + d + e + f + g + h + i + j;
						//System.out.println(perm);
						x++;
					}
					}
					}
					if(x == goal) {
						a = len;
						b = len;
						c = len;
					}
					}
					}
					}
					}
					}
					}
					}
				}
			}
		}
		return perm;
	}

	public static int euler23(int limit) {
		boolean xabun = false;
		boolean yabun = false;
		boolean no = true;
		int sum = 0;
		int x = 0;
		int y = 0;
		int xdiv = 0;
		int xsum = 0;
		int ydiv = 0;
		int ysum = 0;
		for(int i=1; i<=limit; i++) {
			no = true;
			for(x=1; x<i-11; x++) {
				xabun = false;
				yabun = false;
				y = i-x;
				xsum = 0;
				ysum = 0;
				for(xdiv=1; xdiv<=x/2; xdiv++) {
					if(x%xdiv == 0) {
						xsum+=xdiv;
					}
				}
				for(ydiv=1; ydiv<=y/2; ydiv++) {
					if(y%ydiv == 0) {
						ysum+=ydiv;
					}
				}
				
				if(xsum > x) {
					xabun = true;
				}
				if(ysum > y) {
					yabun = true;
				}
				if(yabun == true && xabun == true) { 
					no = false;
					x = i-11;
				//	System.out.println(x + " + " + y + " = " + i);
				}
			}
			if(no) {
				sum+=i;
			}
			// if(i%100==0)
				// System.out.println(i + ": " + sum);
		}
		return sum;
	}

	public static int euler22(String filename) throws IOException { //Evaluates the sum of all scores of names in a .txt file calculated by 
		//the place in name's place in the file and the value of the letters in the name.
        // Solved!
		FileInputStream file = new FileInputStream(filename);
		Scanner scnr = new Scanner(file);
		String all = scnr.next();
		scnr.close();
		String name = "COLIN";
        String temps;
        String[] unsorted = new String[5163];
        String[] sorted = new String[5163];
		char temp = '"';
        char last;
        int end = 0;
        int count = 0;
		int worth = 0;
        int total = 0;
		for(int i=0; i<all.length(); i++) { // Separate each name into the unsorted array
            last = temp;
			temp = all.charAt(i);
            if(last == '"' && temp != ',' && temp != '"') {
                for(int j=i+1; j<i+20 && j<all.length(); j++) {
                    if(all.charAt(j) == '"') {
                        end = j;
                        break;
                    }
                }
                unsorted[count] = all.substring(i,end);
                count++;
            }
        }
        for(int i=0; i<unsorted.length; i++) {
            temps = unsorted[i];
            count = 0;
            for(int j=0; j<unsorted.length; j++) {
                if(temps.compareTo(unsorted[j]) > 0) {
                    count++;
                }
            }
            sorted[count] = temps;
        }
        for(int i = 0; i < sorted.length; i++) { // Print every name in an array
            name = sorted[i];
            worth = 0;
            // System.out.print(name + " - ");
            for(int j=0; j<name.length(); j++) { // Find the value of each name
                temp = name.charAt(j);
                worth += temp-64;
            }
            total += worth*(i+1);
        }
        return total;
	}

	public static int euler21(int under) { //Evaluates the sum of all amicable numbers (the sum of the divisors of the sum of divisors of a number are the same) under variable 'under'
		int sumFin = 0;
		int num1 = 0;
		int num2 = 0;
		int sum1 = 0;
		int sum2 = 0;
		for(int j=1; j<=under; j++) {
			num1 = j;
			num2 = 0;
			sum1 = 0;
			sum2 = 0;
			for(int i=1; i<=num1/2; i++) {
				if(num1%i == 0) {
					sum1+=i;
				}
			}
			num2 = sum1;
			for(int i=1; i<=num2/2; i++) {
				if(num2%i == 0) {
					sum2+=i;
				}
			}
			if(sum2 == num1 && num1 != num2) {
				sumFin+=num1;
				// System.out.println(num1 + " -> " + sum1 + " -> " + num2 + " -> " + sum2);
			}
		}
		return sumFin;
	}

	public static int euler20(int factorial) { //Returns the sum of all digits in the number formed by taking the factorial of variable 'factorial'
		//Current issue: the factorial of 100 is way too huge for ints.
		//Solved the issue by breaking the number into several int values in an intArray, keeping each under 7 digits long and adding on to the next. This system accurately allows for very large numbers to be used!
		int sum = 0;
		int[] product = new int[]{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,1};
		int dig = 0;
		char temp = '0';
		String[] proStr = new String[]{"","","","","","","","","","","","","","","","","","","","","","","",};
		String part = "";
		
		for(int i=2; i<=factorial; i++) {
			for(int j=22; j>=0; j--) {
				product[j]*=i;
		//		if(i==2)
		//			product[j]*=2;
		//		if(product[j]%10 == 0) 
		//			product[j]/=10;
			}
			for(int j=22; j>=0; j--) {
				if(product[j]>=10000000 && j>0) {
					product[j-1]+=product[j]/10000000;
					product[j] = product[j]%10000000;
				}
			}
		}
		// System.out.println("");
		for(int i=0; i<=22; i++) {
		//	product[i]*=2;
			proStr[i] = Integer.toString(product[i]);
			part = proStr[i];
			// System.out.print(part + ", ");
			for(int j=0; j<part.length(); j++) {
				temp = part.charAt(j);
				dig = Character.getNumericValue(temp);
				sum+=dig;
			}
		}
		// System.out.println("");
		return sum;
	}

	public static int euler16(int power) { //Returns the sum of the digits of the number formed by 2 to the power of variable 'power'
		int sum = 0;
		int[] num = new int[34];
		num[33] = 2;
		int[] lens = new int[34];
		String[] str = new String[34];
		char temp = ' ';
		for(int i=1; i<power; i++) {
			for(int j=33; j>=0; j--) {
				num[j] *= 2;
			}
			for(int j=33; j>=0; j--) {
				if(num[j]>=1000000000 && j>0) {
					num[j-1] += num[j]/1000000000;
					num[j] = num[j]%1000000000;
				}
			}
		}
		for(int i=0; i<34; i++) {
			// System.out.print(num[i] + " ");
			str[i] = Integer.toString(num[i]);
			lens[i] = str[i].length();
			for(int j=0; j<lens[i]; j++) {
				temp = str[i].charAt(j);
				sum += Character.getNumericValue(temp);
			}
		}
		// System.out.println("");
		return sum;
	}

	public static int euler15(int size) {
		int route = 0;
		int x;
		int y;
		int[][] square = new int[size][size];
		for(int a=0; a<2; a++) {
			x = 0;
			y = 0;
			if(a == 0) {
				square[y][x] = 1;
				x++;
			}
			if(a == 1) {
				square[y][x] = 2;
				y++;
			}
			for(int b=0; b<2; b++) {
			if(b == 0) {
				square[y][x] = 1;
				x++;
			}
			if(b == 1) {
				square[y][x] = 2;
				y++;
			}
			for(int c=0; c<2; c++) {
			if(c == 0) {
				square[y][x] = 1;
				x++;
				route++;
			}
			if(c == 1) {
				square[y][x] = 2;
				y++;
				route++;
			}
			}
			}
		}
		return route;
	}

	public static long euler10(long below) { //Returns the sum of all the prime numbers below variable 'below'
		long sum = 2L;
		for(long i=3L; i<=below; i+=2) {
			if(isPrime(i))
				sum+=i;
		}
		return sum;
	}

	public static int euler9(int pythSum) { //Returns the product of the pythagorean triplet whose sum is equal to the variable 'pythSum'
		int a = 1;
		int b = 2;
		int c = 3;
		int pro = 0;
		while(c<(pythSum-2)) {
			b = 1;
			while(b<c) {
				a = 1;
				while(a<b) {
					if((a+b+c)==pythSum) {
						if(((a*a)+(b*b))==(c*c)) {
							pro = a*b*c;
							// System.out.println(a + "^2 + " + b + "^2 = " + c + "^2");
						}
					}
					a++;
				}
				b++;
			}
			c++;
		}
		return pro;
	}

	public static int euler8(int adjnum) { //Finds the largest possible project of 'adjnum' adjacent numbers
		return 0;
	}

	public static int euler7(int primeNum) { //Finds the variable 'primeNum'th prime number
		int count = 1;
		int num = 1;
		boolean prime = true;
		while(count <= primeNum) {
			prime = true;
			num++;
			for(int i=2; i<num; i++) {
				if(num%i == 0) {
					prime = false;
				}
			}
			if(prime) {
				count++;
				//System.out.print(num + " ");
			}
		}
		// System.out.println();
		return num;
	}

	public static int euler6(int nat) { //Finds the difference between the sum of the squares of all natural numbers under the variable 'nat' and the square of 
						//the sum of the same numbers
		int sqrSum = 0;
		int square = 0;
		int sum = 0;
		for(int i=1;i<=nat; i++) {
			sum+=i;
			sqrSum += (i*i);
		}
		square = sum*sum;
		return square-sqrSum;

	}

	public static int euler5(int limit) { //Calculates the smallest common multiple of all digits under the variable 'limit'.
		int multiple = 1;
		int temp = 0;
		boolean prime;
		int count2;
		int count2Big = 0;
		int count3;
		int count3Big = 0;
		for(int i=2; i<=limit; i++) {
			count2 = 0;
			count3 = 0;
			prime = true;
			for(int j=2; j<i; j++) {
				if(i%j == 0) {
					temp = i;
					prime = false;
					while(temp>3) {
						if(temp%2==0) {
							count2++;
							temp/=2;
						}
						else if(temp%3==0) {
							count3++;
							temp/=3;
						}
						else
							temp--;

					}
					j=i;
				}
			}
			if(prime) {
//				System.out.print(i + " ");
				multiple*=i;
			}
			if(count2 > count2Big)
				count2Big = count2;
			if(count3 > count3Big)
				count3Big = count3;
		}
		// System.out.println();
		for(int i=0; i<count2Big; i++) 
			multiple*=2;
		for(int i=0; i<count3Big; i++)
			multiple*=3;
//		System.out.println("Twos: " + (count2Big+1) + "\nThrees: " + (count3Big+1));
		return multiple;
	}

	public static int euler4(int limit) {
		int product;
		String pStr = "";
		int len = pStr.length();
		char a = ' ';
		char b = ' ';
		int largest = 0;
		// int largI = 0;
		// int largJ = 0;
		// int count = 0;
		boolean pal;
		for(int i=10; i<limit; i++) {
			for(int j=i; j<limit; j++) {
				// count = 0;
				pal = true;
				product = j*i;
				pStr = String.valueOf(product);
				len = pStr.length();
				for(int k=0; k<len; k++) {
					a = pStr.charAt(k);
					b = pStr.charAt(len-k-1);
					//System.out.print("Does " + a + " = " + b + "? ");
					if(a == b) {
						// count++;
						//System.out.println("YEP!");
					}
					else {
						pal = false;
						//System.out.println("NO");
					}
				}
				if(pal)
					if(product > largest) {
						largest = product;
						// largI = i;
						// largJ = j;
						// System.out.println(largest + " = " + largI + " * " + largJ);
					}
			}
		}
		return largest;
	}

	public static boolean isPrime(long check) {
		boolean prime = true;
		if(check == 4L)
			return false;
		for(long i=2L; i<check/2L; i++) {
			if(i%2L == 0L && i!=2L)
				continue;
			if(i%3L == 0L && i!=3L)
				continue;
			if(i%5L == 0L && i!=5L)
				continue;
			if(i%7L == 0L && i!=7L)
				continue;
			if(check%i == 0L) {
				prime = false;
				break;
			}
		}
		return prime;
	}

	public static boolean isPrime(int check) {
		boolean prime = true;
		if(check == 4)
			return false;
		for(int i=2; i<check/2; i++) {
			if(i%2 == 0 && i!=2)
				continue;
			if(i%3 == 0 && i!=3)
				continue;
			if(i%5 == 0 && i!=5)
				continue;
			if(i%7 == 0 && i!=7)
				continue;
			if(check%i == 0) {
				prime = false;
				break;
			}
		}
		return prime;
	}

	public static long euler3(long fac) {
		long max = 0L;
		for(long i=2L; i<1000000L; i++) {
			if(fac%i==0) {
				if(isPrime(i)) {
					if(i > max) {
						max = i;
					}
					// System.out.print(lrg + " ");
				}
			}
		}
		return max;
	}
	
	public static int euler2(int max) {
		int sum = 0;
		int num1 = 1;
		int num2 = 1;
		int temp = 0;
		while(num1<max) {
			//System.out.println(num1 + " ");
			if(num1%2==0)
				sum+=num1;
			temp = num1;
			num1 = num2+temp;
			num2 = temp;
		}
		return sum;
	}

	public static int euler1(int max) {
		int sum = 0;
		for(int i=3; i<max; i++) {
			if(i%3 == 0 || i%5 == 0) {
				sum += i;
			}
		}
		return sum;
	}
}
