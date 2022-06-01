import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

class thirty {
	public static void main(String[] args) throws IOException {
        System.out.println();
		// System.out.println(euler31()); // Solved 27/1/22
		// System.out.println(euler32()); // Solved 15/2/22
		// // System.out.println(euler33()); // Unsolved
        // System.out.println(euler34()); // Solved 18/5/22
		// System.out.println(euler35(1000000)); // Solved 11/5/22
        // System.out.println(euler36(1000000)); // Solved 18/5/22
        // System.out.println(euler37(3797)); // Solved 18/5/22
		// System.out.println(euler38()); // Solved 25/5/22
		// System.out.println(euler39(1000)); // Solved 25/5/22
		// System.out.println(euler40()); // Solved 25/5/22
		// // System.out.println(euler41()); // Solved 25/5/22 Takes a long time
		// System.out.println(euler42("lib\\words42.txt")); // Solved 25/5/22
		// System.out.println(euler43()); // Solved 25/5/22
		// System.out.println(euler44()); // Solved 25/5/22
		// System.out.println(euler45()); // Solved 26/5/22
		// System.out.println(euler46());
		System.out.println(euler47(4));
	}

	public static int euler47(int c) {
		int num;
		int[] primes = new int[c*c];
		int[][] ans = new int[c][c+1];
		boolean valid = true;
		for(int k=10; k<1000000; k++) {
			valid = true;
			num = k;
			for(int i=0; i<c; i++) {
				ans[i] = primeFactors(num+i,c);
				for(int j=0; j<ans[i].length; j++) {
					// System.out.print(ans[i][j] + ", ");
					if(ans[i][j] == 0) {
						valid = false;
						break;
					}
				}
				if(!valid) {
					break;
				}
				// System.out.println();
			}
			// System.out.println(valid);
			if(valid) {
				for(int i=0; i<primes.length; i++) {
					primes[i] = ans[i/c][i%c+1];
					if(!isPrime(primes[i]) && !isPrime((int)Math.sqrt(primes[i]))) {
						valid = false;
						break;
					}
					for(int j=0; j<i; j++) {
						if(primes[i] == primes[j]) {
							valid = false;
							break;
						}
					}
					if(!valid) {
						break;
					}
				}
				if(valid) {
					System.out.println(ans[0][0]);
					break;
				}
			}
		}
		System.out.println();
		for(int i=0; i<ans.length; i++) {
			for(int j=0; j<ans[i].length; j++) {
				System.out.print(ans[i][j] + ", ");
			}
			System.out.println();
		}
		System.out.println(valid);
		System.out.println();
		return ans[0][0];
	}

	public static int[] primeFactors(int num, int count) {
		int temp1, temp2;
		int[] factors = new int[count+1];
		// boolean valid = true;
		factors[0] = num;
		factors[1] = num;
		for(int i=1; i<count; i++) {
			temp1 = factors[i];
			if(isPrime(temp1)) {
				continue;
			}
			for(int j=2; j<Math.sqrt(temp1); j++) {
				if(!isPrime(j)) {
					continue;
				}
				if(temp1%j == 0) {
					factors[i+1] = temp1/j;
					factors[i] = j;
				}
			}
		}
		for(int i=1; i<=count; i++) {
			temp1 = factors[i];
			for(int j=1; j<i; j++) {
				temp2 = factors[j];
				if(temp2 != 0 && temp1%temp2 == 0) {
					if(factors[0] == 644) {
					// System.out.println("Missed a square at: " + factors[0]);
					// System.out.println(temp1 + " " + temp2);
					}
					factors[j] = temp2*temp2;
					factors[i] = temp1/temp2;
				}
			}
		}
		for(int i=1; i<=count; i++) {
			temp1 = factors[i];
			if((!isPrime(temp1) && temp1 != 4) || temp1 == 1) {
				factors[count] = 0;
				break;
			}
			for(int j=1; j<i; j++) {
				temp2 = factors[j];
				if(temp1 == temp2) {
					factors[count] = 0;
					break;
				}
			}
		}
		// for(int i=0; i<=count; i++) {
		// 	for(int j=1; j<=count; j++) {
		// 		if(factors[j] == 0) {
		// 			valid = false;
		// 			break;
		// 		}
		// 	}
		// 	if(valid) {
		// 		System.out.print(factors[i] + ", ");
		// 	}
		// }
		// if(valid)
		// 	System.out.println();
		return factors;
	}

