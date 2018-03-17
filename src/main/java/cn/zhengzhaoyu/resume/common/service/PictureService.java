package cn.zhengzhaoyu.resume.common.service;

import cn.zhengzhaoyu.resume.common.model.Picture;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import java.util.List;

public class PictureService {
    private static final Picture pictureDao = new Picture().dao();

    public String getPicUrlById(Integer id) {
        Picture url = pictureDao.findFirst(pictureDao.getSqlPara("picture.getPicUrlById", id));
        if (null == url) {
            return null;
        }
        return url.getUrl();
    }
}
