package biz.mike_neko.bulletinboard.controller;

import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import biz.mike_neko.bulletinboard.repository.BoardData;
import biz.mike_neko.bulletinboard.repository.BoardRepository;
import lombok.AllArgsConstructor;

@Controller
@AllArgsConstructor
public class BoardController {

	private final BoardRepository repo;
	
	@GetMapping("/")
	public String getContents(Model model) {
		List<BoardData> dataList = repo.findAll();
		model.addAttribute("dataList", dataList);
		return "index";
	}
	
	@PostMapping("/")
	public String postContents(@RequestParam String handle_name,
			@RequestParam String email,
			@RequestParam String contents,
			Model model) {
		BoardData bd = new BoardData();
		bd.setHandle_name(handle_name);
		bd.setEmail(email);
		bd.setContents(contents);
		bd.setCreate_time(new Date());
		repo.saveAndFlush(bd);
		return "redirect:/";
	}
	
}
