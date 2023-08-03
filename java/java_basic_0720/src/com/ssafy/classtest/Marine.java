package com.ssafy.classtest;

//1. 속성
//	체력	int hp (기본 체력 : 100)
//	모드	int mode (0 : 일반모드, 1 : 흥분모드)
//2. 기능
//	공격	? attck([?]) >> 1회 공격시 일반모드일 경우 상대방 체력 - 10
//										흥분모드일 경우 상대방 체력 - 15 
//	모드변경 void changeMode() ( 0 --> 1 변경) 자신의 체력 - 25
//												자신의 체력이 40이하일 경우 모드 변경 불가능
public class Marine {

	int hp;
	int mode;
	int power;
	
	public Marine() {
		hp = 100;
		power = 10;
	}
	
	void attack(Marine enemy, int cnt) {
		for(int i=0;i<cnt;i++)
			enemy.hp -= power;
	}
	
	public void changeMode() {
		if(hp > 40) {
			mode = 1;
			hp -= 25;
			power = 15;
		} else {
			System.out.println("체력이 40이하일 경우 모드 변경 불가!!!");
		}
	}
	
	String getStatus() {
//		int >> String
//		hp + ""
//		String.valueOf(hp);
//		Integer.toString(hp);
		return hp <= 0 ? "die" : hp + "";
	}
	
}
