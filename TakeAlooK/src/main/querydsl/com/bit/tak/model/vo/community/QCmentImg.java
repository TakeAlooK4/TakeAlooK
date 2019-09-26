package com.bit.tak.model.vo.community;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCmentImg is a Querydsl query type for CmentImg
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCmentImg extends EntityPathBase<CmentImg> {

    private static final long serialVersionUID = 2031897465L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCmentImg cmentImg1 = new QCmentImg("cmentImg1");

    public final StringPath cmentImg = createString("cmentImg");

    public final QCcomment cmentNo;

    public final NumberPath<Integer> imgNo = createNumber("imgNo", Integer.class);

    public QCmentImg(String variable) {
        this(CmentImg.class, forVariable(variable), INITS);
    }

    public QCmentImg(Path<? extends CmentImg> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCmentImg(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCmentImg(PathMetadata metadata, PathInits inits) {
        this(CmentImg.class, metadata, inits);
    }

    public QCmentImg(Class<? extends CmentImg> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.cmentNo = inits.isInitialized("cmentNo") ? new QCcomment(forProperty("cmentNo"), inits.get("cmentNo")) : null;
    }

}

