package com.wrlhblog.service.impl;

import com.wrlhblog.model.CommentCount;
import com.wrlhblog.mapper.CommentCountMapper;
import com.wrlhblog.service.ICommentCountService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 评论计数表 服务实现类
 * </p>
 *
 * @author 
 * @since 2020-12-29
 */
@Service
public class CommentCountServiceImpl extends ServiceImpl<CommentCountMapper, CommentCount> implements ICommentCountService {

}