	public static int euler46() {
		int diff = 0;
		int[] sqr = new int[32768];
		boolean goldbach = true;
		for(int i=1; i<sqr.length; i++) { // Fill the sqr array with doubles of squares
			sqr[i] = i*i*2;
			if(sqr[i]<0) {
				if(goldbach) {
					goldbach = false;
					System.out.println(sqr[i-1] + " at " + (i-1));
				}
				break;
			}
		}
		// for(int i=9; i<sqr[sqr.length-1]; i+=2) {// Find odd composite numbers by
		for(int i=1000000001; i<2000000000; i+=2) {
			if(isPrime(i)) {
				continue;
			}
			goldbach = false;
			for(int j=1; j<sqr.length; j++) {
				diff = i-sqr[j];
				if(isPrime(diff)) {
					goldbach = true;
					// System.out.println(i + " = " + diff + " + " + sqr[j]);
					break;
				}
			}
			if(!goldbach) {
				System.out.println(i + " = " + diff + " + " + (i-diff));
				return i;
			}
		}
		return 0;
	}

	public static long euler45() {
		int size = 100000;
		long max = 0;
		int tn = 0;
		long tt;
		int pn = 0;
		long pt;
		int hn = 0;
		long ht;
		long[] t = new long[size];
		long[] p = new long[size];
		long[] h = new long[size];
		boolean found;

		for(int i=1; i<t.length; i++) {
			tt = (i*(i+1L))/2L;
			pt = (i*((3L*i)-1L))/2L;
			ht = i*((2L*i)-1L);
			t[i] = tt;
			p[i] = pt;
			h[i] = ht;
		}
		// System.out.println("Biggest in size " + size + ": " + t[size-1] + ", " + p[size-1] + ", " + h[size-1]);
		for(hn=1; hn<h.length; hn++) {
			ht = h[hn];
			found = false;
			for(pn=1; pn<p.length; pn++) {
				pt = p[pn];
				if(pt != ht) {
					continue;
				}
				for(tn=1; tn<t.length; tn++) {
					tt = t[tn];
					if(tt == pt && tt == ht && ht == pt) {
						// System.out.print("T_" + tn + " = ");
						// System.out.print("P_" + pn + " = ");
						// System.out.print("H_" + hn + " = ");
						// System.out.println(pt);
						found = true;
						if(tt > max) {
							max = tt;
						}
						break;
					}
				}
				if(found) {
					break;
				}
			}
		}
		return max;
	}

	public static int euler44() {
		int d = 10000000;
		int diff;
		int sum;
		int temp;
		int[] p = new int[2400];
		boolean valids, validd;
		// boolean blah = true;

		for(int i=1; i<p.length; i++) { // Fill array p with numbers in the sequence
			temp = (i*(3*i-1))/2;
			if(temp > 0) {
				p[i] = temp;
			// } else if(blah){
			// 	System.out.println(i);
			// 	blah = false;
			}
			if(i<20) {
				// System.out.print(p[i] + ",");
			}
		}
		// System.out.println(p[p.length-1]);
		
		for(int i=1; i<p.length; i++) {
			for(int j=1; j<i; j++) {
				valids = false;
				validd = false;
				sum = p[i] + p[j];
				diff = p[i] - p[j];
				if(diff > d) {
					continue;
				}
				int k=1;
				for(k=1; k<p.length; k++) { // Find the pentagonal numbers that equal the sum and difference of p[i] and p[j]
					if(sum == p[k]) {
						valids = true;
						// System.out.println(p[i] + " - " + p[j]);
					} else if(sum < p[k]) {
						break;
					}
					if(diff == p[k]) {
						validd = true;
					} else if(diff > p[k-1]) {
						continue;
					}
					if(valids && validd) {
						break;
					}
				}
				if(valids && validd) {
					// System.out.println("Sum is at position " + k + ":");
					// System.out.println(p[i] + " - " + p[j] + " = " + diff);
					// System.out.println(p[i] + " + " + p[j] + " = " + sum);
					// System.out.println();
					if(diff < d) {
						d = diff;
					}
				}
			}
		}
		// System.out.println(p[999]);
		return d;
	}

