package com.its.test.controller;

import com.its.test.dto.BoardDTO;
import com.its.test.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    private final BoardService bs;
    @PostMapping("/save")
    public String save(@ModelAttribute BoardDTO boardDTO){
        bs.save(boardDTO);
        return "redirect:/board";
    }
    @GetMapping("/{boardId}")
    public String findById(@PathVariable("boardId") Long boardId,
                           Model model){
        BoardDTO boardDTO = bs.findById(boardId);
        model.addAttribute("boardDTO", boardDTO);
        return "/boardPages/detail";
    }
}
