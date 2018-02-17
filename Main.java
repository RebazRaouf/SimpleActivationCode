package kurdishDev;

import android.app.Activity;

public class Main {
	
	static SerialGenerator generator;
	static Main main;
	static Activity activity;
	String imei,user;
	String generatedSerail;
	
	public static void init(Activity activity)throws Exception {
		Main.activity = activity;
		if(isEqual(getPackName())){
			generator = new SerialGenerator();
			main = new Main();
		}else{
			throw new Error();
		}
	}
	
	protected static boolean isPackageTrue() {
		return isEqual(getPackName());
	}
	
	private static String getPackName() {
        //change with your package name
		return "com.your.package.name";
		//return activity.getPackageName();
	}
	
	private static boolean isEqual(String str) {
		return str.equalsIgnoreCase("com.your.package.name");
	}
	
	public static void setUserName(String user){
		Main.main.user = user;
	}
	
	public static void setData(String imei){
		Main.main.imei = imei;
	}
	
	public String getData(){
		return Main.main.imei;
	}
	
	public static String getSerial() throws Exception{
		if(generator==null) throw new Error();
		return generator.getGeneratedSerial();
	}
	
	public static boolean isActivated(String code){
		return generator.compareActivationSerial(code);
	}
	
	

}
