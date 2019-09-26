package com.bit.tak.model.vo.host;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QHost_Img is a Querydsl query type for Host_Img
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHost_Img extends EntityPathBase<Host_Img> {

    private static final long serialVersionUID = -617355328L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QHost_Img host_Img = new QHost_Img("host_Img");

    public final StringPath hostImg = createString("hostImg");

    public final QHost hostNo;

    public final NumberPath<Integer> imgNo = createNumber("imgNo", Integer.class);

    public QHost_Img(String variable) {
        this(Host_Img.class, forVariable(variable), INITS);
    }

    public QHost_Img(Path<? extends Host_Img> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QHost_Img(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QHost_Img(PathMetadata metadata, PathInits inits) {
        this(Host_Img.class, metadata, inits);
    }

    public QHost_Img(Class<? extends Host_Img> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.hostNo = inits.isInitialized("hostNo") ? new QHost(forProperty("hostNo"), inits.get("hostNo")) : null;
    }

}

