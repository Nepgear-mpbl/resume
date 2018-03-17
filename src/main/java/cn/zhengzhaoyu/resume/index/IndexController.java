package cn.zhengzhaoyu.resume.index;

import cn.zhengzhaoyu.resume.common.model.Project;
import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Record;

import java.util.List;
import java.util.Map;

public class IndexController extends Controller {
    private static final IndexService srv=new IndexService();
    public void index(){
        List<Project> projects=srv.getAllProjectInfo();
        Map<Integer,List<Record>> techStacks=srv.getTechStackNamesAndProjectId();
        setAttr("projects",projects);
        setAttr("techStacks",techStacks);
        render("index.html");
    }
}
