package com.bit.tak.model.vo.admin;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QP_Review is a Querydsl query type for P_Review
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QP_Review extends EntityPathBase<P_Review> {

    private static final long serialVersionUID = -1641687496L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QP_Review p_Review = new QP_Review("p_Review");

    public final com.bit.tak.model.vo.product.QProduct product;

    public final StringPath review = createString("review");

    public final DateTimePath<java.util.Date> reviewDate = createDateTime("reviewDate", java.util.Date.class);

    public final NumberPath<Integer> reviewNo = createNumber("reviewNo", Integer.class);

    public final com.bit.tak.model.vo.member.QMuser user;

    public QP_Review(String variable) {
        this(P_Review.class, forVariable(variable), INITS);
    }

    public QP_Review(Path<? extends P_Review> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QP_Review(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QP_Review(PathMetadata metadata, PathInits inits) {
        this(P_Review.class, metadata, inits);
    }

    public QP_Review(Class<? extends P_Review> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.product = inits.isInitialized("product") ? new com.bit.tak.model.vo.product.QProduct(forProperty("product"), inits.get("product")) : null;
        this.user = inits.isInitialized("user") ? new com.bit.tak.model.vo.member.QMuser(forProperty("user")) : null;
    }

}

