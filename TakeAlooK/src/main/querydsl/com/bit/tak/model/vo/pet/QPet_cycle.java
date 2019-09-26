package com.bit.tak.model.vo.pet;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPet_cycle is a Querydsl query type for Pet_cycle
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPet_cycle extends EntityPathBase<Pet_cycle> {

    private static final long serialVersionUID = 641670437L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPet_cycle pet_cycle = new QPet_cycle("pet_cycle");

    public final DatePath<java.sql.Date> clinicCheck = createDate("clinicCheck", java.sql.Date.class);

    public final DatePath<java.sql.Date> clinicDate = createDate("clinicDate", java.sql.Date.class);

    public final QLife_Cycle lifeCycleNo;

    public final NumberPath<Integer> petCycleNo = createNumber("petCycleNo", Integer.class);

    public final QPet petId;

    public QPet_cycle(String variable) {
        this(Pet_cycle.class, forVariable(variable), INITS);
    }

    public QPet_cycle(Path<? extends Pet_cycle> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPet_cycle(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPet_cycle(PathMetadata metadata, PathInits inits) {
        this(Pet_cycle.class, metadata, inits);
    }

    public QPet_cycle(Class<? extends Pet_cycle> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.lifeCycleNo = inits.isInitialized("lifeCycleNo") ? new QLife_Cycle(forProperty("lifeCycleNo"), inits.get("lifeCycleNo")) : null;
        this.petId = inits.isInitialized("petId") ? new QPet(forProperty("petId"), inits.get("petId")) : null;
    }

}

