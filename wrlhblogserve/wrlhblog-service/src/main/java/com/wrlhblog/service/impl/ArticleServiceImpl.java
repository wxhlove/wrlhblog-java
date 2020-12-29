package com.wrlhblog.service.impl;

import com.wrlhblog.model.Article;
import com.wrlhblog.mapper.ArticleMapper;
import com.wrlhblog.service.IArticleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章表 服务实现类
 * </p>
 *
 * @author 
 * @since 2020-12-29
 */
@Service
public class ArticleServiceImpl extends ServiceImpl<ArticleMapper, Article> implements IArticleService {

}
