package umc.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QOpenHours is a Querydsl query type for OpenHours
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QOpenHours extends EntityPathBase<OpenHours> {

    private static final long serialVersionUID = 1766858974L;

    public static final QOpenHours openHours = new QOpenHours("openHours");

    public final umc.domain.common.QBaseEntity _super = new umc.domain.common.QBaseEntity(this);

    public final StringPath breakTime = createString("breakTime");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final EnumPath<umc.domain.enums.DayOfWeek> dayOfWeek = createEnum("dayOfWeek", umc.domain.enums.DayOfWeek.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath totalRunningTime = createString("totalRunningTime");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QOpenHours(String variable) {
        super(OpenHours.class, forVariable(variable));
    }

    public QOpenHours(Path<? extends OpenHours> path) {
        super(path.getType(), path.getMetadata());
    }

    public QOpenHours(PathMetadata metadata) {
        super(OpenHours.class, metadata);
    }

}

