package com.wrlhblog.controller;


import com.alibaba.druid.util.StringUtils;
import com.wrlhblog.utils.RespBean;
import com.wrlhblog.utils.UploadUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


/**
 * <p>
 * 文章表 前端控制器
 * </p>
 */
@RestController
@RequestMapping("/article")
public class ArticleController {


    @Value("${uploadConfig.articleSummarySize}")
    private Long articleSummarySize;

    /**
     * 图片上传
     */
    @PostMapping("/uploadTitlePicture")
    public RespBean uploadArticlePicture(MultipartFile file) throws IOException {

        byte[] fileBytes = file.getBytes();
        String filename = file.getOriginalFilename();

        //文件上传
        String fileUrl = UploadUtils.uploadImage(fileBytes, filename, null);
        System.out.println("fileUrl = " + fileUrl);

        if (StringUtils.isEmpty(fileUrl)) {
            return RespBean.error("上传失败");
        }
        return RespBean.ok("上传成功", fileUrl);
    }


}
