package com.bit.tak.model.vo.member;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QCompany is a Querydsl query type for Company
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QCompany extends EntityPathBase<Company> {

    private static final long serialVersionUID = 2033839419L;

    public static final QCompany company = new QCompany("company");

    public final StringPath cAddress = createString("cAddress");

    public final StringPath cManager = createString("cManager");

    public final StringPath cName = createString("cName");

    public final StringPath cNo = createString("cNo");

    public final StringPath cPassword = createString("cPassword");

    public final StringPath cPhone = createString("cPhone");

    public QCompany(String variable) {
        super(Company.class, forVariable(variable));
    }

    public QCompany(Path<? extends Company> path) {
        super(path.getType(), path.getMetadata());
    }

    public QCompany(PathMetadata metadata) {
        super(Company.class, metadata);
    }

}

