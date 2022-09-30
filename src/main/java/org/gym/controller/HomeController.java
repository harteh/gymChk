package org.gym.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.gym.VO.GymVO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		/* 
		logger.info("Welcome home! The client locale is {}.", locale);
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		*/
		
		logger.info("GYM Open!");
		
		
		return "home";
	}
	
	/**
	 * 정원을 입력받아 GymVO에 정원을 설정하고 페이지에 출력한다
	 * @param model
	 * @return page home, get to maxGym
	 */
	@PostMapping("/openProc")
	public String openProc(@RequestParam("maxUser") int maxUser, Model model) {
		logger.info("GYM 정원 설정 후 개장");
		GymVO gym = new GymVO();
		gym.setMaxMem(maxUser);
		
		String maxGym = Integer.toString(gym.getMaxMem());
		model.addAttribute("maxGym", maxGym);
		logger.info("최대인원 {}" ,maxGym);
		
		return "home";
	}

	@PostMapping("/closeProc")
	public String closeProc(Model model) {
		logger.info("GYM 문닫음");
		return "home";
	}
	
	
	@PostMapping("/addProc")
	public String addProc(Model model) {
		logger.info("현재 사용 인원 +1 명, 회원증 로그인");
		return "home";
	}
	
	
	@PostMapping("/minusProc")
	public String minusProc(Model model) {
		logger.info("현재 사용 인원 -1 명, 회원증 체크아웃");
		return "home";
	}
	
	
	
}
