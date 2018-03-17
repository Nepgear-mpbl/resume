package cn.zhengzhaoyu.resume.common.model.base;

import com.jfinal.plugin.activerecord.Model;
import com.jfinal.plugin.activerecord.IBean;

/**
 * Generated by JFinal, do not modify this file.
 */
@SuppressWarnings({"serial", "unchecked"})
public abstract class BaseProjectInfo<M extends BaseProjectInfo<M>> extends Model<M> implements IBean {

	public M setId(java.lang.Integer id) {
		set("id", id);
		return (M)this;
	}

	public java.lang.Integer getId() {
		return get("id");
	}

	public M setBackground(java.lang.String background) {
		set("background", background);
		return (M)this;
	}

	public java.lang.String getBackground() {
		return get("background");
	}

	public M setIwork(java.lang.String iwork) {
		set("iwork", iwork);
		return (M)this;
	}

	public java.lang.String getIwork() {
		return get("iwork");
	}

	public M setResult(java.lang.String result) {
		set("result", result);
		return (M)this;
	}

	public java.lang.String getResult() {
		return get("result");
	}

	public M setProjectId(java.lang.Integer projectId) {
		set("project_id", projectId);
		return (M)this;
	}

	public java.lang.Integer getProjectId() {
		return get("project_id");
	}

}