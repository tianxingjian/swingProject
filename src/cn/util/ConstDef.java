package cn.util;

import java.util.Vector;

/**
 * ceshi
 * @author tianxingjian
 *
 */
public class ConstDef {
	public static final int DEFAULT_WIDTH = 500;
	public static final int DEFAULT_HEIGHT = 450;
	public static final int TOP_HEIGHT = 150;
	public static final int CScoll_HEIGHT = 120;
	public static final int CP_HEIGHT = 160;
	public static Vector<String> sericolumns = new Vector<String>();
	public static Vector<String> ssericolumns = new Vector<String>();
	public static Vector<String> columnNames = new Vector<String>();
	public static Vector<String> scolumnNames = new Vector<String>();
	public static Vector datas = new Vector();
	public static Vector serialDatas = new Vector();
	static{
		columnNames.add("序号");
		columnNames.add("学号");
		columnNames.add("姓名");
		columnNames.add("语文");
		columnNames.add("数学");
		columnNames.add("英语");
		columnNames.add("总分");
		
		scolumnNames.add("排名");
		scolumnNames.add("学号");
		scolumnNames.add("姓名");
		scolumnNames.add("语文");
		scolumnNames.add("数学");
		scolumnNames.add("英语");
		scolumnNames.add("总分");

	}
}
