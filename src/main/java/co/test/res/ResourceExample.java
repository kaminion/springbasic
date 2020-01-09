package co.test.res;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class ResourceExample implements ResourceLoaderAware {
    //@AutoWired
    private ResourceLoader resourceLoader;

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
        System.out.println(resourceLoader.getClassLoader());
    }

    public void print()
    {
        System.out.println(resourceLoader);
    }
}
