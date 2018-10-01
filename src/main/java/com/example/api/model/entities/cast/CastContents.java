package com.example.api.model.entities.cast;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.apache.ibatis.type.Alias;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@ToString
/*@NamedNativeQuery(
        name = "Person.methodNameInRepository",
        query = "SELECT id, post_id, board_id, description, title, thumbnail_path, hit_count, created_date_time FROM cast_contents",
        resultSetMapping = "personProfileMapper"
)
@SqlResultSetMapping(
        name = "personProfileMapper",
        classes = {@ConstructorResult(
                targetClass = CastContents.class,
                columns = {
                        @ColumnResult(name = "id"),
                        @ColumnResult(name = "post_id"),
                        @ColumnResult(name = "board_id"),
                        @ColumnResult(name = "description"),
                        @ColumnResult(name = "title"),
                        @ColumnResult(name = "thumbnail_path"),
                        @ColumnResult(name = "hit_count"),
                        @ColumnResult(name = "created_date_time")
                }
                )}
                )


@Table(name = "cast_contents")*/
@Alias("Cast")
public class CastContents {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private long postId;
    private long order_priority;

    private String boardId;

    private String description;

    private String title;

    private String thumbnailPath;

    private long hitCount;

    private LocalDateTime createdDateTime;

}
