package kurdishDev;

import java.util.ArrayList;

class SerialGenerator {
	
	MyOnwGenerator generator;
	
	public SerialGenerator() {
		generator = new MyOnwGenerator();
	}
	
	public String getGeneratedSerial()throws Exception{
		if(Main.main== null || Main.activity==null || !Main.isPackageTrue())throw new Error();
		return generator.getEncodedCode(Main.main.getData());
	}
	
	public boolean compareActivationSerial(String ActivationCode){
		if(Main.main== null || Main.activity==null || !Main.isPackageTrue())throw new Error();
		DataStructure data = ParseSerial(Main.main.user);
		for(int i=1;i<8;i++){
			data.setChar(i, generator.getChared(i, data.getChar(i)));
		}
		String code = generator.getFirstActivationCode() + data.getLastActivationCode();
		if(code.equalsIgnoreCase(ActivationCode)){
			return true;
		}else{
			return false;
		}
	}
	
	private DataStructure ParseSerial(String userName){
		String code = Main.main.generatedSerail;
		code = clean(code);
		ArrayList<String> arr = new ArrayList<String>();
		int[] index = new int[]{0,2,6,code.length()-1};
		int[] indexUser = new int[]{1,2,0};
		for(int i=0;i<index.length;i++){
			char s = code.charAt(index[i]);
			arr.add(String.valueOf(s));
		}
		if(userName.length()<5)throw new Error();
		for(int i=0;i<indexUser.length;i++){
			char s = userName.charAt(indexUser[i]);
			arr.add(String.valueOf(s));
		}
		DataStructure structure = new DataStructure();
		int ind=-1;
		for(int i=1;i<8;i++){
			ind++;
			structure.setChar(i, arr.get(ind));
		}
		return structure;
	}
	
	private String clean(String str){
		return str.replace("-v1", "");
	}

}