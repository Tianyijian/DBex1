package mysql;

import java.util.ArrayList;
import java.util.List;

public class Constant {

	@SuppressWarnings("serial")
	public static List<String> text = new ArrayList<String>() {
		{
			add("ĳ������ƽ̨���е����������ܽ������ѯ��");
			add("�г��۸���4Ԫ���ϵĻ���������������������棨IN ��ѯ��");
			add("�ҳ��۸���ߵĻ������������ ��theta all��");
			add("�ҳ��۸�����͵Ļ��� ��theta some��");
			add("�г��������˵���1������Ʒ�Ĺ˿ͺ� (not exists)");
		}
	};
	@SuppressWarnings("serial")
	public static List<String> sql = new ArrayList<String>() {
		{
			add("SELECT p.name, SUM(sell_price) FROM platform p, sell  WHERE sell.`p_id` = p.`p_id` GROUP BY p.`p_id`;");
			add("SELECT sell_num, sell_price FROM sell  WHERE g_id IN (SELECT g_id FROM goods WHERE price > 4);");
			add("SELECT g_id, SUM(sell_num) FROM sell WHERE g_id IN (SELECT g_id FROM goods WHERE price >= ALL(SELECT price FROM goods));");
			add("SELECT NAME, price FROM goods WHERE price > SOME(SELECT price FROM goods);");
			add("SELECT DISTINCT c_id FROM order_detail od1 WHERE NOT EXISTS" + 
					"	(SELECT * FROM order_detail od2 " + 
					"		WHERE od2.s_id = '1' AND NOT EXISTS " + 
					"		 (SELECT * FROM order_detail od3 WHERE od3.`c_id` = od1.`c_id` AND od3.`g_id` = od2.`g_id`));");
		}
	};
}