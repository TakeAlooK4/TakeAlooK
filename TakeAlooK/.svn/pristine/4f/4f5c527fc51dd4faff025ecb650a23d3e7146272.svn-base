package com.bit.tak.model.vo.admin;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QH_Answer is a Querydsl query type for H_Answer
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QH_Answer extends EntityPathBase<H_Answer> {

    private static final long serialVersionUID = 1117239206L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QH_Answer h_Answer = new QH_Answer("h_Answer");

    public final StringPath answerContent = createString("answerContent");

    public final DateTimePath<java.util.Date> hAnswerDate = createDateTime("hAnswerDate", java.util.Date.class);

    public final NumberPath<Integer> hAnswerno = createNumber("hAnswerno", Integer.class);

    public final QH_Qna hQno;

    public QH_Answer(String variable) {
        this(H_Answer.class, forVariable(variable), INITS);
    }

    public QH_Answer(Path<? extends H_Answer> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QH_Answer(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QH_Answer(PathMetadata metadata, PathInits inits) {
        this(H_Answer.class, metadata, inits);
    }

    public QH_Answer(Class<? extends H_Answer> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.hQno = inits.isInitialized("hQno") ? new QH_Qna(forProperty("hQno"), inits.get("hQno")) : null;
    }

}

