package com.bit.tak.model.vo.member;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QMuser is a Querydsl query type for Muser
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QMuser extends EntityPathBase<Muser> {

    private static final long serialVersionUID = 1352316406L;

    public static final QMuser muser = new QMuser("muser");

    public final StringPath contact = createString("contact");

    public final StringPath id = createString("id");

    public final StringPath name = createString("name");

    public final StringPath nickname = createString("nickname");

    public final StringPath password = createString("password");

    public QMuser(String variable) {
        super(Muser.class, forVariable(variable));
    }

    public QMuser(Path<? extends Muser> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMuser(PathMetadata metadata) {
        super(Muser.class, metadata);
    }

}

