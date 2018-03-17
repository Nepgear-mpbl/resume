package cn.zhengzhaoyu.resume.common;

import cn.zhengzhaoyu.resume.common.model._MappingKit;
import com.jfinal.config.*;
import com.jfinal.core.JFinal;
import com.jfinal.json.MixedJsonFactory;
import com.jfinal.kit.PathKit;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.activerecord.IDataSourceProvider;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;

public class Config extends JFinalConfig {

    private static final Prop prop = loadConfig();

    private static Prop loadConfig() {
        try {
            return PropKit.use("config-dev.properties");
        } catch (RuntimeException e) {
            return PropKit.use("config.properties");
        }
    }

    public static void main(String[] args) {
        JFinal.start("src/main/webapp", 80, "/");
    }

    @Override
    public void configConstant(Constants me) {
        me.setDevMode(prop.getBoolean("devMode"));
        me.setJsonFactory(MixedJsonFactory.me());
    }

    @Override
    public void configRoute(Routes me) {
        me.add(new FrontRoute());
    }

    @Override
    public void configEngine(Engine me) {
        me.addSharedFunction("/_view/common/__layout.html");
    }

    @Override
    public void configPlugin(Plugins me) {
        DruidPlugin dp = getDruidPlugin();
        me.add(dp);
        ActiveRecordPlugin arp = getActiveRecordPlugin(dp);
        me.add(arp);
    }

    @Override
    public void configInterceptor(Interceptors me) {

    }

    @Override
    public void configHandler(Handlers me) {

    }

    public DruidPlugin getDruidPlugin() {
        String url = prop.get("druid.url");
        String username = prop.get("druid.username");
        String password = prop.get("druid.password");
        String driverClass = prop.get("druid.driverClass");
        return new DruidPlugin(url, username, password, driverClass);
    }
    private ActiveRecordPlugin getActiveRecordPlugin(IDataSourceProvider provider) {
        ActiveRecordPlugin arp = new ActiveRecordPlugin(provider);
        arp.setDialect(new MysqlDialect());
        _MappingKit.mapping(arp);
        arp.setBaseSqlTemplatePath(PathKit.getWebRootPath() + "/_sql");
        arp.addSqlTemplate("all.sql");
        return arp;
    }
}
