package convertSinsu;

public class ConvertUtil {

	public static void main(String[] args) {
		
		System.out.println(getDigits(HextoDec("essxy1230")));
	}

	final static char[] digits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
			'a', 'b', 'c', 'd', 'e', 'f', 'g' ,'h' , 'i', 'j', 'k', 'l', 'm' , 'n' , 'o' , 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z',
			'A', 'B', 'C', 'D', 'E', 'F', 'G' ,'H' , 'I', 'J', 'K', 'L', 'M' , 'N' , 'O' , 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	public static final String hex2Num = "0123456789abcdefghijklmnopqrstuvwxyz";
	
	public static String getDigits(long v) {
		System.out.println("v : "+v);
		if (v < 0)
			return "";

		char buf[] = new char[33];
		int charPos = buf.length - 1;
		int radix = digits.length;

		while (v > -1) {
			System.out.println((int) (v % radix));
			buf[charPos--] = digits[(int) (v % radix)];
			v = v / radix;
			if (v == 0) {
				break;
			}
		}
		return new String(buf, charPos + 1, (buf.length - 1 - charPos));
	}
	
    private static long toDec(char c){
    	long res = 0L;
    	if(c >= '0' && c <= '9') {
    		res = c - '0';
        	return res;
        }
        if(c >= 'a' && c <= 'z') {
        	res = 10 + c - 'a';
        	return res;
        }
        throw new IllegalArgumentException(String.valueOf(c));
    }
	
    public static long HextoDec(String s){
    	long n = 0L;
        for( int i = 0; i < s.length(); i++){
        	System.out.println(s.charAt(i));
            n = n * 36 + toDec(s.charAt(i));//けたをずらしながら10進数を計算
            System.out.println("n : "+n);
        }
        return n;
    }

}
