package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFoodCategory is a Querydsl query type for FoodCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFoodCategory extends EntityPathBase<FoodCategory> {

    private static final long serialVersionUID = 839207294L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFoodCategory foodCategory = new QFoodCategory("foodCategory");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final ListPath<umc.study.domain.mapping.UserPrefer, umc.study.domain.mapping.QUserPrefer> foodPreferenceList = this.<umc.study.domain.mapping.UserPrefer, umc.study.domain.mapping.QUserPrefer>createList("foodPreferenceList", umc.study.domain.mapping.UserPrefer.class, umc.study.domain.mapping.QUserPrefer.class, PathInits.DIRECT2);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<Mission, QMission> missionList = this.<Mission, QMission>createList("missionList", Mission.class, QMission.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final QStore store;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QFoodCategory(String variable) {
        this(FoodCategory.class, forVariable(variable), INITS);
    }

    public QFoodCategory(Path<? extends FoodCategory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFoodCategory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFoodCategory(PathMetadata metadata, PathInits inits) {
        this(FoodCategory.class, metadata, inits);
    }

    public QFoodCategory(Class<? extends FoodCategory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.store = inits.isInitialized("store") ? new QStore(forProperty("store"), inits.get("store")) : null;
    }

}

