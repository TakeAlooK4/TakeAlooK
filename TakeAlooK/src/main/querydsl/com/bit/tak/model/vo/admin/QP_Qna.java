package com.bit.tak.model.vo.admin;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QP_Qna is a Querydsl query type for P_Qna
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QP_Qna extends EntityPathBase<P_Qna> {

    private static final long serialVersionUID = -934132988L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QP_Qna p_Qna = new QP_Qna("p_Qna");

    public final StringPath pQcomment = createString("pQcomment");

    public final DateTimePath<java.util.Date> pQdate = createDateTime("pQdate", java.util.Date.class);

    public final NumberPath<Integer> pQno = createNumber("pQno", Integer.class);

    public final com.bit.tak.model.vo.product.QProduct product;

    public final com.bit.tak.model.vo.member.QMuser user;

    public QP_Qna(String variable) {
        this(P_Qna.class, forVariable(variable), INITS);
    }

    public QP_Qna(Path<? extends P_Qna> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QP_Qna(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QP_Qna(PathMetadata metadata, PathInits inits) {
        this(P_Qna.class, metadata, inits);
    }

    public QP_Qna(Class<? extends P_Qna> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.product = inits.isInitialized("product") ? new com.bit.tak.model.vo.product.QProduct(forProperty("product"), inits.get("product")) : null;
        this.user = inits.isInitialized("user") ? new com.bit.tak.model.vo.member.QMuser(forProperty("user")) : null;
    }

}
