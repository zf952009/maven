package cn.itcast.config;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * codening:utf-8
 *
 * @author :TxxsAbstractRoutingDataSource
 * @time :2019.08.28,11:00
 * @file :cn.itcast.config.TxxsAbstractRoutingDataSource.jave
 */
public class TxxsAbstractRoutingDataSource extends AbstractRoutingDataSource {

    private final int dataSourceNumber;
    private AtomicInteger count = new AtomicInteger(0);

    public TxxsAbstractRoutingDataSource(int dataSourceNumber) {
        this.dataSourceNumber = dataSourceNumber;
    }


    /**
     * Determine the current lookup key. This will typically be
     * implemented to check a thread-bound transaction context.
     * <p>Allows for arbitrary keys. The returned key needs
     * to match the stored lookup key type, as resolved by the
     * {@link #resolveSpecifiedLookupKey} method.
     */
    @Override
    protected Object determineCurrentLookupKey() {

        return null;
    }
}
