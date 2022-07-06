package com.its.test;

import com.its.test.dto.BoardDTO;
import com.its.test.dto.MemberDTO;
import com.its.test.service.BoardService;
import com.its.test.service.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.*;

@SpringBootTest
public class TestClass {
    @Autowired
    private MemberService memberService;
    @Autowired
    private BoardService boardService;

    @Test
    @Transactional
    @DisplayName("save 테스트")
    public void saveTest(){
        String testTitle = "testTitle1";
        String testWriter = "testWriter1";
        String testContents = "testContents1";
        MemberDTO memberDTO = new MemberDTO(testWriter,"testPassword","testName");
        System.out.println(memberDTO);
        memberService.save(memberDTO);
        BoardDTO boardDTO = new BoardDTO(testTitle,testWriter,testContents);
        Long id = boardService.save(boardDTO);
        BoardDTO resultDTO = boardService.findById(id);
        assertThat(resultDTO.getBoardWriter()).isEqualTo(testWriter);
    }
}
