package umc.study.domain;

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

    private static final long serialVersionUID = 479029197L;

    public static final QUser user = new QUser("user");

    public final umc.study.domain.common.QBaseEntity _super = new umc.study.domain.common.QBaseEntity(this);

    public final StringPath address = createString("address");

    public final StringPath birth = createString("birth");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final StringPath email = createString("email");

    public final EnumPath<umc.study.domain.enums.Gender> gender = createEnum("gender", umc.study.domain.enums.Gender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final DatePath<java.time.LocalDate> inactiveDate = createDate("inactiveDate", java.time.LocalDate.class);

    public final ListPath<Inquiry, QInquiry> inquiryList = this.<Inquiry, QInquiry>createList("inquiryList", Inquiry.class, QInquiry.class, PathInits.DIRECT2);

    public final ListPath<umc.study.domain.mapping.UserAlarm, umc.study.domain.mapping.QUserAlarm> memberAlarmList = this.<umc.study.domain.mapping.UserAlarm, umc.study.domain.mapping.QUserAlarm>createList("memberAlarmList", umc.study.domain.mapping.UserAlarm.class, umc.study.domain.mapping.QUserAlarm.class, PathInits.DIRECT2);

    public final StringPath name = createString("name");

    public final StringPath phoneNumber = createString("phoneNumber");

    public final NumberPath<Integer> point = createNumber("point", Integer.class);

    public final ListPath<Review, QReview> reviewList = this.<Review, QReview>createList("reviewList", Review.class, QReview.class, PathInits.DIRECT2);

    public final EnumPath<umc.study.domain.enums.UserStatus> status = createEnum("status", umc.study.domain.enums.UserStatus.class);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public final ListPath<umc.study.domain.mapping.UserMission, umc.study.domain.mapping.QUserMission> useerMissionList = this.<umc.study.domain.mapping.UserMission, umc.study.domain.mapping.QUserMission>createList("useerMissionList", umc.study.domain.mapping.UserMission.class, umc.study.domain.mapping.QUserMission.class, PathInits.DIRECT2);

    public final ListPath<umc.study.domain.mapping.UserAgree, umc.study.domain.mapping.QUserAgree> userAgreeList = this.<umc.study.domain.mapping.UserAgree, umc.study.domain.mapping.QUserAgree>createList("userAgreeList", umc.study.domain.mapping.UserAgree.class, umc.study.domain.mapping.QUserAgree.class, PathInits.DIRECT2);

    public final ListPath<umc.study.domain.mapping.UserPrefer, umc.study.domain.mapping.QUserPrefer> userPreferList = this.<umc.study.domain.mapping.UserPrefer, umc.study.domain.mapping.QUserPrefer>createList("userPreferList", umc.study.domain.mapping.UserPrefer.class, umc.study.domain.mapping.QUserPrefer.class, PathInits.DIRECT2);

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

