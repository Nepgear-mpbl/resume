package cn.zhengzhaoyu.resume.common;

import cn.zhengzhaoyu.resume.index.IndexController;
import cn.zhengzhaoyu.resume.others.OthersController;
import cn.zhengzhaoyu.resume.project.ProjectController;
import com.jfinal.config.Routes;

public class FrontRoute extends Routes{
    @Override
    public void config() {
        setBaseViewPath("_view");
        add("/", IndexController.class, "/index");
        add("/api", CommonApiController.class);
        add("/project", ProjectController.class);
        add("/others", OthersController.class);
    }
}
