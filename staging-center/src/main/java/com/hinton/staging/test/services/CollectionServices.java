package com.hinton.staging.test.services;

import com.hinton.staging.test.adapter.OutCollection;
import com.hinton.staging.test.entity.Collection;
import com.hinton.staging.test.mapper.CollectionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CollectionServices {
    @Autowired
    CollectionMapper collectionMapper;

    public OutCollection getCollectionById(Long id){
        Collection collection = collectionMapper.getOneCollectionByUserAndReferenceId(1L,1L,"test");
        return new OutCollection(collection);
    }
}
