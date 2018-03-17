package cn.zhengzhaoyu.resume.index;

import cn.zhengzhaoyu.resume.common.model.Project;
import cn.zhengzhaoyu.resume.common.model.TechStack;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class IndexService {
    private static final Project projectDao = new Project().dao();
    private static final TechStack techStackDao = new TechStack().dao();

    public List<Project> getAllProjectInfo() {
        List<Project> infos = projectDao.find(projectDao.getSqlPara("project.getAllProjectInfo"));
        if (null == infos) {
            return null;
        }
        return infos;
    }

    public Map<Integer, List<Record>> getTechStackNamesAndProjectId() {
        List<Record> ids = Db.find(projectDao.getSqlPara("project.getAllProjectId"));
        if (null == ids) {
            return null;
        }
        Map<Integer, List<Record>> techStackTable = new HashMap<>();
        for (Record i : ids) {
            Integer id = i.get("id");
            if (null == id) {
                return null;
            }
            List<Record> techStacks = Db.find(techStackDao.getSqlPara("techStack.getTechStackNameById", id));
            techStackTable.put(id, techStacks);
        }
        return techStackTable;
    }
}
