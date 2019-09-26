package com.bit.tak.model.vo.clinic;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QSclinic is a Querydsl query type for Sclinic
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSclinic extends EntityPathBase<Sclinic> {

    private static final long serialVersionUID = 1662173223L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QSclinic sclinic = new QSclinic("sclinic");

    public final QFclinic fCode;

    public final StringPath sCode = createString("sCode");

    public final StringPath sName = createString("sName");

    public QSclinic(String variable) {
        this(Sclinic.class, forVariable(variable), INITS);
    }

    public QSclinic(Path<? extends Sclinic> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QSclinic(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QSclinic(PathMetadata metadata, PathInits inits) {
        this(Sclinic.class, metadata, inits);
    }

    public QSclinic(Class<? extends Sclinic> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.fCode = inits.isInitialized("fCode") ? new QFclinic(forProperty("fCode")) : null;
    }

}
