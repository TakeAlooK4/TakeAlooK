package com.bit.tak.model.vo.pet;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QLife_Cycle is a Querydsl query type for Life_Cycle
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QLife_Cycle extends EntityPathBase<Life_Cycle> {

    private static final long serialVersionUID = -1495075260L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QLife_Cycle life_Cycle = new QLife_Cycle("life_Cycle");

    public final NumberPath<Integer> clinicDate = createNumber("clinicDate", Integer.class);

    public final StringPath clinicMoment = createString("clinicMoment");

    public final NumberPath<Integer> lifeCycleNo = createNumber("lifeCycleNo", Integer.class);

    public final com.bit.tak.model.vo.clinic.QTclinic tCode;

    public QLife_Cycle(String variable) {
        this(Life_Cycle.class, forVariable(variable), INITS);
    }

    public QLife_Cycle(Path<? extends Life_Cycle> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QLife_Cycle(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QLife_Cycle(PathMetadata metadata, PathInits inits) {
        this(Life_Cycle.class, metadata, inits);
    }

    public QLife_Cycle(Class<? extends Life_Cycle> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.tCode = inits.isInitialized("tCode") ? new com.bit.tak.model.vo.clinic.QTclinic(forProperty("tCode"), inits.get("tCode")) : null;
    }

}
