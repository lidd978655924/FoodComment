
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `t_admin`
-- ----------------------------
DROP TABLE IF EXISTS `t_admin`;
CREATE TABLE `t_admin` (
  `userId` bigint(20)  NOT NULL AUTO_INCREMENT,
  `userName` varchar(50)  DEFAULT NULL,
  `userPw` varchar(50)  DEFAULT NULL,
  PRIMARY KEY (`userId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

insert t_admin(userName,userPw) values ("admin","admin");

-- ----------------------------
-- Table structure for `t_liuyan`
-- ----------------------------
DROP TABLE IF EXISTS `t_liuyan`;
CREATE TABLE `t_liuyan` (
  `liuyan_id` bigint(20)  NOT NULL AUTO_INCREMENT,
  `liuyan_title` varchar(50)  DEFAULT NULL,
  `liuyan_content` varchar(5000) DEFAULT NULL,
  `liuyan_date` varchar(50)  DEFAULT NULL,
  `liuyan_user` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`liuyan_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `t_gonggao`
-- ----------------------------
DROP TABLE IF EXISTS `t_gonggao`;
CREATE TABLE `t_gonggao` (
  `gonggao_id` bigint(20)  NOT NULL AUTO_INCREMENT,
  `gonggao_title` varchar(50)  DEFAULT NULL,
  `gonggao_content` varchar(8000)  DEFAULT NULL,
  `gonggao_data` varchar(50)  DEFAULT NULL,
  `gonggao_fabuzhe` varchar(255)  DEFAULT NULL,
  `gonggao_del` varchar(50)  DEFAULT NULL,
  `gonggao_one1` varchar(50)  DEFAULT NULL,
  `gonggao_one2` varchar(50)  DEFAULT NULL,
  `gonggao_one3` varchar(50)  DEFAULT NULL,
  `gonggao_one4` varchar(50)  DEFAULT NULL,
  `gonggao_one5` varchar(23)  DEFAULT NULL,
  `gonggao_one6` varchar(23)  DEFAULT NULL,
  `gonggao_one7` varchar(255)  DEFAULT NULL,
  `gonggao_one8` varchar(255)  DEFAULT NULL,
  PRIMARY KEY (`gonggao_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `user_id` bigint(20)  NOT NULL AUTO_INCREMENT,
  `user_name` varchar(50)  DEFAULT NULL,
  `user_pw` varchar(8000)  DEFAULT NULL,
  `user_type` int  DEFAULT NULL,
  `user_realname` varchar(50)  DEFAULT NULL,
  `user_address` varchar(50)  DEFAULT NULL,
  `user_sex` varchar(50)  DEFAULT NULL,
  `user_tel` varchar(50)  DEFAULT NULL,
  `user_email` varchar(50)  DEFAULT NULL,
  `user_qq` varchar(50)  DEFAULT NULL,
  `user_man` varchar(50)  DEFAULT NULL,
  `user_age` varchar(50)  DEFAULT NULL,
  `user_birthday` varchar(50)  DEFAULT NULL,
  `user_xueli` varchar(50)  DEFAULT NULL,
  `user_del` varchar(50)  DEFAULT NULL,
  `user_one1` varchar(50)  DEFAULT NULL,
  `user_one2` varchar(50)  DEFAULT NULL,
  `user_one3` varchar(50)  DEFAULT NULL,
  `user_one4` varchar(50)  DEFAULT NULL,
  `user_one5` varchar(50)  DEFAULT NULL,
  `user_one6` varchar(255)  DEFAULT NULL,
  `user_one7` varchar(255)  DEFAULT NULL,
  `user_one8` varchar(50)  DEFAULT NULL,
  `user_one9` varchar(23)  DEFAULT NULL,
  `user_one10` varchar(23)  DEFAULT NULL,
  `user_one11` varchar(255)  DEFAULT NULL,
  `user_one12` varchar(255)  DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `t_catelog`
-- ----------------------------
DROP TABLE IF EXISTS `t_catelog`;
CREATE TABLE `t_catelog` (
  `catelog_id` bigint(20)  NOT NULL AUTO_INCREMENT,
  `catelog_name` varchar(50)  DEFAULT NULL,
  `catelog_miaoshu` varchar(5000)  DEFAULT NULL,
  `catelog_del` varchar(50)  DEFAULT NULL,
  PRIMARY KEY (`catelog_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for `t_product`
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
  `product_id` bigint(20)  NOT NULL AUTO_INCREMENT,
  `product_name` varchar(50)  DEFAULT NULL,
  `product_miaoshu` varchar(5000)  DEFAULT NULL,
  `product_pic` varchar(50)  DEFAULT NULL,
  `product_yanse` varchar(50)  DEFAULT NULL,
  `product_shichangjia` int  DEFAULT NULL,
  `product_tejia` int  DEFAULT NULL,
  `product_isnottejia` varchar(50)  DEFAULT NULL,
  `product_isnottuijian` varchar(50)  DEFAULT NULL,
  `product_catelog_id` int  DEFAULT NULL,
  `product_kucun` int  DEFAULT NULL,
  `product_Del` varchar(50)  DEFAULT NULL,
  `product_shrq` varchar(50)  DEFAULT NULL,
  `product_haoping` int  DEFAULT NULL,
  `product_zhongping` int  DEFAULT NULL,
  `product_chaping` int  DEFAULT NULL,
  PRIMARY KEY (`product_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- ----------------------------
-- Table structure for `t_pingjia`
-- ----------------------------
DROP TABLE IF EXISTS `t_pingjia`;
CREATE TABLE `t_pingjia` (
  `id` bigint(20)  NOT NULL AUTO_INCREMENT,
  `content` varchar(5000)  DEFAULT NULL,
  `shijian` varchar(50)  DEFAULT NULL,
  `productId` int  DEFAULT NULL,
  `userId` int  DEFAULT NULL,
  `del` varchar(50)  DEFAULT NULL,
  `haoping` int  DEFAULT NULL,
  `zhongping` int  DEFAULT NULL,
  `chaping` int  DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for `t_goods`
-- ----------------------------
DROP TABLE IF EXISTS `t_goods`;
CREATE TABLE `t_goods` (
  `goods_id` bigint(20)  NOT NULL AUTO_INCREMENT,
  `goods_name` varchar(50)  DEFAULT NULL,
  `goods_miaoshu` varchar(5000)  DEFAULT NULL,
  `goods_pic` varchar(50)  DEFAULT NULL,
  `goods_yanse` varchar(50)  DEFAULT NULL,
  `goods_shichangjia` int  DEFAULT NULL,
  `goods_tejia` int  DEFAULT NULL,
  `goods_isnottejia` varchar(50)  DEFAULT NULL,
  `goods_isnottuijian` varchar(50)  DEFAULT NULL,
  `goods_catelog_id` int  DEFAULT NULL,
  `goods_Del` int  DEFAULT NULL,
  PRIMARY KEY (`goods_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- ----------------------------
-- Table structure for `t_picNews`
-- ----------------------------
DROP TABLE IF EXISTS `t_picNews`;
CREATE TABLE `t_picNews` (
  `picNews_id` bigint(20)  NOT NULL AUTO_INCREMENT,
  `picNews_title` varchar(50)  DEFAULT NULL,
  `picNews_content` varchar(8000)  DEFAULT NULL,
  `fujian` varchar(8000)  DEFAULT NULL,
  `fujian_yuanshiming` varchar(50)  DEFAULT NULL,
  `picNews_date` varchar(50)  DEFAULT NULL,
  `picNews_one1` varchar(50)  DEFAULT NULL,
  `picNews_one2` varchar(50)  DEFAULT NULL,
  `picNews_one4` varchar(50)  DEFAULT NULL,
  `picNews_one5` varchar(23)  DEFAULT NULL,
  `picNews_one6` varchar(23)  DEFAULT NULL,
  `picNews_one7` varchar(255)  DEFAULT NULL,
  `picNews_one8` varchar(255)  DEFAULT NULL,
  PRIMARY KEY (`picNews_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


