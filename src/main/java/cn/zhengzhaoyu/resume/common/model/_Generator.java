package cn.zhengzhaoyu.resume.common.model;

import cn.zhengzhaoyu.resume.common.Config;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.activerecord.generator.Generator;
import com.jfinal.plugin.druid.DruidPlugin;

public class _Generator {
    public static void main(String[] args) {

        String baseModelPackageName = "cn.zhengzhaoyu.resume.common.model.base";
        String baseModelOutputDir = "src/main/java/cn/zhengzhaoyu/resume/common/model/base";
        String modelPackageName = "cn.zhengzhaoyu.resume.common.model";
        String modelOutputDir = "src/main/java/cn/zhengzhaoyu/resume/common/model";

        DruidPlugin dp = new Config().getDruidPlugin();
        dp.start();

        Generator generator = new Generator(dp.getDataSource(), baseModelPackageName, baseModelOutputDir, modelPackageName, modelOutputDir);

        generator.setDialect(new MysqlDialect());
        generator.setGenerateChainSetter(true);
        generator.setGenerateDaoInModel(false);
        generator.setRemovedTableNamePrefixes("r_");
        generator.setGenerateDataDictionary(false);

        generator.generate();

        dp.stop();

    }
}
