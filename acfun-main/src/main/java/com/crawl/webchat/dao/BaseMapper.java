package com.crawl.webchat.dao;
import java.util.List;


public interface BaseMapper<T, P> {
	public Integer insert(T t);

	public List<T> selectList(P p);

	public Integer selectCount(P p);

	public Integer update(T t);

	public Integer updateByQuery(P p);

	public Integer delete(T t);
}
