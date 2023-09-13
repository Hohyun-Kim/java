import java.net.*;
import java.io.*;
import java.io.ObjectInputStream.GetField;

//  PT99990099
// SYNP-SIIR-ASCJ-FAET

public class SEOUL10_JAVA {

	// 닉네임을 사용자에 맞게 변경해 주세요.
	static final String NICKNAME = "A0010_1048688";

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

	public static void main(String[] args) {

		Socket socket = null;
		String recv_data = null;
		byte[] bytes = new byte[1024];
		float[][] balls = new float[NUMBER_OF_BALLS][2];
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
					order = (int) balls[0][1];
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
				// - order: 1인 경우 선공, 2인 경우 후공을 의미
				// - balls[][]: 일타싸피 정보를 수신해서 각 공의 좌표를 배열로 저장
				// 예) balls[0][0]: 흰 공의 X좌표
				// balls[0][1]: 흰 공의 Y좌표
				// balls[1][0]: 1번 공의 X좌표
				// balls[4][0]: 4번 공의 X좌표
				// balls[5][0]: 마지막 번호(8번) 공의 X좌표

				// 여기서부터 코드를 작성하세요.
				// 아래에 있는 것은 샘플로 작성된 코드이므로 자유롭게 변경할 수 있습니다.

				float[][] holes = { { 0, 0 }, { 127, 0 }, { 254, 0 }, { 0, 127 }, { 127, 127 }, { 254, 127 } };
				float r = (float) (5.73 / 2.0);

				float angle1, angle2, angle3, angle4;
				float a, b, c, d;

				float[] whiteBall = balls[0];
				float[] targetBall = balls[1];
				float[] targetHoll = holes[0];

				System.out.println("----GAME----");
				if(order == 1) {
					if(balls[1][0] != -1) {
						targetBall = balls[1];
						for(int i = 2; i < 6; i++) {
							if(i == 3)
								continue;
							float tmp1 = Math.abs(getAngle(whiteBall, balls[i]));
							float tmp2 = Math.abs(getAngle(whiteBall, targetBall));

							if(Math.abs(tmp1 - tmp2) < 7) {
								if(getDist(whiteBall, targetBall) >= getDist(whiteBall, balls[i]) ) {
									targetBall = balls[3];
									break;
								}
							}
						}
					}
					else if(balls[3][0] != -1)
						targetBall = balls[3];
					else
						targetBall = balls[5];
				}
				else if(order == 2) {
					if(balls[2][0] != -1) {
						targetBall = balls[2];
						for(int i = 1; i < 6; i++) {
							if(i == 2)
								continue;
							float tmp1 = Math.abs(getAngle(whiteBall, balls[i]));
							float tmp2 = Math.abs(getAngle(whiteBall, targetBall));

							if(Math.abs(tmp1 - tmp2) < 7) {
								if(getDist(whiteBall, targetBall) >= getDist(whiteBall, balls[i])) {
									targetBall = balls[4];
									break;
								}
							}
						}
					}
					else if(balls[4][0] != -1)
						targetBall = balls[4];
					else
						targetBall = balls[5];
				}

				angle4 = getAngle(whiteBall, targetBall);

				// target hole 설정
				float minGap = (float) 360.0;
				int holeIdx = 0;
				for (int i = 0; i < 6; i++) {
					float tmp = getAngle(whiteBall, holes[i]);
					float gap = Math.abs(tmp - angle4);
					if (minGap > gap) {
						minGap = gap;
						holeIdx = i;
					}
				}
				targetHoll = holes[holeIdx];

				// 값 계산
				a = getDist(targetBall, targetHoll);
				b = getDist(whiteBall, targetHoll);
				c = getDist(whiteBall, targetBall);

				angle1 = getAcosAngle(a, b, c);
				angle2 = getAcosAngle(c, a, b);
				d = (float) Math.sqrt(c * c + (2 * r) * (2 * r) - 2 * c * (2 * r) * getCos(angle1, angle2));
				angle3 = getAcosAngle(2 * r, c, d);
				angle4 = getAngle(whiteBall, targetBall); // 2번 선언
				
				if(angle1 == 0.0)
					angle = angle4;
				else {					
					if(getAngle(whiteBall, targetBall) > getAngle(whiteBall, targetHoll))
						angle = angle4 + angle3;
					else
						angle = angle4 - angle3;
				}
				
				
				System.out.println("DIST" + a+d);
				if(a + d > 150)
					power = 70;
				else if(a + d > 100)
					power = 50;
				else
					power = 30;

				// 주어진 데이터(공의 좌표)를 활용하여 두 개의 값을 최종 결정하고 나면,
				// 나머지 코드에서 일타싸피로 값을 보내 자동으로 플레이를 진행하게 합니다.
				// - angle: 흰 공을 때려서 보낼 방향(각도)
				// - power: 흰 공을 때릴 힘의 세기
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
	
	public static float getCos(float angle1, float angle2) {
		angle1 = (float) (angle1 * Math.PI / 180.0);
		angle2 = (float) (angle2 * Math.PI / 180.0);

		float cos = (float) Math.cos(angle1 + angle2);
		return cos;
	}

	public static float getAcosAngle(float a, float b, float c) {
		float angle = b * b + c * c - a * a;
		angle = (float) (angle / (2.0 * b * c));
		angle = (float) Math.acos(angle);
		angle = (float) (angle * (180.0 / Math.PI));
		return angle;
	}

	public static float getDist(float[] start, float[] end) {
		return (float) Math.sqrt(Math.pow(end[1] - start[1], 2) + Math.pow(end[0] - start[0], 2));
	}

	public static float getAngle(float[] white, float[] target) {
		float angle;

		angle = (float) Math.atan2(target[0] - white[0], target[1] - white[1]);
		angle = (float) (angle * (180.0 / Math.PI));
		return angle;
	}
}
