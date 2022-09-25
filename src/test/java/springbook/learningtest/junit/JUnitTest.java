package springbook.learningtest.junit;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@Configuration
class EmptyConfiguration {}

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = EmptyConfiguration.class)
public class JUnitTest {
    @Autowired ApplicationContext context;

    static Set<JUnitTest> testObjects = new HashSet<JUnitTest>();
    static ApplicationContext contextObject = null;

    @Test
    public void test1() {
        assertThat(testObjects).doesNotContain(this);
        testObjects.add(this);

        assertThat(contextObject == null || contextObject == this.context).isTrue();
        contextObject = this.context;
    }

    @Test public void test2() {
        assertThat(testObjects).doesNotContain(this);
        testObjects.add(this);

        Assertions.assertThat(contextObject == null || contextObject == this.context).isTrue();
        contextObject = this.context;
    }

    @Test public void test3() {
        assertThat(testObjects).doesNotContain(this);
        testObjects.add(this);

        Assertions.assertThat(contextObject == null || contextObject == this.context).isTrue();
        contextObject = this.context;
    }
}
