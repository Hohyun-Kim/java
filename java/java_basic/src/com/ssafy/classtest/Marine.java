package com.ssafy.classtest;

//1. 속성
//	체력	int hp
//	모드	int mode(0: 일반모드, 1: 흥분모드)
//2. 기능
//	공격	? attack([?]) >> 1회 공격시 일반모드일 경우 상대방 체력 -10
//										흥분모드일 경우 상대방 체력 -15
//	모드변경 void changeMode( 0 --> 1 변경) 자신의 체력 -25
//											자신의 체력이 40이하일 경우 모드 변경 불가능
	
public class Marine {
	
	int h;
	int mode;
	int power;
	
	public Marine() {
		h = 100;
		mode = 0;
		power = 10;
	}
	
	void attack(Marine enemy, int cnt) {
		for (int i = 0; i < cnt; i++) {
			enemy.h -= this.power;
		}
		if (enemy.h <= 0) {
			enemy.h = 0;
		}
	}
	
	public void changeMode() {
		this.mode = 1;
		h -= h<=40? 0:25;
		this.power = 15;
	}
	
	String Info() {
		return h==0? "die":h+"";
	}

}
