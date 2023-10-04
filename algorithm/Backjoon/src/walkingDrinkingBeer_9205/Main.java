package walkingDrinkingBeer_9205;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
	
	static class Location {
		int x;
		int y;
		public Location(int x, int y) {
			this.x = x;
			this.y = y;
		}
		public int calcDistance(Location other) {
			return Math.abs(this.x - other.x) + Math.abs(this.y - other.y);
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int T = Integer.parseInt(br.readLine());
		String[] coord = new String[2];
		Location home;
		Location festival;
		Location[] cs;
		boolean[] visit;
		boolean success;
		int n;
		for(int t = 0; t < T; t++) {
			n = Integer.parseInt(br.readLine());
			coord = br.readLine().split(" ");
			home = new Location(Integer.parseInt(coord[0]), Integer.parseInt(coord[1]));
			cs = new Location[n];
			visit = new boolean[n];
			success = false;
			for(int i = 0; i < n; i++) {
				coord = br.readLine().split(" ");
				cs[i] = new Location(Integer.parseInt(coord[0]), Integer.parseInt(coord[1]));
			}
			coord = br.readLine().split(" ");
			festival = new Location(Integer.parseInt(coord[0]), Integer.parseInt(coord[1]));
			if(home.calcDistance(festival) <= 1000) {
				success = true;
			} else {
				Queue<Location> csq = new ArrayDeque<>();
				csq.offer(home);
				while(!csq.isEmpty()) {
					Location now = csq.poll();
					for(int i = 0; i < n; i++) {
						if(!visit[i] && (now.calcDistance(cs[i]) <= 1000)) {
							if(cs[i].calcDistance(festival) <= 1000) {
								success = true;
								break;
							}
							visit[i] = true;
							csq.offer(cs[i]);
						}
					}
					if(success) break;
				}
			}
			sb.append(success?"happy":"sad").append("\n");
		}
		System.out.println(sb);
	}
}

