package com.togo.spring.es;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @Author taiyn
 * @Description TODO
 * @Date 6:19 下午 2020/6/26
 **/
public interface Repository extends ElasticsearchRepository<Entity, String> {

}
