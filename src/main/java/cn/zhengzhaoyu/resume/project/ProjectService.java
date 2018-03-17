package cn.zhengzhaoyu.resume.project;

import cn.zhengzhaoyu.resume.common.model.Picture;
import cn.zhengzhaoyu.resume.common.model.Project;
import cn.zhengzhaoyu.resume.common.model.ProjectInfo;
import cn.zhengzhaoyu.resume.common.model.TechStack;

import java.util.ArrayList;
import java.util.List;

public class ProjectService {
    private static final Project projectDao = new Project().dao();
    private static final ProjectInfo projectInfoDao = new ProjectInfo().dao();
    private static final TechStack techStackDao = new TechStack().dao();
    private static final Picture pictureDao = new Picture().dao();

    public Project getInfoById(Integer id) {
        Project info = projectDao.findFirst(projectDao.getSqlPara("project.getInfoById", id));
        if (null == info) {
            return null;
        }
        return info;
    }

    public ProjectInfo getDetailById(Integer id) {
        ProjectInfo detail = projectInfoDao.findFirst(projectInfoDao.getSqlPara("projectInfo.getDetailById", id));
        if (null == detail) {
            return null;
        }
        return detail;
    }

    public List<TechStack> getTechStackById(Integer id) {
        List<TechStack> techStacks = techStackDao.find(techStackDao.getSqlPara("techStack.getTechStackById", id));
        if (null == techStacks) {
            return null;
        }
        return techStacks;
    }

    public List<Integer> getPictureIdsById(Integer id){
        List<Picture> pictures = pictureDao.find(pictureDao.getSqlPara("picture.getPicIdByProjectId", id));
        if (null == pictures) {
            return null;
        }
        List<Integer> picIds=new ArrayList<>();
        for (Picture p:pictures) {
            picIds.add(p.getId());
        }
       return picIds;
    }
}
