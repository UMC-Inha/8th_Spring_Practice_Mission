package umc.study.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTerms is a Querydsl query type for Terms
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QTerms extends EntityPathBase<Terms> {

    private static final long serialVersionUID = 1963675077L;

    public static final QTerms terms = new QTerms("terms");

    public final StringPath body = createString("body");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath optional = createBoolean("optional");

    public final StringPath title = createString("title");

    public final ListPath<umc.study.domain.mapping.UserAgree, umc.study.domain.mapping.QUserAgree> userAgreeList = this.<umc.study.domain.mapping.UserAgree, umc.study.domain.mapping.QUserAgree>createList("userAgreeList", umc.study.domain.mapping.UserAgree.class, umc.study.domain.mapping.QUserAgree.class, PathInits.DIRECT2);

    public QTerms(String variable) {
        super(Terms.class, forVariable(variable));
    }

    public QTerms(Path<? extends Terms> path) {
        super(path.getType(), path.getMetadata());
    }

    public QTerms(PathMetadata metadata) {
        super(Terms.class, metadata);
    }

}

