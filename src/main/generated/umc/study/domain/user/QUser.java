package umc.study.domain.user;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = 1607133580L;

    public static final QUser user = new QUser("user");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final DatePath<java.time.LocalDate> birth = createDate("birth", java.time.LocalDate.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<umc.study.domain.enums.Gender> gender = createEnum("gender", umc.study.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final ListPath<umc.study.domain.inquiry.Inquiry, umc.study.domain.inquiry.QInquiry> inquiries = this.<umc.study.domain.inquiry.Inquiry, umc.study.domain.inquiry.QInquiry>createList("inquiries", umc.study.domain.inquiry.Inquiry.class, umc.study.domain.inquiry.QInquiry.class, PathInits.DIRECT2);

    public final NumberPath<Integer> missionCompleted = createNumber("missionCompleted", Integer.class);

    public final StringPath name = createString("name");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final ListPath<umc.study.domain.review.Review, umc.study.domain.review.QReview> reviews = this.<umc.study.domain.review.Review, umc.study.domain.review.QReview>createList("reviews", umc.study.domain.review.Review.class, umc.study.domain.review.QReview.class, PathInits.DIRECT2);

    public final EnumPath<umc.study.domain.enums.UserStatus> status = createEnum("status", umc.study.domain.enums.UserStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final ListPath<umc.study.domain.mapping.UserMission, umc.study.domain.mapping.QUserMission> userMissions = this.<umc.study.domain.mapping.UserMission, umc.study.domain.mapping.QUserMission>createList("userMissions", umc.study.domain.mapping.UserMission.class, umc.study.domain.mapping.QUserMission.class, PathInits.DIRECT2);

    public final ListPath<umc.study.domain.mapping.UserNotification, umc.study.domain.mapping.QUserNotification> userNotifications = this.<umc.study.domain.mapping.UserNotification, umc.study.domain.mapping.QUserNotification>createList("userNotifications", umc.study.domain.mapping.UserNotification.class, umc.study.domain.mapping.QUserNotification.class, PathInits.DIRECT2);

    public QUser(String variable) {
        super(User.class, forVariable(variable));
    }

    public QUser(Path<? extends User> path) {
        super(path.getType(), path.getMetadata());
    }

    public QUser(PathMetadata metadata) {
        super(User.class, metadata);
    }

}

