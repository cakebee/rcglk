package com.students.utils;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;



public class SerializeUtils {
	
	public static boolean serialize(Object obj,String path) throws IOException {
		FileOutputStream fileOutputStream=new FileOutputStream(path);
		ObjectOutputStream objectOutputStream=new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(obj);
		objectOutputStream.close();
		fileOutputStream.close();
		return true;
		
	}
	
	public static Object serializeToObject(String path) throws IOException, ClassNotFoundException {
		FileInputStream fileInputStream=new FileInputStream(path);
		ObjectInputStream objectInputStream=new ObjectInputStream(fileInputStream);
		return objectInputStream.readObject();
		
	}

}
