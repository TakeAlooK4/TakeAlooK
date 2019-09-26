package com.bit.tak.model.vo.product;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHospital is a Querydsl query type for Hospital
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHospital extends EntityPathBase<Hospital> {

    private static final long serialVersionUID = -391571413L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QHospital hospital = new QHospital("hospital");

    public final com.bit.tak.model.vo.productCode.QArea areaCode;

    public final StringPath cName = createString("cName");

    public final StringPath detailImg01 = createString("detailImg01");

    public final NumberPath<Integer> hosCost = createNumber("hosCost", Integer.class);

    public final StringPath hosNo = createString("hosNo");

    public final StringPath mainImg01 = createString("mainImg01");

    public final StringPath mainImg02 = createString("mainImg02");

    public final StringPath mainImg03 = createString("mainImg03");

    public final StringPath petCode = createString("petCode");

    public final StringPath petGender = createString("petGender");

    public final com.bit.tak.model.vo.clinic.QTclinic tCode;

    public QHospital(String variable) {
        this(Hospital.class, forVariable(variable), INITS);
    }

    public QHospital(Path<? extends Hospital> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QHospital(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QHospital(PathMetadata metadata, PathInits inits) {
        this(Hospital.class, metadata, inits);
    }

    public QHospital(Class<? extends Hospital> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.areaCode = inits.isInitialized("areaCode") ? new com.bit.tak.model.vo.productCode.QArea(forProperty("areaCode")) : null;
        this.tCode = inits.isInitialized("tCode") ? new com.bit.tak.model.vo.clinic.QTclinic(forProperty("tCode"), inits.get("tCode")) : null;
    }

}

