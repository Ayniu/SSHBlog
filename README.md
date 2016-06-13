### SSHBlog
- 本系统（nodeJothy）是使用SSH框架搭建的简易博客系统。
- 主要功能

  用户注册、登陆、修改个人信息、搜索用户、关注用户；管理员查看所有用户、删除用户、搜索用户；用户查看个人微博、查看其他人的微博、查看自己的关注人和粉丝等。

- 待实现/优化功能
  1. 查看关注的人与粉丝时，可以更进一步显示双方之间的关系
  2. 用户主页可以显示关注的人的微博
  3. 外键实体类关联表的存储与删除的处理的理解还不够透彻，需加强！

- Usage

  在Eclipse等IDE中新建Web Project，命名为weibo，将本项目代码拷贝进去，接着将项目部署到服务器。在浏览器输入***localhost:port/weibo/home.jsp***即可访问.(home.jsp为入口文件)
