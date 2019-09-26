package com.bit.tak.model.vo.clinic;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QTclinic is a Querydsl query type for Tclinic
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QTclinic extends EntityPathBase<Tclinic> {

    private static final long serialVersionUID = -1745290392L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QTclinic tclinic = new QTclinic("tclinic");

    public final QSclinic sCode;

    public final StringPath tCode = createString("tCode");

    public final StringPath tName = createString("tName");

    public QTclinic(String variable) {
        this(Tclinic.class, forVariable(variable), INITS);
    }

    public QTclinic(Path<? extends Tclinic> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QTclinic(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QTclinic(PathMetadata metadata, PathInits inits) {
        this(Tclinic.class, metadata, inits);
    }

    public QTclinic(Class<? extends Tclinic> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.sCode = inits.isInitialized("sCode") ? new QSclinic(forProperty("sCode"), inits.get("sCode")) : null;
    }

}

