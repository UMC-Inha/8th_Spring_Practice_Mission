package umc.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QVisitPurpose is a Querydsl query type for VisitPurpose
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QVisitPurpose extends EntityPathBase<VisitPurpose> {

    private static final long serialVersionUID = 1891388602L;

    public static final QVisitPurpose visitPurpose1 = new QVisitPurpose("visitPurpose1");

    public final umc.domain.common.QBaseEntity _super = new umc.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final StringPath visitPurpose = createString("visitPurpose");

    public QVisitPurpose(String variable) {
        super(VisitPurpose.class, forVariable(variable));
    }

    public QVisitPurpose(Path<? extends VisitPurpose> path) {
        super(path.getType(), path.getMetadata());
    }

    public QVisitPurpose(PathMetadata metadata) {
        super(VisitPurpose.class, metadata);
    }

}

