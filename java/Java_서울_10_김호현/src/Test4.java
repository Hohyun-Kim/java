/*
Test4.java : 팀원 평균

[테스트케이스]

5
5 50 50 70 80 100
7 100 95 90 80 70 60 50
3 70 90 80
3 70 90 81
9 100 99 98 97 96 95 94 93 91

*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Test4 {

	public static void main(String[] args) throws FileNotFoundException {
		//////////////////////////////////////////////////////////////
		// 테스트 후 아래 파일 입력을 표준입력으로 처리하는 문장은 주석 처리해주세요!!!! ( System.setIn처리 코드 )
		//////////////////////////////////////////////////////////////
//		System.setIn(new FileInputStream("Test4.txt"));
		
		
		Scanner in = new Scanner(System.in);
		
		int T = in.nextInt();
		int num_member = 0;
		String team_info = "";
		for (int t = 0; t < T; t++) {
			num_member = in.nextInt();
			int[] team_member = new int[num_member];
			double avg = 0;
			double cnt = 0;
			for (int m = 0; m < num_member; m++) {
				team_member[m] = in.nextInt();
				avg += team_member[m];
			}
			avg /= (double)num_member;
			for (int member : team_member) {
				if (member > avg) {
					cnt++;
				}
			}
			cnt /= (double)num_member;
			cnt = (double)((int)(cnt*100000))/1000;
			String cnt_toString = cnt+"";
			if (cnt_toString.length()==4)
				cnt_toString += "00";
			else if (cnt_toString.length()==5)
				cnt_toString += "0";
			
			System.out.println("#"+(t+1)+" "+cnt_toString+"%");
		}

	}
}
