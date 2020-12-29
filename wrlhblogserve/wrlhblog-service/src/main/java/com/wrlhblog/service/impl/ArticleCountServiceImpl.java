package com.wrlhblog.service.impl;

import com.wrlhblog.model.ArticleCount;
import com.wrlhblog.mapper.ArticleCountMapper;
import com.wrlhblog.service.IArticleCountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章点赞计数表 服务实现类
 * </p>
 *
 * @author 
 * @since 2020-12-29
 */
@Service
public class ArticleCountServiceImpl extends ServiceImpl<ArticleCountMapper, ArticleCount> implements IArticleCountService {

}
