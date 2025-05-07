package umc.domain.mapping;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserPreference is a Querydsl query type for UserPreference
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserPreference extends EntityPathBase<UserPreference> {

    private static final long serialVersionUID = 1538512589L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserPreference userPreference = new QUserPreference("userPreference");

    public final umc.domain.common.QBaseEntity _super = new umc.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final umc.domain.QCuisineType cuisineType;

    public final umc.domain.QPriceRange priceRange;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final umc.domain.QUser user;

    public final umc.domain.QVisitPurpose visitPurpose;

    public QUserPreference(String variable) {
        this(UserPreference.class, forVariable(variable), INITS);
    }

    public QUserPreference(Path<? extends UserPreference> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserPreference(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserPreference(PathMetadata metadata, PathInits inits) {
        this(UserPreference.class, metadata, inits);
    }

    public QUserPreference(Class<? extends UserPreference> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cuisineType = inits.isInitialized("cuisineType") ? new umc.domain.QCuisineType(forProperty("cuisineType")) : null;
        this.priceRange = inits.isInitialized("priceRange") ? new umc.domain.QPriceRange(forProperty("priceRange")) : null;
        this.user = inits.isInitialized("user") ? new umc.domain.QUser(forProperty("user"), inits.get("user")) : null;
        this.visitPurpose = inits.isInitialized("visitPurpose") ? new umc.domain.QVisitPurpose(forProperty("visitPurpose")) : null;
    }

}

