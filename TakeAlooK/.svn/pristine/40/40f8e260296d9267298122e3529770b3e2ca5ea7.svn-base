package com.bit.tak.model.vo.dictionary;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDictionary is a Querydsl query type for Dictionary
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDictionary extends EntityPathBase<Dictionary> {

    private static final long serialVersionUID = 1196813468L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDictionary dictionary = new QDictionary("dictionary");

    public final StringPath dicContents = createString("dicContents");

    public final DateTimePath<java.util.Date> dicDate = createDateTime("dicDate", java.util.Date.class);

    public final StringPath dicImg = createString("dicImg");

    public final NumberPath<Integer> dicLikes = createNumber("dicLikes", Integer.class);

    public final NumberPath<Integer> dicNo = createNumber("dicNo", Integer.class);

    public final QSubheading dicSubcode;

    public final StringPath dicTitle = createString("dicTitle");

    public final StringPath dicVideo = createString("dicVideo");

    public QDictionary(String variable) {
        this(Dictionary.class, forVariable(variable), INITS);
    }

    public QDictionary(Path<? extends Dictionary> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDictionary(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDictionary(PathMetadata metadata, PathInits inits) {
        this(Dictionary.class, metadata, inits);
    }

    public QDictionary(Class<? extends Dictionary> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.dicSubcode = inits.isInitialized("dicSubcode") ? new QSubheading(forProperty("dicSubcode")) : null;
    }

}

