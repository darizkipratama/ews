package com.sipdasrh.ews;

import com.sipdasrh.ews.config.AsyncSyncConfiguration;
import com.sipdasrh.ews.config.EmbeddedRedis;
import com.sipdasrh.ews.config.EmbeddedSQL;
import com.sipdasrh.ews.config.JacksonConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { EwsApp.class, JacksonConfiguration.class, AsyncSyncConfiguration.class })
@EmbeddedRedis
@EmbeddedSQL
public @interface IntegrationTest {
}
