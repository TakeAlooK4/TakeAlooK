package com.bit.tak.model.vo.productCode;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QP_Mrm is a Querydsl query type for P_Mrm
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QP_Mrm extends EntityPathBase<P_Mrm> {

    private static final long serialVersionUID = -6358923L;

    public static final QP_Mrm p_Mrm = new QP_Mrm("p_Mrm");

    public final StringPath mrmCode = createString("mrmCode");

    public final StringPath mrmName = createString("mrmName");

    public QP_Mrm(String variable) {
        super(P_Mrm.class, forVariable(variable));
    }

    public QP_Mrm(Path<? extends P_Mrm> path) {
        super(path.getType(), path.getMetadata());
    }

    public QP_Mrm(PathMetadata metadata) {
        super(P_Mrm.class, metadata);
    }

}

