package umc.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQnaImg is a Querydsl query type for QnaImg
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QQnaImg extends EntityPathBase<QnaImg> {

    private static final long serialVersionUID = 964741094L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QQnaImg qnaImg = new QQnaImg("qnaImg");

    public final umc.domain.common.QBaseEntity _super = new umc.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imgUrl = createString("imgUrl");

    public final QQna qna;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QQnaImg(String variable) {
        this(QnaImg.class, forVariable(variable), INITS);
    }

    public QQnaImg(Path<? extends QnaImg> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QQnaImg(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QQnaImg(PathMetadata metadata, PathInits inits) {
        this(QnaImg.class, metadata, inits);
    }

    public QQnaImg(Class<? extends QnaImg> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.qna = inits.isInitialized("qna") ? new QQna(forProperty("qna"), inits.get("qna")) : null;
    }

}

