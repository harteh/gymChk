package org.gym.service;

import org.gym.VO.GymVO;
import org.gym.mapper.GymMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
public class GymServiceImpl implements GymService {
	
	private final GymMapper mapper;
	
	@Override
	public void openGym(int maxUser) {
		// 최대인원 설정
		mapper.setMaxUser(maxUser);
	}

	@Override
	public int getMaxMem(GymVO gVO) {
		// 설정된 정원 수 반환
		return mapper.getMaxUser(gVO);
	}

	@Override
	public int addUser(GymVO gVO) {
		// 현재 사용인원 +1
		return 0;
	}

	@Override
	public GymVO minusUser(int minusUser) {
		// 현재 사용인원 -1
		return null;
	}



}
