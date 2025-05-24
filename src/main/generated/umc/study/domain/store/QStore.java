package umc.study.domain.store;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QStore is a Querydsl query type for Store
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStore extends EntityPathBase<Store> {

    private static final long serialVersionUID = 1192277842L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QStore store = new QStore("store");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final NumberPath<java.math.BigDecimal> averageRate = createNumber("averageRate", java.math.BigDecimal.class);

    public final QFoodCategory category;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<umc.study.domain.mission.Mission, umc.study.domain.mission.QMission> missions = this.<umc.study.domain.mission.Mission, umc.study.domain.mission.QMission>createList("missions", umc.study.domain.mission.Mission.class, umc.study.domain.mission.QMission.class, PathInits.DIRECT2);

    public final QRegion region;

    public final ListPath<umc.study.domain.review.Review, umc.study.domain.review.QReview> reviews = this.<umc.study.domain.review.Review, umc.study.domain.review.QReview>createList("reviews", umc.study.domain.review.Review.class, umc.study.domain.review.QReview.class, PathInits.DIRECT2);

    public final StringPath storeName = createString("storeName");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QStore(String variable) {
        this(Store.class, forVariable(variable), INITS);
    }

    public QStore(Path<? extends Store> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QStore(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QStore(PathMetadata metadata, PathInits inits) {
        this(Store.class, metadata, inits);
    }

    public QStore(Class<? extends Store> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.category = inits.isInitialized("category") ? new QFoodCategory(forProperty("category")) : null;
        this.region = inits.isInitialized("region") ? new QRegion(forProperty("region")) : null;
    }

}

