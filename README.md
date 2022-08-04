# 项目说明
基于开源版本的二次开发的个人博客。
关于原生项目详情见：
[myblog-mybatis](https://github.com/oneStarLR/myblog-mybatis)
# 技术栈
## 前端
- JS框架：JQuery
- CSS框架：Semantic UI官网
- Markdown编辑器：编辑器 Markdown
- 代码高亮：代码高亮 prism
- 动画效果：动画 animate.css
- 文章目录：目录生成 Tocbot
- 音乐盒：zplayer
- 照片墙：lightbox插件
## 后端
- 核心框架：SpringBoot 2.2.5
- 项目构建：jdk1.8、Maven 3
- 持久层框架：Mybatis
- 模板框架：Thymeleaf
- 分页插件：PageHelper
- 加密：MD5加密
## 数据库
- MySQL 5.7

# 二开说明
## 优化
- markdown引擎的渲染
- 删除部分已知冗余代码
- 压缩了CSS/JS等代码文件
- 解决CDN失效的问题
- 美化(个性化)部分页面与交互
- 后端SQL优化
- 大道至简，砍掉一些原生的功能
- 其他细节

## 新增
- 后台管理：文章的撤回、发布功能
- 网站白天/黑夜模式切换
- 网站公告弹窗功能
- 特殊节日全站哀悼模式
- 留言、评论区的表单后端校验、SQL优化
- 其他细节
## 其他
- 忘记了....

# 项目部署
关于部署，原作者在自己的博客里也有一套教程，包含了从部署到nginx反向代理部分。
当然我自己也写了一篇教程，mysql使用docker容器技术，简化部署的流程：
- 安装JDK11
- 安装docker
- 安装mysql5.7
- 打包部署
- nginx反向代理
- https加密协议
- ....
> 教程地址：
[SpringBoot博客部署](https://www.waer.ltd/articles/2022/08/04/1659587541384.html)

