package com.bit.tak.model.vo.community;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCommLike is a Querydsl query type for CommLike
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCommLike extends EntityPathBase<CommLike> {

    private static final long serialVersionUID = -261113734L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCommLike commLike = new QCommLike("commLike");

    public final QCommunity commNo;

    public final NumberPath<Integer> likeNo = createNumber("likeNo", Integer.class);

    public final com.bit.tak.model.vo.member.QMuser nickname;

    public QCommLike(String variable) {
        this(CommLike.class, forVariable(variable), INITS);
    }

    public QCommLike(Path<? extends CommLike> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCommLike(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCommLike(PathMetadata metadata, PathInits inits) {
        this(CommLike.class, metadata, inits);
    }

    public QCommLike(Class<? extends CommLike> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.commNo = inits.isInitialized("commNo") ? new QCommunity(forProperty("commNo"), inits.get("commNo")) : null;
        this.nickname = inits.isInitialized("nickname") ? new com.bit.tak.model.vo.member.QMuser(forProperty("nickname")) : null;
    }

}

