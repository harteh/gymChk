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
	
	/**
	 * 첫화면: 누적 이용자수 출력
	 * @param model
	 * @param gVO
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, GymVO gVO) {
		logger.info("Open page!");
		
		//누적 이용자 출력
		int sumUser = service.getSumUser(gVO);
		model.addAttribute("sumUser", sumUser);
		
		return "home";
	}
	
	/**
	 * 정원을 입력받아 GymVO에 정원을 설정하고
	 * 정원, 누적이용자수, 현재시간 출력
	 * open/close 같이 사용
	 * @param model
	 * @return page home, get to maxGym
	 */
	@PostMapping("/openProc")
	public String openProc(@RequestParam("maxUser") int maxUser, Model model, GymVO gVO, Locale locale) {
		
		logger.info("GYM 정원 설정 후 개장");
		service.openGym(maxUser);
		
		int maxGym = service.getMaxMem(gVO);	//시설 정원 출력
		model.addAttribute("maxGym", maxGym);
		
		int sumUser = service.getSumUser(gVO);	//누적 이용자 수
		model.addAttribute("sumUser", sumUser);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}

	/**
	 * 회원이 회원카드를 찍고 입실
	 * 현재 인원 수, 누적 인원 수 증가
	 * 현재 인원 수, 누적 인원 수, 시설 정원 조회
	 * 정원, 누적이용자수, 현재시간,  현재 이용자 수 출력
	 * @param model
	 * @param gVO
	 * @return
	 */
	@PostMapping("/addProc")
	public String addProc(Model model, GymVO gVO, Locale locale) {
		logger.info("현재 사용 인원 +1 명, 회원증 로그인");
		
		service.addUser(gVO);
		service.sumUser(gVO);
		
		int sumUser = service.getSumUser(gVO);		//누적 이용자 수
		model.addAttribute("sumUser", sumUser);
		int maxGym = service.getMaxMem(gVO);		//시설 정원
		model.addAttribute("maxGym", maxGym);

		int nowUser = service.getCheckInUser(gVO);	//현재 이용자 수
		model.addAttribute("nowUser", nowUser);
		
		int chkNum;
		int loopNum;
		if(maxGym>9) {
			chkNum = maxGym/10;
			loopNum = nowUser/chkNum;
		} else {
			chkNum = maxGym;		//체크용 수
			loopNum = nowUser;
		}
		model.addAttribute("chkNum", chkNum);
		model.addAttribute("loopNum", loopNum);
		
		logger.info(sumUser+"||"+maxGym+"|"+nowUser+"||"+chkNum+","+loopNum);
		 
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
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
	public String minusProc(Model model, GymVO gVO, Locale locale) {
		logger.info("현재 사용 인원 -1 명, 회원증 체크아웃");
		
		service.minusUser(gVO);

		int sumUser = service.getSumUser(gVO);		//누적 이용자 수
		model.addAttribute("sumUser", sumUser);
		int maxGym = service.getMaxMem(gVO);		//시설 정원
		model.addAttribute("maxGym", maxGym);
		
		int nowUser = service.getCheckInUser(gVO);	//현재 이용자 수
		model.addAttribute("nowUser", nowUser);
		
		int chkNum;
		int loopNum;
		if(maxGym>9) {
			chkNum = maxGym/10;
			loopNum = nowUser/chkNum;
		} else {
			chkNum = maxGym;		//체크용 수
			loopNum = nowUser;
		}
		model.addAttribute("chkNum", chkNum);
		model.addAttribute("loopNum", loopNum);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );

		return "home";
	}
	
	
	
}
