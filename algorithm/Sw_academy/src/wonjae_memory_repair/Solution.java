package wonjae_memory_repair;

import java.util.Scanner;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		sc.nextLine();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			String memory = sc.nextLine();
			char now = '0';
			int cnt = 0;
			for (int i = 0; i < memory.length(); i++) {
				if (now != memory.charAt(i)) {
					cnt++;
					now = memory.charAt(i);
				}
			}
			System.out.println("#"+test_case+" "+cnt);
		}
		
	}
}

//2
//0011
//100