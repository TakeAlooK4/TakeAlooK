package com.bit.tak.model.vo.product;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QP_resultValue is a Querydsl query type for P_resultValue
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QP_resultValue extends EntityPathBase<P_resultValue> {

    private static final long serialVersionUID = -962982220L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QP_resultValue p_resultValue = new QP_resultValue("p_resultValue");

    public final QCart cart;

    public final NumberPath<Integer> resultValue = createNumber("resultValue", Integer.class);

    public final NumberPath<Integer> sumValue = createNumber("sumValue", Integer.class);

    public QP_resultValue(String variable) {
        this(P_resultValue.class, forVariable(variable), INITS);
    }

    public QP_resultValue(Path<? extends P_resultValue> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QP_resultValue(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QP_resultValue(PathMetadata metadata, PathInits inits) {
        this(P_resultValue.class, metadata, inits);
    }

    public QP_resultValue(Class<? extends P_resultValue> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cart = inits.isInitialized("cart") ? new QCart(forProperty("cart"), inits.get("cart")) : null;
    }

}

