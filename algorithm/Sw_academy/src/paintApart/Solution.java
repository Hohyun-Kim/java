package paintApart;

public class Solution {
	
	public static void main(String[] args) {
		
		int[] f = new int[9];
		f[1] = 2;
		f[2] = 3;
		for(int i = 3; i < 9; i++) {
			f[i] = f[i-1] + f[i-2];
		}
		System.out.println(f[8]);

	}

}
