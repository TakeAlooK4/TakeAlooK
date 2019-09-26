package com.bit.tak;
import com.bit.tak.model.vo.community.QCommunity;
import com.bit.tak.model.vo.community.Search;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;

public class CommunityPredicate {

	public static Predicate search(Search search) {
		BooleanBuilder builder = new BooleanBuilder();
		QCommunity qCommunity = QCommunity.community;
		
		if (search.getSearchCondition().equals("TITLE")) {
			builder.and(qCommunity.commTitle.like("%" + search.getSearchKeyword() + "%"));
		} else if (search.getSearchCondition().equals("CONTENT")) {
			builder.and(qCommunity.commContents.like("%" + search.getSearchKeyword() + "%"));
		} else if (search.getSearchCondition().equals("NICKNAME")) {
			builder.and(qCommunity.nickname.nickname.like("%" + search.getSearchKeyword() + "%"));
		}
		System.out.println(builder);
		return builder;
	}
}
