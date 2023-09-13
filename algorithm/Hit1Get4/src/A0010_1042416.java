import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;

public class A0010_1042416 {

	// 닉네임을 사용자에 맞게 변경해 주세요.
	static final String NICKNAME = "A0010_1042416";
	
	// 일타싸피 프로그램을 로컬에서 실행할 경우 변경하지 않습니다.
	static final String HOST = "127.0.0.1";

	// 일타싸피 프로그램과 통신할 때 사용하는 코드값으로 변경하지 않습니다.
	static final int PORT = 1447;
	static final int CODE_SEND = 9901;
	static final int CODE_REQUEST = 9902;
	static final int SIGNAL_ORDER = 9908;
	static final int SIGNAL_CLOSE = 9909;

	// 게임 환경에 대한 상수입니다.
	static final int TABLE_WIDTH = 254;
	static final int TABLE_HEIGHT = 127;
	static final int NUMBER_OF_BALLS = 6;
	static final int[][] HOLES = { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };
	static final float[][][] HOLE_BORDER = { {{0, 0}, {3, 0}}, {{124, 0}, {130, 0}}, {{251, 0}, {254, 3}},
			{{0, 124}, {3, 127}}, {{124, 127}, {130, 127}}, {{251, 127}, {254, 124}} };
	
	static final double R = 5.73;
	static float[][] balls;
	static int[] ball_idx;
	static int number_of_usefulBall = 0;
	static float[] targetBalls_x;
	static float[] targetBalls_y;
	static float whiteBall_x;
	static float whiteBall_y;
	
	static boolean check_path(float start_x, float start_y, float dest_x, float dest_y, int ti) {
		boolean pass = true;
		for(int i = 0; i < number_of_usefulBall; i++) {
			int bi = ball_idx[i];
			if(ti == bi) continue;
			float d = Math.abs((dest_y-start_y)*balls[bi][0] + (start_x-dest_x)*balls[bi][1] + (dest_x-start_x)*(dest_x*start_y - start_x*dest_y))/((float)Math.sqrt((dest_y-start_y)*(dest_y-start_y)+(start_x-dest_x)*(start_x-dest_x)));
			if((dest_x - balls[bi][0]) * (balls[bi][0] - start_x) > 0 && (dest_y - balls[bi][1]) * (balls[bi][1] - start_y) > 0) continue;
			if(d <= 5.73) {
				pass = false;
				break;
			}
		}
		return pass;
	}
	
	static float calc_distance(float x0, float y0, float x1, float y1) {
		return (float) Math.sqrt((x1-x0) * (x1-x0) + (y1-y0) * (y1-y0));
	}
	
	static ArrayList<Integer> find_hole(tb target_ball) {
		ArrayList<Integer> holes = new ArrayList<>();
		int min = Integer.MAX_VALUE;
		for(int i = 0; i < 6; i++) {
			if(check_path(target_ball.x, target_ball.y, HOLES[i][0], HOLES[i][1], target_ball.idx)) {
				for(int j = 0; j < 2; j++) {
					if(!check_path(target_ball.x, target_ball.y, HOLE_BORDER[i][j][0], HOLE_BORDER[i][j][1], target_ball.idx)) {
						continue;
					}
					float finalHole_x = HOLES[i][0]>0?HOLES[i][0]-3:HOLES[i][0]+3;
					float finalHole_y = HOLES[i][1]>0?HOLES[i][1]-3:HOLES[i][1]+3;
					if(target_ball.idx == 1 || target_ball.idx == 4 ) {
						finalHole_x = HOLES[target_ball.finalhole][0];
					}
					
					float target_final_width = Math.abs(target_ball.x - finalHole_x);
					float target_final_height = Math.abs(target_ball.y - finalHole_y);
					double target_final_radian = target_final_height > 0? Math.atan(target_final_height / target_final_width): 0;

					float targetBall_hx = (target_ball.x < finalHole_x)?(float) ((Math.cos(target_final_radian) * R) * -1) + target_ball.x:(float) ((Math.cos(target_final_radian) * R)) + target_ball.x;
					float targetBall_hy = (target_ball.y < finalHole_y)?(float) ((Math.sin(target_final_radian) * R) * -1) + target_ball.y:(float) ((Math.sin(target_final_radian) * R)) + target_ball.y;
					if(check_path(whiteBall_x, whiteBall_x, targetBall_hx, targetBall_hy, 0)) {
						float a = calc_distance(HOLES[i][0], HOLES[i][1], target_ball.x, target_ball.y);
						float b = calc_distance(HOLES[i][0], HOLES[i][1], whiteBall_x, whiteBall_y);
						float c = calc_distance( target_ball.x, target_ball.y, whiteBall_x, whiteBall_y);
						if((180.0 / Math.PI) * Math.acos((((a*a)+(b*b)) - c*c)/(2*a*b)) >= 95) {
							holes.add(i);
						}
					}
				}
			}
		}
		return holes;
	}
	
