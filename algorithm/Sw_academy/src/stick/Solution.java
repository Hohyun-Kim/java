package stick;

public class Solution {
	
	public static void main(String[] args) {
		
		int[] f = new int[7];
		f[1] = 2;
		f[2] = 5;
		for(int i = 3; i < 7; i++) {
			f[i] = f[i-1]*2 + f[i-2];
		}
		System.out.println(f[6]);

	}

}
