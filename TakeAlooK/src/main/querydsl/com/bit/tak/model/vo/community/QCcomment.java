package com.bit.tak.model.vo.community;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCcomment is a Querydsl query type for Ccomment
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCcomment extends EntityPathBase<Ccomment> {

    private static final long serialVersionUID = 2031981651L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCcomment ccomment = new QCcomment("ccomment");

    public final StringPath cmentContents = createString("cmentContents");

    public final DateTimePath<java.util.Date> cmentDate = createDateTime("cmentDate", java.util.Date.class);

    public final NumberPath<Integer> cmentNo = createNumber("cmentNo", Integer.class);

    public final QCommunity commNo;

    public final com.bit.tak.model.vo.member.QMuser nickname;

    public QCcomment(String variable) {
        this(Ccomment.class, forVariable(variable), INITS);
    }

    public QCcomment(Path<? extends Ccomment> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCcomment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCcomment(PathMetadata metadata, PathInits inits) {
        this(Ccomment.class, metadata, inits);
    }

    public QCcomment(Class<? extends Ccomment> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.commNo = inits.isInitialized("commNo") ? new QCommunity(forProperty("commNo"), inits.get("commNo")) : null;
        this.nickname = inits.isInitialized("nickname") ? new com.bit.tak.model.vo.member.QMuser(forProperty("nickname")) : null;
    }

}

