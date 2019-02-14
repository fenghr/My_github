package com.soft863.test;


import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractJExcelView;
import com.soft863.entity.User;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

/**
 * @ClassName: ExcelResolver.java
 * @Description:
 * 
 * @author cqq
 * @version V1.0
 * @date  2018��7��3������9:29:02
 */
@Component("/excelView")
public class ExcelResolver  extends AbstractJExcelView{

	/* (non-Javadoc)
	 * @see org.springframework.web.servlet.view.document.AbstractJExcelView#buildExcelDocument(java.util.Map, jxl.write.WritableWorkbook, javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
	 */
	@Override
	protected void buildExcelDocument(Map<String, Object> map, WritableWorkbook book, HttpServletRequest req,
			HttpServletResponse resp) throws Exception {
		
		// ��ȡ����
		List<User> list = (List<User>) map.get("list");
		
		// ��ȡ����
		String[] titles =(String[]) map.get("titles");
		
		// ��ȡ�ļ���
		String filename = (String) map.get("filename");
		
		// ����sheet���� �� sheetname���ڼ���sheet �±�0��ʼ
		WritableSheet sheet = book.createSheet("�û���Ϣ", 0);
	
		// �������ⵥԪ��
		for (int i = 0; i < titles.length; i++) {
			
			// ������Ԫ��
			Label lb = new Label(i,0,titles[i]);
			sheet.addCell(lb);
		}
		
		
		// �������У�������Ԫ������ 
		for (int i = 0; i < list.size(); i++) {
			User user = list.get(i);//List<Map map>--->Map map
			Label lb1 = new Label(0,i+1,String.valueOf(user.getName()));
			Label lb2 = new Label(1,i+1,String.valueOf(user.getAccount()));
			Label lb3 = new Label(2,i+1,String.valueOf(user.getDept()));
			Label lb4 = new Label(3,i+1,String.valueOf(user.getGender()));
			Label lb5 = new Label(3,i+1,String.valueOf(user.getEmail()));
			sheet.addCell(lb1);
			sheet.addCell(lb2);
			sheet.addCell(lb3);
			sheet.addCell(lb4);
			sheet.addCell(lb5);
		}
		
		/*String filename2=new String("�ļ�.xls".getBytes("utf-8"),"iso-8859-1"); //���������������
		resp.setHeader("Content-Disposition", "attchment;filename="+filename2);*/
		
		// attchment:
		resp.setHeader("Content-Disposition", "attchment;filename="+filename);
		
		
		
		
	}


}
