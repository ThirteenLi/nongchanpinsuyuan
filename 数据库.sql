/*
SQLyog Professional v12.08 (64 bit)
MySQL - 5.5.49 : Database - gap1
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`gap1` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `gap1`;

/*Table structure for table `base_dict` */

DROP TABLE IF EXISTS `base_dict`;

CREATE TABLE `base_dict` (
  `dict_id` varchar(32) NOT NULL COMMENT '数据字典id(主键)',
  `dict_type_code` varchar(10) NOT NULL COMMENT '数据字典类别代码',
  `dict_type_name` varchar(64) NOT NULL COMMENT '数据字典类别名称',
  `dict_item_name` varchar(64) NOT NULL COMMENT '数据字典项目名称',
  `dict_item_code` varchar(10) DEFAULT NULL COMMENT '数据字典项目(可为空)',
  `dict_sort` int(10) DEFAULT NULL COMMENT '排序字段',
  `dict_enable` char(1) NOT NULL COMMENT '1:使用 0:停用',
  `dict_memo` varchar(64) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`dict_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `base_dict` */

/*Table structure for table `t_agent` */

DROP TABLE IF EXISTS `t_agent`;

CREATE TABLE `t_agent` (
  `id_dls` int(11) NOT NULL AUTO_INCREMENT,
  `phoneNumber_dls` varchar(255) DEFAULT NULL,
  `password_dls` varchar(255) DEFAULT NULL,
  `realName_dls` varchar(255) DEFAULT NULL,
  `gender_dls` varchar(255) DEFAULT NULL,
  `email_dls` varchar(255) DEFAULT NULL,
  `IDCardNum_dls` varchar(255) DEFAULT NULL,
  `pictureIDCF_dls` varchar(255) DEFAULT NULL,
  `pictureIDCB_dls` varchar(255) DEFAULT NULL,
  `pictureIDC_dls` varchar(255) DEFAULT NULL,
  `condition_dls` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id_dls`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `t_agent` */

insert  into `t_agent`(`id_dls`,`phoneNumber_dls`,`password_dls`,`realName_dls`,`gender_dls`,`email_dls`,`IDCardNum_dls`,`pictureIDCF_dls`,`pictureIDCB_dls`,`pictureIDC_dls`,`condition_dls`) values (1,'123456','','哈哈哈','','','0','','','',1),(2,'12345','1','张小红','先生','1','0',NULL,NULL,NULL,1),(3,'1','1','唐先生','先生','123@qq.com','0',NULL,NULL,NULL,1),(5,'18888888888','','哈哈哈','先生','123@qq.com','0',NULL,NULL,NULL,-1),(6,'2','123','2','先生','2','0',NULL,NULL,NULL,1);

/*Table structure for table `t_apply` */

DROP TABLE IF EXISTS `t_apply`;

CREATE TABLE `t_apply` (
  `id_message` bigint(20) NOT NULL AUTO_INCREMENT,
  `usercategory` varchar(255) DEFAULT NULL,
  `userid` bigint(20) DEFAULT NULL,
  `applycategory` varchar(255) DEFAULT NULL,
  `userapply` varchar(255) DEFAULT NULL,
  `zt` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_message`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

/*Data for the table `t_apply` */

insert  into `t_apply`(`id_message`,`usercategory`,`userid`,`applycategory`,`userapply`,`zt`) values (1,'farmer',10,'农场注销申请','我想删除1号农场，望批准。','审核成功'),(2,'farmer',10,'其它要求','分页测试1','审核成功'),(3,'farmer',10,'农场信息修改','分页测试2','已成功提交到后台'),(4,'farmer',10,'农场信息修改','分页测试3','0'),(5,'farmer',10,'农场注销申请','分页测试4','1'),(6,'farmer',10,'农场信息修改','分页测试5','1'),(7,'farmer',10,'农户留言','测试留言','我们会尽快解决'),(8,'farmer',10,'农户信息变更','把我名字变成1','1'),(9,'farmer',10,'农户信息变更','我到公安局改名了叫小星星','可以'),(13,'farmer',10,'农户信息变更','测试2055','同意'),(14,'farmer',15,'农户留言','我的菜真的很好吃啊！','是的'),(15,'farmer',10,'农场信息修改','',NULL),(16,'agent',3,'代理点信息修改','发符文防守打法热通过个人',NULL),(17,'agent',3,'代理点注销申请','删除测试11111111111111111',NULL),(18,'agent',3,'代理商信息变更','ad噶十多个地方噶顺德',NULL),(19,'agent',3,'代理商留言','阿根廷如果仍',NULL),(20,'agent',3,'代理商信息变更','爱迪生发发',NULL);

/*Table structure for table `t_checker` */

DROP TABLE IF EXISTS `t_checker`;

CREATE TABLE `t_checker` (
  `id_zjy` bigint(11) NOT NULL AUTO_INCREMENT,
  `username_zjy` varchar(255) DEFAULT NULL,
  `password_zjy` varchar(255) DEFAULT NULL,
  `realName_zjy` varchar(255) DEFAULT NULL,
  `phone_zjy` varchar(255) DEFAULT NULL,
  `qq_zjy` varchar(255) DEFAULT NULL,
  `condition_zjy` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id_zjy`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `t_checker` */

insert  into `t_checker`(`id_zjy`,`username_zjy`,`password_zjy`,`realName_zjy`,`phone_zjy`,`qq_zjy`,`condition_zjy`) values (1,'c1','c1','质量检测员1','123','123',1),(2,'c2','c2','质量检查员2','123','123',1),(3,'1','1','质量检测员3','123','123',1),(5,'horacehe','123','hhc','18820180325','123456789',1),(6,'zjy1','123','ldy','123','123',1),(7,'zjy6','6','6','6','6',1),(8,'zjy7','7','7','7','7',0),(9,'zjy8','123','123','123','123',1),(10,'zjy9','123','123','123','123',0),(11,'zjy10','123','123','123','123',1),(12,'zjy11','123','123','123','123',1);

/*Table structure for table `t_customer` */

DROP TABLE IF EXISTS `t_customer`;

CREATE TABLE `t_customer` (
  `id_cus` bigint(11) NOT NULL AUTO_INCREMENT,
  `phoneNumber_cus` varchar(255) DEFAULT NULL,
  `nickName_cus` varchar(255) DEFAULT NULL,
  `password_cus` varchar(255) DEFAULT NULL,
  `address_cus` varchar(255) DEFAULT NULL,
  `gender_cus` varchar(255) DEFAULT NULL,
  `birthday_cus` varchar(255) DEFAULT '1990-01-01',
  `photo_cus` varchar(255) DEFAULT NULL,
  `email_cus` varchar(255) DEFAULT NULL,
  `condition_cus` tinyint(1) DEFAULT '1',
  PRIMARY KEY (`id_cus`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

/*Data for the table `t_customer` */

insert  into `t_customer`(`id_cus`,`phoneNumber_cus`,`nickName_cus`,`password_cus`,`address_cus`,`gender_cus`,`birthday_cus`,`photo_cus`,`email_cus`,`condition_cus`) values (1,'1','测试账号','1','广东省佛山市','先生','1990-01-01',NULL,'163@163.com',1),(2,'133','消费者测试账号2','1','广东省广州市','先生','2018-01-09',NULL,'123@123.com',1),(3,'18929950000','哈东区',NULL,'黑龙江省哈尔滨市香坊区三大动力路23号','先生','2018-03-04',NULL,'123@qq.com',1),(4,'130','测试spring姓名',NULL,'广东省深圳市','先生','2018-03-16',NULL,'123@qq.com',1),(7,'13212345678','项目姓名测试数据4',NULL,'黑龙江·','女士','2018-03-13',NULL,'123@qq.com',1),(8,'123321','项目姓名测试数据5',NULL,'111','先生','2018-03-06',NULL,'123@qq.com',1),(9,'188','项目姓名测试数据6','d41d8cd98f00b204e9800998ecf8427e','','','2018-03-05','','',1),(14,'ls','ces11',NULL,'',NULL,'1990-01-01',NULL,'',1),(17,'180301','','123','','','2018-03-01','','',1),(19,'173','',NULL,'',NULL,'1997-09-01',NULL,'',1),(20,'789','','202cb962ac59075b964b07152d234b70','','','2018-03-06','','',1),(21,'123','nh',NULL,'111','先生','2018-03-07',NULL,'123@qq.com',1),(22,'12300000000','王者荣耀',NULL,'哈理工对面的飞鱼网咖','先生','2018-01-01',NULL,'123@qq.com',1),(23,'1232','','','',NULL,NULL,NULL,'',NULL),(24,'18999999999','qqqqqq',NULL,'哈理工天桥对面','先生','2018-03-08',NULL,'123@qq.com',1),(25,'13920180310','123','123',NULL,'先生',NULL,NULL,'123@qq.com',NULL),(26,'13320180311','111','123456',NULL,'先生',NULL,NULL,'123@qq.com',NULL),(27,'13603152031','hhh','123456',NULL,'先生',NULL,NULL,'123@qq.com',NULL),(28,'18720180320','华工大',NULL,'五山','先生','3/6/2018',NULL,'123@qq.com',1),(29,'13312345678','华农',NULL,'五山','先生','3/5/2018',NULL,'123@qq.com',1),(30,NULL,'项目姓名测试数据10',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(31,NULL,'项目姓名测试数据10',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(32,NULL,'项目姓名测试数据10',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(33,NULL,'项目姓名测试数据10',NULL,NULL,NULL,NULL,NULL,NULL,NULL),(34,'13520180404','12345',NULL,'153','先生','2018-04-01',NULL,'1342',1),(35,NULL,'项目姓名测试数据10',NULL,NULL,NULL,NULL,NULL,NULL,NULL);

/*Table structure for table `t_farmer` */

DROP TABLE IF EXISTS `t_farmer`;

CREATE TABLE `t_farmer` (
  `id_nh` int(11) NOT NULL AUTO_INCREMENT,
  `phoneNumber_nh` varchar(255) DEFAULT NULL,
  `password_nh` varchar(255) DEFAULT NULL,
  `email_nh` varchar(255) DEFAULT NULL,
  `iDCardNum_nh` varchar(255) DEFAULT NULL,
  `realName_nh` varchar(255) DEFAULT NULL,
  `gender_nh` varchar(255) DEFAULT NULL,
  `pictureIDCF_nh` varchar(255) DEFAULT NULL,
  `pictureIDCB_nh` varchar(255) DEFAULT NULL,
  `pictureIDC_nh` varchar(255) DEFAULT NULL,
  `condition_nh` tinyint(1) DEFAULT '0',
  PRIMARY KEY (`id_nh`)
) ENGINE=InnoDB AUTO_INCREMENT=39 DEFAULT CHARSET=utf8;

/*Data for the table `t_farmer` */

insert  into `t_farmer`(`id_nh`,`phoneNumber_nh`,`password_nh`,`email_nh`,`iDCardNum_nh`,`realName_nh`,`gender_nh`,`pictureIDCF_nh`,`pictureIDCB_nh`,`pictureIDC_nh`,`condition_nh`) values (1,'12345678901','321','123@qq.com','0','测试农户真实姓名','先生',NULL,NULL,NULL,1),(10,'155','1','123@qq.com','44010101010188','haochi','先生',NULL,NULL,NULL,1),(11,'13712345678','123','123@qq.com','0','哈哈哈','先生',NULL,NULL,NULL,1),(13,'2','2','2','2','杜甫','先生',NULL,NULL,NULL,1),(14,'3','3','3','3','3','先生',NULL,NULL,NULL,1),(15,'1','1','1','1','李白','先生',NULL,NULL,NULL,1),(17,'23452','1','1','1','1','先生',NULL,NULL,NULL,1),(18,'543432','1','1','1','农户用户名测试','先生',NULL,NULL,NULL,1),(19,NULL,'123',NULL,NULL,'农户用户名测试',NULL,NULL,NULL,NULL,NULL),(20,NULL,'123',NULL,NULL,'农户用户名测试',NULL,NULL,NULL,NULL,NULL),(25,'17312345678','123541','123@qq.com','0','徐幻露','女士','C:\\pic\\20180408_104951_17312345678_pictureIDCF_nh.jpg','C:\\pic\\20180408_104951_17312345678_pictureIDCB_nh.jpg','C:\\pic\\20180408_104951_17312345678_pictureIDC_nh.jpg',-1),(29,'18212345678','123456','123@qq.com','0','梁项禹','先生','13424','15','413',1),(35,NULL,NULL,NULL,NULL,NULL,NULL,'','','',1),(36,NULL,NULL,NULL,NULL,NULL,NULL,'','','',1),(37,NULL,'123',NULL,NULL,'农户用户名测试',NULL,NULL,NULL,NULL,NULL),(38,'18846438792','123456','123@qq.com','413411345134','我相信','先生',NULL,NULL,NULL,1);

/*Table structure for table `t_manager` */

DROP TABLE IF EXISTS `t_manager`;

CREATE TABLE `t_manager` (
  `id_gly` bigint(11) NOT NULL AUTO_INCREMENT,
  `username_gly` varchar(255) DEFAULT NULL,
  `password_gly` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_gly`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

/*Data for the table `t_manager` */

insert  into `t_manager`(`id_gly`,`username_gly`,`password_gly`) values (1,'root','root'),(2,'admin','admin'),(3,'gly','gly'),(4,'cszh','cszh'),(5,'1','1'),(6,'2','2'),(7,'3','3'),(8,'cs','cs'),(9,'cs2','cs2');

/*Table structure for table `t_nongchang` */

DROP TABLE IF EXISTS `t_nongchang`;

CREATE TABLE `t_nongchang` (
  `id_ncfarm` int(11) NOT NULL AUTO_INCREMENT,
  `id_nh_ncfarm` int(11) NOT NULL,
  `name_ncfarm` varchar(255) DEFAULT NULL,
  `address_ncfarm` varchar(255) DEFAULT NULL,
  `area_ncfarm` varchar(255) DEFAULT NULL,
  `areaUnit_ncfarm` varchar(255) DEFAULT '亩',
  `traffic_ncfarm` varchar(255) DEFAULT NULL,
  `mainProduct_ncfarm` varchar(255) DEFAULT NULL,
  `picture_ncfarm` varchar(255) DEFAULT NULL COMMENT '农户上传的凭证',
  `condition_ncfarm` varchar(255) DEFAULT NULL COMMENT '农场的状态',
  PRIMARY KEY (`id_ncfarm`),
  KEY `FKlmcop3cfotam4iakchm7i8eq7` (`id_nh_ncfarm`),
  CONSTRAINT `FKlmcop3cfotam4iakchm7i8eq7` FOREIGN KEY (`id_nh_ncfarm`) REFERENCES `t_farmer` (`id_nh`),
  CONSTRAINT `r1` FOREIGN KEY (`id_nh_ncfarm`) REFERENCES `t_farmer` (`id_nh`) ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8;

/*Data for the table `t_nongchang` */

insert  into `t_nongchang`(`id_ncfarm`,`id_nh_ncfarm`,`name_ncfarm`,`address_ncfarm`,`area_ncfarm`,`areaUnit_ncfarm`,`traffic_ncfarm`,`mainProduct_ncfarm`,`picture_ncfarm`,`condition_ncfarm`) values (4,10,'王记佳木斯农场','黑龙江省佳木斯市','12','亩','哈佳高铁','土豆',NULL,'1'),(5,10,'王记哈市农场','黑龙江省哈尔滨市','100','亩','京哈高铁','白菜',NULL,'1'),(6,10,'王记大庆农场','黑龙江省大庆市','90','亩','哈齐高铁','西葫芦',NULL,'1'),(7,10,'王记牡丹江农场','黑龙江省牡丹江市','30','亩','火车','猪肉',NULL,'1'),(8,10,'王记齐齐哈尔农场','黑龙江省齐齐哈尔市','60','亩','高铁','养鸭',NULL,'1'),(9,10,'王记北极农场','黑龙江省漠河县','500','亩','火车','苹果',NULL,'0'),(10,10,'王记大农场','修改测试','53124','亩','1324','雪梨',NULL,'0'),(11,10,'马也记大农场','广东省佛山市高明区农田大道','100','亩','城巴','番茄、苹果等',NULL,NULL),(12,10,'发达发达是','314','1234','14234','14234','',NULL,NULL),(13,11,'爱迪生范围','阿凡达的','个人歌手','亩','大帅哥','苹果',NULL,NULL),(15,10,'大大的农场','广东','15','亩','动车','青菜',NULL,NULL),(16,15,'李白的农场','广东省中山市','15','亩','汽车','大头菜',NULL,'1'),(18,10,'','','','亩','','',NULL,NULL);

/*Table structure for table `t_order` */

DROP TABLE IF EXISTS `t_order`;

CREATE TABLE `t_order` (
  `id_order` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单号',
  `sellerzl` varchar(255) DEFAULT NULL COMMENT '卖家类型',
  `sellerid` bigint(20) DEFAULT NULL COMMENT '卖家id',
  `buyerzl` varchar(255) DEFAULT NULL COMMENT '买家类型',
  `buyerid` bigint(20) DEFAULT NULL COMMENT '买家id',
  `productid` varchar(255) DEFAULT NULL COMMENT '产品id号',
  `buynumber` varchar(255) DEFAULT NULL COMMENT '成交数量',
  `id_shop` bigint(20) DEFAULT NULL COMMENT '商店id',
  `conditon_order` varchar(255) DEFAULT NULL COMMENT '订单状态',
  `buyPrice` varchar(255) DEFAULT NULL,
  `buyUnit` varchar(255) DEFAULT NULL,
  `productName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_order`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;

/*Data for the table `t_order` */

insert  into `t_order`(`id_order`,`sellerzl`,`sellerid`,`buyerzl`,`buyerid`,`productid`,`buynumber`,`id_shop`,`conditon_order`,`buyPrice`,`buyUnit`,`productName`) values (8,'farmer',10,'agnet',3,'20180409_103721_10','2',1,'1','1','斤','大西瓜'),(9,'farmer',15,'agnet',3,'20180410_110105_15','10',1,'1','100','斤','涮菜'),(10,'farmer',10,'agnet',3,'20180409_103721_10','1',1,'1','1','斤','大西瓜'),(11,'agent',3,'agnet',2,'20180413_173835_3','1',4,'1','3','斤','大西瓜'),(12,'farmer',10,'agnet',3,'20180416_083658_10','12',1,'1','3','斤','大冬瓜');

/*Table structure for table `t_quality` */

DROP TABLE IF EXISTS `t_quality`;

CREATE TABLE `t_quality` (
  `id_zl` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'id号',
  `id_pro` varchar(255) DEFAULT NULL COMMENT '产品号',
  `ny` varchar(255) DEFAULT NULL COMMENT '农药残留',
  `harm` varchar(255) DEFAULT NULL COMMENT '有害物质评分',
  `yjw` varchar(255) DEFAULT NULL COMMENT '总评',
  PRIMARY KEY (`id_zl`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `t_quality` */

insert  into `t_quality`(`id_zl`,`id_pro`,`ny`,`harm`,`yjw`) values (1,'20180409_103721_10','100','100','100'),(2,'20180413_173835_3','1','1','1'),(3,'4235','合格','合格','优'),(5,'1324','43','134','143');

/*Table structure for table `t_repositoryproduct` */

DROP TABLE IF EXISTS `t_repositoryproduct`;

CREATE TABLE `t_repositoryproduct` (
  `id_rep` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '批次编号',
  `productId_rep` varchar(255) DEFAULT NULL COMMENT '产品批次号',
  `idHead_rep` varchar(255) DEFAULT NULL COMMENT '上一级源头批次编号',
  `userCategory_reo` varchar(255) DEFAULT NULL COMMENT '用户类型',
  `idOwner_rep` bigint(20) DEFAULT NULL COMMENT '批次拥有者的id号',
  `idPlace_rep` bigint(20) DEFAULT NULL COMMENT '产品所在地id号',
  `name_rep` varchar(255) DEFAULT NULL COMMENT '产品名称',
  `number_rep` varchar(255) DEFAULT NULL COMMENT '产品总量',
  `reduceNum_rep` varchar(255) DEFAULT NULL COMMENT '产品余量',
  `buyUnit_rep` varchar(255) DEFAULT NULL COMMENT '买入计量单位',
  `buyPrice_rep` varchar(255) DEFAULT NULL COMMENT '买入总价',
  `sellUnit_rep` varchar(255) DEFAULT NULL COMMENT '销售计量单位',
  `sellPrice_rep` varchar(255) DEFAULT NULL COMMENT '销售单价',
  PRIMARY KEY (`id_rep`)
) ENGINE=InnoDB AUTO_INCREMENT=30 DEFAULT CHARSET=utf8;

/*Data for the table `t_repositoryproduct` */

insert  into `t_repositoryproduct`(`id_rep`,`productId_rep`,`idHead_rep`,`userCategory_reo`,`idOwner_rep`,`idPlace_rep`,`name_rep`,`number_rep`,`reduceNum_rep`,`buyUnit_rep`,`buyPrice_rep`,`sellUnit_rep`,`sellPrice_rep`) values (7,'20180409_103721_10',NULL,'farmer',10,5,'大西瓜','7','0','斤','0.5','斤','1'),(8,'20180409_205305_10',NULL,'farmer',10,6,'香蕉','100','70.0','把','3','把','6'),(9,'20180410_110105_15',NULL,'farmer',15,16,'涮菜','100','90.0','斤','5','斤','100'),(10,'20180411_092545_10',NULL,'farmer',10,6,'大白菜','100','40.0','斤','2','斤','5'),(24,'20180413_173835_3','20180409_103721_10','agent',3,1,'大西瓜','1','0.0','斤','1','斤','3'),(25,'20180413_190525_2','20180413_173835_3','agent',2,4,'大西瓜','1','1','斤','3',NULL,NULL),(26,'20180416_083552_10',NULL,'farmer',10,5,'油菜花','100','100','斤','3','斤','5'),(27,'20180416_083658_10',NULL,'farmer',10,5,'大冬瓜','20','8.0','个','20','斤','3'),(28,'20180416_083743_10',NULL,'farmer',10,5,'西葫芦','60','60','斤','5','斤','7'),(29,'20180416_091823_3','20180416_083658_10','agent',3,1,'大冬瓜','12','12','斤','3',NULL,NULL);

/*Table structure for table `t_shop` */

DROP TABLE IF EXISTS `t_shop`;

CREATE TABLE `t_shop` (
  `id_shop` int(11) NOT NULL AUTO_INCREMENT,
  `id_dls_shop` int(11) NOT NULL,
  `name_shop` varchar(255) DEFAULT NULL,
  `address_shop` varchar(255) DEFAULT NULL,
  `traffic_shop` varchar(255) DEFAULT NULL,
  `mainProduct_shop` varchar(255) DEFAULT NULL,
  `picture_shop` varchar(255) DEFAULT NULL,
  `condition_shop` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id_shop`,`id_dls_shop`),
  KEY `FK43uqd571e9cx78bt1em9d3xtl` (`id_dls_shop`),
  CONSTRAINT `FK43uqd571e9cx78bt1em9d3xtl` FOREIGN KEY (`id_dls_shop`) REFERENCES `t_agent` (`id_dls`),
  CONSTRAINT `t_shop_ibfk_1` FOREIGN KEY (`id_dls_shop`) REFERENCES `t_agent` (`id_dls`) ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

/*Data for the table `t_shop` */

insert  into `t_shop`(`id_shop`,`id_dls_shop`,`name_shop`,`address_shop`,`traffic_shop`,`mainProduct_shop`,`picture_shop`,`condition_shop`) values (1,3,'新鲜蔬菜','佛山市城南市场','地铁1号线到季华园站',NULL,NULL,'1'),(2,3,'美味蔬菜','哈理工东区后门','101到乐松广场站走进哈里东然后走到后门',NULL,NULL,'1'),(3,3,'放心蔬菜','哈尔滨市','公共汽车','白菜',NULL,'1'),(4,2,'新鲜果蔬','长春市','巴士','蔬菜',NULL,'1'),(5,3,'诚意代理点','佛山市顺德区大良街道','动车','白菜',NULL,NULL),(6,2,'测试代理点','1111111','11111','11111',NULL,'0');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
