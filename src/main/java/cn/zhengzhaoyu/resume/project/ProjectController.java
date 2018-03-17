package cn.zhengzhaoyu.resume.project;

import com.jfinal.core.Controller;

import java.util.List;

public class ProjectController extends Controller {
    private static final ProjectService srv = new ProjectService();

    public void index() {
        Integer id = getParaToInt("projectId");
        setAttr("info",srv.getInfoById(id));
        setAttr("detail",srv.getDetailById(id));
        setAttr("techStacks",srv.getTechStackById(id));
        setAttr("pictureIds",srv.getPictureIdsById(id));
        render("project.html");
    }
}
