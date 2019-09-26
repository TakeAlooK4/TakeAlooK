package com.bit.tak.model.vo.community;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QCommImg is a Querydsl query type for CommImg
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCommImg extends EntityPathBase<CommImg> {

    private static final long serialVersionUID = 2069784192L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QCommImg commImg1 = new QCommImg("commImg1");

    public final StringPath commImg = createString("commImg");

    public final QCommunity commNo;

    public final NumberPath<Integer> imgNo = createNumber("imgNo", Integer.class);

    public QCommImg(String variable) {
        this(CommImg.class, forVariable(variable), INITS);
    }

    public QCommImg(Path<? extends CommImg> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QCommImg(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QCommImg(PathMetadata metadata, PathInits inits) {
        this(CommImg.class, metadata, inits);
    }

    public QCommImg(Class<? extends CommImg> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.commNo = inits.isInitialized("commNo") ? new QCommunity(forProperty("commNo"), inits.get("commNo")) : null;
    }

}