	public static long euler43() {
		long sum = 0L;
		long num;
		int temp;
		int[] checks = {2,3,5,7,11,13,17};
		int[] sets;
		String nums;
		String skip = "";
		boolean valid;
		boolean[] digs;

		for(long j=1023456789L; j<9876543211L; j++) {
			num = j;
			sets = new int[checks.length];
			nums = "" + num;
			valid = true;
			digs = new boolean[10];
			if(nums.length() != 10) {
				valid = false;
				continue;
			}
			for(int i=0; i<nums.length(); i++) {
				temp = Character.getNumericValue(nums.charAt(i));
				if(digs[temp]) {
					// System.out.println("Contains repeating number!");
					valid = false;
					skip = "";
					for(int k=0; k<9-i; k++) {
						skip += "9";
					}
					if(!skip.equals("")) {
						j += Long.parseLong(skip);
					}
					break;
				}
				digs[temp] = true;
			}
			if(!valid)
				continue;
			for(int i=1; i<8; i++) {
				sets[i-1] = Integer.parseInt(nums.substring(i,i+3));
			}
			for(int i=0; i<7; i++) {
				if(sets[i]%checks[i] != 0) {
					// System.out.println("Doesn't meet one of the checks!");
					valid = false;
					break;
				}
			}
			if(valid) {
				sum += num;
			}
		}
		return sum;
	}

	public static int euler42(String filename) throws IOException {
		FileInputStream file = new FileInputStream(filename);
		Scanner scnr = new Scanner(file);
		String all = scnr.next();
		scnr.close();
		String[] words = new String[1786];
		char temp = all.charAt(0);
		char last;
		int count = 0;
		int end = 0;
		int[] values = new int[1786];
		int[] sequence = new int[25];

		for(int i=1; i<all.length(); i++) { // Separate each word into the words array
			last = temp;
			temp = all.charAt(i);
			if(last == '"' && temp != '"' && temp != ',') {
				for(int j=i+1; j<i+20 && j<all.length(); j++) {
					if(all.charAt(j) == '"') {
						end = j;
						break;
					}
				}
				words[count] = all.substring(i,end);
				count++;
				i=end-1;
			}
		}
		count = 0;
		
		for(int i=0; i<words.length; i++) { // Determine the value of each word and put it into the values array
			for(int j=0; j<words[i].length(); j++) {
				temp = words[i].charAt(j);
				values[i] += Character.valueOf(temp)-64;
			}
			// System.out.print(values[i] + ", ");
		}
		count = 0;

		for(int i=0; i<sequence.length; i++) { // Calculate the first 25 of the sequence and check it to each value
			sequence[i] = (i*(i+1))/2;
			for(int j=0; j<values.length; j++) {
				if(values[j] == sequence[i]) {
					count++;
				}
			}
			// System.out.print(sequence[i] + ", ");
		}
		// System.out.println();
		return count;
	}

	public static int euler41() {
		boolean valid;
		boolean[] digs;
		int max = 0;
		int nth;
		int blah;
		String num;
		for(int i=5; i<8; i++) {
			nth = (int) Math.pow(10,(int) i-1);
			for(int j=nth; j<nth*10; j++) {
				valid = true;
				num = "" + j;
				digs = new boolean[9];
				for(int k=0; k<num.length(); k++) {
					blah = Character.getNumericValue(num.charAt(k));
					if(blah == 0) {
						valid = false;
						break;
					}
					if(digs[blah-1]) {
						valid = false;
						break;
					}
					digs[blah-1] = true;
				}
				for(int k=i; k<9; k++) {
					if(digs[k]) {
						valid = false;
						break;
					}
				}
				if(valid) {
					if(isPrime(j)) {
						if(j>max) {
							max = j;
							// System.out.println(max);
						}
					}
				}
			}
		}
		return max;
	}

	public static int euler40() {
		String champer = "";
		char[] chars = new char[7];
		int prod = 1;
		int[] ints = new int[7];
		int[] places = {1,10,100,1000,10000,100000,1000000};
		for(int i=1; i<200000; i++) {
			champer += i + "";
		}
		// System.out.println(champer);
		for(int i=0; i<places.length; i++) {
			chars[i] = champer.charAt(places[i]-1);
			ints[i] = Character.getNumericValue(chars[i]);
			// System.out.print(ints[i] + " x ");
			prod *= ints[i];
		}
		// System.out.println("\n=");
		return prod;
	}

