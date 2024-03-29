package com.bit.tak.model.vo.member;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QU_Del is a Querydsl query type for U_Del
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QU_Del extends EntityPathBase<U_Del> {

    private static final long serialVersionUID = 1359003999L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QU_Del u_Del = new QU_Del("u_Del");

    public final QMuser nickname;

    public final QU_DelReason uDelcode;

    public final NumberPath<Integer> uDelNo = createNumber("uDelNo", Integer.class);

    public QU_Del(String variable) {
        this(U_Del.class, forVariable(variable), INITS);
    }

    public QU_Del(Path<? extends U_Del> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QU_Del(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QU_Del(PathMetadata metadata, PathInits inits) {
        this(U_Del.class, metadata, inits);
    }

    public QU_Del(Class<? extends U_Del> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.nickname = inits.isInitialized("nickname") ? new QMuser(forProperty("nickname")) : null;
        this.uDelcode = inits.isInitialized("uDelcode") ? new QU_DelReason(forProperty("uDelcode")) : null;
    }

}

