package com.sunchaser.earth.integrate.upload.impl.qiniu;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.sunchaser.earth.common.exceptions.EarthException;
import com.sunchaser.earth.common.property.UploadProperties;
import com.sunchaser.earth.integrate.upload.impl.AbstractUploader;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;

/**
 * 七牛云整合
 * @author sunchaser admin@lilu.org.cn
 * @since JDK8 2021/7/17
 */
@Component
@Slf4j
@DependsOn(value = "uploadProperties")
public class QiniuCloudUploader extends AbstractUploader implements InitializingBean {

    private static final String BASE_LOG = "上传七牛云";

    private UploadManager uploadManager;

    private UploadProperties.Qiniu qiniu;

    private Auth auth;

    @Override
    public void afterPropertiesSet() throws Exception {
        Configuration configuration = new Configuration(Region.huanan());
        uploadManager = new UploadManager(configuration);
        qiniu = this.uploadProperties.getQiniu();
        auth = Auth.create(qiniu.getAccessKey(), qiniu.getSecretKey());
    }

    @Override
    protected String doUpload(MultipartFile multipartFile, String fileURI) throws Exception {
        try {
            FileInputStream fileInputStream = (FileInputStream) multipartFile.getInputStream();
            String token = auth.uploadToken(qiniu.getBucketName());
            Response put = uploadManager.put(fileInputStream, fileURI, token, null, null);
            if (!put.isOK()) {
                throw new EarthException(BASE_LOG + "出错:" + put.toString());
            }
            DefaultPutRet defaultPutRet = new Gson().fromJson(put.bodyString(), DefaultPutRet.class);
            return qiniu.getDomain() + defaultPutRet.key;
        } catch (QiniuException qe) {
            Response response = qe.response;
            String errorRes = BASE_LOG + "异常:" + response.toString();
            log.error(errorRes);
            throw new EarthException(errorRes);
        }
    }
}
