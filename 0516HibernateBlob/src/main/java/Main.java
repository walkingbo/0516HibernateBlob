import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.sql.Date;
import java.util.GregorianCalendar;

import org.springframework.context.support.GenericXmlApplicationContext;

import hibernate.dao.SampleDAO;
import hibernate.domain.Sample;



public class Main {

	public static void main(String[] args) {
		GenericXmlApplicationContext context =
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		SampleDAO dao = context.getBean(SampleDAO.class);
		
		
		Sample sample = dao.get(2);
		System.out.println(sample);
		
		try {
			FileOutputStream fos =
					new FileOutputStream("./아이유1.jpg");
			fos.write(sample.getImage());
			fos.flush();
			fos.close();
		}catch(Exception e) {}
		
		
		/*
		Sample sample = new Sample();
		sample.setNum(2);
		sample.setName("아이유");
		
		//Date 객체 만들어서 대입 
		GregorianCalendar cal = new GregorianCalendar(1993,5,16);
		
		Date regdate = new Date(cal.getTimeInMillis());
		sample.setRegdate(regdate);
		
		//이미지 파일을 가지고 바이트 배열 만들기 
		String imageFile= "/Users/a503_18/Downloads/아이유.JPG";
		File f = new File(imageFile);
		try {
			byte [] b = new byte[(int)f.length()];
			FileInputStream fis = new FileInputStream(f);
			fis.read(b);
			sample.setImage(b);
			fis.close();
			
		}catch(Exception e) {
			System.out.println("파일 경로 예외:" + e.getMessage());
			e.printStackTrace();
		}
		
		dao.upsert(sample);
		*/
		
		context.close();
		

	}

}
