package com.hinton.mysql;

import com.github.pagehelper.PageInterceptor;
import com.github.pagehelper.autoconfigure.PageHelperProperties;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.BindResult;
import org.springframework.boot.context.properties.bind.Binder;
import org.springframework.boot.context.properties.source.ConfigurationPropertySource;
import org.springframework.boot.context.properties.source.ConfigurationPropertySources;
import org.springframework.context.EnvironmentAware;
import org.springframework.core.env.Environment;

import java.util.Properties;
import java.util.Set;


public class BaseDatasourceConfig implements EnvironmentAware {

    @Autowired
    private PageHelperProperties pageHelperProperties;

    private Iterable<ConfigurationPropertySource> sources;

    @Override
    public void setEnvironment(Environment environment) {
        sources = ConfigurationPropertySources.get(environment);//, "pagehelper."
    }

    protected  SqlSessionFactory addPageInterceptor(SqlSessionFactory sqlSessionFactory) {
        PageInterceptor interceptor = new PageInterceptor();
        Properties properties = pageHelperProperties.getProperties();

        Binder binder = new Binder(sources);
        BindResult<Properties> bindResult = binder.bind("pagehelper", Properties.class);
        Properties environmentProperties= bindResult.get();

        Set<String> environmentPropertiesKeys = environmentProperties.stringPropertyNames();
        for (String key : environmentPropertiesKeys) {
            if (!properties.containsKey(key)) {
                properties.setProperty(key, environmentProperties.getProperty(key));
            }
        }
        interceptor.setProperties(properties);
        sqlSessionFactory.getConfiguration().addInterceptor(interceptor);
        return sqlSessionFactory;
    }
}
