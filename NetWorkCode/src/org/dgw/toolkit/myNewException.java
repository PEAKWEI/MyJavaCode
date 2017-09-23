package org.dgw.toolkit;

/**
 * 
 * @author Administrator 自定义异常类的使用方案
 *
 */
// 自定義異常類的聲明
public class myNewException extends Exception {

	public myNewException(String s) {
		super(s);
		System.out.println(s);
	}
}
//自定義的異常類的使用
class naviException {
	
	public static void main(String[] args) throws myNewException{
		    //調用辦法，在沒有聲明的情況下也可以調用，不過處理辦法僅僅是顯示出一條訊息
			throw new myNewException("自定義異常類");
	}

}
