
package com.wrlhblog.utils;


import com.alibaba.druid.util.StringUtils;
import com.wrlhblog.mapper.DataDicMapper;
import com.wrlhblog.model.DataDic;
import org.csource.common.MyException;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 上传工具类
 */
public class UploadUtils {


    @Autowired
    private DataDicMapper dataDicMapper;

    private static StorageClient1 storageClient1 = null;

    //初始化上传参数
    static {
        try {
            ClientGlobal.initByProperties("fastdfs-client.properties");
            TrackerClient trackerClient = new TrackerClient();
            TrackerServer trackerServer = trackerClient.getConnection();
            StorageServer storageServer = null;
            storageClient1 = new StorageClient1(trackerServer, storageServer);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
    }

    /**
     * 图片上传
     *
     * @return
     */

    public static String uploadImage(byte[] bytes, String fileName, Map<String, String> nameValues) {

        String fileSuffixName = getFileSuffixName(fileName);

        String url = "";

        //附加信息
        if (nameValues != null && !nameValues.isEmpty()) {
            //不为空时
            url = uploadImageWithNameValuePair(bytes, fileSuffixName, nameValues);
        } else {
            url = uploadImageWitNothNameValuePair(bytes, fileSuffixName);
        }

        return url;
    }


    /**
     * 上传图片含附加属性
     */
    private static String uploadImageWithNameValuePair(byte[] bytes, String fileSuffixName, Map<String, String> nameValues) {

        String url = "";
        try {

            List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(nameValues.size());
            for (Map.Entry<String, String> maps : nameValues.entrySet()) {
                nameValuePairs.add(new NameValuePair(maps.getKey(), maps.getValue()));
            }
            url = storageClient1.upload_file1(bytes, fileSuffixName, nameValuePairs.toArray(new NameValuePair[nameValues.size()]));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }

        return url;
    }


    /**
     * 上传图片不含附加属性
     */
    private static String uploadImageWitNothNameValuePair(byte[] bytes, String fileSuffixName) {

        String url = "";
        try {
            url = storageClient1.upload_file1(bytes, fileSuffixName, null);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (MyException e) {
            e.printStackTrace();
        }
        return url;
    }

    /**
     * 获取文件后缀名
     *
     * @param fileName
     * @return
     */
    private static String getFileSuffixName(String fileName) {
        if (StringUtils.isEmpty(fileName)) {
            return "";
        }
        if (!fileName.contains(".")) {
            return "";
        }
        String suffixName = fileName.substring(fileName.lastIndexOf(".") + 1);

        return suffixName;
    }


    /**
     * 获取数据字典内容
     */
    private Map<String, Object> getDataDicToMap() {

        List<DataDic> dataDics = dataDicMapper.getDataDirs(UserInfoUtil.getUser().getId());
        if (CollectionUtils.isEmpty(dataDics)) {
            return null;
        }
        return dataDics.stream().collect(Collectors.toMap(dataDic -> dataDic.getDicCode(), dataDic -> dataDic.getDataContent()));
    }


}