package com.example.api.model.entities.board;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Alias("Board")
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Board {

    @Id
    private String boardId;

    private String groupId;

    private String subject;

    private Integer listLevel;

    private Integer readLevel;

    private Integer writeLevel;
    private Integer replyLevel;
    private Integer commentLevel;
    private Integer uploadLevel;
    private Integer countDelete;
    private Integer countModify;
    private Integer useSecret;
    private Integer useGood;
    private Integer useNogood;

    private long pageRows;

    private long writeMin;
    private long writeMax;
    private long writePoint;
    private long commentMin;
    private long commentMax;

    private Integer limitWrite;

    private long maxStrlenComment;

    @Column(columnDefinition = "enum('ALWAYS','SOMETIMES','NEVER')")
    @Enumerated(EnumType.STRING)
    private CommentAllowed commentAllowed;

    private boolean isWriteAuth;
    private boolean isCommentAuth;

    public enum CommentAllowed {
        ALWAYS("ALWAYS"), SOMETIMES("SOMETIMES"), NEVER("NEVER");

        private String value;

        CommentAllowed(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }

    }


}
