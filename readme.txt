开发目的：做一个Shiro的demo
开发成果：
1、根据不同的角色展示不同的菜单管理，这个没有实现，具体不难，只需要根据权限类型，判断该角色是否具备显示菜单的权限即可
2、根据不同角色展示CRUD，已经实现。实现原理
       2.1、在Relam中，继承AuthorizingRealm，做身份认证和授权管理，并且授权管理存放到Shiro的StringPermission中
       2.2、在Controller中，定义注解@RequestPermission，并且权限标签，为用户是否具备访问该方法做权限控制
       2.3、在页面中，使用Shiro的标签：<shiro:hasPermission name="">  name中定义的是权限标签，做按钮控制处理（未实现）
       2.4、参考网站：http://412887952-qq-com.iteye.com/blog/2299777