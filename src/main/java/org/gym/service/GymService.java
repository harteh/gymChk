package org.gym.service;

import org.gym.VO.GymVO;
import org.springframework.stereotype.Service;


public interface GymService {
	
	/**
	 * 정원 설정
	 * 개장 시 최대인원 설정
	 * (컨트롤버튼: Open 클릭 시 동작) 
	 * 한번에 사용가능한 최대인원 설정 
	 * @param maxUser
	 */
	void openGym(int maxUser);
	
	/**
	 * 정원 조회
	 * 설정 된 정원 수를 반환받는다
	 * @param gVO
	 * @return int maxMem
	 */
	int getMaxMem(GymVO gVO);
	
	//누적인원수 조회
	int getSumUser(GymVO gVO);
	//현재인원수 조회
	int getCheckInUser(GymVO gVO);
	
	
	//누적 인원수 증가
	void sumUser(GymVO gVO);
	/**
	 * 회원이 회원증을 찍고 입실하면
	 * (컨트롤버튼: Check-in 클릭 시 동작) 
	 * 현재 사용인원이 1명 늘어난다
	 * 범위: ~ 최대인원(maxUser)명
	 * @param plusUser
	 * @return
	 */
	void addUser(GymVO gVO);

	/**
	 * 회원이 회원증을 찍고 퇴실하면
	 * (컨트롤버튼: CheckOut 클릭 시 동작) 
	 * 현재 사용인원이 1명 줄어든다
	 * @param minusUser
	 * @return
	 */
	void minusUser(GymVO gVO);

}
