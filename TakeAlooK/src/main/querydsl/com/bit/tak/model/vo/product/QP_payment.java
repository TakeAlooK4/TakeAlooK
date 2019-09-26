package com.bit.tak.model.vo.product;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QP_payment is a Querydsl query type for P_payment
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QP_payment extends EntityPathBase<P_payment> {

    private static final long serialVersionUID = -1726116506L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QP_payment p_payment = new QP_payment("p_payment");

    public final StringPath address = createString("address");

    public final StringPath cellphone = createString("cellphone");

    public final com.bit.tak.model.vo.member.QMuser muser;

    public final NumberPath<Integer> paymentno = createNumber("paymentno", Integer.class);

    public final QProduct product;

    public final NumberPath<Integer> sumvalue = createNumber("sumvalue", Integer.class);

    public QP_payment(String variable) {
        this(P_payment.class, forVariable(variable), INITS);
    }

    public QP_payment(Path<? extends P_payment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QP_payment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QP_payment(PathMetadata metadata, PathInits inits) {
        this(P_payment.class, metadata, inits);
    }

    public QP_payment(Class<? extends P_payment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.muser = inits.isInitialized("muser") ? new com.bit.tak.model.vo.member.QMuser(forProperty("muser")) : null;
        this.product = inits.isInitialized("product") ? new QProduct(forProperty("product"), inits.get("product")) : null;
    }

}

