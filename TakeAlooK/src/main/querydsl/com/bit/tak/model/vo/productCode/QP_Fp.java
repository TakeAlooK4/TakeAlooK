package com.bit.tak.model.vo.productCode;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QP_Fp is a Querydsl query type for P_Fp
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QP_Fp extends EntityPathBase<P_Fp> {

    private static final long serialVersionUID = -2078415331L;

    public static final QP_Fp p_Fp = new QP_Fp("p_Fp");

    public final StringPath fpCode = createString("fpCode");

    public final StringPath fpName = createString("fpName");

    public QP_Fp(String variable) {
        super(P_Fp.class, forVariable(variable));
    }

    public QP_Fp(Path<? extends P_Fp> path) {
        super(path.getType(), path.getMetadata());
    }

    public QP_Fp(PathMetadata metadata) {
        super(P_Fp.class, metadata);
    }

}

