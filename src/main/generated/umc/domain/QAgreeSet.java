package umc.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAgreeSet is a Querydsl query type for AgreeSet
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAgreeSet extends EntityPathBase<AgreeSet> {

    private static final long serialVersionUID = 177802493L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QAgreeSet agreeSet = new QAgreeSet("agreeSet");

    public final umc.domain.common.QBaseEntity _super = new umc.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isLocation = createBoolean("isLocation");

    public final BooleanPath isMarketing = createBoolean("isMarketing");

    public final BooleanPath isNewEvent = createBoolean("isNewEvent");

    public final BooleanPath isQna = createBoolean("isQna");

    public final BooleanPath isReview = createBoolean("isReview");

    public final QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QAgreeSet(String variable) {
        this(AgreeSet.class, forVariable(variable), INITS);
    }

    public QAgreeSet(Path<? extends AgreeSet> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QAgreeSet(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QAgreeSet(PathMetadata metadata, PathInits inits) {
        this(AgreeSet.class, metadata, inits);
    }

    public QAgreeSet(Class<? extends AgreeSet> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
    }

}

