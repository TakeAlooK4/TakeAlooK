package com.bit.tak.model.vo.admin;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QP_Answer is a Querydsl query type for P_Answer
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QP_Answer extends EntityPathBase<P_Answer> {

    private static final long serialVersionUID = -2120147298L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QP_Answer p_Answer = new QP_Answer("p_Answer");

    public final StringPath answerContent = createString("answerContent");

    public final DateTimePath<java.util.Date> pAnswerDate = createDateTime("pAnswerDate", java.util.Date.class);

    public final NumberPath<Integer> pAnswerno = createNumber("pAnswerno", Integer.class);

    public final QP_Qna pQno;

    public QP_Answer(String variable) {
        this(P_Answer.class, forVariable(variable), INITS);
    }

    public QP_Answer(Path<? extends P_Answer> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QP_Answer(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QP_Answer(PathMetadata metadata, PathInits inits) {
        this(P_Answer.class, metadata, inits);
    }

    public QP_Answer(Class<? extends P_Answer> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.pQno = inits.isInitialized("pQno") ? new QP_Qna(forProperty("pQno"), inits.get("pQno")) : null;
    }

}

