package umc.spring.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPreferFoodCategory is a Querydsl query type for PreferFoodCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPreferFoodCategory extends EntityPathBase<PreferFoodCategory> {

    private static final long serialVersionUID = 101283960L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPreferFoodCategory preferFoodCategory = new QPreferFoodCategory("preferFoodCategory");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final umc.spring.domain.QFoodCategory foodCategory;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final umc.spring.domain.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QPreferFoodCategory(String variable) {
        this(PreferFoodCategory.class, forVariable(variable), INITS);
    }

    public QPreferFoodCategory(Path<? extends PreferFoodCategory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPreferFoodCategory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPreferFoodCategory(PathMetadata metadata, PathInits inits) {
        this(PreferFoodCategory.class, metadata, inits);
    }

    public QPreferFoodCategory(Class<? extends PreferFoodCategory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.foodCategory = inits.isInitialized("foodCategory") ? new umc.spring.domain.QFoodCategory(forProperty("foodCategory")) : null;
        this.member = inits.isInitialized("member") ? new umc.spring.domain.QMember(forProperty("member")) : null;
    }

}

