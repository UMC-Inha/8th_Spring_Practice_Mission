package umc.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QCuisineType is a Querydsl query type for CuisineType
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QCuisineType extends EntityPathBase<CuisineType> {

    private static final long serialVersionUID = 1208198743L;

    public static final QCuisineType cuisineType1 = new QCuisineType("cuisineType1");

    public final umc.domain.common.QBaseEntity _super = new umc.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath cuisineType = createString("cuisineType");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QCuisineType(String variable) {
        super(CuisineType.class, forVariable(variable));
    }

    public QCuisineType(Path<? extends CuisineType> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCuisineType(PathMetadata metadata) {
        super(CuisineType.class, metadata);
    }

}

