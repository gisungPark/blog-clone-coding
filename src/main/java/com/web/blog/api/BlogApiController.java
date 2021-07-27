package com.web.blog.api;


import com.web.blog.config.auth.PrincipalDetail;
import com.web.blog.dto.ResponseDto;
import com.web.blog.model.Board;
import com.web.blog.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

@RestController
public class BlogApiController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/api/board")
    public ResponseDto<Integer> save(@RequestBody Board board, @AuthenticationPrincipal PrincipalDetail principal){

        boardService.write(board, principal.getUser());
        return new ResponseDto<Integer>(HttpStatus.OK.value(), 1);
    }

    @GetMapping("/api/board/list")
    public ResponseDto<Page<Board>> boardList(@PageableDefault(size = 2, sort = "id", direction = Sort.Direction.DESC) Pageable pageable){
        Page<Board> boards = boardService.boardList(pageable);
        return new ResponseDto<Page<Board>>(HttpStatus.OK.value(), boards);
    }




}
