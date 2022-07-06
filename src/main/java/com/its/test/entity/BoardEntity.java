package com.its.test.entity;

import com.its.test.dto.BoardDTO;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "board_table2")
public class BoardEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "board_id")
    private Long boardId;

    @Column(name = "board_writer",length = 30, nullable = false)
    private String boardWriter;

    @Column(name = "board_title", length = 50, nullable = false)
    private String boardTitle;

    @Column(name = "board_contents", length = 500)
    private String boardContents;

    @Column(name = "board_hits")
    @ColumnDefault("0")
    private int boardHits;

    @CreationTimestamp
    @Column(name = "board_created_time",updatable = false)
    private LocalDateTime boardCreatedTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private MemberEntity memberEntity;

    public static BoardEntity toBoardSaveEntity(BoardDTO boardDTO,MemberEntity memberEntity){
        BoardEntity boardEntity = new BoardEntity();
        boardEntity.setBoardWriter(memberEntity.getMemberEmail());
        boardEntity.setBoardTitle(boardDTO.getBoardTitle());
        boardEntity.setBoardContents(boardDTO.getBoardContents());
        boardEntity.setMemberEntity(memberEntity);
        return boardEntity;
    }
}
