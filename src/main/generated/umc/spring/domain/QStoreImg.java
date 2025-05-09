package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QStoreImg is a Querydsl query type for StoreImg
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QStoreImg extends EntityPathBase<StoreImg> {

    private static final long serialVersionUID = 1751892942L;

    public static final QStoreImg storeImg = new QStoreImg("storeImg");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imgUrl = createString("imgUrl");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QStoreImg(String variable) {
        super(StoreImg.class, forVariable(variable));
    }

    public QStoreImg(Path<? extends StoreImg> path) {
        super(path.getType(), path.getMetadata());
    }

    public QStoreImg(PathMetadata metadata) {
        super(StoreImg.class, metadata);
    }

}

