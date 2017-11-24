package cards.view;

import java.util.ArrayList;

import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

import card.entiy.Card;

public class CardTabelModel implements TableModel{
	
	private ArrayList<Card> cardList;
	
	public ArrayList<Card> getCardList() {
		return cardList;
	}
	
	public CardTabelModel(ArrayList<Card> cardList) {
		this.cardList = cardList;
	}

	@Override
	public int getRowCount() {
		return cardList.size();
	}

	@Override
	public int getColumnCount() {
		return 3;
	}
    
	@Override
	public String getColumnName(int columnIndex) {
		switch (columnIndex) {
		case 0:
			return "序号";
		case 1:
			return "UID";
		case 2:
			return "Status";
		default:
			return "error";
		}
	}

	@Override
	public Class<?> getColumnClass(int columnIndex) {
		return String.class;
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		if (columnIndex==0) {
			return true;
		}else {
			return false;
		}
		
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
	    Card user=cardList.get(rowIndex);
	        if(columnIndex==0){//第一列是UserInfo对象的ID值
	            return ""+user.getID();
	        }else if(columnIndex==1){//第二列是UID属性值
	            return user.getUID();
	        }else if(columnIndex==2){//第二列是Status值
	            return ""+user.getStatus();
	        }else{//除非设计时逻辑错误，否则不会到这里
	            return "出错!";
	        }
	}

	@Override
	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		String info=rowIndex+"行"+columnIndex+"列的值改变: "+aValue.toString();
		System.out.println(info);
	}

	@Override
	public void addTableModelListener(TableModelListener l) {
	}

	@Override
	public void removeTableModelListener(TableModelListener l) {
	}
	

}
