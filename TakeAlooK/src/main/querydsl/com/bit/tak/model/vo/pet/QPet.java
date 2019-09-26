package com.bit.tak.model.vo.pet;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QPet is a Querydsl query type for Pet
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QPet extends EntityPathBase<Pet> {

    private static final long serialVersionUID = -373266498L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QPet pet = new QPet("pet");

    public final QBreed breedCode;

    public final ListPath<Medical, QMedical> medical = this.<Medical, QMedical>createList("medical", Medical.class, QMedical.class, PathInits.DIRECT2);

    public final com.bit.tak.model.vo.member.QMuser nickname;

    public final DatePath<java.sql.Date> petBirth = createDate("petBirth", java.sql.Date.class);

    public final StringPath petCode = createString("petCode");

    public final StringPath petGender = createString("petGender");

    public final NumberPath<Integer> petId = createNumber("petId", Integer.class);

    public final StringPath petImg = createString("petImg");

    public final StringPath petName = createString("petName");

    public QPet(String variable) {
        this(Pet.class, forVariable(variable), INITS);
    }

    public QPet(Path<? extends Pet> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QPet(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QPet(PathMetadata metadata, PathInits inits) {
        this(Pet.class, metadata, inits);
    }

    public QPet(Class<? extends Pet> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.breedCode = inits.isInitialized("breedCode") ? new QBreed(forProperty("breedCode")) : null;
        this.nickname = inits.isInitialized("nickname") ? new com.bit.tak.model.vo.member.QMuser(forProperty("nickname")) : null;
    }

}
