package cn.zhengzhaoyu.resume.common;

import cn.zhengzhaoyu.resume.common.service.PictureService;
import com.jfinal.core.Controller;

public class CommonApiController extends Controller {
    private static final PictureService ps=new PictureService();
    public void picture(){
        Integer picId=getParaToInt("pictureId");
        renderFile(ps.getPicUrlById(picId));
    }
}
