package com.example.board.repository;

import com.example.board.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Integer> {
    //JPA Repository
    //Title에 포함된 모든 데이터를 검색, findBy(컬럼이름)Containing
    //Title에 기워드가 일치하는 것을 검색,  findBy(컬럼이름)

    Page<Board> findByTitleContaining(String searchKeyword, Pageable pageable);
}
