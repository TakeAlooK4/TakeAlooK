package com.bit.tak.model.vo.host;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHost_Review is a Querydsl query type for Host_Review
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHost_Review extends EntityPathBase<Host_Review> {

    private static final long serialVersionUID = -331789765L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QHost_Review host_Review = new QHost_Review("host_Review");

    public final QHost hostNo;

    public final StringPath hrContents = createString("hrContents");

    public final DateTimePath<java.util.Date> hrDate = createDateTime("hrDate", java.util.Date.class);

    public final NumberPath<Integer> hrGpa = createNumber("hrGpa", Integer.class);

    public final NumberPath<Integer> hrNo = createNumber("hrNo", Integer.class);

    public final com.bit.tak.model.vo.member.QMuser nickname;

    public QHost_Review(String variable) {
        this(Host_Review.class, forVariable(variable), INITS);
    }

    public QHost_Review(Path<? extends Host_Review> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QHost_Review(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QHost_Review(PathMetadata metadata, PathInits inits) {
        this(Host_Review.class, metadata, inits);
    }

    public QHost_Review(Class<? extends Host_Review> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.hostNo = inits.isInitialized("hostNo") ? new QHost(forProperty("hostNo"), inits.get("hostNo")) : null;
        this.nickname = inits.isInitialized("nickname") ? new com.bit.tak.model.vo.member.QMuser(forProperty("nickname")) : null;
    }

}

