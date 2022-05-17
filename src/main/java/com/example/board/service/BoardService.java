package com.example.board.service;

import com.example.board.entity.Board;
import com.example.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.UUID;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    //게시글 저장
    public void write(Board board, MultipartFile file) throws Exception{
        String projectPath = System.getProperty("user.dir") + "\\src\\main\\resources\\static\\files"; //저장 경로

        UUID uuid = UUID.randomUUID() ;// 식별자, 랜덤으로 이름 생성

        String fileName = uuid + "_"+file.getOriginalFilename(); //랜덤값 + 파일 원래 이름

        File saveFile = new File(projectPath, fileName); //파일 껍대기에 경로와 파일 이름 지정해준다.

        file.transferTo(saveFile);

        board.setFilename(fileName);
        board.setFilepath("/files/"+fileName); //static 이후부터

        boardRepository.save(board);
    }

    //게시글 리스트 출력
    public Page<Board> boardList(Pageable pageable){
        return boardRepository.findAll(pageable);
    }

    public Page<Board> boardSearch(String searchKeyword, Pageable pageable){
        return boardRepository.findByTitleContaining(searchKeyword, pageable);
    }

    //특정 게시글 불러오기
    public Board boardView(Integer id){
        return boardRepository.findById(id).get();
    }

    public void boardDelete(Integer id){
        boardRepository.deleteById(id);
    }
}
