package com.bit.tak.model.vo.host;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHost is a Querydsl query type for Host
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHost extends EntityPathBase<Host> {

    private static final long serialVersionUID = 680421084L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QHost host = new QHost("host");

    public final DateTimePath<java.util.Date> hostArrivaldate = createDateTime("hostArrivaldate", java.util.Date.class);

    public final TimePath<java.sql.Time> hostArrivaltime = createTime("hostArrivaltime", java.sql.Time.class);

    public final StringPath hostContents = createString("hostContents");

    public final DateTimePath<java.sql.Timestamp> hostDate = createDateTime("hostDate", java.sql.Timestamp.class);

    public final DateTimePath<java.util.Date> hostDeadline = createDateTime("hostDeadline", java.util.Date.class);

    public final NumberPath<Integer> hostGpa = createNumber("hostGpa", Integer.class);

    public final NumberPath<Integer> hostHit = createNumber("hostHit", Integer.class);

    public final StringPath hostImg = createString("hostImg");

    public final BooleanPath hostManager = createBoolean("hostManager");

    public final NumberPath<Integer> hostNo = createNumber("hostNo", Integer.class);

    public final NumberPath<Integer> hostParticipant = createNumber("hostParticipant", Integer.class);

    public final StringPath hostPlace = createString("hostPlace");

    public final DateTimePath<java.util.Date> hostRecruit = createDateTime("hostRecruit", java.util.Date.class);

    public final DateTimePath<java.util.Date> hostStartdate = createDateTime("hostStartdate", java.util.Date.class);

    public final TimePath<java.sql.Time> hostStarttime = createTime("hostStarttime", java.sql.Time.class);

    public final StringPath hostTitle = createString("hostTitle");

    public final NumberPath<Integer> hostTotalparticipant = createNumber("hostTotalparticipant", Integer.class);

    public final com.bit.tak.model.vo.member.QMuser nickname;

    public QHost(String variable) {
        this(Host.class, forVariable(variable), INITS);
    }

    public QHost(Path<? extends Host> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QHost(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QHost(PathMetadata metadata, PathInits inits) {
        this(Host.class, metadata, inits);
    }

    public QHost(Class<? extends Host> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.nickname = inits.isInitialized("nickname") ? new com.bit.tak.model.vo.member.QMuser(forProperty("nickname")) : null;
    }

}

