package umc.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QPriceRange is a Querydsl query type for PriceRange
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QPriceRange extends EntityPathBase<PriceRange> {

    private static final long serialVersionUID = 1728129691L;

    public static final QPriceRange priceRange1 = new QPriceRange("priceRange1");

    public final umc.domain.common.QBaseEntity _super = new umc.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath priceRange = createString("priceRange");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QPriceRange(String variable) {
        super(PriceRange.class, forVariable(variable));
    }

    public QPriceRange(Path<? extends PriceRange> path) {
        super(path.getType(), path.getMetadata());
    }

    public QPriceRange(PathMetadata metadata) {
        super(PriceRange.class, metadata);
    }

}

