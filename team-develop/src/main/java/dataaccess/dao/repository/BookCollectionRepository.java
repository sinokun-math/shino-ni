package dataaccess.dao.repository;

import java.util.List;

import dataaccess.dao.GenericDao;
import dataaccess.entity.BookCollectionEntity;

public interface BookCollectionRepository extends GenericDao<BookCollectionEntity, Integer> {
	<T> List<BookCollectionEntity> findBy_ (T t);
}

