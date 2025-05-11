package umc.spring.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QInquiryImg is a Querydsl query type for InquiryImg
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QInquiryImg extends EntityPathBase<InquiryImg> {

    private static final long serialVersionUID = 1872774696L;

    public static final QInquiryImg inquiryImg = new QInquiryImg("inquiryImg");

    public final umc.spring.domain.common.QBaseEntity _super = new umc.spring.domain.common.QBaseEntity(this);

    //inherited
    public final DateTimePath<java.time.LocalDateTime> createdAt = _super.createdAt;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath imgUrl = createString("imgUrl");

    //inherited
    public final DateTimePath<java.time.LocalDateTime> updatedAt = _super.updatedAt;

    public QInquiryImg(String variable) {
        super(InquiryImg.class, forVariable(variable));
    }

    public QInquiryImg(Path<? extends InquiryImg> path) {
        super(path.getType(), path.getMetadata());
    }

    public QInquiryImg(PathMetadata metadata) {
        super(InquiryImg.class, metadata);
    }

}

