package com.study.service.impl;

import com.study.entity.Publisher;
import com.study.mapper.PublisherMapper;
import com.study.service.PublisherService;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PublisherServiceImpl implements PublisherService {

    @Resource
    PublisherMapper publisherMapper;

    @Override
    public List<Publisher> getPublishers() {
        return publisherMapper.getPublisher();
    }

    @Override
    public List<Publisher> getSelectPublishers(String name) {
        return publisherMapper.getSelectPublisher(name);
    }
}
