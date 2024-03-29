package com.bit.tak.model.vo.member;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QU_Report is a Querydsl query type for U_Report
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QU_Report extends EntityPathBase<U_Report> {

    private static final long serialVersionUID = 2127439712L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QU_Report u_Report = new QU_Report("u_Report");

    public final QHandling handlingCode;

    public final DateTimePath<java.util.Date> handlingDate = createDateTime("handlingDate", java.util.Date.class);

    public final StringPath reportBoard = createString("reportBoard");

    public final NumberPath<Integer> reportBoardno = createNumber("reportBoardno", Integer.class);

    public final QReport reportCode;

    public final DateTimePath<java.util.Date> reportDate = createDateTime("reportDate", java.util.Date.class);

    public final QMuser reportee;

    public final QMuser reporter;

    public final NumberPath<Integer> reportMentno = createNumber("reportMentno", Integer.class);

    public final NumberPath<Integer> reportNo = createNumber("reportNo", Integer.class);

    public QU_Report(String variable) {
        this(U_Report.class, forVariable(variable), INITS);
    }

    public QU_Report(Path<? extends U_Report> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QU_Report(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QU_Report(PathMetadata metadata, PathInits inits) {
        this(U_Report.class, metadata, inits);
    }

    public QU_Report(Class<? extends U_Report> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.handlingCode = inits.isInitialized("handlingCode") ? new QHandling(forProperty("handlingCode")) : null;
        this.reportCode = inits.isInitialized("reportCode") ? new QReport(forProperty("reportCode")) : null;
        this.reportee = inits.isInitialized("reportee") ? new QMuser(forProperty("reportee")) : null;
        this.reporter = inits.isInitialized("reporter") ? new QMuser(forProperty("reporter")) : null;
    }

}

