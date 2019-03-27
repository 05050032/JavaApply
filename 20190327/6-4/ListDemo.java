import java.awt.*;
import java.awt.event.*;

public class ListDemo extends java.awt.Frame implements ItemListener {
  java.awt.List list;
  java.awt.Panel panel;
  public static void main(String args[]){
    new ListDemo();
  }
  
  // �غc�禡
  public ListDemo() {
    super("List Demo");

    final int row = 1;    // �C
    final int column = 3; // ��

    // �w�q Layout Manager �� GridLayout
    setLayout(new GridLayout(row, column));

    // �غc�禡 1
    // �w�]��ܶ��ئC�Ƭ�4
    // �B�����\�h����ܶ���
    list = new List();
    list.addItemListener(this);
    // �]�wList�������
    for (int i=0; i < 5; i++)  {  
	
      list.add("List " + i);
	}
      
    // �]�w�O�_���\���سQ�h�����  
    list.setMultipleMode(false);

    // ����ﶵ����
    list.select(3);

    panel = new Panel();
    panel.add(list);
    add(panel);

    // �غc�禡 2
    // �i��ܪ����ئC�Ƭ�5
    list = new List(6);
    list.addItemListener(this);
    // �]�wList������ء]Item�^
    for (int i=0; i < 10; i++) {  
	list.add("List " + i);
	}
      
    // �]�w�O�_���\���سQ�h�����  
    list.setMultipleMode(true);

    // ����ﶵ����
	list.select(2);
    list.select(4);
    list.select(6);

    panel = new Panel();
    panel.add(list);
    add(panel);
	
	panel = new Panel();
    // Demo Only
    //panel.setText("Total items: " + list.getItemCount() + ",    First Item: " + list.getItem() + ",    Init Selected Index: " + list.getSelectedIndex());
    add(panel);

    // �]�w�������j�p
    this.setSize(420, 150);

    // Center the frame
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = this.getSize();

    if (frameSize.height > screenSize.height)
      frameSize.height = screenSize.height;

    if (frameSize.width > screenSize.width)
      frameSize.width = screenSize.width;

    this.setLocation((screenSize.width - frameSize.width) / 2, (screenSize.height - frameSize.height) / 2);

    // ��ܵ���
    this.setVisible(true);

    this.addWindowListener(new WindowAdapter() {
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });
  }
  public void itemStateChanged(ItemEvent e) {
  String source = null;

    // ���o���Ͷ��بƥ󪺪���
    List li = (List)(e.getItemSelectable());
    if(li.isMultipleMode()==true){
		source = "Total items: " +li.getItemCount() + ", Select Item: ";
		int []iA = li.getSelectedIndexes();
		String[]sA=li.getSelectedItems();
		System.out.print(source);
		for (int i=0; i < iA.length; i++) {
			if(i+1 < iA.length) 
				System.out.print(sA[i]+",");
			else
				System.out.print(sA[i]);
		}
	System.out.println("");
  }
  else{
	  source = "Total items: " +li.getItemCount() + ", Select Item: " + li.getSelectedItem();
	  System.out.println(source);
	}
  }
}