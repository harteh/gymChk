package org.gym.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.gym.VO.GymVO;
import org.gym.service.GymService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private GymService service;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		logger.info("Open page!");
		return "home";
	}
	
	/**
	 * 정원을 입력받아 GymVO에 정원을 설정하고 페이지에 출력한다
	 * open/close 같이 사용
	 * @param model
	 * @return page home, get to maxGym
	 */
	@PostMapping("/openProc")
	public String openProc(@RequestParam("maxUser") int maxUser, Model model, GymVO gVO, Locale locale) {
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		logger.info("GYM 정원 설정 후 개장");
		service.openGym(maxUser);
		
		int maxGym = service.getMaxMem(gVO);
		logger.info("정원 조회: " + maxGym);
		model.addAttribute("maxGym", maxGym);
		return "home";
	}

	/**
	 * 회원이 회원카드를 찍고 입실
	 * 현재 인원 수, 누적 인원 수 증가
	 * 현재 인원 수, 누적 인원 수, 시설 정원 조회
	 * 
	 * @param model
	 * @param gVO
	 * @return
	 */
	@PostMapping("/addProc")
	public String addProc(Model model, GymVO gVO) {
		logger.info("현재 사용 인원 +1 명, 회원증 로그인");
		
		service.addUser(gVO);
		service.sumUser(gVO);
		int nowUser = service.getCheckInUser(gVO);	//현재 이용자 수
		int sumUser = service.getSumUser(gVO);		//누적 이용자 수
		int maxGym = service.getMaxMem(gVO);		//시설 정원
		
		model.addAttribute("nowUser", nowUser);
		model.addAttribute("sumUser", sumUser);
		model.addAttribute("maxGym", maxGym);
		
		return "home";
	}
	
	/**
	 * 회원: 회원카드를 찍고 퇴실
	 * 현재 인원 수 감소
	 * 현재 인원 수, 누적 인원 수, 시설 정원 조회
	 * 
	 * @param model
	 * @param gVO
	 * @return
	 */
	@PostMapping("/minusProc")
	public String minusProc(Model model, GymVO gVO) {
		logger.info("현재 사용 인원 -1 명, 회원증 체크아웃");
		
		service.minusUser(gVO);
		int nowUser = service.getCheckInUser(gVO);	//현재 이용자 수
		int sumUser = service.getSumUser(gVO);		//누적 이용자 수
		int maxGym = service.getMaxMem(gVO);		//시설 정원
		
		model.addAttribute("nowUser", nowUser);
		model.addAttribute("sumUser", sumUser);
		model.addAttribute("maxGym", maxGym);		
		return "home";
	}
	
	
	
}
