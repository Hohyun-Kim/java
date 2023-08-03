import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

public class Test3 {
	public static String tc = "10000\r\n"+"2530";
	
	public static int[] charge_type = {1000, 500, 100, 50, 10};

	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new StringReader(tc));
		
		int money = Integer.parseInt(br.readLine());
		int price = Integer.parseInt(br.readLine());
		int charge = money-price;
		int num_charge = 0;
		System.out.println("투입금액 : "+ money + "원");
		System.out.println("상품금액 : "+ price + "원");
		System.out.println("거스름돈 : "+ charge + "원");
		System.out.println("------------------------");
		for (int next_charge : charge_type) {
			num_charge = (charge/next_charge);
			charge %= next_charge;
			System.out.println(next_charge+"원 : "+num_charge+"개");
		}
	}
}