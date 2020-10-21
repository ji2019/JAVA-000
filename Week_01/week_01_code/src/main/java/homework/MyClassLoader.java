package homework;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyClassLoader extends ClassLoader {

	public static void main(String[] args) throws IOException {
		try {
			Class<?> aClass = new MyClassLoader().loadClass("Hello");
			Object obj = aClass.newInstance();
			Method method = aClass.getMethod("hello");
			method.invoke(obj);
		} catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException
				| InvocationTargetException e) {
			e.printStackTrace();
		}

	}

	/**
	 * <p>
	 * Title: cypher
	 * </p>
	 * <p>
	 * Description:加密， 将原来的1改为0,0改为1
	 * </p>
	 * 
	 * @param in
	 * @param out
	 * @throws IOException
	 */
	public static void cypher(InputStream in, OutputStream out) throws IOException {
		int b = 0;
		while ((b = in.read()) != -1) {
			// b ^ 0xff == 255 - b
			out.write(b ^ 0xff);
		}
	}

	private String classDir;

	public MyClassLoader() {

	}

	public MyClassLoader(String classDir) {
		this.classDir = classDir;
	}

	/**
	 * 覆盖ClassLoader的findClass方法
	 */
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		String workdir = System.getProperty("user.dir");
		String classFileName = workdir + "\\hello\\" + name + ".xlass";
		try {
			FileInputStream fin = new FileInputStream(classFileName);
			ByteArrayOutputStream baout = new ByteArrayOutputStream();
			// 解密
			cypher(fin, baout);
			fin.close();
			// 转为字节数组
			byte[] byteArray = baout.toByteArray();
			return defineClass(name,byteArray, 0, byteArray.length);
			//return defineClass(byteArray, 0, byteArray.length);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public String getClassDir() {
		return classDir;
	}

	public void setClassDir(String classDir) {
		this.classDir = classDir;
	}

}
