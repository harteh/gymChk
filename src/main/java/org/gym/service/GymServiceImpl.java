package org.gym.service;

import org.gym.VO.GymVO;
import org.gym.controller.HomeController;
import org.gym.mapper.GymMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class GymServiceImpl implements GymService {
	
	private static final Logger logger = LoggerFactory.getLogger(GymServiceImpl.class);
	
	private final GymMapper mapper;

	
	@Override
	public void openGym(int maxUser) {
		// 최대인원 설정
		logger.info("service: open, max:"+ maxUser);
		mapper.setMaxUser(maxUser);
	}


	@Override
	public int addUser(GymVO gVO) {
		// 현재 사용인원 +1
		return mapper.getMaxUser(gVO);
	}

	@Override
	public GymVO minusUser(int minusUser) {
		// 현재 사용인원 -1
		return null;
	}


	

}
