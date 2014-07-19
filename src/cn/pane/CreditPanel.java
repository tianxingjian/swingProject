package cn.pane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashSet;
import java.util.Set;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import cn.util.ConstDef;


public class CreditPanel extends JPanel {
	private static final int DEFAULT_WIDTH = 780;
	private static final int DEFAULT_HEIGHT = 650;
	private JPanel topPanel;
	private JPanel cenPanel;
	
	private JPanel tconPanel;
	private JPanel tbuttonPanel;
	private JScrollPane cSPanel;
	private JPanel cbuttonPanel;
	private JScrollPane bsPanel;
	private JSplitPane splitPane;
	
	private JTable newTable;
	private JTable sortTable;
	private JTable newRowHeaderTable;
	private JTable sortRowHeaderTable;
	private DefaultTableModel newModel;
	private DefaultTableModel sortModel;
	private DefaultTableModel newSoModel;
	private DefaultTableModel sortSoModel;
	
	private JButton btnAdd;
	private JButton btnSort;
	
	private JLabel soLable;
	private JLabel xmLable;
	private JLabel ywLable;
	private JLabel sxLable;
	private JLabel enLable;
	
	private JTextField soField;
	private JTextField xmField;
	private JTextField ywField;
	private JTextField sxField;
	private JTextField enField;

	public CreditPanel(){
		
	}

	public void init(){
		initTopPane();
		initCenterPane();
		initButtonPane();
		addBtnListener(btnAdd);
		sortBtnListener(btnSort);
		splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, true, cenPanel, bsPanel);
		this.setLayout(new BorderLayout());
		this.add(topPanel, BorderLayout.NORTH);
		this.add(splitPane, BorderLayout.CENTER);
	}
	
	private void initButtonPane(){
		sortTable = new JTable();
		sortModel = new DefaultTableModel(ConstDef.datas,ConstDef.scolumnNames);
		sortTable.setModel(sortModel);
		sortTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		bsPanel = new JScrollPane(sortTable);
		bsPanel.setPreferredSize(new Dimension(ConstDef.DEFAULT_WIDTH, ConstDef.CScoll_HEIGHT));
	}
	
	private void initCenterPane(){
		
		
		cbuttonPanel = new JPanel();
		cenPanel = new JPanel();
		newTable = new JTable();
		newModel = new DefaultTableModel(ConstDef.datas,ConstDef.columnNames);
		newTable.setModel(newModel);
		newTable.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		cSPanel = new JScrollPane(newTable);
		//newRowHeaderTable = new JTable(new DefaultTableModel(ConstDef.serialDatas,ConstDef.sericolumns));
		//cSPanel.setRowHeaderView(newRowHeaderTable);
		cSPanel.setPreferredSize(new Dimension(ConstDef.DEFAULT_WIDTH, ConstDef.CScoll_HEIGHT));
		btnSort = new JButton("排序");
		
		cbuttonPanel.add(btnSort);
		cenPanel.setLayout(new BorderLayout());
		cenPanel.add(cSPanel, BorderLayout.NORTH);
		cenPanel.add(cbuttonPanel, BorderLayout.CENTER);
		cenPanel.setPreferredSize(new Dimension(ConstDef.DEFAULT_WIDTH, ConstDef.CP_HEIGHT));
	}
	
	private void initTopPane(){
		 soLable = new JLabel("学号:");
		 xmLable = new JLabel("姓名:");
		 ywLable = new JLabel("语文:");
		 sxLable = new JLabel("数学:");
		 enLable = new JLabel("英语:");
		
		 soField = new JTextField();
		 xmField = new JTextField();
		 ywField = new JTextField();
		 sxField = new JTextField();
		 enField = new JTextField();
		 
		 btnAdd = new JButton("新增");
		 topPanel = new JPanel();
		 tconPanel = new JPanel();
		 tbuttonPanel = new JPanel();
		 tbuttonPanel.add(btnAdd);
		 
		 tconPanel.setLayout(new GridLayout(3,4));
		 tconPanel.add(soLable);
		 tconPanel.add(soField);
		 tconPanel.add(xmLable);
		 tconPanel.add(xmField);
		 tconPanel.add(ywLable);
		 tconPanel.add(ywField);
		 tconPanel.add(sxLable);
		 tconPanel.add(sxField);
		 tconPanel.add(enLable);
		 tconPanel.add(enField);
		 
		 topPanel.setLayout(new BorderLayout());
		 topPanel.add(tconPanel, BorderLayout.NORTH);
		 topPanel.add(tbuttonPanel, BorderLayout.CENTER);
	}
	
	private Vector getTableDatas(){
		DefaultTableModel tableModel = (DefaultTableModel)this.newTable.getModel();
		Vector old = tableModel.getDataVector();
		return old;
	}
	
	private Vector getFieldValue(){
		Vector datas = getTableDatas();
		String xh;
		String xm;
		String yw;
		String sx;
		String en;
		try {
			xh = checkValue(this.soField.getText(), 1);
			xm = checkValue(this.xmField.getText(), 1);
			yw = checkValue(this.ywField.getText(), 0);
			sx = checkValue(this.sxField.getText(), 0);
			en = checkValue(this.enField.getText(), 0);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "警告", JOptionPane.ERROR_MESSAGE);
			return datas;
		}
		
		if(datas == null){
			datas = new Vector();
		}
		Vector newRowData = new Vector();
		Vector serNo = new Vector();
		newRowData.add(datas.size() + 1);
		newRowData.add(xh);
		newRowData.add(xm);
		newRowData.add(Double.valueOf(yw));
		newRowData.add(Double.valueOf(sx));
		newRowData.add(Double.valueOf(en));
		newRowData.add(Double.valueOf(yw) + Double.valueOf(sx) + Double.valueOf(en));
		datas.add(newRowData);
		return datas;
		
	}
	
	private String checkValue(String src,  int type) throws Exception{
		if(src != null && src.trim().length() > 0){
			if(type == 0){
				Double.parseDouble(src.trim());
				return src.trim();
			}else{
				return src.trim();
			}
		}else{
			throw new Exception("字段不能为空！");
		}
	}
	
	private void updateNewTable(Vector datas){
		DefaultTableModel model = new DefaultTableModel(datas,ConstDef.columnNames);
		newTable.setModel(model);
	}
	
	private void updateSortTable(Vector datas){
		
		DefaultTableModel model = new DefaultTableModel(datas,ConstDef.scolumnNames);
		SampleSortingTableModel sortModel = new SampleSortingTableModel(model, 6);
		
		sortTable.setModel(sortModel);
	}
	
	private void addBtnListener(JButton btn){
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Vector datas = getFieldValue();
				updateNewTable(datas);
			}
		});
	}
	
	private void sortBtnListener(JButton btn){
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				Vector datas = getTableDatas();
				updateSortTable(datas);
			}
		});
	}
	
}