	public static int euler39(int max) {
		int count = 0;
		int countMax = 0;
		int a,b,c;
		int a2,b2,c2;
		int p, pMax = 120;
		boolean valid;
		for(p=12; p<=max; p++) {
			count = 0;
			for(c=3; c<p; c++) {
				for(b=2; b<c; b++) {
					valid = true;
					a = p-(c+b);
					if(a < 1 || a > b) {
						valid = false;
						continue;
					}
					if(a+b+c != p) {
						valid = false;
						continue;
					}
					a2 = a*a;
					b2 = b*b;
					c2 = c*c;
					if(a2+b2 != c2) {
						valid = false;
						continue;
					}
					if(valid) {
						// System.out.println(a + " " + b + " " + c);
						count++;
					}
				}
			}
			if(count > 0)
				// System.out.println(p + " " + count);
			if(count > countMax) {
				pMax = p;
				countMax = count;
			}
		}
		return pMax;
	}
	
	public static String euler38() {
		int num;
		int num2;
		int sum;
		String concate;
		String max = "";
		boolean valid;
		boolean[] digits;

		for(int j=0; j<10000; j++) {
			num = j;
			valid = true;
			concate = "";
			for(int i=1; i<10; i++) {
				if(concate.length()>8) {
					// System.out.println(concate);
					break;
				}
				concate += num*i;
			}
			if(concate.length()>9) {
				valid = false;
				continue;
			}
			sum = 0;
			digits = new boolean[9];
			for(int i=0; i<concate.length(); i++) {
				num2 = Character.getNumericValue(concate.charAt(i));
				if(num2 == 0) {
					valid = false;
					break;
				}
				if(digits[num2-1]) {
					valid = false;
					break;
				}
				digits[num2-1] = true;
				// System.out.print(num2 + " + ");
				sum += num2;
			}
			if(sum != 45) {
				// System.out.println(sum);
				valid = false;
				continue;
			}
			if(valid) {
				// System.out.println(concate);
				if(concate.compareTo(max) > 0) {
					max = concate;
				}
			}
		}
		// System.out.println();
		return max;
	}

    public static int euler37(int max) {
        boolean trunk;
        int total = 0;
        // int count = 0;
        int num;
        String nums;
        String temp;
        for(int j=20; j<1000000; j++) {
                    //   739397
            num = j;
            nums = "" + num;
            temp = nums;
            trunk = true;
            for(int i=0; i<nums.length(); i++) {
                if(nums.charAt(i) == '4' || nums.charAt(i) == '6' || nums.charAt(i) == '8' || nums.charAt(i) == '0') {
                    trunk = false;
                    break;
                }
            }
            if(!trunk) {
                continue;
            }
            if(!isPrime(num)) {
                trunk = false;
                continue;
            }
            for(int i=1; i<nums.length(); i++) { // Removing left to right
                temp = nums.substring(i,nums.length());
                if(temp.equals("1")) {
                    trunk = false;
                    break;
                }
                // System.out.print(temp + " ");
                if(!isPrime(Integer.parseInt(temp))) {
                    trunk = false;
                    break;
                }
            }
            if(!trunk) {
                continue;
            }
            // System.out.println();
            for(int i=0; i<nums.length()-1; i++) { // Removing right to left
                temp = nums.substring(0,(nums.length()-1)-i);
                if(temp.equals("1")) {
                    trunk = false;
                    break;
                }
                // System.out.print(temp + " ");
                if(!isPrime(Integer.parseInt(temp))) {
                    trunk = false;
                    break;
                }
            }
            if(!trunk) {
                continue;
            }
            // System.out.println();
            if(trunk) {
                total += num;
                // count++;
                // System.out.println(num + " " + total + " " + count);
            }
        }
        return total;
    }

    public static int euler36(int max) { // Returns the sum of all numbers under max where both number and binary form are palindromes
        int total = 0;
        int num;
        String bin = "-1";
        for(int i=0; i< max; i++) {
            num = i;
            bin = "-1";
            if(isPalindrome(String.valueOf(num))) {
                bin = toBinary(num);
            }
            else {
                continue;
            }

            if(isPalindrome(bin)) {
                total += num;
                // System.out.println(num + " " + bin);
            }
        }
        // System.out.println(bin);
        return total;
    }

    public static String toBinary(int num) {
        String bin = "";
        while(num>0) {
            bin = bin + num%2;
            num /= 2;
        }
        return bin;
    }

