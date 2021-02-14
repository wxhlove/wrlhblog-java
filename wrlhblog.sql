/*
 Navicat Premium Data Transfer

 Source Server         : centos-linux
 Source Server Type    : MySQL
 Source Server Version : 50731
 Source Host           : 10.211.55.7:3306
 Source Schema         : wrlhblog

 Target Server Type    : MySQL
 Target Server Version : 50731
 File Encoding         : 65001

 Date: 14/02/2021 13:24:49
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for article
-- ----------------------------
DROP TABLE IF EXISTS `article`;
CREATE TABLE `article` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `uid` bigint(19) DEFAULT NULL COMMENT '用户id',
  `sid` bigint(19) DEFAULT NULL COMMENT '分类id',
  `lid` bigint(19) DEFAULT NULL COMMENT '标签id',
  `title` varchar(255) DEFAULT NULL COMMENT '文章标题',
  `article_content` text COMMENT 'md文件源码/富文本源码',
  `edit_model` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '编辑模式(markdown /富文本)',
  `summary` text COMMENT '总结',
  `publish_time` datetime DEFAULT NULL COMMENT '发布日期',
  `edit_time` datetime DEFAULT NULL COMMENT '编辑日期',
  `state` int(11) DEFAULT NULL COMMENT '0表示草稿箱，1表示已发表，2表示已删除',
  `image_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '总结背景图片',
  PRIMARY KEY (`id`),
  KEY `article_sid` (`sid`) USING BTREE COMMENT '分类id',
  KEY `article_uid` (`uid`) USING BTREE COMMENT '用户id',
  KEY `article_lid` (`lid`) USING BTREE COMMENT '标签id',
  CONSTRAINT `article_lid_lableId` FOREIGN KEY (`lid`) REFERENCES `lable` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `article_sid_sortId` FOREIGN KEY (`sid`) REFERENCES `sort` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `article_uid_userId` FOREIGN KEY (`uid`) REFERENCES `user` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='文章表';

-- ----------------------------
-- Records of article
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for article_count
-- ----------------------------
DROP TABLE IF EXISTS `article_count`;
CREATE TABLE `article_count` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `aid` bigint(19) DEFAULT NULL COMMENT '文章id',
  `count_number` int(11) DEFAULT NULL COMMENT '文章点赞计数',
  `count_time` datetime DEFAULT NULL COMMENT '计数时间',
  PRIMARY KEY (`id`),
  KEY `articlecount_aid` (`aid`) USING BTREE COMMENT '文章id',
  CONSTRAINT `articlecount_aid_articleId` FOREIGN KEY (`aid`) REFERENCES `article` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='文章点赞计数表';

-- ----------------------------
-- Records of article_count
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `aid` bigint(19) DEFAULT NULL COMMENT '文章id',
  `uid` bigint(19) DEFAULT NULL COMMENT '用户id',
  `content` text COMMENT '评论内容',
  `parent_id` bigint(19) DEFAULT NULL COMMENT '父级id',
  `comment_time` datetime DEFAULT NULL COMMENT '评论时间',
  PRIMARY KEY (`id`),
  KEY `comment_aid` (`aid`) USING BTREE COMMENT '文章id',
  KEY `comment_uid` (`uid`) USING BTREE COMMENT '用户id',
  KEY `comment_parentId` (`parent_id`) USING BTREE COMMENT '父级id',
  CONSTRAINT `comment_aid_articleId` FOREIGN KEY (`aid`) REFERENCES `article` (`id`),
  CONSTRAINT `comment_parentid_id` FOREIGN KEY (`parent_id`) REFERENCES `comment` (`id`),
  CONSTRAINT `comment_uid_userId` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='评论表';

-- ----------------------------
-- Records of comment
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for comment_count
-- ----------------------------
DROP TABLE IF EXISTS `comment_count`;
CREATE TABLE `comment_count` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `cid` bigint(19) DEFAULT NULL COMMENT '评论id',
  `count_number` int(11) DEFAULT NULL COMMENT '点赞计数',
  `count_time` datetime DEFAULT NULL COMMENT '计数时间',
  PRIMARY KEY (`id`),
  KEY `commentcount_cid` (`cid`) USING BTREE COMMENT '评论表id',
  CONSTRAINT `commentcount_cid_commentId` FOREIGN KEY (`cid`) REFERENCES `comment` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='评论计数表';

-- ----------------------------
-- Records of comment_count
-- ----------------------------
BEGIN;
COMMIT;

-- ----------------------------
-- Table structure for data_dic
-- ----------------------------
DROP TABLE IF EXISTS `data_dic`;
CREATE TABLE `data_dic` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `uid` bigint(19) DEFAULT NULL COMMENT '用户id',
  `dic_code` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '字典代码',
  `dic_name` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '字典名称',
  `data_content` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '数据内容',
  `company` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '单位',
  `create_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '创建时间',
  `type` varchar(64) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '类型',
  `state` tinyint(1) DEFAULT NULL COMMENT '状态',
  `describe` varchar(255) COLLATE utf8mb4_bin DEFAULT NULL COMMENT '描述',
  `update_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `data_dic_code` (`dic_code`) USING BTREE COMMENT '数据编码',
  UNIQUE KEY `data_dic_name` (`dic_name`) USING BTREE COMMENT '数据名称'
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_bin COMMENT='数据字典表';

-- ----------------------------
-- Records of data_dic
-- ----------------------------
BEGIN;
INSERT INTO `data_dic` VALUES (1, 1, 'artucle_ summary_ picture_size', '文章总结图片存储大小', '1024', 'k', '2021-02-01 19:30:53', 'picture', 1, '文章总结图片展示', '2021-02-01 19:30:53');
COMMIT;

-- ----------------------------
-- Table structure for lable
-- ----------------------------
DROP TABLE IF EXISTS `lable`;
CREATE TABLE `lable` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `uid` bigint(19) DEFAULT NULL COMMENT '用户id',
  `name` varchar(64) DEFAULT NULL COMMENT '标签名称',
  `name_style_color` varchar(64) DEFAULT NULL COMMENT '标签样式颜色',
  `descripation` varchar(255) DEFAULT NULL COMMENT '描述',
  `add_username` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin DEFAULT NULL COMMENT '添加人姓名',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `comment_name` (`name`) USING BTREE COMMENT '标签名称'
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='分类表';

-- ----------------------------
-- Records of lable
-- ----------------------------
BEGIN;
INSERT INTO `lable` VALUES (1, 1, 'java', '#0F69E7', 'java 内容', 'wxhlove', '2021-01-22 13:54:41');
INSERT INTO `lable` VALUES (2, 1, 'vue', '#ED400C', 'vue内容', 'wxhlove', '2021-01-22 19:48:36');
COMMIT;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `url` varchar(64) DEFAULT NULL COMMENT 'url地址',
  `path` varchar(64) DEFAULT NULL COMMENT 'path地址',
  `component_dir` varchar(64) DEFAULT NULL COMMENT '模块所在文件夹',
  `component` varchar(64) DEFAULT NULL COMMENT '模块名称',
  `name` varchar(64) DEFAULT NULL COMMENT '菜单名称',
  `icon_cls` varchar(64) DEFAULT NULL COMMENT '菜单图标样式',
  `require_auth` tinyint(1) DEFAULT '1' COMMENT '是否需要登录',
  `parent_id` bigint(19) DEFAULT NULL COMMENT '父级id',
  `parent_is` tinyint(1) DEFAULT NULL COMMENT '当前是否是父级目录',
  `enabled` tinyint(1) DEFAULT '1' COMMENT '是否是父级目录',
  PRIMARY KEY (`id`),
  KEY `menu_parentId` (`parent_id`) USING BTREE COMMENT '父级id',
  CONSTRAINT `menu_parentid_id` FOREIGN KEY (`parent_id`) REFERENCES `menu` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='菜单表';

-- ----------------------------
-- Records of menu
-- ----------------------------
BEGIN;
INSERT INTO `menu` VALUES (1, '/', NULL, NULL, NULL, '所有', NULL, 1, NULL, 1, 1);
INSERT INTO `menu` VALUES (2, '/', '/layout', '', 'Layout', '博客管理', 'fa fa-file-text-o', 1, 1, 1, 1);
INSERT INTO `menu` VALUES (3, '/', '/layout', '', 'Layout', '私人备用', 'fa fa-hand-paper-o', 1, 1, 1, 1);
INSERT INTO `menu` VALUES (4, '/', '/layout', '', 'Layout', '黑果管理', 'fa fa-laptop', 1, 1, 1, 1);
INSERT INTO `menu` VALUES (5, '/', '/layout', '', 'Layout', '会员管理', 'fa fa-user-o', 1, 1, 1, 1);
INSERT INTO `menu` VALUES (6, '/', '/layout', '', 'Layout', '日志管理', 'fa fa-file-o', 1, 1, 1, 1);
INSERT INTO `menu` VALUES (7, '/', '/layout', '', 'Layout', '系统管理', 'fa fa-cog', 1, 1, 1, 1);
INSERT INTO `menu` VALUES (8, '/blog/articlesearch/**', '/blog/articlesearch', 'blog', 'ArticleSearch', '文章查询', 'fa fa-columns', 1, 2, 0, 1);
INSERT INTO `menu` VALUES (9, '/private/edit/**', '/private/edit', 'private', 'PrivateEdit', '私人编辑', NULL, 1, 3, 0, 1);
INSERT INTO `menu` VALUES (10, '/blackmack/edit/**', '/blackmack/edit', 'blackmac', 'BlackmackEdit', '黑果编辑', NULL, 1, 4, 0, 1);
INSERT INTO `menu` VALUES (11, '/member/edit/**', '/member/edit', 'member', 'MemberEdit', '会员编辑', NULL, 1, 5, 0, 1);
INSERT INTO `menu` VALUES (12, '/log/edit/**', '/log/edit', 'log', 'LogEdit', '日志编辑', NULL, 1, 6, 0, 1);
INSERT INTO `menu` VALUES (13, '/system/edit/**', '/system/edit', 'system', 'SystemEdit', '系统编辑', '', 1, 7, 0, 1);
INSERT INTO `menu` VALUES (14, '/blog/articleedit/**', '/blog/articleedit', 'blog', 'ArticleEdit', '文章编辑', 'fa fa-pencil-square-o', 1, 2, 0, 1);
INSERT INTO `menu` VALUES (15, '/blog/lablesort/**', '/blog/lablesort', 'blog', 'LableSort', '应用管理', 'fa fa-tags', 1, 2, 0, 1);
INSERT INTO `menu` VALUES (16, '/blog/articlemanage/**', '/blog/articlemanage', 'blog', 'ArticleManage', '文章管理', 'fa fa-list-alt', 1, 2, 0, 1);
COMMIT;

-- ----------------------------
-- Table structure for role
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `name` varchar(32) NOT NULL COMMENT '角色名(英文)',
  `alias` varchar(32) NOT NULL COMMENT '角色别名',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_name` (`name`) USING BTREE COMMENT '角色名'
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='角色表';

-- ----------------------------
-- Records of role
-- ----------------------------
BEGIN;
INSERT INTO `role` VALUES (1, 'ROLE_admin', '管理员', '2021-01-05 22:36:25');
COMMIT;

-- ----------------------------
-- Table structure for role_menu
-- ----------------------------
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT,
  `rid` bigint(19) DEFAULT NULL,
  `mid` bigint(19) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `rolemenu_rid` (`rid`) USING BTREE COMMENT '角色id',
  KEY `rolemenu_mid` (`mid`) USING BTREE COMMENT '菜单id',
  CONSTRAINT `rolemenu_mid_menuId` FOREIGN KEY (`mid`) REFERENCES `menu` (`id`),
  CONSTRAINT `rolemenu_rid_roleId` FOREIGN KEY (`rid`) REFERENCES `role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='角色菜单关联表';

-- ----------------------------
-- Records of role_menu
-- ----------------------------
BEGIN;
INSERT INTO `role_menu` VALUES (1, 1, 8);
INSERT INTO `role_menu` VALUES (2, 1, 9);
INSERT INTO `role_menu` VALUES (3, 1, 10);
INSERT INTO `role_menu` VALUES (4, 1, 11);
INSERT INTO `role_menu` VALUES (5, 1, 12);
INSERT INTO `role_menu` VALUES (6, 1, 13);
COMMIT;

-- ----------------------------
-- Table structure for sort
-- ----------------------------
DROP TABLE IF EXISTS `sort`;
CREATE TABLE `sort` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `uid` bigint(19) DEFAULT NULL COMMENT '用户id',
  `name` varchar(64) DEFAULT NULL COMMENT '标签名称',
  `name_style_color` varchar(64) DEFAULT NULL COMMENT '标签样式',
  `descripation` varchar(255) DEFAULT NULL COMMENT '描述',
  `add_username` varchar(64) DEFAULT NULL COMMENT '添加人名称',
  `add_time` datetime DEFAULT NULL COMMENT '添加时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `sort_name` (`name`) USING BTREE COMMENT '标签名称'
) ENGINE=InnoDB AUTO_INCREMENT=1352887955114426372 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='分类表';

-- ----------------------------
-- Records of sort
-- ----------------------------
BEGIN;
INSERT INTO `sort` VALUES (1, 1, 'java', '#0DEDF5', 'java后端', 'wxhlove', '2021-01-23 15:53:50');
INSERT INTO `sort` VALUES (1352887955114426371, 1, 'vue', '#E6D410', 'vue 哈哈', 'wxhlove', '2021-01-25 11:46:26');
COMMIT;

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `username` varchar(32) NOT NULL COMMENT '用户名',
  `nickname` varchar(32) NOT NULL COMMENT '用户昵称',
  `password` varchar(255) NOT NULL COMMENT '用户密码',
  `email` varchar(64) NOT NULL COMMENT '用户邮箱',
  `telephone` varchar(16) NOT NULL COMMENT '用户电话',
  `birthady` datetime DEFAULT NULL COMMENT '用户生日',
  `user_face` varchar(255) DEFAULT NULL COMMENT '用户头像',
  `regisation_time` datetime NOT NULL COMMENT '注册时间',
  `enable` tinyint(1) NOT NULL COMMENT '是否启用',
  PRIMARY KEY (`id`),
  UNIQUE KEY `user_username` (`username`) USING BTREE COMMENT '用户名'
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户表';

-- ----------------------------
-- Records of user
-- ----------------------------
BEGIN;
INSERT INTO `user` VALUES (1, 'wxhlove', '落霞孤鹜', '$2a$10$ySG2lkvjFHY5O0./CPIE1OI8VJsuKYEzOYzqIa7AJR6sEgSzUFOAm', '601983393@qq.com', '18571585515', '1989-10-14 13:12:52', 'https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2398780591,2077326219&fm=26&gp=0.jpg', '2020-12-31 13:13:11', 1);
COMMIT;

-- ----------------------------
-- Table structure for user_role
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` bigint(19) NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `uid` bigint(19) NOT NULL COMMENT '用户id',
  `rid` bigint(19) NOT NULL COMMENT '角色id',
  PRIMARY KEY (`id`),
  KEY `userrole_uid` (`uid`) USING BTREE COMMENT '用户id',
  KEY `userrole_rid` (`rid`) USING BTREE COMMENT '角色id',
  CONSTRAINT `userrole_rid` FOREIGN KEY (`rid`) REFERENCES `role` (`id`),
  CONSTRAINT `userrole_uid` FOREIGN KEY (`uid`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC COMMENT='用户角色关联表';

-- ----------------------------
-- Records of user_role
-- ----------------------------
BEGIN;
INSERT INTO `user_role` VALUES (1, 1, 1);
COMMIT;

SET FOREIGN_KEY_CHECKS = 1;
