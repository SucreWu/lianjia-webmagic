
SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for lianjia_newhouse
-- ----------------------------
DROP TABLE IF EXISTS `lianjia_newhouse`;
CREATE TABLE `lianjia_newhouse` (
  `id` varchar(255) NOT NULL COMMENT '唯一ID',
  `name` varchar(255) DEFAULT NULL COMMENT '楼盘名称',
  `alias` varchar(255) DEFAULT NULL COMMENT '别名',
  `average_price` int(10) DEFAULT NULL COMMENT '均价（单位：元/㎡），已售完的楼盘为-1，待售楼盘为0',
  `address` varchar(255) DEFAULT NULL COMMENT '地址',
  `developer` varchar(255) DEFAULT NULL COMMENT '开发商',
  `property_company` varchar(255) DEFAULT NULL COMMENT '物业公司',
  `telphone` varchar(255) DEFAULT NULL COMMENT '咨询电话',
  `decoration_condition` varchar(255) DEFAULT NULL COMMENT '装修情况',
  `latest_opening_time` varchar(255) DEFAULT NULL COMMENT '最新开盘',
  `submit_time` varchar(255) DEFAULT NULL COMMENT '交房时间',
  `water_and_electricity` varchar(255) DEFAULT NULL COMMENT '用水用电',
  `property_costs` varchar(255) DEFAULT NULL COMMENT '物业费',
  `planned_households` varchar(255) DEFAULT NULL COMMENT '规划户数',
  `property_term` varchar(255) DEFAULT NULL COMMENT '产权年限',
  `volumetric_rate` varchar(255) DEFAULT NULL COMMENT '容积率',
  `green_coverage` varchar(255) DEFAULT NULL COMMENT '绿化率',
  `parking_condition` varchar(255) DEFAULT NULL COMMENT '车位状况',
  `type` varchar(255) DEFAULT NULL COMMENT '房产标签',
  `status` varchar(255) DEFAULT NULL COMMENT '销售状态',
  `area` varchar(255) DEFAULT NULL COMMENT '户型面积',
  `longitude` varchar(255) DEFAULT NULL COMMENT '经度',
  `latitude` varchar(255) DEFAULT NULL COMMENT '纬度',
  `insert_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '插入时间',
  `update_time` timestamp NULL DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
