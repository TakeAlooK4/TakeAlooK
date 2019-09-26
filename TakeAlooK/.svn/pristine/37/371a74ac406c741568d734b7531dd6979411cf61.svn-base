package com.bit.tak.model.vo.pet;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMedical is a Querydsl query type for Medical
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMedical extends EntityPathBase<Medical> {

    private static final long serialVersionUID = 541551024L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMedical medical = new QMedical("medical");

    public final StringPath clinicHos = createString("clinicHos");

    public final NumberPath<Integer> medicalCost = createNumber("medicalCost", Integer.class);

    public final DatePath<java.sql.Date> medicalDate = createDate("medicalDate", java.sql.Date.class);

    public final StringPath medicalMemo = createString("medicalMemo");

    public final NumberPath<Integer> medicalNo = createNumber("medicalNo", Integer.class);

    public final QPet petId;

    public final com.bit.tak.model.vo.clinic.QTclinic tCode;

    public QMedical(String variable) {
        this(Medical.class, forVariable(variable), INITS);
    }

    public QMedical(Path<? extends Medical> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMedical(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMedical(PathMetadata metadata, PathInits inits) {
        this(Medical.class, metadata, inits);
    }

    public QMedical(Class<? extends Medical> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.petId = inits.isInitialized("petId") ? new QPet(forProperty("petId"), inits.get("petId")) : null;
        this.tCode = inits.isInitialized("tCode") ? new com.bit.tak.model.vo.clinic.QTclinic(forProperty("tCode"), inits.get("tCode")) : null;
    }

}

