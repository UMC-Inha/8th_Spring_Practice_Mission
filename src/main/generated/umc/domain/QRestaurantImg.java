package umc.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRestaurantImg is a Querydsl query type for RestaurantImg
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRestaurantImg extends EntityPathBase<RestaurantImg> {

    private static final long serialVersionUID = -1815470913L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRestaurantImg restaurantImg = new QRestaurantImg("restaurantImg");

    public final umc.domain.common.QBaseEntity _super = new umc.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imgUrl = createString("imgUrl");

    public final QRestaurant restaurant;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QRestaurantImg(String variable) {
        this(RestaurantImg.class, forVariable(variable), INITS);
    }

    public QRestaurantImg(Path<? extends RestaurantImg> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRestaurantImg(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRestaurantImg(PathMetadata metadata, PathInits inits) {
        this(RestaurantImg.class, metadata, inits);
    }

    public QRestaurantImg(Class<? extends RestaurantImg> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.restaurant = inits.isInitialized("restaurant") ? new QRestaurant(forProperty("restaurant"), inits.get("restaurant")) : null;
    }

}

