package org.gym.mapper;

import org.gym.VO.GymVO;

public interface GymMapper {

	//정원 설정
	public void setMaxUser(int maxUser);
	
	//정원 조회
	public int getMaxUser(GymVO gVO);
	//누적 이용자 수 조회
	public int getSumUser(GymVO gVO);
	//현재 이용자 수 조회
	public int getCheckInUser(GymVO gVO);
	
	
	//누적인원수 증가
	public void addSum(GymVO gVO);
	//인원수 증가
	public void addUser(GymVO gVO);
	//인원수 감소
	public void minusUser(GymVO gVO);

}