	static class tb {
		float x;
		float y;
		int idx;
		int finalhole;
		float distance_to_finalhole;
		ArrayList<Integer> possible_holes;
		
		public tb(float x, float y, int idx) {
			this.x = x;
			this.y = y;
			this.idx = idx;
		}
		
		public void setPossibleHoles(ArrayList<Integer> ph) {
			possible_holes = ph;
		}
		
		public void setFinalHole() {
			float min = 254*254;
			int min_idx = 0;
			for(int i = 0; i < possible_holes.size(); i++) {
				int hole_idx = possible_holes.get(i);
				float now_d = calc_distance(x, y, HOLES[hole_idx][0], HOLES[hole_idx][1]);
				if(now_d < min) {
					min = now_d;
					min_idx = hole_idx;
				}
			}
			finalhole = min_idx;
			distance_to_finalhole = min;
		}		
	}

	public static void main(String[] args) {

		Socket socket = null;
		String recv_data = null;
		byte[] bytes = new byte[1024];
		balls = new float[NUMBER_OF_BALLS][2];
		int order = 0;

		try {
			socket = new Socket();
			System.out.println("Trying Connect: " + HOST + ":" + PORT);
			socket.connect(new InetSocketAddress(HOST, PORT));
			System.out.println("Connected: " + HOST + ":" + PORT);

			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			String send_data = CODE_SEND + "/" + NICKNAME + "/";
			bytes = send_data.getBytes("UTF-8");
			os.write(bytes);
			os.flush();
			System.out.println("Ready to play!\n--------------------");

			while (socket != null) {

				// Receive Data
				bytes = new byte[1024];
				int count_byte = is.read(bytes);
				recv_data = new String(bytes, 0, count_byte, "UTF-8");
				System.out.println("Data Received: " + recv_data);

				// Read Game Data
				String[] split_data = recv_data.split("/");
				int idx = 0;
				try {
					for (int i = 0; i < NUMBER_OF_BALLS; i++) {
						for (int j = 0; j < 2; j++) {
							balls[i][j] = Float.parseFloat(split_data[idx++]);
						}
					}
				} catch (Exception e) {
					bytes = (CODE_REQUEST + "/" + CODE_REQUEST).getBytes("UTF-8");
					os.write(bytes);
					os.flush();
					System.out.println("Received Data has been currupted, Resend Requested.");
					continue;
				}

				// Check Signal for Player Order or Close Connection
				if (balls[0][0] == SIGNAL_ORDER) {
					order = (int)balls[0][1];
					System.out.println("\n* You will be the " + (order == 1 ? "first" : "second") + " player. *\n");
					continue;
				} else if (balls[0][0] == SIGNAL_CLOSE) {
					break;
				}

				// Show Balls' Position
				for (int i = 0; i < NUMBER_OF_BALLS; i++) {
					System.out.println("Ball " + i + ": " + balls[i][0] + ", " + balls[i][1]);
				}

				float angle = 0.0f;
				float power = 0.0f;

				//////////////////////////////
				// 이 위는 일타싸피와 통신하여 데이터를 주고 받기 위해 작성된 부분이므로 수정하면 안됩니다.
				//
				// 모든 수신값은 변수, 배열에서 확인할 수 있습니다.
				//   - order: 1인 경우 선공, 2인 경우 후공을 의미
				//   - balls[][]: 일타싸피 정보를 수신해서 각 공의 좌표를 배열로 저장
				//     예) balls[0][0]: 흰 공의 X좌표
				//         balls[0][1]: 흰 공의 Y좌표
				//         balls[1][0]: 1번 공의 X좌표
				//         balls[4][0]: 4번 공의 X좌표
				//         balls[5][0]: 마지막 번호(8번) 공의 X좌표
				
				// 여기서부터 코드를 작성하세요.
				// 아래에 있는 것은 샘플로 작성된 코드이므로 자유롭게 변경할 수 있습니다.
				


				// whiteBall_x, whiteBall_y: 흰 공의 X, Y좌표를 나타내기 위해 사용한 변수
				whiteBall_x = balls[0][0];
				whiteBall_y = balls[0][1];
				
				
//				게임에 현재 존재하는 balls
				ball_idx = new int[NUMBER_OF_BALLS];
				number_of_usefulBall = 0;
				for(int i = 0; i < NUMBER_OF_BALLS; i++) {
					if(balls[i][0] == -1 && balls[i][1] == -1) continue;
					ball_idx[number_of_usefulBall] = i;
					number_of_usefulBall++;
				}
				
//				target ball들 객체 생성
				tb[] tbs = new tb[3];
				int[] tbs_idx = new int[3];
				if(order == 1) {
					tbs_idx[0] = 1;
					tbs_idx[1] = 3;
					tbs_idx[2] = 5;
				} else {
					tbs_idx[0] = 2;
					tbs_idx[1] = 4;
					tbs_idx[2] = 5;
				}
				for(int i = 0; i < 3; i++) {
					int ti = tbs_idx[i];
					tbs[i] = new tb(balls[ti][0], balls[ti][1], ti);					
				}
				
//				target ball마다 가능한 hole 찾아주기
				int targetBall_idx = 0;
				float min = 254*254;
				int remain_tb = 0;
				boolean[] tb_able = new boolean[3];
				for(int i = 0; i < 3; i++) {
					if(tbs[i].x == -1 && tbs[i].y == -1) continue;
					tb now = tbs[i];
					now.setPossibleHoles(find_hole(now));
					now.setFinalHole();
					remain_tb++;
					tb_able[i] = true;
				}
				
				for(int i = 0; i < 3; i++) {
					if(remain_tb > 1 && i == 2) break;
					if(tb_able[i]) {
						if (tbs[i].distance_to_finalhole < min) targetBall_idx = i;
					}
				}
				
				
				tb targetBall = tbs[targetBall_idx];
				
				float targetBall_x = balls[targetBall.idx][0];
				float targetBall_y = balls[targetBall.idx][1];
				
				float finalHole_x = HOLES[targetBall.finalhole][0]>0?HOLES[targetBall.finalhole][0]-3:HOLES[targetBall.finalhole][0]+3;
				float finalHole_y = HOLES[targetBall.finalhole][1]>0?HOLES[targetBall.finalhole][1]-3:HOLES[targetBall.finalhole][1]+3;
				if(targetBall.finalhole == 1 || targetBall.finalhole == 4 ) {
					finalHole_x = HOLES[targetBall.finalhole][0];
				}
				
				float target_final_width = Math.abs(targetBall_x - finalHole_x);
				float target_final_height = Math.abs(targetBall_y - finalHole_y);
				double target_final_radian = target_final_height > 0? Math.atan(target_final_height / target_final_width): 0;

				float targetBall_hx = (targetBall_x < finalHole_x)?(float) ((Math.cos(target_final_radian) * R) * -1) + targetBall_x:(float) ((Math.cos(target_final_radian) * R)) + targetBall_x;
				float targetBall_hy = (targetBall_y < finalHole_y)?(float) ((Math.sin(target_final_radian) * R) * -1) + targetBall_y:(float) ((Math.sin(target_final_radian) * R)) + targetBall_y;
				
				
				
				
//				흰공과 hole사이 거리구하기
//				float[] dWH = new float[6];
//				for(int i = 0; i < 6; i++) {
//					dWH[i] = calc_distance(whiteBall_x, whiteBall_y, HOLES[i][0], HOLES[i][1]);
//				}
				float distance_white_Hall = calc_distance(whiteBall_x, whiteBall_y, HOLES[targetBall.finalhole][0], HOLES[targetBall.finalhole][1]);
				
				// width, height: 목적구와 흰 공의 X좌표 간의 거리, Y좌표 간의 거리
				float width = Math.abs(targetBall_hx - whiteBall_x);
				float height = Math.abs(targetBall_hy - whiteBall_y);

				
				// radian: width와 height를 두 변으로 하는 직각삼각형의 각도를 구한 결과
				//   - 1radian = 180 / PI (도)
				//   - 1도 = PI / 180 (radian)
				// angle : 아크탄젠트로 얻은 각도 radian을 degree로 환산한 결과
				double radian = height > 0? Math.atan(width / height): 0;
				angle = (float) ((180.0 / Math.PI) * radian);
				
				// 목적구가 상하좌우로 일직선상에 위치했을 때 각도 입력
				if (whiteBall_x == targetBall_hx)
				{
					if (whiteBall_y < targetBall_hy)
					{
						angle = 0;
					}
					else
					{
						angle = 180;
					}
				}
				else if (whiteBall_y ==targetBall_hy)
				{
					if (whiteBall_x < targetBall_hx)
					{
						angle = 90;
					}
					else
					{
						angle = 270;
					}
				}
				
				// 목적구가 흰 공을 중심으로 2사분면에 위치했을 때 각도를 재계산
				if (whiteBall_x > targetBall_hx && whiteBall_y < targetBall_hy)
				{
					radian = Math.atan(width / height);
					angle = (float) (360 - ((180.0 / Math.PI) * radian));
				}
				
				// 목적구가 흰 공을 중심으로 3사분면에 위치했을 때 각도를 재계산
				else if (whiteBall_x > targetBall_hx && whiteBall_y > targetBall_hy)
				{
					radian = Math.atan(width / height);
					angle = (float) (((180.0 / Math.PI) * radian) + 180);
				}

				// 목적구가 흰 공을 중심으로 4사분면에 위치했을 때 각도를 재계산
				else if (whiteBall_x < targetBall_hx && whiteBall_y > targetBall_hy)
				{
					radian = Math.atan(height / width);
					angle = (float) (((180.0 / Math.PI) * radian) + 90);
				}
				
				// distance: 두 점(좌표) 사이의 거리를 계산
				double distance = Math.sqrt((width * width) + (height * height));

				// power: 거리 distance에 따른 힘의 세기를 계산
				power = (float) (distance + targetBall.distance_to_finalhole)/5;
				





				// 주어진 데이터(공의 좌표)를 활용하여 두 개의 값을 최종 결정하고 나면,
				// 나머지 코드에서 일타싸피로 값을 보내 자동으로 플레이를 진행하게 합니다.
				//   - angle: 흰 공을 때려서 보낼 방향(각도)
				//   - power: 흰 공을 때릴 힘의 세기
				// 
				// 이 때 주의할 점은 power는 100을 초과할 수 없으며,
				// power = 0인 경우 힘이 제로(0)이므로 아무런 반응이 나타나지 않습니다.
				//
				// 아래는 일타싸피와 통신하는 나머지 부분이므로 수정하면 안됩니다.
				//////////////////////////////

				String merged_data = angle + "/" + power + "/";
				bytes = merged_data.getBytes("UTF-8");
				os.write(bytes);
				os.flush();
				System.out.println("Data Sent: " + merged_data);
			}

			os.close();
			is.close();
			socket.close();
			System.out.println("Connection Closed.\n--------------------");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
