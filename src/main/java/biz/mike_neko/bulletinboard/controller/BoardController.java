package biz.mike_neko.bulletinboard.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import biz.mike_neko.bulletinboard.form.MainFormData;
import biz.mike_neko.bulletinboard.repository.BoardData;
import biz.mike_neko.bulletinboard.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Sort;

@Controller
@AllArgsConstructor
public class BoardController {

	private final BoardRepository repo;
	
	@GetMapping("/")
	public String getContents(Model model) {
		List<BoardData> dataList = repo.findAllByOrderByIdDesc();
		model.addAttribute("dataList", dataList);
		return "index";
	}
	
	@PostMapping("/")
	public String postContents(@ModelAttribute @Validated MainFormData mainFormData, BindingResult result, Model model) {
		BoardData bd = new BoardData();
		bd.setHandle_name(mainFormData.getHandle_name());
		bd.setEmail(mainFormData.getEmail());
		bd.setContents(mainFormData.getContents());
		bd.setCreate_time(new Date());
		
		if(!result.hasErrors()) {
			repo.saveAndFlush(bd);
		}else {
			List<String> list = new ArrayList<String>();
			for(ObjectError e: result.getAllErrors()) {
				list.add(e.getDefaultMessage());
			}
			model.addAttribute("errorData", list);
			return getContents(model);
		}
		return "redirect:/";
	}
	
}
