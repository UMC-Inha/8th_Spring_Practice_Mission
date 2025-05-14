package umc.study.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFoodPrefer is a Querydsl query type for FoodPrefer
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QFoodPrefer extends EntityPathBase<FoodPrefer> {

    private static final long serialVersionUID = -257100368L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFoodPrefer foodPrefer = new QFoodPrefer("foodPrefer");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final umc.study.domain.QFoodCategory foodCategory;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final umc.study.domain.QUser user;

    public QFoodPrefer(String variable) {
        this(FoodPrefer.class, forVariable(variable), INITS);
    }

    public QFoodPrefer(Path<? extends FoodPrefer> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QFoodPrefer(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QFoodPrefer(PathMetadata metadata, PathInits inits) {
        this(FoodPrefer.class, metadata, inits);
    }

    public QFoodPrefer(Class<? extends FoodPrefer> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.foodCategory = inits.isInitialized("foodCategory") ? new umc.study.domain.QFoodCategory(forProperty("foodCategory")) : null;
        this.user = inits.isInitialized("user") ? new umc.study.domain.QUser(forProperty("user")) : null;
    }

}

