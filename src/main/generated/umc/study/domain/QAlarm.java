package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QAlarm is a Querydsl query type for Alarm
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QAlarm extends EntityPathBase<Alarm> {

    private static final long serialVersionUID = 1946320527L;

    public static final QAlarm alarm = new QAlarm("alarm");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    public final StringPath content = createString("content");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<umc.study.domain.mapping.UserAlarm, umc.study.domain.mapping.QUserAlarm> memberAlarmList = this.<umc.study.domain.mapping.UserAlarm, umc.study.domain.mapping.QUserAlarm>createList("memberAlarmList", umc.study.domain.mapping.UserAlarm.class, umc.study.domain.mapping.QUserAlarm.class, PathInits.DIRECT2);

    public final StringPath title = createString("title");

    public final EnumPath<umc.study.domain.enums.AlarmType> type = createEnum("type", umc.study.domain.enums.AlarmType.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QAlarm(String variable) {
        super(Alarm.class, forVariable(variable));
    }

    public QAlarm(Path<? extends Alarm> path) {
        super(path.getType(), path.getMetadata());
    }

    public QAlarm(PathMetadata metadata) {
        super(Alarm.class, metadata);
    }

}

