package com.bit.tak.model.vo.member;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QC_Del is a Querydsl query type for C_Del
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QC_Del extends EntityPathBase<C_Del> {

    private static final long serialVersionUID = 1342380621L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QC_Del c_Del = new QC_Del("c_Del");

    public final NumberPath<Integer> cDelNo = createNumber("cDelNo", Integer.class);

    public final QCompany cNo;

    public final DateTimePath<java.util.Date> expirationDate = createDateTime("expirationDate", java.util.Date.class);

    public QC_Del(String variable) {
        this(C_Del.class, forVariable(variable), INITS);
    }

    public QC_Del(Path<? extends C_Del> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QC_Del(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QC_Del(PathMetadata metadata, PathInits inits) {
        this(C_Del.class, metadata, inits);
    }

    public QC_Del(Class<? extends C_Del> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cNo = inits.isInitialized("cNo") ? new QCompany(forProperty("cNo")) : null;
    }

}

