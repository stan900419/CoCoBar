package util;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Cal 
{
	public static void SaveObject(Object o,String FileName)
	{
		try {
			FileOutputStream fos=new FileOutputStream(FileName);
			ObjectOutputStream oos=new ObjectOutputStream(fos);
			oos.writeObject(o);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Object ReadObject(String FileName)
	{
		Object o=null;
		try {
			FileInputStream fis=new FileInputStream(FileName);
			ObjectInputStream ois=new ObjectInputStream(fis);
			o=ois.readObject();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return o;
	}

}
