package com.web.blog.service;

import com.web.blog.model.Board;
import com.web.blog.model.User;
import com.web.blog.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BoardService {

    @Autowired
    private BoardRepository boardRepository;

    @Transactional
    public void write(Board board, User user){
        board.setCount(0);
        board.setUser(user);
        boardRepository.save(board);
    }

    @Transactional(readOnly = true)
    public Page<Board> boardList(Pageable pageable) {
        return boardRepository.findAll(pageable);

    }

    @Transactional(readOnly = true)
    public Board findById(Long id) {
       return boardRepository.findById(id)
                .orElseThrow(() -> {
                    return new IllegalStateException("해당 게시글은 존재하지 않습니다. : " + id);
                });
    }
}
