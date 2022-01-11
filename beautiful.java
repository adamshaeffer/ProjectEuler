class beautiful {  //A program to make the thumbnail in my website. A little extra I know, but it looks cool.
	public static void main(String[] args) {
		print("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		print("|||||||||||||||||PPPPP|||RRRRR||||OOOO|||||||JJ||EEEEEE|||CCCC|||TTTTTT|||||||||||||||||");
		print("|||||||||||||||||PP||PP||RR||RR||OO||OO||||||JJ||EE||||||CC||CC||||TT|||||||||||||||||||");
		print("|||||||||||||||||PP||PP||RR||RR||OO||OO||||||JJ||EE||||||CC||||||||TT|||||||||||||||||||");
		print("|||||||||||||||||PPPPP|||RRRRR|||OO||OO||||||JJ||EEEEEE||CC||||||||TT|||||||||||||||||||");
		print("|||||||||||||||||PP||||||RR|RR|||OO||OO||JJ||JJ||EE||||||CC||||||||TT|||||||||||||||||||");
		print("|||||||||||||||||PP||||||RR|RR|||OO||OO||JJ||JJ||EE||||||CC||||||||TT|||||||||||||||||||");
		print("|||||||||||||||||PP||||||RR||RR||OO||OO||JJ||JJ||EE||||||CC||CC||||TT|||||||||||||||||||");
		print("|||||||||||||||||PP||||||RR||RR|||OOOO||||JJJJ|||EEEEEE|||CCCC|||||TT|||||||||||||||||||");
		print("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
		print("|||||||||||||||||||||||||EEEEEE||UU||UU||LL||||||EEEEEE||RRRRR||||||||||||||||||||||||||");
		print("|||||||||||||||||||||||||EE||||||UU||UU||LL||||||EE||||||RR||RR|||||||||||||||||||||||||");
		print("|||||||||||||||||||||||||EE||||||UU||UU||LL||||||EE||||||RR||RR|||||||||||||||||||||||||");
		print("|||||||||||||||||||||||||EEEEEE||UU||UU||LL||||||EEEEEE||RRRRR||||||||||||||||||||||||||");
		print("|||||||||||||||||||||||||EE||||||UU||UU||LL||||||EE||||||RR|RR||||||||||||||||||||||||||");
		print("|||||||||||||||||||||||||EE||||||UU||UU||LL||||||EE||||||RR|RR||||||||||||||||||||||||||");
		print("|||||||||||||||||||||||||EE||||||UU||UU||LL||||||EE||||||RR||RR|||||||||||||||||||||||||");
		print("|||||||||||||||||||||||||EEEEEE|||UUUU|||LLLLLL||EEEEEE||RR||RR|||||||||||||||||||||||||");
		print("||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||");
	}

	public static void print(String toprint) {
		String actually = change(toprint, '|', '.');
		actually = change(actually, 'P', '|');
		actually = change(actually, 'R', '|');
		actually = change(actually, 'O', '|');
		actually = change(actually, 'J', '|');
		actually = change(actually, 'E', '|');
		actually = change(actually, 'C', '|');
		actually = change(actually, 'T', '|');
		actually = change(actually, 'U', '|');
		actually = change(actually, 'L', '|');
		System.out.println(actually);
		
	}

	public static String change(String convert, char a, char b) { //Changes all instances of char 'a' in String 
		//'convert' to char 'b'
		int len = convert.length();
		char temp = ' ';
		char[] loading = new char[len];
		String product = "";
		for(int i=0; i<len; i++) {
			temp = convert.charAt(i);
			if(temp==a) {
				loading[i] = b;
			} else {
				loading[i] = temp;
			}
		}
		for(int i=0; i<len; i++) {
			product += loading[i];
		}
		return product;
	}
}
