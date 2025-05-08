package umc.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 842294081L;

    public static final QMember member = new QMember("member1");

    public final umc.domain.common.QBaseEntity _super = new umc.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final StringPath birth = createString("birth");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final EnumPath<umc.domain.enums.Gender> gender = createEnum("gender", umc.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DateTimePath<java.time.LocalDateTime> inactiveAt = createDateTime("inactiveAt", java.time.LocalDateTime.class);

    public final BooleanPath isPhone = createBoolean("isPhone");

    public final EnumPath<umc.domain.enums.LoginType> loginType = createEnum("loginType", umc.domain.enums.LoginType.class);

    public final StringPath mail = createString("mail");

    public final NumberPath<Integer> missionComplete = createNumber("missionComplete", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath phoneNum = createString("phoneNum");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final BooleanPath status = createBoolean("status");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

