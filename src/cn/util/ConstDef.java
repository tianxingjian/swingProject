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
		columnNames.add("���");
		columnNames.add("ѧ��");
		columnNames.add("����");
		columnNames.add("����");
		columnNames.add("��ѧ");
		columnNames.add("Ӣ��");
		columnNames.add("�ܷ�");
		
		scolumnNames.add("����");
		scolumnNames.add("ѧ��");
		scolumnNames.add("����");
		scolumnNames.add("����");
		scolumnNames.add("��ѧ");
		scolumnNames.add("Ӣ��");
		scolumnNames.add("�ܷ�");

	}
}
