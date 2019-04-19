package mysql;

import java.util.ArrayList;
import java.util.List;

public class Constant {

	@SuppressWarnings("serial")
	public static List<String> text = new ArrayList<String>() {
		{
			add("某个电商平台所有店铺卖出的总金额（分组查询）");
			add("列出价格在4元以上的货物的销售数量和销售收益（IN 查询）");
			add("找出价格最高的货物的销售总数 （theta all）");
			add("找出价格不是最低的货物 （theta some）");
			add("列出至少买了店铺1所有商品的顾客号 (not exists)");
		}
	};
	@SuppressWarnings("serial")
	public static List<String> sql = new ArrayList<String>() {
		{
			add("SELECT p.name, SUM(sell_price) FROM platform p, sell  WHERE sell.`p_id` = p.`p_id` GROUP BY p.`p_id`;");
			add("SELECT sell_num, sell_price FROM sell  WHERE g_id IN (SELECT g_id FROM goods WHERE price > 4);");
			add("SELECT g_id, SUM(sell_num) FROM sell WHERE g_id IN (SELECT g_id FROM goods WHERE price >= ALL(SELECT price FROM goods));");
			add("SELECT NAME, price FROM goods WHERE price > SOME(SELECT price FROM goods);");
			add("SELECT DISTINCT c_id FROM order_detail od1 WHERE NOT EXISTS" + "	(SELECT * FROM order_detail od2 "
					+ "		WHERE od2.s_id = '1' AND NOT EXISTS "
					+ "		 (SELECT * FROM order_detail od3 WHERE od3.`c_id` = od1.`c_id` AND od3.`g_id` = od2.`g_id`));");
		}
	};

	@SuppressWarnings("serial")
	public static List<String> view_text = new ArrayList<String>() {
		{
			add("定义视图ShopSell, 描述每个店铺的总销售收益");
			add("定义视图CustomPay，描述顾客下订单时使用的支付平台情况");
		}
	};

	@SuppressWarnings("serial")
	public static List<String> view_sql = new ArrayList<String>() {
		{
			add("CREATE VIEW ShopSell(shop_name, sell_income) AS (SELECT s.name, SUM(sell_price) FROM shop s, sell  WHERE sell.`s_id` = s.s_id GROUP BY s.s_id);");
			add("CREATE VIEW CustomPay AS (SELECT c.name, p.pay_name FROM custom c, order_form o, pay p WHERE c.c_id = o.c_id AND p.pay_id = o.pay_id GROUP BY o.o_id);");
		}
	};

	@SuppressWarnings("serial")
	public static List<String> index_text = new ArrayList<String>() {
		{
			add("在order_detail表中创建一个基于商品号和电商平台号的索引");
			add("在sell 表中创建一个基于商品号和店铺号的索引");
		}
	};

	@SuppressWarnings("serial")
	public static List<String> index_sql = new ArrayList<String>() {
		{
			add("CREATE INDEX idxGidPid ON order_detail(g_id, p_id);");
			add("CREATE INDEX idxGidSid ON sell(g_id, s_id);");
		}
	};

	@SuppressWarnings("serial")
	public static List<String> delete_text = new ArrayList<String>() {
		{
			add("删除信用小于3.0的店铺");
			add("删除店铺的获益小于20的销售记录");
		}
	};

	@SuppressWarnings("serial")
	public static List<String> delete_sql = new ArrayList<String>() {
		{
			add("DELETE FROM shop WHERE credit < 3.0;");
			add("DELETE FROM sell WHERE sell_price < 20;");
		}
	};
}
