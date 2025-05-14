package umc.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRestaurantFood is a Querydsl query type for RestaurantFood
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRestaurantFood extends EntityPathBase<RestaurantFood> {

    private static final long serialVersionUID = -445110558L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRestaurantFood restaurantFood = new QRestaurantFood("restaurantFood");

    public final umc.domain.common.QBaseEntity _super = new umc.domain.common.QBaseEntity(this);

    public final NumberPath<Integer> cost = createNumber("cost", Integer.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath foodName = createString("foodName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final QRestaurant restaurant;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QRestaurantFood(String variable) {
        this(RestaurantFood.class, forVariable(variable), INITS);
    }

    public QRestaurantFood(Path<? extends RestaurantFood> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRestaurantFood(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRestaurantFood(PathMetadata metadata, PathInits inits) {
        this(RestaurantFood.class, metadata, inits);
    }

    public QRestaurantFood(Class<? extends RestaurantFood> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.restaurant = inits.isInitialized("restaurant") ? new QRestaurant(forProperty("restaurant"), inits.get("restaurant")) : null;
    }

}

