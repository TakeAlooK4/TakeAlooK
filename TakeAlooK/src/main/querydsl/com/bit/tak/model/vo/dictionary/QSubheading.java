package com.bit.tak.model.vo.dictionary;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QSubheading is a Querydsl query type for Subheading
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QSubheading extends EntityPathBase<Subheading> {

    private static final long serialVersionUID = -1601195064L;

    public static final QSubheading subheading = new QSubheading("subheading");

    public final StringPath sCategory = createString("sCategory");

    public final StringPath sInitials = createString("sInitials");

    public QSubheading(String variable) {
        super(Subheading.class, forVariable(variable));
    }

    public QSubheading(Path<? extends Subheading> path) {
        super(path.getType(), path.getMetadata());
    }

    public QSubheading(PathMetadata metadata) {
        super(Subheading.class, metadata);
    }

}

