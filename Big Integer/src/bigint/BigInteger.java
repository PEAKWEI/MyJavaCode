package bigint;

/**
 * This class encapsulates a BigInteger, i.e. a positive or negative integer
 * with any number of digits, which overcomes the computer storage length
 * limitation of an integer.
 * 
 */
public class BigInteger {

	/**
	 * True if this is a negative integer
	 */
	boolean negative;

	/**
	 * Number of digits in this integer
	 */
	int numDigits;

	/**
	 * Reference to the first node of this integer's linked list representation
	 * NOTE: The linked list stores the Least Significant Digit in the FIRST node.
	 * For instance, the integer 235 would be stored as: 5 --> 3 --> 2
	 * 
	 * Insignificant digits are not stored. So the integer 00235 will be stored as:
	 * 5 --> 3 --> 2 (No zeros after the last 2)
	 */
	DigitNode front;

	/**
	 * Initializes this integer to a positive number with zero digits, in other
	 * words this is the 0 (zero) valued integer.
	 */
	public BigInteger() {
		negative = false;
		numDigits = 0;
		front = null;
	}

	/**
	 * Parses an input integer string into a corresponding BigInteger instance. A
	 * correctly formatted integer would have an optional sign as the first
	 * character (no sign means positive), and at least one digit character
	 * (including zero). Examples of correct format, with corresponding values
	 * Format Value +0 0 -0 0 +123 123 1023 1023 0012 12 0 0 -123 -123 -001 -1 +000
	 * 0
	 * 
	 * Leading and trailing spaces are ignored. So " +123 " will still parse
	 * correctly, as +123, after ignoring leading and trailing spaces in the input
	 * string.
	 * 
	 * Spaces between digits are not ignored. So "12 345" will not parse as an
	 * integer - the input is incorrectly formatted.
	 * 
	 * An integer with value 0 will correspond to a null (empty) list - see the
	 * BigInteger constructor
	 * 
	 * @param integer Integer string that is to be parsed
	 * @return BigInteger instance that stores the input integer.
	 * @throws IllegalArgumentException If input is incorrectly formatted
	 */
	public static BigInteger parse(String integer) throws IllegalArgumentException {

		boolean f = false;
		/* IMPLEMENT THIS METHOD */
		int len = integer.length();
		StringBuffer buffer = new StringBuffer(integer).reverse();
		char[] cs = buffer.toString().toCharArray();
		DigitNode head = null;
		DigitNode node1 = new DigitNode(0, null);
		DigitNode node2 = new DigitNode(0, null);
		head = node1;
		for (int i = 0; i < len; i++) {
			if (cs[i] == '-') {
				f = true;
				len--;
				continue;
			}
			if(cs[i] == '+') {
				len--;
				continue;
			}
			if (Character.isDigit(cs[i])) {
				node2 = new DigitNode(cs[i] - '0', null);
				node1.next = node2;
				node1 = node2;
			} else {
				throw new IllegalArgumentException("Incorrect Format");
			}

		}
		BigInteger integer2 = new BigInteger();
		integer2.front = head.next;
		integer2.numDigits = len;
		integer2.negative = f;
		// following line is a placeholder for compilation
		return integer2;
	}

	private static void printList(DigitNode head) {
		while (head != null) {
			System.out.print(head.digit + " ");
			head = head.next;
		}
	}


	/**
	 * Adds the first and second big integers, and returns the result in a NEW
	 * BigInteger object. DOES NOT MODIFY the input big integers.
	 * 
	 * NOTE that either or both of the input big integers could be negative. (Which
	 * means this method can effectively subtract as well.)
	 * 
	 * @param first  First big integer
	 * @param second Second big integer
	 * @return Result big integer
	 */
	public static BigInteger add(BigInteger first, BigInteger second) {

		/* IMPLEMENT THIS METHOD */
		BigInteger bigc = new BigInteger();
		bigc.front = new DigitNode(0, null);
		int carry = 0;
		DigitNode a = (first.front);
		DigitNode b = (second.front);
		DigitNode head = bigc.front;
		DigitNode c = bigc.front;
		BigInteger d = null;
		for (int i = 0; i < first.numDigits || i < second.numDigits; i++) {
			if(b==null) {
				b=new DigitNode(0, null);
			}
			int temp = carry + a.digit + b.digit;
			c.digit = temp % 10;
			bigc.numDigits++;
			d = new BigInteger();
			d.front = new DigitNode(0, null);
			c.next = d.front;
			c = d.front;
			carry = temp / 10;
			a = a.next;
			b = b.next;
		}

		if (carry != 0) {
			c.digit = carry;
			bigc.numDigits++;
		}
		bigc.negative=first.negative==second.negative?false:true;
		bigc.front = head;
		// following line is a placeholder for compilation
		return bigc;
	}

	public static DigitNode reverseList(DigitNode head) {
		if (head == null || head.next == null)
			return head;
		DigitNode pre = head;
		DigitNode cur = head.next;

		while (cur != null) {
			DigitNode temp = cur.next;
			cur.next = pre;
			pre = cur;
			cur = temp;
		}

		head.next = null;
		return head;

	}

	/**
	 * Returns the BigInteger obtained by multiplying the first big integer with the
	 * second big integer
	 * 
	 * This method DOES NOT MODIFY either of the input big integers
	 * 
	 * @param first  First big integer
	 * @param second Second big integer
	 * @return A new BigInteger which is the product of the first and second big
	 *         integers
	 */
	public static BigInteger multiply(BigInteger first, BigInteger second) {
		DigitNode front2 = second.front;
		String retval = front2.digit + "";
		for (DigitNode curr = front2.next; curr != null; curr = curr.next) {
			if (curr.digit == 0)
				continue;
			retval = curr.digit + retval;
		}
   		int b=Integer.parseInt(retval);
   		DigitNode a = (first.front);
   		BigInteger bigc=new BigInteger();
   		bigc.front = new DigitNode(0, null);
   		BigInteger d = null;
   		DigitNode c = bigc.front;
        int carry=0;
        for(int i=0;i<first.numDigits;i++){
            int temp=a.digit*b+carry;
            c.digit=temp%10;
            bigc.numDigits++;
            d = new BigInteger();
			d.front = new DigitNode(0, null);
			c.next = d.front;
			c = d.front;
            carry=temp/10;
            a = a.next;
        }
        while(carry!=0){//乘法的进位可能不止一位
            c.digit=carry%10;
            bigc.numDigits++;
            d = new BigInteger();
			d.front = new DigitNode(0, null);
			c.next = d.front;
			c = d.front;
            carry/=10;
        }
        bigc.negative=first.negative==second.negative?false:true;
       // return c;
		// following line is a placeholder for compilation
		return bigc;
	}
	public static void main(String[] args) {
		BigInteger parse = BigInteger.parse("123");
	}
	
	public boolean StrToInteger(String str) {
		StringBuffer buffer = new StringBuffer(str);
		for(int i=0;i<buffer.length();i++) {
			if(buffer.charAt(i)=='0') {
				return false;
			}
		}
		return true;
		
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		if (front == null) {
			return "0";
		}
		String retval = front.digit + "";
		for (DigitNode curr = front.next; curr != null; curr = curr.next) {
			//if (curr.digit == 0&&Integer.parseInt(retval)!=0)
			if (curr.digit == 0&&StrToInteger(retval))
				continue;
			retval = curr.digit + retval;
		}

		if (negative) {
			retval = '-' + retval;
		}
		return retval;
	}
}