    public static boolean isPalindrome(String str) {
        char front;
        char back;
        for(int i=0; i<str.length(); i++) {
            front = str.charAt(i);
            back = str.charAt((str.length()-1)-i);
            if(front != back)
                return false;
        }
        return true;
    }

	public static int euler35(int max) {
		int count = 4;
		int curr;
		int temp;
		boolean prime;
		String currs;
		String temps;
		char pow;
		for(int j=11; j<max; j++) {
			curr = j;
			prime = true;
			currs = String.valueOf(curr);
			for(int i=0; i<currs.length(); i++) {
				pow = currs.charAt(i);
				if(pow=='2' || pow=='4' || pow=='5' || pow=='6' || pow=='8' || pow=='0')
					prime = false;
			}
			if(!prime)
				continue;
			if(!(isPrime(curr)))
				continue;
			for(int i=0; i<currs.length()-1; i++) {
				temps = currs.substring(i+1,currs.length());
				temps += currs.substring(0,i+1);
				temp = Integer.parseInt(temps);
				if(!(isPrime(temp))) {
					prime = false;
					break;
				}
			}
			if(prime == true) {
				count++;
				// System.out.print(curr + " ");
			}
		}
		return count;
	}

    public static int euler34() {
        int total = 0;
        int num = 145;
        for(int i=3; i<41000; i++) {
            num = i;
            if(digFact(num) == num) {
                total += num;
            }
        }
        // if(digFact(num) == num)
        //     total += num;
        return total;
    }

    public static int digFact(int check) {
        String str = String.valueOf(check);
        int place;
        int factorial;
        int total = 0;
        for(int i=0; i<str.length(); i++) {
            factorial = 1;
            place = Character.getNumericValue(str.charAt(i));
            for(int j=1; j<=place; j++) {
                factorial *= j;
            }
            total += factorial;
        }
        return total;
    }

	public static boolean isPrime(int check) {
		boolean prime = true;
		if(check == 4)
			return false;
		for(int i=2; i<=Math.sqrt(check); i++) {
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
			}
		}
		return prime;
	}

	public static int euler33() {
		return -1;
	}

	public static int euler32() { //Returns the sum of products where all digits 1-9 are used in the three numbers a * b = c
		int pan;
		int a;
		int b;
		int c;
		int sum = 0;
		int place = 0;
		int[] all = new int[20];
		String coll = "";
		char temp;
		// boolean one2nine;

		for(a=2; a<99; a++) {
			if(a%10 == 0)
				a++;
			b = a;
			if(a>9)
				b = ((a/10)+1)*10+1;
			if(b%10==0)
				b++;
			while(b<5000) {
				c = a*b;
				coll = ""+a+b+c;
				// one2nine = false;
				if(coll.length() > 9)
					b = 5000;
				if(coll.length() == 9) {
					pan = 0;
					for(int i=0; i<coll.length(); i++) { //checks that all digits 1-9 are used, and that there are no repeats
						temp = coll.charAt(i);
						pan += Character.getNumericValue(temp);
						for(int j=i+1; j<coll.length(); j++) {
							if(temp == coll.charAt(j))
								pan += 50;
						}
					}
					if(pan == 45) {
						all[place] = c;
						place++;
					}
				}
				b++;
			}
		}
		for(int i=0; i<all.length; i++) {
			for(int j=i+1; j<all.length; j++) {
				if(all[i] == all[j])
					all[j] = 0;
			}
			sum += all[i];
		}
		return sum;
	}

	public static int euler31() { //Returns the number of different ways to make 2 pounds with any number of coins
		int p1 = 0;
		int p2 = 0;
		int p5 = 0;
		int p10 = 0;
		int p20 = 0;
		int p50 = 0;
		int p100 = 0;
		int p200 = 0;
		int count = 0;

		for(p1=0; p1<=200/1; p1++) {
		for(p2=0; p2<=200/2; p2++) {
			for(p5=0; p5<=200/5; p5++) {
			for(p10=0; p10<=200/10; p10++) {
				for(p20=0; p20<=200/20; p20++) {
				for(p50=0; p50<=200/50; p50++) {
					for(p100=0; p100<=200/100; p100++) {
					for(p200=0; p200<=200/200; p200++) {
						if((p1*1)+(p2*2)+(p5*5)+(p10*10)+(p20*20)+(p50*50)+(p100*100)+(p200*200) == 200) {
							count++;
						}
					}
					}
				}
				}
			}
			}
		}
		}

		return count;
	}
}
