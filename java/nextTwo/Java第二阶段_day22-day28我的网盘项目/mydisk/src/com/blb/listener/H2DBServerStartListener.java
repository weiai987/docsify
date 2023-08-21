package com.blb.listener;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.h2.tools.Server;

import com.blb.utils.DBUtils;
import com.blb.utils.IOUtils;

/**
 * 使用监听器启动h2数据库，如果不使用h2数据库，请在web.xml中去掉监听器
 * @author huahao
 *
 */
public class H2DBServerStartListener implements ServletContextListener {

    //H2数据库服务器启动实例
    private Server server;
    /*
     * Web应用初始化时启动H2数据库
     */
    public void contextInitialized(ServletContextEvent sce) {
        try {
            System.out.println("正在启动h2数据库...");
            //使用org.h2.tools.Server这个类创建一个H2数据库的服务并启动服务，由于没有指定任何参数，那么H2数据库启动时默认占用的端口就是8082
            server = Server.createTcpServer().start();
            System.out.println("h2数据库启动成功...");
            
            System.out.println("正在初始化表...");
            String sql = IOUtils.read("mydisk.sql");
            Connection connection = DBUtils.getConnection();
            PreparedStatement prepareStatement = connection.prepareStatement(sql);
            prepareStatement.execute();
            System.out.println("初始化表成功...");
        } catch (SQLException e) {
            System.out.println("启动h2数据库出错：" + e.toString());
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IOException e) {
        	System.out.println("启动h2数据库出错：" + e.toString());
			e.printStackTrace();
			throw new RuntimeException(e);
		}
    }

    /*
     * Web应用销毁时停止H2数据库
     */
    public void contextDestroyed(ServletContextEvent sce) {
        if (this.server != null) {
            // 停止H2数据库
            this.server.stop();
            this.server = null;
        }
    }
}