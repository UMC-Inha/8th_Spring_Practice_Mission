package umc.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPreferCategory is a Querydsl query type for PreferCategory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPreferCategory extends EntityPathBase<PreferCategory> {

    private static final long serialVersionUID = 1470437109L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPreferCategory preferCategory = new QPreferCategory("preferCategory");

    public final umc.domain.common.QBaseEntity _super = new umc.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final umc.domain.QFoodCategory foodCategory;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final umc.domain.QMember member;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QPreferCategory(String variable) {
        this(PreferCategory.class, forVariable(variable), INITS);
    }

    public QPreferCategory(Path<? extends PreferCategory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPreferCategory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPreferCategory(PathMetadata metadata, PathInits inits) {
        this(PreferCategory.class, metadata, inits);
    }

    public QPreferCategory(Class<? extends PreferCategory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.foodCategory = inits.isInitialized("foodCategory") ? new umc.domain.QFoodCategory(forProperty("foodCategory")) : null;
        this.member = inits.isInitialized("member") ? new umc.domain.QMember(forProperty("member")) : null;
    }

}

