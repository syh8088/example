package com.example.api.repositories.board;

import com.example.api.model.entities.board.Board;
import com.example.api.model.entities.board.QBoard;
import org.springframework.data.jpa.repository.support.QueryDslRepositorySupport;

public class BoardRepositoryImpl extends QueryDslRepositorySupport implements BoardRepositoryCustom {

    QBoard board = QBoard.board;


    /**
     * Creates a new {@link QuerydslRepositorySupport} instance for the given domain type.
     *
     * @param //domainClass must not be {@literal null}.
     */

    public BoardRepositoryImpl() {
        super(Board.class);
    }

    @Override
    public Board getBoardById(String id) {
        return from(board)
                .where(board.boardId.eq(id))
                .fetchOne();
    }
}

