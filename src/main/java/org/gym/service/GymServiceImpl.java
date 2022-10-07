package org.gym.service;

import org.gym.VO.GymVO;
import org.gym.mapper.GymMapper;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GymServiceImpl implements GymService {
	
	private final GymMapper mapper;
	
	@Override
	public void openGym(int maxUser) {
		// 최대인원 설정 - 정원 설정
		mapper.setMaxUser(maxUser);
	}

	@Override
	public int getMaxMem(GymVO gVO) {
		// 설정된 정원 수 반환 - 정원 조회
		return mapper.getMaxUser(gVO);
	}
	
	@Override
	public int getSumUser(GymVO gVO) {
		// 누적 이용자 수 조회
		return mapper.getSumUser(gVO);
	}


	@Override
	public int getCheckInUser(GymVO gVO) {
		// 현재 이용자 수 조회
		return mapper.getCheckInUser(gVO);
	}

	@Override
	public void sumUser(GymVO gVO) {
		// 누적 이용자 수 증가
		mapper.addSum(gVO);
	}

	@Override
	public void addUser(GymVO gVO) {
		// 현재 이용자 수 증가
		mapper.addUser(gVO);
	}

	@Override
	public void minusUser(GymVO gVO) {
		// 현재 이용자 수 감소
		mapper.minusUser(gVO);
	}



}
