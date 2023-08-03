import java.util.Arrays;

public class Test2 {

	public static void main(String[] args) {

		int[][] jumsu = { { 95, 60, 72, 80 }, { 44, 52, 68, 94 }, { 65, 67, 57, 72 }, { 70, 72, 76, 77 } };
		double sum = 0;
		double total_size = jumsu.length*jumsu[0].length;
		double total_avg;
		double[] jumsu_avg = new double[jumsu[0].length];
		double max_differ = 0;
		int max_differ_index = -1;
		
		
		for (int i = 0; i < jumsu.length; i++) {
			for (int j = 0; j < jumsu[i].length; j++) {
				jumsu_avg[j] += jumsu[i][j];
				sum += jumsu[i][j];
			}
		}
		
		
		total_avg = (float) (sum/total_size);
		
		for (int i = 0; i < jumsu[0].length; i++) {
			jumsu_avg[i] /= jumsu.length;
			if (Math.abs(total_avg - jumsu_avg[i]) > max_differ) {
				max_differ = Math.abs(total_avg - jumsu_avg[i]);
				max_differ_index = i;
			}
		}
		
		total_avg = (double)((int)(total_avg*100))/100;
		jumsu_avg[max_differ_index] = (double)((int)(jumsu_avg[max_differ_index]*100))/100;
		
		System.out.println("전체 평균 : "+ total_avg + " 과목 평균 : "+ jumsu_avg[max_differ_index]);
		
	}

}
