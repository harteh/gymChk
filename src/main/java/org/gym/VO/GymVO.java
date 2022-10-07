package org.gym.VO;

import lombok.Data;

@Data
public class GymVO {
	/**
	 * 시설ID, 정원, 체크인한 인원수,  누적인원수
	 */
	private int gym_id;
	private int maxMem;
	private int checkIn;
	private int sumMem;
}
