package com.bit.tak.model.vo.admin;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QH_Qna is a Querydsl query type for H_Qna
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QH_Qna extends EntityPathBase<H_Qna> {

    private static final long serialVersionUID = -941521156L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QH_Qna h_Qna = new QH_Qna("h_Qna");

    public final com.bit.tak.model.vo.product.QHospital hosNo;

    public final StringPath hQcomment = createString("hQcomment");

    public final DateTimePath<java.util.Date> hQdate = createDateTime("hQdate", java.util.Date.class);

    public final NumberPath<Integer> hQno = createNumber("hQno", Integer.class);

    public final com.bit.tak.model.vo.member.QMuser nickname;

    public QH_Qna(String variable) {
        this(H_Qna.class, forVariable(variable), INITS);
    }

    public QH_Qna(Path<? extends H_Qna> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QH_Qna(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QH_Qna(PathMetadata metadata, PathInits inits) {
        this(H_Qna.class, metadata, inits);
    }

    public QH_Qna(Class<? extends H_Qna> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.hosNo = inits.isInitialized("hosNo") ? new com.bit.tak.model.vo.product.QHospital(forProperty("hosNo"), inits.get("hosNo")) : null;
        this.nickname = inits.isInitialized("nickname") ? new com.bit.tak.model.vo.member.QMuser(forProperty("nickname")) : null;
    }

}

