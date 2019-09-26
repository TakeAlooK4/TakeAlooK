package com.bit.tak.model.vo.product;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProduct is a Querydsl query type for Product
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QProduct extends EntityPathBase<Product> {

    private static final long serialVersionUID = -1005047586L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProduct product = new QProduct("product");

    public final com.bit.tak.model.vo.productCode.QP_Age ageCode;

    public final StringPath animalType = createString("animalType");

    public final com.bit.tak.model.vo.member.QCompany cNo;

    public final StringPath detailImg01 = createString("detailImg01");

    public final com.bit.tak.model.vo.productCode.QP_Fp fpCode;

    public final StringPath mainImg01 = createString("mainImg01");

    public final com.bit.tak.model.vo.productCode.QP_Mrm mrmCode;

    public final com.bit.tak.model.vo.productCode.QP_Code pCode;

    public final NumberPath<Integer> prAmount = createNumber("prAmount", Integer.class);

    public final NumberPath<Integer> prCost = createNumber("prCost", Integer.class);

    public final StringPath prName = createString("prName");

    public final NumberPath<Integer> prNo = createNumber("prNo", Integer.class);

    public QProduct(String variable) {
        this(Product.class, forVariable(variable), INITS);
    }

    public QProduct(Path<? extends Product> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProduct(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProduct(PathMetadata metadata, PathInits inits) {
        this(Product.class, metadata, inits);
    }

    public QProduct(Class<? extends Product> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.ageCode = inits.isInitialized("ageCode") ? new com.bit.tak.model.vo.productCode.QP_Age(forProperty("ageCode")) : null;
        this.cNo = inits.isInitialized("cNo") ? new com.bit.tak.model.vo.member.QCompany(forProperty("cNo")) : null;
        this.fpCode = inits.isInitialized("fpCode") ? new com.bit.tak.model.vo.productCode.QP_Fp(forProperty("fpCode")) : null;
        this.mrmCode = inits.isInitialized("mrmCode") ? new com.bit.tak.model.vo.productCode.QP_Mrm(forProperty("mrmCode")) : null;
        this.pCode = inits.isInitialized("pCode") ? new com.bit.tak.model.vo.productCode.QP_Code(forProperty("pCode")) : null;
    }

}
