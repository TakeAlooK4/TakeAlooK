package com.bit.tak.model.vo.pet;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QBreed is a Querydsl query type for Breed
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QBreed extends EntityPathBase<Breed> {

    private static final long serialVersionUID = 2055595091L;

    public static final QBreed breed = new QBreed("breed");

    public final StringPath breedCode = createString("breedCode");

    public final StringPath breedName = createString("breedName");

    public QBreed(String variable) {
        super(Breed.class, forVariable(variable));
    }

    public QBreed(Path<? extends Breed> path) {
        super(path.getType(), path.getMetadata());
    }

    public QBreed(PathMetadata metadata) {
        super(Breed.class, metadata);
    }

}

