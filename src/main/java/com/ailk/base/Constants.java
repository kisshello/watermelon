
package com.ailk.base;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class Constants {

	public final static int PAGE_SIZE = 10; // 公告-显示页个数

	public final static String DOWN_GOODS_PIC = "/goods_pic_dir/";
	public final static String UPLOAD_FILE_PATH = "/UPLOAD_FILE_PATH/"; // 文件上传路径
	public final static String UPLOAD_FILE_PATH_REPAIR = "UPLOAD_FILE_PATH"; // 文件上传路径
	public final static String EXPORT_FILE_PATH = "EXPORT_FILE_PATH";
	// 文件导出临时路径
	public final static String PRIVATE_KEY = "/keyFile/";

	public final static String BOOK_FILE_PATH = "/book_service/";

	public final static String BOOK_RECORD_AUDIO = "/book_record_audio/";

	public final static String BOOK_RECORD_IMG = "/book_record_img/";

	public final static String LOGIN_FAILED = "0";
	public final static String LOGIN_SUCCESS = "1";

	public final static String OPERATE_TYPE_ADD = "0";
	public final static String OPERATE_TYPE_UPDATE = "1";
	public final static String OPERATE_TYPE_DELETE = "2";

	public final static String RESULT_FAILED = "0";
	public final static String RESULT_SUCCESS = "1";

	public final static String LOGIN_TYPE_LIANTONG = "1";
	public final static String LOGIN_TYPE_FUWUSHANG = "2";

	// 树
	public final static String CLOSED = "closed";
	public final static String OPEN = "open";
	public final static String DEFAULT_TARGET = "";

	// 判断真假
	public final static String IS_TRUE = "1";
	public final static String IS_FALSE = "0";

	// 是否判断
	public final static String IS_YES = "1"; // 是
	public final static String IS_NO = "0"; // 否

	/***************************************** 动态表单 *****************************************/
	public final static String PARENT_ATTR_NORMAL_ID = "112";
	public final static String TEMPLATE_TYPE_GONGDANG = "G";
	public final static String TEMPLATE_TYPE_DINGDANG = "D";

	// 动态表单布局样式
	public final static String DF_LAYOUT_STYLE_NORMAL = "NORMAL"; // 普通模式
	public final static String DF_LAYOUT_STYLE_FILE = "FILES"; // 普通模式 FILE标签
	public final static String DF_LAYOUT_STYLE_TABS = "TABS"; // TABPANEL TAB标签
	public final static String DF_LAYOUT_STYLE_GRID = "GRID"; // DATAGRID 列表
	public final static String DF_LAYOUT_STYLE_GRIDEDIT = "GRIDEDIT"; // DATAGRID
																		// 列表

	// 展示类型
	public final static String DF_DISPLAY_STYLE_TEXT = "TEXT"; // 普通输入框
	public final static String DF_DISPLAY_STYLE_DATE = "TEXT_DATE"; // 日期/时间输入框
	public final static String DF_DISPLAY_STYLE_DATE_FULL = "TEXT_DATE_FULL"; // 日期/时间输入框
	public final static String DF_DISPLAY_STYLE_TEXT_DOUBLE = "TEXT_DOUBLE"; // 长文本框(如：地址输入)
	public final static String DF_DISPLAY_STYLE_TEXTAREA = "TEXTAREA"; // 多文本框
	public final static String DF_DISPLAY_STYLE_SELECT = "SELECT"; // 下拉选择框
	public final static String DF_DISPLAY_STYLE_SELECT_LINK = "SELECT_LINK"; // 选择联动
	public final static String DF_DISPLAY_STYLE_CHECKBOX = "CHECKBOX"; // 多选
	public final static String DF_DISPLAY_STYLE_RADIO = "RADIO"; // 单选
	public final static String DF_DISPLAY_STYLE_FILE = "FILE"; // 附件

	// 取值类型
	public final static String DF_SAVE_TYPE_H = "H"; // 横表
	public final static String DF_SAVE_TYPE_Z = "Z"; // 纵表

	// 默认值类型
	public final static String DF_DEFAULT_TYPE_FIXED = "01"; // 固定值
	public final static String DF_DEFAULT_TYPE_SESSION = "02"; // session
	public final static String DF_DEFAULT_TYPE_EXPRESSION = "03"; // 表达式

	public final static String DF_DROP_TEMPLATE_SUFFIX = "$AILK"; // 此属性不保存
	public final static String DF_REQUIRED_TEMPLATE_SUFFIX = "$REQUIRED"; // 必填属性标示

	public final static String DF_FILE_EXTEND_ATTR_ID = "F";
	public final static String DF_FILE_EXTEND_ATTR_CODE = "FILE_CODE_";

	/***************************************** 动态表单 *****************************************/

	/***************************************** 定单 *****************************************/
	// RELA_TYPE解释
	// 构成说明：PIM + 011(这里指require_type) + A(这里指阶段)
	public final static String ORDER_RELA_TYPE_LEAVE = "PIM001"; // 请假
	// ----------------------------规划A
	public final static String ORDER_RELA_TYPE_GUIHUA_CSKDXJ1 = "PIM011A1"; // 城市宽带新建需求评估流程
	public final static String ORDER_RELA_TYPE_GUIHUA_CSKDKR1 = "PIM012A1"; // 城市宽带扩容需求评估流程
	public final static String ORDER_RELA_TYPE_GUIHUA_CSKDGZ1 = "PIM013A1"; // 城市宽带改造需求评估流程
	// -----
	public final static String ORDER_RELA_TYPE_GUIHUA_LYKDXJ1 = "PIM021A1"; // 商业楼宇宽带新建需求评估流程
	public final static String ORDER_RELA_TYPE_GUIHUA_LYKDKR1 = "PIM022A1"; // 商业楼宇宽带扩容需求评估流程
	public final static String ORDER_RELA_TYPE_GUIHUA_LYKDGZ1 = "PIM023A1"; // 商业楼宇宽带改造需求评估流程
	// -----
	public final static String ORDER_RELA_TYPE_GUIHUA_GXKDXJ1 = "PIM031A1"; // 高校校园宽带新建需求评估流程
	public final static String ORDER_RELA_TYPE_GUIHUA_GXKDKR1 = "PIM032A1"; // 高校校园宽带扩容需求评估流程
	public final static String ORDER_RELA_TYPE_GUIHUA_GXKDGZ1 = "PIM033A1"; // 高校校园宽带改造需求评估流程
	// -----
	public final static String ORDER_RELA_TYPE_GUIHUA_WXWXJ1 = ""; // 无线网新建需求评估流程
	// -----
	public final static String ORDER_RELA_TYPE_GUIHUA_CSKDXJ2 = "PIM011A2"; // 城市宽带新建规划评估流程
	public final static String ORDER_RELA_TYPE_GUIHUA_CSKDKR2 = "PIM012A2"; // 城市宽带扩容规划评估流程
	public final static String ORDER_RELA_TYPE_GUIHUA_CSKDGZ2 = "PIM013A2"; // 城市宽带改造规划评估流程
	// -----
	public final static String ORDER_RELA_TYPE_GUIHUA_LYKDXJ2 = "PIM021A2"; // 商业楼宇宽带新建规划评估流程
	public final static String ORDER_RELA_TYPE_GUIHUA_LYKDKR2 = "PIM022A2"; // 商业楼宇宽带扩容规划评估流程
	public final static String ORDER_RELA_TYPE_GUIHUA_LYKDGZ2 = "PIM023A2"; // 商业楼宇宽带改造规划评估流程
	// -----
	public final static String ORDER_RELA_TYPE_GUIHUA_GXKDXJ2 = "PIM031A2"; // 高校校园宽带新建规划评估流程
	public final static String ORDER_RELA_TYPE_GUIHUA_GXKDKR2 = "PIM032A2"; // 高校校园宽带扩容规划评估流程
	public final static String ORDER_RELA_TYPE_GUIHUA_GXKDGZ2 = "PIM033A2"; // 高校校园宽带改造规划评估流程
	// -----
	public final static String ORDER_RELA_TYPE_GUIHUA_WXWXJ2 = ""; // 无线网新建规划评估流程

	// ----------------------------计划B
	public final static String ORDER_RELA_TYPE_JIHUA_CSKDXJ = "PIM011B1"; // 城市宽带新建实施计划审批流程
	public final static String ORDER_RELA_TYPE_JIHUA_CSKDKR = "PIM012B1"; // 城市宽带扩容实施计划审批流程
	public final static String ORDER_RELA_TYPE_JIHUA_CSKDGZ = "PIM013B1"; // 城市宽带扩容实施计划审批流程
	// -----
	public final static String ORDER_RELA_TYPE_JIHUA_LYKDXJ = "PIM021B1"; // 商业楼宇宽带新建实施计划审批流程
	public final static String ORDER_RELA_TYPE_JIHUA_LYKDKR = "PIM022B1"; // 商业楼宇宽带扩容实施计划审批流程
	public final static String ORDER_RELA_TYPE_JIHUA_LYKDGZ = "PIM023B1"; // 商业楼宇宽带扩容实施计划审批流程
	// -----
	public final static String ORDER_RELA_TYPE_JIHUA_GXKDXJ = "PIM031B1"; // 高校校园宽带新建实施计划审批流程
	public final static String ORDER_RELA_TYPE_JIHUA_GXKDKR = "PIM032B1"; // 高校校园宽带扩容实施计划审批流程
	public final static String ORDER_RELA_TYPE_JIHUA_GXKDGZ = "PIM033B1"; // 高校校园宽带扩容实施计划审批流程

	public final static String ORDER_RELA_TYPE_JIHUA_WXW = ""; // 无线网实施计划审批流程

	// ----------------------------可研C
	public final static String ORDER_RELA_TYPE_KEYAN_XM = "PIM000C1"; // 可研下达流程
	public final static String ORDER_RELA_TYPE_KEYAN_CSKDXJ = "PIM011C1"; // 城市宽带新建立项下达流程
	public final static String ORDER_RELA_TYPE_KEYAN_CSKDKR = "PIM012C1"; // 城市宽带扩容立项下达流程
	public final static String ORDER_RELA_TYPE_KEYAN_CSKDGZ = "PIM013C1"; // 城市宽带扩容立项下达流程

	public final static String ORDER_RELA_TYPE_KEYAN_LYKDXJ = "PIM021C1"; // 商业楼宇宽带新建立项下达流程
	public final static String ORDER_RELA_TYPE_KEYAN_LYKDKR = "PIM022C1"; // 商业楼宇宽带扩容立项下达流程
	public final static String ORDER_RELA_TYPE_KEYAN_LYKDGZ = "PIM023C1"; // 商业楼宇宽带扩容立项下达流程

	public final static String ORDER_RELA_TYPE_KEYAN_GXKDXJ = "PIM031D1"; // 高校校园宽带新建立项下达流程
	public final static String ORDER_RELA_TYPE_KEYAN_GXKDKR = "PIM032D1"; // 高校校园宽带扩容立项下达流程
	public final static String ORDER_RELA_TYPE_KEYAN_GXKDGZ = "PIM033D1"; // 高校校园宽带扩容立项下达流程

	// ----------------------------立项D
	public final static String ORDER_RELA_TYPE_LIXIANG_XM = "PIM000D1"; // 立项下达流程
																		// 废弃
	public final static String ORDER_RELA_TYPE_LIXIANG_CSKDXJ = "PIM011D1"; // 城市宽带新建立项下达流程
	public final static String ORDER_RELA_TYPE_LIXIANG_CSKDKR = "PIM012D1"; // 城市宽带扩容立项下达流程
	public final static String ORDER_RELA_TYPE_LIXIANG_CSKDGZ = "PIM013D1"; // 城市宽带扩容立项下达流程

	public final static String ORDER_RELA_TYPE_LIXIANG_LYKDXJ = "PIM021D1"; // 商业楼宇宽带新建立项下达流程
	public final static String ORDER_RELA_TYPE_LIXIANG_LYKDKR = "PIM022D1"; // 商业楼宇宽带扩容立项下达流程
	public final static String ORDER_RELA_TYPE_LIXIANG_LYKDGZ = "PIM023D1"; // 商业楼宇宽带扩容立项下达流程

	public final static String ORDER_RELA_TYPE_LIXIANG_GXKDXJ = "PIM031D1"; // 高校校园宽带新建立项下达流程
	public final static String ORDER_RELA_TYPE_LIXIANG_GXKDKR = "PIM032D1"; // 高校校园宽带扩容立项下达流程
	public final static String ORDER_RELA_TYPE_LIXIANG_GXKDGZ = "PIM033D1"; // 高校校园宽带扩容立项下达流程

	// ----------------------------设计E
	public final static String ORDER_RELA_TYPE_SHEJI_CSKDXJ = "PIM011E1"; // 城市宽带新建设计流程
	public final static String ORDER_RELA_TYPE_SHEJI_CSKDKR = "PIM012E1"; // 城市宽带扩容设计流程
	public final static String ORDER_RELA_TYPE_SHEJI_CSKDGZ = "PIM013E1"; // 城市宽带扩容设计流程

	public final static String ORDER_RELA_TYPE_SHEJI_LYKDXJ = "PIM021E1"; // 商业楼宇宽带新建设计流程
	public final static String ORDER_RELA_TYPE_SHEJI_LYKDKR = "PIM022E1"; // 商业楼宇宽带扩容设计流程
	public final static String ORDER_RELA_TYPE_SHEJI_LYKDGZ = "PIM023E1"; // 商业楼宇宽带扩容设计流程

	public final static String ORDER_RELA_TYPE_SHEJI_GXKDXJ = "PIM031E1"; // 高校校园宽带新建设计流程
	public final static String ORDER_RELA_TYPE_SHEJI_GXKDKR = "PIM032E1"; // 高校校园宽带扩容设计流程
	public final static String ORDER_RELA_TYPE_SHEJI_GXKDGZ = "PIM033E1"; // 高校校园宽带扩容设计流程

	// ----------------------------采购F
	public final static String ORDER_RELA_TYPE_CAIGOU_WZ = "PIM000F1"; // 采购流程

	// ----------------------------施工H
	public final static String ORDER_RELA_TYPE_SHIGONG_JLZP_CSKDXJ = "PIM011H1"; // 城市宽带新建指派监理单位流程流程
	public final static String ORDER_RELA_TYPE_SHIGONG_JLZP_CSKDKR = "PIM012H1"; // 城市宽带扩容指派监理单位流程流程
	public final static String ORDER_RELA_TYPE_SHIGONG_JLZP_CSKDGZ = "PIM013H1"; // 城市宽带改造指派监理单位流程流程

	public final static String ORDER_RELA_TYPE_SHIGONG_JLZP_LYKDXJ = "PIM021H1"; // 商业楼宇宽带新建指派监理单位流程流程
	public final static String ORDER_RELA_TYPE_SHIGONG_JLZP_LYKDKR = "PIM022H1"; // 商业楼宇宽带扩容指派监理单位流程流程
	public final static String ORDER_RELA_TYPE_SHIGONG_JLZP_LYKDGZ = "PIM023H1"; // 商业楼宇宽带改造指派监理单位流程流程

	public final static String ORDER_RELA_TYPE_SHIGONG_JLZP_GXKDXJ = "PIM031H1"; // 高校校园宽带新建指派监理单位流程流程
	public final static String ORDER_RELA_TYPE_SHIGONG_JLZP_GXKDKR = "PIM032H1"; // 高校校园宽带扩容指派监理单位流程流程
	public final static String ORDER_RELA_TYPE_SHIGONG_JLZP_GXKDGZ = "PIM033H1"; // 高校校园宽带改造指派监理单位流程流程

	public final static String ORDER_RELA_TYPE_SHIGONG_SGZP_CSKDXJ = "PIM011H2"; // 城市宽带新建指派施工单位流程流程
	public final static String ORDER_RELA_TYPE_SHIGONG_SGZP_CSKDKR = "PIM012H2"; // 城市宽带扩容指派施工单位流程流程
	public final static String ORDER_RELA_TYPE_SHIGONG_SGZP_CSKDGZ = "PIM013H2"; // 城市宽带改造指派施工单位流程流程

	public final static String ORDER_RELA_TYPE_SHIGONG_SGZP_LYKDXJ = "PIM021H2"; // 商业楼宇宽带新建指派施工单位流程流程
	public final static String ORDER_RELA_TYPE_SHIGONG_SGZP_LYKDKR = "PIM022H2"; // 商业楼宇宽带扩容指派施工单位流程流程
	public final static String ORDER_RELA_TYPE_SHIGONG_SGZP_LYKDGZ = "PIM023H2"; // 商业楼宇宽带改造指派施工单位流程流程

	public final static String ORDER_RELA_TYPE_SHIGONG_SGZP_GXKDXJ = "PIM031H2"; // 高校校园宽带新建指派施工单位流程流程
	public final static String ORDER_RELA_TYPE_SHIGONG_SGZP_GXKDKR = "PIM032H2"; // 高校校园宽带扩容指派施工单位流程流程
	public final static String ORDER_RELA_TYPE_SHIGONG_SGZP_GXKDGZ = "PIM033H2"; // 高校校园宽带改造指派施工单位流程流程

	// ----------------------------交维K
	public final static String ORDER_RELA_TYPE_JIAOWEI_CSKDXJ = "PIM011K1"; // 城市宽带新建交维流程
	public final static String ORDER_RELA_TYPE_JIAOWEI_CSKDKR = "PIM012K1"; // 城市宽带扩容交维流程
	public final static String ORDER_RELA_TYPE_JIAOWEI_CSKDGZ = "PIM013K1"; // 城市宽带扩容交维流程

	public final static String ORDER_RELA_TYPE_JIAOWEI_LYKDXJ = "PIM021K1"; // 商业楼宇宽带新建交维流程
	public final static String ORDER_RELA_TYPE_JIAOWEI_LYKDKR = "PIM022K1"; // 商业楼宇宽带扩容交维流程
	public final static String ORDER_RELA_TYPE_JIAOWEI_LYKDGZ = "PIM023K1"; // 商业楼宇宽带扩容交维流程

	public final static String ORDER_RELA_TYPE_JIAOWEI_GXKDXJ = "PIM031K1"; // 高校校园宽带新建交维流程
	public final static String ORDER_RELA_TYPE_JIAOWEI_GXKDKR = "PIM032K1"; // 高校校园宽带扩容交维流程
	public final static String ORDER_RELA_TYPE_JIAOWEI_GXKDGZ = "PIM033K1"; // 高校校园宽带扩容交维流程

	// -----------------------------验收Q
	public final static String ORDER_RELA_TYPE_YANSHOU_CSKDXJ = "PIM011Q1"; // 城市宽带新建一次性验收流程
	public final static String ORDER_RELA_TYPE_YANSHOU_CSKDKR = "PIM012Q1"; // 城市宽带扩容一次性验收流程
	public final static String ORDER_RELA_TYPE_YANSHOU_CSKDGZ = "PIM013Q1"; // 城市宽带扩容一次性验收流程

	public final static String ORDER_RELA_TYPE_YANSHOU_LYKDXJ = "PIM021Q1"; // 商业楼宇宽带新建一次性验收流程
	public final static String ORDER_RELA_TYPE_YANSHOU_LYKDKR = "PIM022Q1"; // 商业楼宇宽带扩容一次性验收流程
	public final static String ORDER_RELA_TYPE_YANSHOU_LYKDGZ = "PIM023Q1"; // 商业楼宇宽带扩容一次性验收流程

	public final static String ORDER_RELA_TYPE_YANSHOU_GXKDXJ = "PIM031Q1"; // 高校校园宽带新建一次性验收流程
	public final static String ORDER_RELA_TYPE_YANSHOU_GXKDKR = "PIM032Q1"; // 高校校园宽带扩容一次性验收流程
	public final static String ORDER_RELA_TYPE_YANSHOU_GXKDGZ = "PIM033Q1"; // 高校校园宽带扩容一次性验收流程

	public final static String ORDER_RELA_TYPE_YANSHOU_CSKDXJ2 = "PIM011Q2"; // 城市宽带新建初终验收流程
	public final static String ORDER_RELA_TYPE_YANSHOU_CSKDKR2 = "PIM012Q2"; // 城市宽带扩容初终验收流程
	public final static String ORDER_RELA_TYPE_YANSHOU_CSKDGZ2 = "PIM013Q2"; // 城市宽带扩容初终验收流程

	public final static String ORDER_RELA_TYPE_YANSHOU_LYKDXJ2 = "PIM021Q2"; // 商业楼宇宽带新建初终验收流程
	public final static String ORDER_RELA_TYPE_YANSHOU_LYKDKR2 = "PIM022Q2"; // 商业楼宇宽带扩容初终验收流程
	public final static String ORDER_RELA_TYPE_YANSHOU_LYKDGZ2 = "PIM023Q2"; // 商业楼宇宽带扩容初终验收流程

	public final static String ORDER_RELA_TYPE_YANSHOU_GXKDXJ2 = "PIM031Q2"; // 高校校园宽带新建初终验收流程
	public final static String ORDER_RELA_TYPE_YANSHOU_GXKDKR2 = "PIM032Q2"; // 高校校园宽带扩容初终验收流程
	public final static String ORDER_RELA_TYPE_YANSHOU_GXKDGZ2 = "PIM033Q2"; // 高校校园宽带扩容初终验收流程

	// -----------------------------暂估转固W
	public final static String ORDER_RELA_TYPE_ZGZG_CSKDXJ = "PIM011W1"; // 城市宽带新建暂估转固流程
	public final static String ORDER_RELA_TYPE_ZGZG_CSKDKR = "PIM012W1"; // 城市宽带扩容暂估转固流程
	public final static String ORDER_RELA_TYPE_ZGZG_CSKDGZ = "PIM013Q1"; // 城市宽带扩容暂估转固流程

	public final static String ORDER_RELA_TYPE_ZGZG_LYKDXJ = "PIM021W1"; // 商业楼宇宽带新建暂估转固流程
	public final static String ORDER_RELA_TYPE_ZGZG_LYKDKR = "PIM022W1"; // 商业楼宇宽带扩容暂估转固流程
	public final static String ORDER_RELA_TYPE_ZGZG_LYKDGZ = "PIM023Q1"; // 商业楼宇宽带扩容暂估转固流程

	public final static String ORDER_RELA_TYPE_ZGZG_GXKDXJ = "PIM031W1"; // 高校校园宽带新建暂估转固流程
	public final static String ORDER_RELA_TYPE_ZGZG_GXKDKR = "PIM032W1"; // 高校校园宽带扩容暂估转固流程
	public final static String ORDER_RELA_TYPE_ZGZG_GXKDGZ = "PIM033W1"; // 高校校园宽带扩容暂估转固流程

	public final static String ORDER_DEAL_ACT_YIBAN = "0"; // 个人已办
	public final static String ORDER_DEAL_ACT_WEIBAN = "1"; // 未办
	public final static String ORDER_DEAL_ACT_DAIBAN = "2"; // 个人待办

	// N：未启动，R：运行中，F：撤单，S：成功
	public final static String ORDER_STATUS_N = "N";
	public final static String ORDER_STATUS_R = "R";
	public final static String ORDER_STATUS_F = "F";
	public final static String ORDER_STATUS_S = "S";
	public final static String ORDER_STATUS_SS = "SS";
	public final static String ORDER_STATUS_SN = "SN";

	public final static String ORDER_WORK_TYPE_DAIBAN = "1";
	public final static String ORDER_WORK_TYPE_DAIYUE = "2";

	public final static String ORDER_DEAL_RESULT_Y = "Y";
	public final static String ORDER_DEAL_RESULT_N = "N";

	public final static String ORDER_OPER_TYPE_PASS = "01"; // 通过
	public final static String ORDER_OPER_TYPE_BACK = "02"; // 回退
	public final static String ORDER_OPER_TYPE_CALLBACK = "03"; // 自己撤回
	public final static String ORDER_OPER_TYPE_STOP = "04"; // 终止
	public final static String ORDER_OPER_TYPE_TRANSFER = "05"; // 转办
	public final static String ORDER_OPER_TYPE_SUSPEND = "06"; // 挂起
	public final static String ORDER_OPER_TYPE_CLAIM = "07"; // 签收
	public final static String ORDER_OPER_TYPE_RESUME = "08"; // 解挂

	public final static String ORDER_SEND_CNT_DEFAULT = "1"; // 默认发送人数

	public final static String ORDER_SQL_OPER_TYPE_END = "END";
	public final static String ORDER_SQL_OPER_TYPE_STOP = "STOP";
	public final static String ORDER_SQL_OPER_TYPE_D_SENDER = "D_SENDER";
	public final static String ORDER_SQL_OPER_TYPE_C_SENDER = "C_SENDER";
	public final static String ORDER_SQL_OPER_TYPE_ACTIVE = "ACTIVE";
	public final static String ORDER_SQL_OPER_TYPE_UNACTIVE = "UNACTIVE";

	public final static String TEMPLATE_PUB_TYPE_AREACODE = "01";
	public final static String TEMPLATE_PUB_TYPE_RELATYPE = "02";
	public final static String TEMPLATE_PUB_TYPE_CUSTOM = "03";

	/***************************************** 定单 *****************************************/

	/***************************************** 流程ID *****************************************/
	public final static String FLOW_ID_GH_CSKDXJ = "101";
	public final static String FLOW_ID_GH_CSKDKR = "107";
	public final static String FLOW_ID_GH_CSKDGZ = "109";
	public final static String FLOW_ID_GH_LYKDXJ = "111";
	public final static String FLOW_ID_GH_LYKDKR = "113";
	public final static String FLOW_ID_GH_LYKDGZ = "115";
	public final static String FLOW_ID_GH_GXKDXJ = "117";
	public final static String FLOW_ID_GH_GXKDKR = "119";
	public final static String FLOW_ID_GH_GXKDGZ = "121";

	public final static String FLOW_ID_GH_CSKDXJ2 = "102";
	public final static String FLOW_ID_GH_CSKDKR2 = "108";
	public final static String FLOW_ID_GH_CSKDGZ2 = "110";
	public final static String FLOW_ID_GH_LYKDXJ2 = "112";
	public final static String FLOW_ID_GH_LYKDKR2 = "114";
	public final static String FLOW_ID_GH_LYKDGZ2 = "116";
	public final static String FLOW_ID_GH_GXKDXJ2 = "118";
	public final static String FLOW_ID_GH_GXKDKR2 = "120";
	public final static String FLOW_ID_GH_GXKDGZ2 = "122";

	public final static String FLOW_ID_JH_KD = "103";
	// pms_应急项目可研立项流程
	public final static String FLOW_ID_LX_XM = "104";
	// pms_物资采购需求单审批流程
	public final static String FLOW_ID_CG_WZ = "124";
	public final static String FLOW_ID_SJ_KD = "106";
	public final static String FLOW_ID_JL_KD = "126";
	public final static String FLOW_ID_SG_KD = "127";

	/***************************************** 流程ID *****************************************/

	public final static String REQUIRE_TYPE_CSKDXJ = "011";
	public final static String REQUIRE_TYPE_CSKDKR = "012";
	public final static String REQUIRE_TYPE_CSKDGZ = "013";
	public final static String REQUIRE_TYPE_LYKDXJ = "021";
	public final static String REQUIRE_TYPE_LYKDKR = "022";
	public final static String REQUIRE_TYPE_LYKDGZ = "023";
	public final static String REQUIRE_TYPE_GXKDXJ = "031";
	public final static String REQUIRE_TYPE_GXKDKR = "032";
	public final static String REQUIRE_TYPE_GXKDGZ = "033";

	public final static String STAGE_1 = "01";
	public final static String STAGE_2 = "02";
	public final static String STAGE_3 = "03";

	public final static String INVEST_PLAN_SPECIALTY_CSKD = "01";
	public final static String INVEST_PLAN_SPECIALTY_LYKD = "02";
	public final static String INVEST_PLAN_SPECIALTY_GXKD = "03";

	public final static String DATA_PRIVILEGE_BENREN = "1";
	public final static String DATA_PRIVILEGE_CITYCODE = "2";
	public final static String DATA_PRIVILEGE_AREACODE = "3";
	public final static String DATA_PRIVILEGE_ALL = "4";

	public final static String PLAN_TYPE_IN = "01"; // 规划内
	public final static String PLAN_TYPE_OUT = "02"; // 规划外

	public final static String IS_URGENCY_YES = "01"; // 正常
	public final static String IS_URGENCY_NO = "02"; // 应急
	public static final int MAX_IMG_VALUE = 100;

	/**
	 * 验房
	 */
	// 紧急程度 1一般 2加急
	public static Integer HOUSE_INSPECTION_LEVEL_01 = 1;
	public static Integer HOUSE_INSPECTION_LEVEL_02 = 2;

	// 房屋状态 1待检查2待整改3已整改4已通过
	public static String HOUSE_INSPECTION_HSTATE_01 = "1";
	public static String HOUSE_INSPECTION_HSTATE_02 = "2";
	public static String HOUSE_INSPECTION_HSTATE_03 = "3";
	public static String HOUSE_INSPECTION_HSTATE_04 = "4";
	// 问题状态 1待检查2待整改3已整改4已通过5被退回6已作废
	public static String HOUSE_INSPECTION_PSTATE_02 = "2";
	public static String HOUSE_INSPECTION_PSTATE_03 = "3";
	public static String HOUSE_INSPECTION_PSTATE_04 = "4";
	public static String HOUSE_INSPECTION_PSTATE_05 = "5";
	public static String HOUSE_INSPECTION_PSTATE_06 = "6";
	// 检查 1：部位2：检查项 3：问题描述
	public static String HOUSE_INSPECTION_CPITEMTYPE_01 = "1";
	public static String HOUSE_INSPECTION_CPITEMTYPE_02 = "2";
	public static String HOUSE_INSPECTION_CPITEMTYPE_03 = "3";
	public static String HOUSE_INSPECTION_DEFAULT_COMPANYCODE = "0";

	// 订单状态（创建、成功、失败）。
	public static String DUIBA_ORDER_CREATE = "1";
	public static String DUIBA_ORDER_SUCCESS = "2";
	public static String DUIBA_ORDER_FAIL = "3";
	// 积分状态（预扣、成功、返还）。
	public static String DUIBA_CREDIT_PRE = "1";
	public static String DUIBA_CREDIT_SUCCESS = "2";
	public static String DUIBA_CREDIT_RETURN = "3";

	// 积分记录-类型 商城积分消费 商城积分返还
	public static String SCORE_CONSUME = "23";
	public static String SCORE_RETURN = "24";

	// 云物管抢单菜单id
	public static String PMSAPP_SECONDMENU_GRAB_REPAIRORDER = "1001015";
	// 云物管派单菜单id
	public static String PMSAPP_SECONDMENU_ASSIGN_REPAIRORDER = "1001016";
	public static String SVC_USER_PICTURE = "SVC_USER_PICTURE";

	// 默认版本信息
	public static String INITIAL_VERSION = "ai";
	public static String INITIAL_APP_NAME = "邻乐汇";
	public static String INITIAL_USER_NAME = "邻乐居民";
	public static String INITIAL_DOWNLOAD_URL = "https://www.linlehui001.com/woxq/m.html";
	public static String INITIAL_DOWNLOAD_HTML = "https://www.linlehui001.com/woxq/m.html";

	// 业主APP下载地址
	public static String LLH_DWONLOAD_URL = "http://182.92.161.166/images/newVersion/WoCell.apk";
	// 业主APP 更新目录
	public static String LLH_UPDATE_BASE_URL = "http://182.92.161.166/images/VERSION/";
	// 业主APP 更新目录
	public static String LLH_UPDATE_PREFIX = "LLHupdate";
	// 邻乐汇版本相关信息，涉及到不同版本信息的 保存
	public static Map<String, Map<String, Object>> APP_MAP = new HashMap<String, Map<String, Object>>();
	public static List<String> BLACK_IP_LIST = new ArrayList<String>(); // ip黑名单
	public static List<String> BLACK_IMEI_LIST = new ArrayList<String>(); // IMEI黑名单

	static {
		// 邻乐汇
		Map<String, Object> aiMap = new HashMap<String, Object>();
		aiMap.put("appName", INITIAL_APP_NAME);
		aiMap.put("userName", INITIAL_USER_NAME);
		APP_MAP.put(INITIAL_VERSION, aiMap);

		// 天鼎管佳
		Map<String, Object> skycoverMap = new HashMap<String, Object>();
		skycoverMap.put("appName", "天鼎管佳");
		skycoverMap.put("userName", "天鼎居民");
		APP_MAP.put("skycover", skycoverMap);

		// 蔚蓝生活
		Map<String, Object> skyblueMap = new HashMap<String, Object>();
		skyblueMap.put("appName", "天朗蔚蓝生活");
		skyblueMap.put("userName", "天朗居民");
		APP_MAP.put("skyblue", skyblueMap);

		// 客户端黑名单
		BLACK_IP_LIST.add("10.0.2.12");

		// 客户端黑名单
		BLACK_IP_LIST.add("27.154.233.230");
		BLACK_IP_LIST.add("60.180.13.38");

		BLACK_IP_LIST.add("183.130.87.163");
		BLACK_IP_LIST.add("125.69.82.115");
		BLACK_IP_LIST.add("113.83.73.178");
		BLACK_IP_LIST.add("58.211.173.222");
		BLACK_IP_LIST.add("114.221.241.239");
		BLACK_IP_LIST.add("113.83.72.177");
		BLACK_IP_LIST.add("125.110.7.107");
		BLACK_IP_LIST.add("60.180.56.30");
		BLACK_IP_LIST.add("60.180.52.197");
		BLACK_IP_LIST.add("112.16.206.226");
		BLACK_IP_LIST.add("113.9.219.183");
		BLACK_IP_LIST.add("14.158.82.191");
		BLACK_IP_LIST.add("1.194.22.172");
		BLACK_IP_LIST.add("115.234.90.96");
		BLACK_IP_LIST.add("180.105.37.244");
		BLACK_IP_LIST.add("116.114.228.231");
		BLACK_IP_LIST.add("183.251.22.115");
		BLACK_IP_LIST.add("182.38.40.56");
		BLACK_IP_LIST.add("117.157.168.41");
		BLACK_IP_LIST.add("60.180.50.176");
		BLACK_IP_LIST.add("118.73.186.92");
		BLACK_IP_LIST.add("27.210.124.198");
		BLACK_IP_LIST.add("60.221.117.169");
		BLACK_IP_LIST.add("36.62.181.252");
		BLACK_IP_LIST.add("115.192.191.121");
		BLACK_IP_LIST.add("116.25.36.69");
		BLACK_IP_LIST.add("58.250.101.7");
		BLACK_IP_LIST.add("49.116.158.121");
		BLACK_IP_LIST.add("61.183.182.242");
		BLACK_IP_LIST.add("27.155.138.226");
		BLACK_IP_LIST.add("113.123.54.177");
		BLACK_IP_LIST.add("58.216.230.190");
		BLACK_IP_LIST.add("221.1.204.10");
		BLACK_IP_LIST.add("223.73.213.249");
		BLACK_IP_LIST.add("60.180.61.203");
		BLACK_IP_LIST.add("113.16.35.125");
		BLACK_IP_LIST.add("117.62.97.151");
		BLACK_IP_LIST.add("61.241.207.202");
		BLACK_IP_LIST.add("116.226.153.228");
		BLACK_IP_LIST.add("60.180.68.150");
		BLACK_IP_LIST.add("171.112.160.12");
		BLACK_IP_LIST.add("171.120.122.135");
		BLACK_IP_LIST.add("119.99.232.163");
		BLACK_IP_LIST.add("122.224.15.203");
		BLACK_IP_LIST.add("60.219.176.144");
		BLACK_IP_LIST.add("60.178.193.70");
		BLACK_IP_LIST.add("49.88.17.181");
		BLACK_IP_LIST.add("125.112.102.228");
		BLACK_IP_LIST.add("27.156.219.216");
		BLACK_IP_LIST.add("14.158.161.111");
		BLACK_IP_LIST.add("60.181.171.176");
		BLACK_IP_LIST.add("113.88.111.35");
		BLACK_IP_LIST.add("106.6.87.45");
		BLACK_IP_LIST.add("49.89.31.31");
		BLACK_IP_LIST.add("60.181.169.116");
		BLACK_IP_LIST.add("119.138.245.96");
		BLACK_IP_LIST.add("222.91.163.130");
		BLACK_IP_LIST.add("113.16.35.93");
		BLACK_IP_LIST.add("113.67.10.62");
		BLACK_IP_LIST.add("39.168.128.157");
		BLACK_IP_LIST.add("49.88.17.231");
		BLACK_IP_LIST.add("42.196.123.95");
		BLACK_IP_LIST.add("120.229.124.245");
		BLACK_IP_LIST.add("122.241.21.219");
		BLACK_IP_LIST.add("171.90.232.143");
		BLACK_IP_LIST.add("36.63.183.144");
		BLACK_IP_LIST.add("60.180.13.38");
		BLACK_IP_LIST.add("27.154.233.230");

		BLACK_IMEI_LIST.add("863100032641247");
	}

	// 图片服务器地址
	public static String PIC_SERVER_URL = "https://pic.linlehui001.com/";
	// 接口服务器地址
	public static String PROJ_SERVER_URL = "https://jkssl.linlehui001.com/";
	// 微信服务器地址
	public static String WX_SERVER_URL = "http://wx.linlehui001.cn/";
	// 积分商城图标
	public static String DEFAULT_DUIBA_LOGO = "https://pic.linlehui001.com/images/wuyepicture/duiba_llh_shoplogo.jpg";
	// BookBusiness.apk 下载地址
	public static String BOOKBUSINESS_DOWNLOAD_URL = "https://pic.linlehui001.com/images/newVersion/BookBusiness.apk";
	// 测试地址
	// public static String PROJ_SERVER_URL="http://182.92.170.191:23334/";

	public static String PAYTYPE_ZFB = "1";
	public static String PAYTYPE_WX = "2";
	public static String PAYTYPE_YL = "3";

	public static int XH_INIT_CREDIT = 35000;
	public static String OPEN_GC_REDUCE_URL = PropertyUtil.getProperty("open.gc.reduceUrl");

	
	public static String SMS_CACHE_CODE="sampleCache4";
	
	public static String AUTH_CODE = "414919";
}