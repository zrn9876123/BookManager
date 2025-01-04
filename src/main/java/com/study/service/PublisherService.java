package com.study.service;

import com.study.entity.Publisher;
import org.springframework.stereotype.Service;

import java.util.List;

public interface PublisherService {
    List<Publisher> getPublishers();
    List<Publisher> getSelectPublishers(String name);
}
