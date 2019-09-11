package cn.itcast.config;

import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.TransactionIsolationLevel;

import java.sql.Connection;

/**
 * codening:utf-8
 *
 * @author :SqlSessionFactory
 * @time :2019.08.30,15:09
 * @file :cn.itcast.config.SqlSessionFactory.jave
 */
//@Configuration
public class SqlSessionFactory implements org.apache.ibatis.session.SqlSessionFactory {
    @Override
    public SqlSession openSession() {
        return null;
    }

    @Override
    public SqlSession openSession(boolean autoCommit) {
        return null;
    }

    @Override
    public SqlSession openSession(Connection connection) {
        return null;
    }

    @Override
    public SqlSession openSession(TransactionIsolationLevel level) {
        return null;
    }

    @Override
    public SqlSession openSession(ExecutorType execType) {
        return null;
    }

    @Override
    public SqlSession openSession(ExecutorType execType, boolean autoCommit) {
        return null;
    }

    @Override
    public SqlSession openSession(ExecutorType execType, TransactionIsolationLevel level) {
        return null;
    }

    @Override
    public SqlSession openSession(ExecutorType execType, Connection connection) {
        return null;
    }

    @Override
    public org.apache.ibatis.session.Configuration getConfiguration() {
        return null;
    }
}
