CREATE TABLE IF NOT EXISTS `catalog`
(
	  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '分类id',
	  `name` varchar(20) DEFAULT NULL COMMENT '分类名称',
	  `alias_name` varchar(20) DEFAULT NULL COMMENT '别名',
	  `create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
	  `lastModifyTime` bigint(20) DEFAULT NULL COMMENT '修改时间',
	  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `tag`
(
	`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标签id',
	`name` varchar(20) DEFAULT NULL COMMENT '标签名称',
	`alias_name` varchar(20) DEFAULT NULL COMMENT '别名',
	`create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
	`lastModifyTime` bigint(20) DEFAULT NULL COMMENT '修改时间',
	PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `article`
(
	`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '文章id',
	`title` varchar(100) DEFAULT NULL COMMENT '题目',
	`cover_img` varchar(100) DEFAULT NULL COMMENT '封面',
	`description` varchar(100) DEFAULT NULL COMMENT '简述',
	`content` LONGTEXT DEFAULT NULL COMMENT '文章内容',
	`click_count` bigint(10) DEFAULT NULL COMMENT '浏览量',
	`comment_count` bigint(10) DEFAULT NULL COMMENT '评论量',
	`praise_count` bigint(10) DEFAULT NULL COMMENT '点赞量',
	`is_top` int(2) DEFAULT NULL COMMENT '是否置顶',
	`status` int(2) DEFAULT NULL COMMENT '状态',
	`create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
	`lastModifyTime` bigint(20) DEFAULT NULL COMMENT '修改时间',
	PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;


CREATE TABLE IF NOT EXISTS `articletag`
(
	`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标签id',
	`article_id` varchar(20) DEFAULT NULL COMMENT '文章ID',
	`tag_id` varchar(20) DEFAULT NULL COMMENT '标签ID',
	`create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
	`lastModifyTime` bigint(20) DEFAULT NULL COMMENT '修改时间',
	PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `articlecatalog`
(
	`id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '标签id',
	`article_id` varchar(20) DEFAULT NULL COMMENT '文章ID',
	`catalog_id` varchar(20) DEFAULT NULL COMMENT '分类ID',
	`create_time` bigint(20) DEFAULT NULL COMMENT '创建时间',
	`lastModifyTime` bigint(20) DEFAULT NULL COMMENT '修改时间',
	PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;
